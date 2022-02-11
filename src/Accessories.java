public abstract class Accessories extends Item
{
    private String brand_;

    Accessories(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice);
        brand_ = brand;
    }

    public String get_brand() {return brand_;}

    public void set_brand(String newBrand) {brand_ = newBrand;}
    public abstract String toString();
}

class PracticeAmp extends Accessories
{
    private int wattage_;

    PracticeAmp(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, int wattage)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        wattage_ = wattage;
    }

    public int get_wattage() {return wattage_;}

    public void set_wattage(int newWattage) {wattage_ = newWattage;}

    public String toString(){return "Practice Amp: " + get_brand();}
}

class Cable extends Accessories
{
    private int length_;

    Cable(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, int length)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        length_ = length;
    }

    public int get_length() {return length_;}

    public void set_length(int newLength) {length_ = newLength;}

    public String toString(){
        return "Cable: " + get_brand();
    }
}

class Strings extends Accessories
{
    private String type_;

    Strings(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, String type)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        type_ = type;
    }

    public String get_type() {return type_;}

    public void set_type(String newType) {type_ = newType;}

    public String toString(){
        return "Strings: " + get_brand();
    }
}