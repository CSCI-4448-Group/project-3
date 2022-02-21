// Logger class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out relevant messages

import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class Logger extends Employee implements Observer {
    private String announcement_;
    private String numItemsSold_;
    private String numItemsPurchased_;
    private String numItemsDamaged_;

    public Logger(String name, Store s, Subject clerk)
    {
        super(name, s);
        clerk.registerObserver(this);
    }

    public void arrive(int day) {
        System.out.println(get_name() + " arrived on day " + day);
    }

    //https://www.w3schools.com/java/java_files_create.asp
    public void log(int day) {
        try {
            FileWriter myWriter = new FileWriter("../logger/Logger-" + day + ".txt", true);
            myWriter.write("Logger wrote: " + announcement_ + "\n");
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void update(String announcement) {
        this.announcement_ = announcement;
        log(get_store().get_calendar().get_current_day());
    }

    public void update(String nameOfEmployee_, String numItemsSold, String numItemsPurchased, String numItemsDamaged) {
       throw new IllegalArgumentException("Error: Wrong update method");
    }

    public void close() {
        System.out.println(get_name() + " is leaving the store.");
    }
}
