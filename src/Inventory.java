import java.util.HashMap;
import java.util.ArrayList;

public class Inventory{
    //Map from ItemType->List of items
    private static HashMap<String, ArrayList<Item>> inventory_;

    Inventory(){
        initialize();
    }
    public void initialize(){
        inventory_ = new HashMap<>();
    }

    //Return the hashmap of inventory
    public HashMap<String, ArrayList<Item>> get_mapping() {
        return inventory_;
    }

    //Return the count of item type in inventory
    public int get_count(String type){
        if(inventory_.containsValue(type)){
            return inventory_.get(type).size();
        }
        return 0;
    }

    public static ArrayList<String> get_item_types() {
        ArrayList<String> mainList = new ArrayList<>();
        mainList.addAll(inventory_.keySet());
        return mainList;
    }

    //Return list of items of type in inventory
    public ArrayList<Item> get_items_of_type(String type){
        return(inventory_.get(type));
    }

    //Return the sum of pruchase price for all items in inventory
    public double get_purch_price_sum(){
        double sum = 0;
        for(Item i : flatten_inventory()){
            sum += i.get_purch_price();
        }
        return sum;
    }

    //Return the sum of the list price for all items in inventory
    public double get_list_price_sum(){
        double sum = 0;
        for(Item i : flatten_inventory()){
            sum += i.get_list_price();
        }
        return sum;
    }

    //Add the items to their corresponding map entry list
    public void put_items(ArrayList<Item> items){
        items.forEach((item)->put_item(item));
    }

    //Add the item to its corresponding map entry list
    public void put_item(Item item){
        System.out.println("Adding item to inventory " + item.toString());
        String type = item.toString().split(":")[0];
        if(inventory_.containsKey(type)){ //If the Item type is already a key in the map
            inventory_.get(type).add(item);
        }
        else{
            inventory_.put(type, new ArrayList<Item>(){{add(item);}}); //Else add a new entry into the map of the form (itemType, new list containing new item)
        }
    }

    //Remove item from list of items type
    public void remove_item(Item item){
        String type = item.toString().split(":")[0];
        if(inventory_.containsKey(type)){
            inventory_.get(type).remove(item);
        }
    }

    //Flatten the inventory_ hashMap into a list of all items currently in inventory
    public ArrayList<Item> flatten_inventory(){
        ArrayList<Item> items = new ArrayList<Item>();
        inventory_.forEach((k,v)-> items.addAll(v));
        return items;
    }
}