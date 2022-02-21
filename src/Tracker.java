//// Tracker class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out the state of clerk's items sold, purchased and damaged
//
//import java.io.FileWriter;  // Import the File class
//import java.io.IOException;  // Import the IOException class to handle errors
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Tracker extends Employee implements Observer {
//    private String employeeName_;
//    private HashMap<String, ArrayList<Integer>> trackerMap_;
//    private String announcement_;
//
//    public Tracker(String name, Store s, ArrayList<Subject> clerks)
//    {
//        super(name, s);
//        employeeName_ = get_name();
//        for (Subject c : clerks){
//            c.registerObserver(this);
//            trackerMap_.put()
//        }
//    }
//
//    public void track(int day) {
//        System.out.println("Tracker: Day " + day);
//        System.out.println("==============================");
//
//    }
//
//    @Override
//    public void update(String announcement) {
//        this.announcement_ = announcement;
//        track(get_store().get_calendar().get_current_day());
//    }
//
//    public HashMap<String, ArrayList<Integer>> getTrackerMap_() {return trackerMap_;}
//
//    public void setTrackerMap_(String name, ArrayList<Integer> newClerkList) {trackerMap_.put(name, newClerkList);}
//}
