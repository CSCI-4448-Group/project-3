import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Store {
    private Inventory inventory_; // Inventory, ////// Identity: Inventory is a mapping between subclass type to items and is different than other objects in the application //////
    private ArrayList<Item> soldItems_; // soldItems list
    private HashMap<Integer, ArrayList<Item>> orderedItems_; //map from (arrival day) -> (list of items arriving)
    private ArrayList<Employee> employees_; // Employees list
    private ArrayList<Customer> buyingCustomers_; // BuyingCustomers list
    private ArrayList<Customer> sellingCustomers_; // SellingCustomers list
    private CashRegister register_; // Cash register
    private Calendar calendar_; // Calendar

    public Store() {
        initializeInventory();
        initializeEmployees();
        initializeCalendar();
        initializeOrdered();
        initializeRegister();
        initializeSoldItems();
    } // Init the store with various initialize methods

    public void initializeInventory() {
        inventory_ = new Inventory();
        //Initialize inventory. 3 of every bottom subclass, 51 items total
        inventory_.put_item((new CD("Led Zepplin CD", 5, 10, true, 0, new Condition("very good"), 0, "Led Zepplin", "Led Zepplin 4")));
        inventory_.put_item((new CD("Post Malone CD", 3, 6, false, 0, new Condition("poor"), 0, "Post Malone", "Stoney")));
        inventory_.put_item((new CD("Metallica CD", 10, 20, true, 0, new Condition("excellent"), 0, "Metallica", "Ride the Lightning")));
        inventory_.put_item((new Vinyl("Judas Priest Vinyl", 8, 16, true, 0, new Condition("very good"), 0, "Judas Priest", "British Steel")));
        inventory_.put_item((new Vinyl("Eminem Vinyl", 5, 10, false, 0, new Condition("poor"), 0, "Eminem", "Marshal Mathers LP")));
        inventory_.put_item((new Vinyl("Daft Punk Vinyl", 15, 30, false, 0, new Condition("poor"), 0, "Daft Punk", "Random Access Memories")));
        inventory_.put_item((new PaperScore("Moonlight Sonata PaperScore", 1, 2, true, 0, new Condition("excellent"), 0, "Beethoven", "Piano Sanata 14")));
        inventory_.put_item((new PaperScore("Christmas Oratorio PaperScore", 1, 2, true, 0, new Condition("very good"), 0, "Bach", "Oratorio")));
        inventory_.put_item((new PaperScore("Fur Elise PaperScore", 1, 2, false, 0, new Condition("excellent"), 0, "Beethoven", "Bagatelle 25")));
        inventory_.put_item((new CD_Player("Sony CDPlayer", 30, 60, true, 0, new Condition("excellent"), 0, "Sony")));
        inventory_.put_item((new CD_Player("LG CDPlayer", 30, 60, true, 0, new Condition("excellent"), 0, "LG")));
        inventory_.put_item((new CD_Player("Logitech CDPlayer", 30, 60, true, 0, new Condition("excellent"), 0, "Logitech")));
        inventory_.put_item((new RecordPlayer("Logitech RecordPlayer", 20, 40, true, 0, new Condition("very good"), 0, "Logitech")));
        inventory_.put_item((new RecordPlayer("LG RecordPlayer", 20, 40, true, 0, new Condition("fair"), 0, "LG")));
        inventory_.put_item((new RecordPlayer("Sony RecordPlayer", 20, 40, true, 0, new Condition("good"), 0, "Sony")));
        inventory_.put_item((new MP3Player("Logitech MP3Player", 20, 40, true, 0, new Condition("very good"), 0, "Logitech")));
        inventory_.put_item((new MP3Player("LG MP3Player", 20, 40, true, 0, new Condition("fair"), 0, "LG")));
        inventory_.put_item((new MP3Player("Sony MP3Player", 20, 40, true, 0, new Condition("good"), 0, "Sony")));
        inventory_.put_item((new Guitar("Gibson SG Guitar", 45, 90, true, 0, new Condition("excellent"), 0, "Gibson", true)));
        inventory_.put_item((new Guitar("Fender Stratocaster Guitar", 40, 80, false, 0, new Condition("good"), 0, "Fender", true)));
        inventory_.put_item((new Guitar("Ibanez Guitar", 40, 80, true, 0, new Condition("very good"), 0, "Ibanez", true)));
        inventory_.put_item((new Bass("Fender Precision Bass", 35, 70, true, 0, new Condition("excellent"), 0, "Fender", true)));
        inventory_.put_item((new Bass("Gibson Thunderbird Bass", 30, 60, true, 0, new Condition("fair"), 0, "Gibson", true)));
        inventory_.put_item((new Bass("Modulus Bass", 40, 80, true, 0, new Condition("excellent"), 0, "Modulus", true)));
        inventory_.put_item((new Mandolin("Kentucky Mandolin", 25, 50, false, 0, new Condition("excellent"), 0, "Kentucky", false)));
        inventory_.put_item((new Mandolin("Gibson Mandolin", 25, 50, false, 0, new Condition("fair"), 0, "Gibson", false)));
        inventory_.put_item((new Mandolin("Goldtone Mandolin", 25, 50, true, 0, new Condition("excellent"), 0, "Goldtone", false)));
        inventory_.put_item((new Flute("Etude Flute", 20, 40, true, 0, new Condition("good"), 0, "Etude", "Alto")));
        inventory_.put_item((new Flute("Yamaha Flute", 20, 40, true, 0, new Condition("good"), 0, "Yamaha", "C")));
        inventory_.put_item((new Flute("Azumi Flute", 20, 40, false, 0, new Condition("good"), 0, "Azume", "Wooden")));
        inventory_.put_item((new Harmonica("Hohner Harmonica", 10, 20, false, 0, new Condition("very good"), 0, "Hohner", "C")));
        inventory_.put_item((new Harmonica("Lee Oskar Harmonica", 10, 20, false, 0, new Condition("very good"), 0, "Lee Oskar", "C")));
        inventory_.put_item((new Harmonica("SEYDEL Blues Harmonica", 10, 20, false, 0, new Condition("very good"), 0, "SEYDEL", "C")));
        inventory_.put_item((new Hat("Post Malone Hat", 25, 50, true, 0, new Condition("good"), 0, "Gucci", 3)));
        inventory_.put_item((new Hat("Slash's Top Hat", 50, 100, true, 0, new Condition("good"), 0, "Slash", 7)));
        inventory_.put_item((new Hat("Carhartt Hat", 10, 20, true, 0, new Condition("good"), 0, "Carhartt", 5)));
        inventory_.put_item((new Bandana("Red Bandana", 4, 8, true, 0, new Condition("excellent"), 0, "Bexar Goods")));
        inventory_.put_item((new Bandana("Blue Bandana", 4, 8, true, 0, new Condition("excellent"), 0, "Topo Designs")));
        inventory_.put_item((new Bandana("White Bandana", 4, 8, true, 0, new Condition("excellent"), 0, "Buck Mason")));
        inventory_.put_item((new Shirt("Carhartt Shirt", 15, 30, true, 0, new Condition("good"), 0, "Carhartt", 5)));
        inventory_.put_item((new Shirt("Gildan Shirt", 15, 30, true, 0, new Condition("excellent"), 0, "Gildan", 6)));
        inventory_.put_item((new Shirt("Hanes Shirt", 15, 30, true, 0, new Condition("good"), 0, "Hanes", 9)));
        inventory_.put_item((new PracticeAmp("Marshall DSL PracticeAmp", 50, 100, true, 0, new Condition("good"), 0, "Marshall", 500)));
        inventory_.put_item((new PracticeAmp("Mesa California Tweed PracticeAmp", 50, 100, true, 0, new Condition("good"), 0, "Mesa", 200)));
        inventory_.put_item((new PracticeAmp("Rogue G10 PracticeAmp", 50, 100, true, 0, new Condition("good"), 0, "Rogue", 10)));
        inventory_.put_item((new Cable("Rogue Cable", 10, 20, true, 0, new Condition("excellent"), 0, "Rogue", 10)));
        inventory_.put_item((new Cable("Marshall Cable", 10, 20, true, 0, new Condition("excellent"), 0, "Marshall", 20)));
        inventory_.put_item((new Cable("Gibson Cable", 10, 20, true, 0, new Condition("excellent"), 0, "Gibson", 50)));
        inventory_.put_item((new Strings("Ernie Ball Strings", 10, 20, true, 0, new Condition("excellent"), 0, "Ernie Ball", "9 gauge")));
        inventory_.put_item((new Strings("Dunlop Strings", 10, 20, true, 0, new Condition("excellent"), 0, "Dunlop", "10 gauge")));
        inventory_.put_item((new Strings("Elixir Strings", 10, 20, true, 0, new Condition("excellent"), 0, "Elixir", "11 gauge")));
        System.out.println("");
    }

    // init employees with Shaggy and Velma
    public void initializeEmployees() {
        employees_ = new ArrayList<Employee>();
        employees_.add(new Clerk("Shaggy",this));
        employees_.add(new Clerk("Velma", this));
    }

    // Init calendar object
    public void initializeCalendar() {
        calendar_ = new Calendar();
    }

    // Init ordered items hashmap
    public void initializeOrdered() {
        orderedItems_ = new HashMap<Integer, ArrayList<Item>>();
    }

    // Init cash register
    public void initializeRegister() {
        register_ = new CashRegister();
    }

    // Init sold items list
    public void initializeSoldItems() {
        soldItems_ = new ArrayList<Item>();
    }
    
    // Add item to inventory
    public void add_to_inventory(Item item) {
        inventory_.put_item((item));
    }

    // Remove item from inventory
    public void remove_from_inventory(Item item) {
        inventory_.remove_item(item);
    }

    // Add item to sold list
    public void add_to_sold(Item item) {
        soldItems_.add(item);
    }

    // Remove item to sold list
    public void remove_from_sold(Item item) {
        soldItems_.remove(item);
    }

    // Add item to ordered list
    public void add_to_ordered(Integer day, ArrayList<Item> items) {
        orderedItems_.put(day,items);
    }

    // Remove item to ordered list
    public void remove_from_ordered(Item item) {
        orderedItems_.remove(item);
    }

    // Getters and Setters
    public void set_employees(ArrayList<Employee> employees) {
        employees_ = employees;
    }

    public void set_register(CashRegister register) {
        register_ = register;
    }

    public void set_calendar(Calendar calendar) {
        calendar_ = calendar;
    }

    public Inventory get_inventory() {
        return inventory_;
    }

    public ArrayList<Item> get_sold_items() {
        return soldItems_;
    }

    public HashMap<Integer, ArrayList<Item>> get_ordered() {
        return orderedItems_;
    }

    public ArrayList<Employee> get_employees() {
        return employees_;
    }

    // Get clerks loops through employees/clerks and adds them to ArrayList of clerks
    public ArrayList<Clerk> get_clerks() {
        ArrayList<Clerk> clerks = new ArrayList<Clerk>();
        for(Employee emp : employees_){
            if(emp instanceof Clerk){
                clerks.add((Clerk)emp);
            }
        }
        return clerks;
    }

    public Clerk get_clerk_of_the_day() {
        Random rand = new Random();
        int rand_num = rand.nextInt(2);

        boolean clerk_available = true;

        Clerk current_clerk = new Clerk("", this);
        Clerk clerk1 = get_clerks().get(0);
        Clerk clerk2 = get_clerks().get(1);

        if (rand_num == 0) {
            if (clerk1.get_days_worked() < 3) {
                current_clerk = clerk1;
                clerk2.set_days_worked(0);
            } else if (clerk2.get_days_worked() < 3) {
                current_clerk = clerk2; 
                clerk1.set_days_worked(0);
            } else {
                clerk_available = false;
            }
        } else {
            if (clerk2.get_days_worked() < 3) {
                current_clerk = clerk2;
                clerk1.set_days_worked(0);
            } else if (clerk1.get_days_worked() < 3) {
                current_clerk = clerk1;
                clerk2.set_days_worked(0);
            } else {
                clerk_available = false;
            }
        }
        if (clerk_available) {
            return current_clerk;
        } 

        return null;
    }

    public CashRegister get_register() {
        return register_;
    }

    public Calendar get_calendar() {
        return calendar_;
    }

    public boolean search_ordered_item_type(String orderType){
        for(HashMap.Entry<Integer, ArrayList<Item>> entry : orderedItems_.entrySet()){ //For each entry in the orderedList_ map
            String foundType = entry.getValue().get(0).toString().split(":")[0]; //Get the type of the item bunch in that entr
            if(foundType.equals(orderType)) { //If the found type matches the passed type, the item is already ordered
                return true;
            }
        }
        return false;
    }
}