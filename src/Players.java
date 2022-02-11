public abstract class Players extends Item {
    // Players are a subclass of item

    private String brand_; // Each player has a brand

    Players(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice);
        brand_ = brand;
    }

    // Getters and setters
    public String get_brand() {return brand_;}

    public void set_brand(String newBrand) {brand_ = newBrand;}
}

// CD_Player, RecordPlayer, MP3Player extend Players
class CD_Player extends Players
{
    CD_Player(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
    }
    public String toString(){
        return "CDPlayer: " + get_brand();
    }
}

class RecordPlayer extends Players
{
    RecordPlayer(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
    }
    public String toString(){
        return "RecordPlayer: " + get_brand();
    }
}

class MP3Player extends Players
{
    MP3Player(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
    }
    public String toString(){
        return "MP3Player: " + get_brand();
    }
}