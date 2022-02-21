// Tracker class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out the state of clerk's items sold, purchased and damaged

import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.HashMap;

public class Tracker extends Employee implements Observer {
    private HashMap<String, ArrayList<Integer>> trackerMap_ = new HashMap<>();
    private ArrayList<Integer> clerkList;
    private String numItemsSold_;
    private String numItemsPurchased_;
    private String numItemsDamaged_;
    private String nameOfEmployee_;
    private String announcement_;

    public Tracker(String name, Store s, Subject clerk)
    {
        super(name, s);
        clerk.registerObserver(this);
    }

    public void track(int day, String nameOfEmployee, String numItemsSold, String numItemsPurchased, String numItemsDamaged) {
        if (!trackerMap_.containsKey(nameOfEmployee))
        {
            ArrayList<Integer> emptyClerkList = new ArrayList<Integer>();
            setTrackerMap_(nameOfEmployee, emptyClerkList);
        }
        else
        {
            int updateSoldItems = trackerMap_.get(nameOfEmployee).get(0) + Integer.parseInt(numItemsSold);
            int updatePurchasedItems = trackerMap_.get(nameOfEmployee).get(1) + Integer.parseInt(numItemsPurchased);
            int updateDamagedItems = trackerMap_.get(nameOfEmployee).get(2) + Integer.parseInt(numItemsDamaged);

            trackerMap_.get(nameOfEmployee).set(0, updateSoldItems);
            trackerMap_.get(nameOfEmployee).set(1, updatePurchasedItems);
            trackerMap_.get(nameOfEmployee).set(2, updateDamagedItems);
        }

        System.out.println("Tracker: Day " + day);
        System.out.println("==============================");
        System.out.println("Clerk       Items Sold      Items Purchased     Items Damaged");

        for (String n : trackerMap_.keySet()) {
            System.out.println(n + "       " + trackerMap_.get(n).get(0) + "         " + trackerMap_.get(n).get(1) + "       " + trackerMap_.get(n).get(2));
        }
    }

    @Override
    public void update(String nameOfEmployee, String numItemsSold, String numItemsPurchased, String numItemsDamaged) {
        nameOfEmployee_ = nameOfEmployee;
        numItemsSold_ = numItemsSold;
        numItemsPurchased_ = numItemsPurchased;
        numItemsDamaged_ = numItemsDamaged;
        track(get_store().get_calendar().get_current_day(), nameOfEmployee_, numItemsSold_, numItemsPurchased_, numItemsDamaged_);
    }

    public void update(String announcement) {
        throw new IllegalArgumentException("Error: Wrong update method");
    }

    public HashMap<String, ArrayList<Integer>> getTrackerMap_() {return trackerMap_;}

    public void setTrackerMap_(String name, ArrayList<Integer> emptyClerkList) {
        emptyClerkList.add(0);
        emptyClerkList.add(0);
        emptyClerkList.add(0);
        trackerMap_.put(name, emptyClerkList);
    }
}
