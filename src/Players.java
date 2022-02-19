public abstract class Players extends Item {
    // Players are a subclass of item

    private String brand_; // Each player has a brand
    private boolean equalized_; // Each player has an equalized property
    Players(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean equalized)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice);
        brand_ = brand;
        equalized_ = equalized;
    }

    // Getters and setters
    public String get_brand() {return brand_;}
    public void set_brand(String newBrand) {brand_ = newBrand;}

    public boolean get_equalized() {return equalized_;}

    public void set_equalized(boolean newEqualized) {equalized_ = newEqualized;}
}

// CD_Player, RecordPlayer, MP3Player extend Players
class CD_Player extends Players
{
    CD_Player(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean equalized)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, equalized);
    }
    public String toString(){
        return "CDPlayer: " + get_brand();
    }
}

class RecordPlayer extends Players
{
    RecordPlayer(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean equalized)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, equalized);
    }
    public String toString(){
        return "RecordPlayer: " + get_brand();
    }
}

class MP3Player extends Players
{
    MP3Player(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean equalized)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, equalized);
    }
    public String toString(){
        return "MP3Player: " + get_brand();
    }
}

class CassettePlayer extends Players
{
    CassettePlayer(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean equalized)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, equalized);
    }
    public String toString(){
        return "CassettePlayer: " + get_brand();
    }
}