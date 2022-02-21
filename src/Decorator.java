import java.util.Random;
public class Decorator {

    // Adopted/modified this Decorator from Bruce Montgomery's Decorator example code in class.

    public Decorator() {}

    public Item run(Item soldItem, Store s, Clerk clerk) {

        // Creates the message to output to the console after all items have been added to the order
        String sale_message = clerk.get_name() + " sold ";
        double total_new_cost = 0.0;

        // Electric items are 10% more likely to have additional sales than acoustic items
        int electric_percent = 0;
        if ( ((Stringed)soldItem).get_electric()) {
            electric_percent = 10;
        }

        Random rand = new Random();

        // Random percent chance
        int percent = rand.nextInt(100);
        int gigbag_count = s.get_inventory().get_count("GigBag");

        // If 10% chance (20% for electric) and we have a gigbag in stock, we sell it with the current stringed item
        if (percent < 10 + electric_percent && gigbag_count > 0) {
            sale_message += "1 Gigbag ";
            total_new_cost += s.get_inventory().get_items_of_type("GigBag").get(0).get_list_price();
            soldItem = new GigBag_addon((Stringed)soldItem, clerk);
        }

        percent = rand.nextInt(100);
        int strings_count = s.get_inventory().get_count("Strings");

        // If 30% chance (40% for electric) and we have strings in stock, we sell 1-3 strings
        if (percent < 30 + electric_percent && strings_count > 0) {
            int chance = rand.nextInt(3) + 1;
            for (int i = 0; i < chance; i++) {
                if (s.get_inventory().get_count("Strings") > 0) {
                    sale_message += "1 Strings ";
                    total_new_cost += s.get_inventory().get_items_of_type("Strings").get(0).get_list_price();
                    soldItem = new Strings_addon((Stringed)soldItem, clerk);
                }
            }
        }
        
        percent = rand.nextInt(100);
        int cable_count = s.get_inventory().get_count("Cable");

        // If 20% chance (30% for electric) and we have Cables in stock, we sell 1-2 cables
        if (percent < 20 + electric_percent && cable_count > 0) {
            int chance = rand.nextInt(2) + 1;
            for (int i = 0; i < chance; i++) {
                if (s.get_inventory().get_count("Cable") > 0) {
                    sale_message += "1 Cable ";
                    total_new_cost += s.get_inventory().get_items_of_type("Cable").get(0).get_list_price();
                    soldItem = new Cable_addon((Stringed)soldItem, clerk);
                }
            }
        }

        percent = rand.nextInt(100);

        // If 15% chance (25% for electric) and we have practice amps in stock, we sell 1 Practice Amp
        if (percent < 15 + electric_percent && s.get_inventory().get_count("Practice Amp") > 0) {
            sale_message += "1 Practice Amp ";
            total_new_cost += s.get_inventory().get_items_of_type("Practice Amp").get(0).get_list_price();
            soldItem = new Practice_amp_addon((Stringed)soldItem, clerk);
        }

        // If we have not sold anything additional, we do not want to output to the console.
        if (!sale_message.equals(clerk.get_name() + " sold ")) {
            sale_message += "with the " + soldItem.get_name() + " for an additional $" + Double.toString(total_new_cost);
            System.out.println(sale_message);
        }
        return soldItem;
    }
}