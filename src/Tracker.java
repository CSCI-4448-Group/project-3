// Tracker class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out the state of clerk's items sold, purchased and damaged

import java.util.ArrayList;
import java.util.HashMap;

public class Tracker implements Observer {
    private HashMap<String, ArrayList<Integer>> trackerMap_ = new HashMap<>(); // Define data structure to store relevant clerk information
    private Calendar calendar; // Calendar attribute for tracking

    // Constructor for Tracker
    public Tracker(Store s)
    {
        calendar = s.get_calendar();
    }

    // Register Tracker as observer of subject clerk
    public void registerClerk(Subject clerk) {
        clerk.registerObserver(this);
    }

    public void track(String nameOfEmployee, int numItemsSold, int numItemsPurchased, int numItemsDamaged) {
        // If the tracker map does not contain the current employee name as a key
        if (!trackerMap_.containsKey(nameOfEmployee))
        {
            // Call setTrackerMap which will create a new entry in HashMap with name of employee and arrayList containing zero values for items sold, items purchased, items damaged
            setTrackerMap_(nameOfEmployee, new ArrayList<Integer>());
        }
        // If the tracker map does contain the name of the employee as a key
        // Update all relevant indices of ArrayList value with increments of parameters
        int updateSoldItems = trackerMap_.get(nameOfEmployee).get(0) + numItemsSold;
        int updatePurchasedItems = trackerMap_.get(nameOfEmployee).get(1) + numItemsPurchased;
        int updateDamagedItems = trackerMap_.get(nameOfEmployee).get(2) + numItemsDamaged;

        // Set the arrayList value indices with updated sold items, purchased items, damaged items
        trackerMap_.get(nameOfEmployee).set(0, updateSoldItems);
        trackerMap_.get(nameOfEmployee).set(1, updatePurchasedItems);
        trackerMap_.get(nameOfEmployee).set(2, updateDamagedItems);
    }

    // Print out relevant data in table format
    public void print_daily_stats() {
        // Divide print statements
        System.out.println("===========================================");
        System.out.println("Tracker: Day " + (calendar.get_current_day() - 1));
        System.out.println("Clerk       Items Sold      Items Purchased     Items Damaged");

        // Go through trackerMap data structure and print out clerk name, items sold, items purchased, items damaged for clerk
        for (String n : trackerMap_.keySet()) {
            System.out.println(n + "          " + trackerMap_.get(n).get(0) + "                " + trackerMap_.get(n).get(1) + "                 " + trackerMap_.get(n).get(2));
        }
    }

    // Method implementation from observer interface
    @Override
    public void update(String announcement) {
        // Use regex to split the string on colons and ensure message is tracker
        if (announcement.split(":")[0].equals("tracker")) {

            // Split announcement string on commas to separate data elements
            String[] vars = announcement.split("tracker: ")[1].split(",");

            // Store data from announcement into relevant variables
            String nameOfEmployee_ = vars[0];
            int numItemsSold_ = Integer.valueOf(vars[1]);
            int numItemsPurchased_ = Integer.valueOf(vars[2]);
            int numItemsDamaged_ = Integer.valueOf(vars[3]);

            // Call track to update tracker's hashmap
            track(nameOfEmployee_, numItemsSold_, numItemsPurchased_, numItemsDamaged_);
        }
        // If the announcement split on colon is print, call print_daily_stats
        else if (announcement.split(":")[0].equals("print")) {
            print_daily_stats();
        } else {
            return;
        }
    }

    public HashMap<String, ArrayList<Integer>> getTrackerMap_() {return trackerMap_;}

    // Takes in a new name key and empty clerk arraylist value and create new entry in HashMap
    public void setTrackerMap_(String name, ArrayList<Integer> emptyClerkList) {
        // Zero out values in arrayList Hashmap value
        emptyClerkList.add(0);
        emptyClerkList.add(0);
        emptyClerkList.add(0);
        // Call put to create a new entry in Tracker's Hashmap
        trackerMap_.put(name, emptyClerkList);
    }
}
