import java.util.ArrayList;
import java.util.Random;
import java.util.Map;
public class Clerk extends Employee{

    private TuneBehavior tuneBehavior_;

    public Clerk(String name, Store s, TuneBehavior tuneBehavior) {
        super(name,s);
        tuneBehavior_ = tuneBehavior;
    }
    public int getRandomNumber(int min, int max) //https://www.baeldung.com/java-generating-random-numbers-in-range
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void set_tune_behvaior(TuneBehavior tuneBehavior){
        tuneBehavior_ = tuneBehavior;
    }

    public void perform_tune(Item item){
        tuneBehavior_.tune(item);
    }
    //Set all items arriving today to have currDay arrival date, add all items to inventory
    private void process_incoming_items(int currDay){
        Store s = get_store();
        ArrayList<Item> incoming = s.get_ordered().get(currDay); //Get all the items from the map
        incoming.forEach((item)->item.set_day_arrived(currDay));  //Set all their arrival dates to current day
        s.get_inventory().put_items(incoming); //Add all the items to the inventory
        s.get_ordered().remove(currDay); //Remove items from orderedItems_
    }

    //Arrive at store and check if items need to be processed
    public void arrive_at_store(){
        int currDay = get_store().get_calendar().get_current_day();
        System.out.println(get_name() + " arrives at the store on Day " + currDay);
        if(get_store().get_ordered().containsKey(currDay)){ //If there are ordered items that arrive today
            process_incoming_items(currDay);
        }
    }


    //Check amount in register, go_to_bank if less than 75 (REMOVE MAGIC NUMBERS)
    public void check_register(){
        double currentAmount = get_store().get_register().get_amount();
        System.out.println(get_name() + " is checking the register and there is " + currentAmount);
        if(currentAmount < 75) {
            go_to_bank();
        }
    }

    //Go to the bank, withdrawal 1000 dollars, add it to the register, tally the withdrawal (REMOVE MAGIC NUMBERS)
    public void go_to_bank(){
        CashRegister reg = get_store().get_register();
        reg.set_amount(reg.get_amount() + 1000);
        reg.set_bank_withdrawal(reg.get_bank_withdrawals() + 1000);
        System.out.println(get_name() + " withdrew 1000 dollars from the bank and the new balance in the register is " + reg.get_amount() + " dollars");
    }

    //Scan the current inventory, if we have 0 count of any type of item, order 3 of them
    public void do_inventory() throws Exception{
        Store s = get_store();
        Inventory inv = s.get_inventory();
        for(Map.Entry<String, ArrayList<Item>> entry : inv.get_mapping().entrySet()){ //For each entry in our inventory map
            if(entry.getValue().isEmpty() && !s.search_ordered_item_type(entry.getKey())){ //If we have 0 count of any items in our current inventory && they have not already been ordered
                place_order(entry.getKey()); //Order that item
            }

        }
        System.out.println("The sum of todays inventory is " + inv.get_list_price_sum()); //Display the list price sum of all items in inventory
    }

    //Adds 3 items of type passed to orderedItems_ map in form of <Day Arriving, List Of Items>
    public void place_order(String type) throws Exception{
        Random rand = new Random();
        Store s = get_store();
        CashRegister reg = s.get_register();
        double total_spent_on_order = 0;
        ArrayList<Item> items = generate_items(type.toLowerCase(), 3); //Generate 3 of the type of items asked for
        // Updates the register with the 
        for (Item item : items) {
            reg.set_amount(reg.get_amount() - item.get_purch_price());
            total_spent_on_order += item.get_purch_price();
        }
        int arrivalDay = s.get_calendar().get_current_day() + rand.nextInt(3) + 1; //Generate random arrival day
        if ((arrivalDay) % 7 == 0) {
            arrivalDay++;
        }

        if(s.get_ordered().containsKey(arrivalDay)){ //If there is already an entry for that arrival day
            s.get_ordered().get(arrivalDay).addAll(items); //Add to items arriving that day
        }
        else{
            s.get_ordered().put(arrivalDay, items); //map the ordered items from (day Arriving) -> (the items created)
        }
        System.out.println(get_name() + " spent $" + Double.toString(total_spent_on_order) + " to place an order for 3 " + type + ", arriving on day " + Integer.toString(arrivalDay) + ".");
    }

