public abstract class Stringed extends Instrument
{
    private boolean electric_;
    private boolean tuned_ = false;

    Stringed(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        electric_ = electric;
    }
    Stringed() {super();}

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
    Stringed component;
    String name;
}

class GigBag_addon extends StringedDecorator {
    GigBag_addon() { super(); }
    GigBag_addon(Stringed component) {
        this.component = component;
        name = component.get_name() + " and GigBag";    }
}

class Strings_addon extends StringedDecorator {
    Strings_addon() { super(); }
    Strings_addon(Stringed component) {
        this.component = component;
        name = component.get_name() + " and Strings";
    }
}

class Practice_amp_addon extends StringedDecorator {
    Practice_amp_addon() { super(); }
    Practice_amp_addon(Stringed component) {
        this.component = component;
        name = component.get_name() + " and Practice Amp";    }
}

class Cable_addon extends StringedDecorator {
    Cable_addon() { super(); }
    Cable_addon(Stringed component) {
        this.component = component;
        name = component.get_name() + " and 1 Cable";
    }
}