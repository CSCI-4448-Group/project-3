//// Tracker class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out the state of clerk's items sold, purchased and damaged
//
//import java.io.FileWriter;  // Import the File class
//import java.io.IOException;  // Import the IOException class to handle errors
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Tracker extends Employee implements Observer {
//    private HashMap<String, ArrayList<Int>> trackerMap_;
//
//    public Tracker(String name, Store s, Subject clerk)
//    {
//        super(name, s);
//        clerk.registerObserver(this);
//    }
//
//    @Override
//    public void update(String announcement) {
//        this.announcement_ = announcement;
//        track(get_store().get_calendar().get_current_day());
//    }
//}