    //Generate numItems items of type provided, return generated ArrayList
    private ArrayList<Item> generate_items(String type, int numItems) throws Exception{
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i < numItems; i++){ //For the number of items we need
            items.add(Item.generate_item(type)); //Call the item generator for the type of item we need
        }
        return items;
    }

    private ArrayList<buyingCustomer> generateBuyingCustomers(){
        ArrayList<buyingCustomer> buyCustomers = new ArrayList<buyingCustomer>();

        // getRandomNumber is exclusive to the maximum so this returns a number between [4, 10] inclusive.
        int randBuyers = getRandomNumber(4, 11); 

        for (int i = 1; i < randBuyers + 1; i++)
        {
            buyCustomers.add(new buyingCustomer("Buying Customer " + i));
        }
        return buyCustomers;
    }

    private ArrayList<sellingCustomer> generateSellingCustomers() throws Exception{
        ArrayList<sellingCustomer> sellCustomers = new ArrayList<sellingCustomer>();

        // getRandomNumber is exclusive to the maximum so this returns a number between [1, 4] inclusive.
        int randSellers = getRandomNumber(1, 5);

        for (int i = 1; i < randSellers + 1; i++)
        {
            sellCustomers.add(new sellingCustomer("Selling Customer " + i));
        }
        return sellCustomers;
    }


    public void open_store() throws Exception{
        ArrayList<buyingCustomer> buyCustomers = generateBuyingCustomers();
        for(buyingCustomer buyer : buyCustomers){ //For each buying customer
            if(get_store().get_inventory().get_items_of_type(buyer.get_wanted_type()).isEmpty()){ //If there are no items of type that customer wants
                System.out.println(buyer.get_name() + " tried to buy a " + buyer.get_wanted_type() + "but none were available");
                continue;
            }
            attempt_sale(buyer,get_store().get_inventory().get_items_of_type(buyer.get_wanted_type()).get(0)); //Attempt to sell the first item of appropriate type
        }

        ArrayList<sellingCustomer> sellCustomers = generateSellingCustomers();
        for(sellingCustomer seller : sellCustomers){ //For each selling customer
            attempt_purchase(seller, seller.get_item()); //Attempt to buy their item
        }
    }

    private void attempt_sale(buyingCustomer buyer, Item toSellItem){
        if(buyer.haggle_roll(50)){ //If we roll 50% chance and win, sell full price
            sell_item(toSellItem, toSellItem.get_list_price());
            System.out.println(get_name() + " sold a " + toSellItem.get_name() + " to " + buyer.get_name() + " for $" + toSellItem.get_sale_price());
        }
        else if(buyer.haggle_roll(75)){ //else if we roll 75% chance and win, sell 90% full price
            sell_item(toSellItem, toSellItem.get_list_price()*.9);
            System.out.println(get_name() + " sold a " + toSellItem.get_name() + " to " + buyer.get_name() + " for $" + toSellItem.get_sale_price() + " after a 10% discount.");
        }
        else{
            System.out.println(get_name() + " tried selling a " + toSellItem.get_condition().get_condition() + " condition " + toSellItem.get_new_or_used() + " " + toSellItem.get_name() + " to " + toSellItem.get_name() + " for $" + toSellItem.get_list_price() + " but customer refused.");
        }
    }

    private void attempt_purchase(sellingCustomer seller, Item toBuyItem){
        double purchPrice = evaluate_item(toBuyItem);
        if(seller.haggle_roll(50)){
            purch_item(toBuyItem,purchPrice);
            System.out.println(get_name() + " bought a " + toBuyItem.get_condition().get_condition() + " condition " + toBuyItem.get_new_or_used() + " " + toBuyItem.get_name() + " from " + seller.get_name() + " for $" + purchPrice);
        }
        else if(seller.haggle_roll(75)){
            purch_item(toBuyItem, purchPrice*1.1);
            System.out.println(get_name() + " bought a " + toBuyItem.get_condition().get_condition() + " condition " + toBuyItem.get_new_or_used() + " " + toBuyItem.get_name() + " from " + seller.get_name() + " for $" + purchPrice + " after a 10% offer increase.");
        }
        else{
            System.out.println(get_name() + " tried buying a " + toBuyItem.get_condition().get_condition() + " condition " + toBuyItem.get_new_or_used() + " " + toBuyItem.get_name() + " from " + seller.get_name() + " for $" + purchPrice + " but customer refused.");
        }
    }

    private void sell_item(Item soldItem, double soldPrice){
        Store s = get_store();
        s.add_to_sold(soldItem);
        s.remove_from_inventory(soldItem);
        s.get_register().set_amount(s.get_register().get_amount() + soldPrice); //Set register amount
        soldItem.set_day_sold(s.get_calendar().get_current_day()); //Set items sold date to current day
        soldItem.set_sale_price(soldPrice); //Set items sold price
    }

    private void purch_item(Item purchItem, double purchPrice){
        Store s = get_store();
        s.add_to_inventory(purchItem);
        purchItem.set_purch_price(purchPrice);
        s.get_register().set_amount(s.get_register().get_amount() - purchPrice); //Set register amount
    }

    private double evaluate_item(Item item){
        Random rand = new Random(); //Too many new randoms
        Condition cond = Condition.randomCondition(); //Get a random condition for item
        item.set_condition(cond); //Set the items condition
        item.set_is_new(rand.nextBoolean()); //Set the items isNew to random
        return calculate_condition_price(cond); //Return random price based on items condition
    }

    private double calculate_condition_price(Condition cond){
        Random rand = new Random();
        switch(cond.get_condition().toLowerCase()){ //Based on the string representation of condition
            case("excellent"):
                return rand.nextInt(11) + 40; //rand number from 40-50
            case("very good"):
                return rand.nextInt(11) + 30;//rand number from 30-40
            case("good"):
                return rand.nextInt(11) + 20;//rand number from 20-30
            case("fair"):
                return rand.nextInt(11) + 10;//rand number from 10-20
            case("poor"):
                return rand.nextInt(10) + 1; //rand number from 1-10
            default:
                throw new IllegalArgumentException("Invalid condition type passed to generate_price" + cond.get_condition());
        }
    }

    public void clean_store(){ //The size of this function needs to be reduced!
        Random rand = new Random();
        String name = get_name();
        Inventory inv = get_store().get_inventory();
        double damage_chance;
        if (name == "Shaggy") {
            damage_chance = 20;
        }
        else if (name == "Velma") {
            damage_chance = 5;
        }
        else {
            damage_chance = 50;
        }
         //Increment calendar day

        //If the roll for a damaging an item fails, finish cleaning the store and return from fxn
        if(rand.nextInt(100) > damage_chance) {
            System.out.println(name + " finished cleaning the store.");
            return;
        }

        //Otherwise proceed with damaging an item
        Item damagedItem = inv.flatten_inventory().get(rand.nextInt(inv.flatten_inventory().size()));//Flatten the inventory into a list of items and pick a random item to damage
        if(damagedItem.get_condition().get_condition() == "poor"){ //If the item breaks
            System.out.println(name + " damaged " + damagedItem.toString() + " and broke it.");
            inv.remove_item(damagedItem);
        }
        else{ //Reducde the items condition by one level, reduce the items listPrice by 20%
            damagedItem.get_condition().decreaseCondition(); //Decrease the items condition
            System.out.println(name + " damaged " + damagedItem.toString() + " and its condition is now " + damagedItem.get_condition().get_condition());
            System.out.println("The price of the item will be reduced from " + damagedItem.get_list_price() + " to " + damagedItem.get_list_price() * .8);
            damagedItem.set_list_price(damagedItem.get_list_price() * .8);
            System.out.println("The new price of the item is: " + damagedItem.get_list_price());
        }
        System.out.println(name + " finished cleaning the store.");
    }

    // Pack up the store for the day. Increase days worked and increment current day. Announce that the store is closed
    public void leave_store(){
        get_store().get_calendar().incr_current_day();
        incr_days_worked();
        System.out.println(get_name() + " locked up the store and went home for the day");
    }
}