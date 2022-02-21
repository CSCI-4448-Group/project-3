import java.util.Random;
public class Decorator {

    // Adopted/modified this Decorator from Bruce Montgomery's Decorator example code in class.

    public Decorator() {}

    public Item run(Stringed soldItem, Store s) {
        // making it look like Decorator in the book
        // by wrapping the actual thing you're selling

        int electric_percent = 0;
        if (soldItem.get_electric()) {
            electric_percent = 10;
        }

        Random rand = new Random();
        int percent = rand.nextInt(100);

        if (percent < 10 + electric_percent && s.get_inventory().get_count("Gigbag") > 0) {
            soldItem = new GigBag_addon(soldItem);
        }

        percent = rand.nextInt(100);
        if (percent < 30 + electric_percent && s.get_inventory().get_count("Strings") > 0) {
            System.out.println("XXXXX Selling Strings with " + soldItem.get_name());
            soldItem = new Strings_addon(soldItem);

            int chance = rand.nextInt(3);
            if (chance == 1) {
                soldItem = new Strings_addon(soldItem);
            }
            if (chance == 2) {
                soldItem = new Strings_addon(soldItem);
            }
        }
        
        percent = rand.nextInt(100);
        if (percent < 20 + electric_percent && s.get_inventory().get_count("Cable") > 0) {
            soldItem = new Cable_addon(soldItem);

            int chance = rand.nextInt(2);
            if (chance == 0) {
                soldItem = new Cable_addon(soldItem);
            }
        }

        percent = rand.nextInt(100);
        if (percent < 15 + electric_percent && s.get_inventory().get_count("Practice Amp") > 0) {
            soldItem = new Practice_amp_addon(soldItem);
        }

        return soldItem;
    }
}