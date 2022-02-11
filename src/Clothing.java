public abstract class Clothing extends Item // Clothing extends abstract class Item
{
    private String brand_; // Each clothing has a brand

    Clothing(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice);
        brand_ = brand;
    }

    // Getters and setters
    public String get_brand() {return brand_;}

    public void set_brand(String newBrand) {brand_ = newBrand;}
}

class Hat extends Clothing // Hat is a subclass of clothing
{
    private int hatSize_; // Hat Size is the attribute of hat

    Hat(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, int hatSize)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        hatSize_ = hatSize;
    }

    // Getters and setters
    public int get_hat_size() {return hatSize_;}

    public void set_hat_size(int newHatSize) {hatSize_ = newHatSize;}

    public String toString(){
        return "Hat: " + get_brand();
    }
}

class Bandana extends Clothing // Bandana extends clothing
{
    Bandana(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
    }

    // Only need toString
    public String toString(){
        return "Bandana: " + get_brand();
    }
}

class Shirt extends Clothing // Shirt extends Clothing
{
    private int shirtSize_; // Shirt Size is the attribute of hat

    Shirt(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, int shirtSize)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        shirtSize_ = shirtSize;
    }

    // Getters and Setters
    public int get_shirt_size() {return shirtSize_;}

    public void set_shirt_size(int newShirtSize) {shirtSize_ = newShirtSize;}

    public String toString(){
        return "Shirt: " + get_brand();
    }
}