public abstract class Stringed extends Instrument
{
    private boolean electric_;
    private boolean tuned_;

    Stringed(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric, boolean tuned)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand);
        electric_ = electric;
        tuned_ = tuned;
    }
}

class Guitar extends Stringed
{
    Guitar(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric, boolean tuned)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric, tuned);
    }
    public String toString(){
        return "Guitar: " + get_brand();
    }
}

class Bass extends Stringed
{
    Bass(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric, boolean tuned)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric, tuned);
    }
    public String toString(){
        return "Bass: " + get_brand();
    }
}

class Mandolin extends Stringed
{
    Mandolin(String name, double purchPrice, double listPrice, boolean isNew, int dayArriv, Condition condition, double salePrice, String brand, boolean electric, boolean tuned)
    {
        super(name, purchPrice, listPrice, isNew, dayArriv, condition, salePrice, brand, electric, tuned);
    }
    public String toString(){
        return new String("Mandolin: " + get_brand());
    }
}
