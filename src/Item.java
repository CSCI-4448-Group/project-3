import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.Random;
abstract public class Item{
    private String name_;
    private double purchasePrice_;
    private double listPrice_;
    private boolean new_;
    private int dayArrived_;
    private Condition condition_; //Maybe we can use a custom data type here so we can have operators like -- and ++ for increasing or decreasing condition after damage
    private double salePrice_; //Default this value to empty? Can't initialize a sale price that hasnt happened yet
    private int daySold_; //Default this value to current int in calander?

    public Item(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice) {
        name_ = name;
        purchasePrice_=purchPrice;
        listPrice_=listPrice;
        new_ = isNew;
        dayArrived_ = dayArriv;
        condition_ = condition;
        salePrice=salePrice_;
    }

////// Encapsulation: Here we see that the attributes of an Item are private, and we have public ways of accessing and modifiying that data. //////

    public void set_name(String name){name_ = name;}
    public void set_purch_price(double price){purchasePrice_ = price;}
    public void set_list_price(double price){listPrice_ = price;}
    public void set_is_new(boolean isNew){new_ = isNew;}
    public void set_day_arrived(int arrived){dayArrived_ = arrived;}
    public void set_condition(Condition cond){condition_ = cond;}
    public void set_sale_price(double price){salePrice_ = price;}
    public void set_day_sold(int soldint){daySold_ = soldint;}

    public String get_name(){return name_;}
    public double get_purch_price(){return purchasePrice_;}
    public double get_list_price(){return listPrice_;}
    public boolean get_is_new(){return new_;}
    public int get_day_arrived(){return dayArrived_;}
    public Condition get_condition(){return condition_;}
    public double get_sale_price(){return salePrice_;}
    public int get_day_sold(){return daySold_;}
    public String get_new_or_used() {if (new_ == true) {return "new";} else {return "used";}}

    //Builds an item of type passed if there is template available in itemBuilder, throws exception if invalid type
    public static Item generate_item(String type) throws Exception {
        type = type.toLowerCase();
        if (itemBuilder_.containsKey(type)) { //If the itemBuilder_ has a template for the desired item
            return itemBuilder_.get(type).call(); //Generate that item and return it
        }
        System.out.println("Item type:" + type);
        throw new IllegalArgumentException("generate_item attempted to generate invalid item");
    }

    //Mapping from (item type) -> lambda function building an item of that type with random attributes
    private static HashMap<String, Callable<Item>> itemBuilder_ = new HashMap<String, Callable<Item>>() {{
        put("cd", () -> {
            Random rand = new Random();
            String[] brands = {"Led Zepplin", "Metallica", "Daft Punk", "AC/DC"};
            String[] albums = {"Dark side of the flute", "Random Access Montgomery", "Its never cheesy enough", "SEG_FAULT: just kidding"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new CD(name + " CD",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,albums[rand.nextInt(albums.length)]);
        });
        put("vinyl", () -> {
            Random rand = new Random();
            String[] brands = {"Led Zepplin", "Metallica", "Daft Punk", "AC/DC"};
            String[] albums = {"Dark side of the flute", "Random Access Montgomery", "Its never cheesy enough", "SEG_FAULT: just kidding"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Vinyl(name + " Vinyl",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,albums[rand.nextInt(albums.length)]);
        });
        put("paperscore", () -> {
            Random rand = new Random();
            String[] brands = {"Led Zepplin", "Metallica", "Daft Punk", "AC/DC"};
            String[] albums = {"Dark side of the flute", "Random Access Montgomery", "Its never cheesy enough", "SEG_FAULT: just kidding"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new PaperScore(name + " Paperscore",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,albums[rand.nextInt(albums.length)]);
        });
        put("practice amp", () -> {
            Random rand = new Random();
            String[] brands = {"Roland", "Bugera", "Laney", "Line 6"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new PracticeAmp(name + " PracticeAmp",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,rand.nextInt(1000));
        });
        put("cable", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Dunlop", "Elixir", "GHS"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Cable(name + " Strings",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,rand.nextInt(500));
        });
        put("strings", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Dunlop", "Elixir", "GHS"};
            String[] types = {"5 gauge", "6 gauge", "7 gauge", "8 gauge", "10 gauge"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Strings(name + " Strings",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name,types[rand.nextInt(types.length)]);
        });
        put("cdplayer", () -> {
            Random rand = new Random();
            String[] brands = {"LG", "Dell", "Logitech", "Sony"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new CD_Player(name + " CDPlayer",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name);
        });
        put("recordplayer", () -> {
            Random rand = new Random();
            String[] brands = {"LG", "Dell", "Logitech", "Sony"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new RecordPlayer(name + " RecordPlayer",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name);
        });
        put("mp3player", () -> {
            Random rand = new Random();
            String[] brands = {"LG", "Dell", "Logitech", "Sony"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new MP3Player(name + " MP3Player",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name);
        });
        put("hat", () -> {
            Random rand = new Random();
            String[] brands = {"Hanes", "Bailey", "Goorin", "New Era"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Hat(name + " Hat",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, rand.nextInt(7));
        });
        put("bandana", () -> {
            Random rand = new Random();
            String[] brands = {"Hanes", "Bailey", "Goorin", "New Era"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Bandana(name + " Bandana",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name);
        });
        put("shirt", () -> {
            Random rand = new Random();
            String[] brands = {"Hane", "Dell", "Logitech", "Sony"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Shirt(name + " Shirt",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, rand.nextInt(5));
        });
        put("guitar", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Fender", "PRS", "G&L"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Guitar(name + " Guitar",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, rand.nextBoolean());
        });
        put("bass", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Fender", "PRS", "G&L"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Bass(name + " Bass",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, rand.nextBoolean());
        });
        put("mandolin", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Fender", "PRS", "G&L"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Mandolin(name + " Mandolin",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, rand.nextBoolean());
        });
        put("flute", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Fender", "PRS", "G&L"};
            String[] types = {"Alto", "C", "Wooden"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Flute(name + " Guitar",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, types[rand.nextInt(types.length)]);
        });
        put("harmonica", () -> {
            Random rand = new Random();
            String[] brands = {"Gibson", "Fender", "PRS", "G&L"};
            String[] keys = {"A","B","C","D","E","F","G"};
            String name = brands[rand.nextInt(brands.length)];
            int purchPrice = rand.nextInt(50) + 1;
            return new Harmonica(name + " Guitar",purchPrice,purchPrice*2,rand.nextBoolean(),
                    -1,new Condition("good"),0,name, keys[rand.nextInt(keys.length)]);
        });

        // All of the above are potential random items to generate from




    }};

}