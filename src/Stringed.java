public abstract class Stringed extends Instrument
{
    private boolean electric_;
    private boolean tuned_ = false;

    Stringed(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        electric_ = electric;
    }

    boolean get_tuned(){return tuned_;}
    void set_tuned(boolean tuned){tuned_ = tuned;}
    boolean get_electric() {return electric_;}
}

class Guitar extends Stringed
{
    Guitar(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric);
    }
    public String toString(){
        return "Guitar: " + get_brand();
    }
}

class Bass extends Stringed
{
    Bass(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric);
    }
    public String toString(){
        return "Bass: " + get_brand();
    }
}

class Mandolin extends Stringed
{
    Mandolin(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric);
    }
    public String toString(){
        return new String("Mandolin: " + get_brand());
    }
}

abstract class StringedDecorator extends Stringed {
    StringedDecorator(Stringed item) {
        super(item.get_name(), item.get_purch_price(), item.get_list_price(), 
        item.get_is_new(), item.get_day_arrived(), item.get_condition(), 
        item.get_sale_price(), item.get_brand(), item.get_electric());
    }
}

// Returns the item in a decorator fashion, and sells the corresponding addon item
class GigBag_addon extends StringedDecorator {
    GigBag_addon(Stringed component, Clerk clerk) {
        super(component);

        Item item = clerk.get_store().get_inventory().get_items_of_type("GigBag").get(0);
        clerk.sell_item(item, item.get_list_price());
    }
}

// Returns the item in a decorator fashion, and sells the corresponding addon item
class Strings_addon extends StringedDecorator {
    Strings_addon(Stringed component, Clerk clerk) {
        super(component);
        Item item = clerk.get_store().get_inventory().get_items_of_type("Strings").get(0);
        clerk.sell_item(item, item.get_list_price());
    }
}

// Returns the item in a decorator fashion, and sells the corresponding addon item
class Practice_amp_addon extends StringedDecorator {
    Practice_amp_addon(Stringed component, Clerk clerk) {
        super(component);
        Item item = clerk.get_store().get_inventory().get_items_of_type("Practice Amp").get(0);
        clerk.sell_item(item, item.get_list_price()); 
    }
}

// Returns the item in a decorator fashion, and sells the corresponding addon item
class Cable_addon extends StringedDecorator {
    Cable_addon(Stringed component, Clerk clerk) {
        super(component);
        Item item = clerk.get_store().get_inventory().get_items_of_type("Cable").get(0);
        clerk.sell_item(item, item.get_list_price());
    }
}