import java.util.Random;
public class Decorator {

    // Adopted/modified this Decorator from Bruce Montgomery's Decorator example code in class.

    public Decorator() {}

    public Item run(Item soldItem, Store s, Clerk clerk) {
        // making it look like Decorator in the book
        // by wrapping the actual thing you're selling

        String sale_message = clerk.get_name() + " sold ";

        int electric_percent = 0;
        if ( ((Stringed)soldItem).get_electric()) {
            electric_percent = 10;
        }

        Random rand = new Random();
        int percent = rand.nextInt(100);

        if (percent < 10 + electric_percent && s.get_inventory().get_count("Gigbag") > 0) {
            soldItem = new GigBag_addon((Stringed)soldItem, clerk);
        }

        percent = rand.nextInt(100);
        int strings_count = s.get_inventory().get_count("Strings");
        if (percent < 30 + electric_percent && strings_count > 0) {
            sale_message += "1 Strings, ";
            soldItem = new Strings_addon((Stringed)soldItem, clerk);

            int chance = rand.nextInt(3);
            if (chance == 1 && strings_count > 1) {
                sale_message += "1 Strings, ";
                soldItem = new Strings_addon((Stringed)soldItem, clerk);
            }
            if (chance == 2 && strings_count > 2) {
                sale_message += "1 Strings, ";
                soldItem = new Strings_addon((Stringed)soldItem, clerk);
            }
        }
        
        percent = rand.nextInt(100);
        int cable_count = s.get_inventory().get_count("Cable");
        if (percent < 20 + electric_percent && cable_count > 0) {
            sale_message += "1 Cable, ";
            soldItem = new Cable_addon((Stringed)soldItem, clerk);

            int chance = rand.nextInt(2);
            if (chance == 0 && cable_count > 1) {
                sale_message += "1 Cable, ";
                soldItem = new Cable_addon((Stringed)soldItem, clerk);
            }
        }

        percent = rand.nextInt(100);
        if (percent < 15 + electric_percent && s.get_inventory().get_count("Practice Amp") > 0) {
            sale_message += "1 Practice Amp, ";
            soldItem = new Practice_amp_addon((Stringed)soldItem, clerk);
        }

        if (!sale_message.equals(clerk.get_name() + " sold ")) {
            sale_message += "with the " + soldItem.get_name();
            System.out.println(sale_message);
        }
        return soldItem;
    }
}