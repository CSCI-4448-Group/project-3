// Logger class is an example of the Observer pattern wherein it subscribes to other classes (in this case the clerk) and prints out relevant messages

import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class Logger implements Observer {
    private String announcement_;
    private String name = "Logger";
    private int currDay;

    public String get_name() {
        return name;
    }

    public Logger(String name, Store s, Subject clerk)
    {
        clerk.registerObserver(this);
        currDay = s.get_calendar().get_current_day();
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
        if (!announcement.split(":")[0].equals("logger")) {
            return;
        }
        this.announcement_ = announcement.split("logger: ")[1];
        log(currDay);
    }
}
