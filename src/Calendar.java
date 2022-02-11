public class Calendar {
    private int begin_day_; // Simulation start date
    private int current_day_; // Simulation current date

    public Calendar() {
        begin_day_ = 0;
        current_day_ = 1;
    }

    // Getters and Setters for class data
    public int get_current_day() {return current_day_;}
    public int get_begin_day() {return begin_day_;}
    public void set_current_day(int day) {
        if(day < 0){
            throw new IllegalArgumentException("Error: cannot set current day < 0");
        }
        current_day_ = day;
    }
    public void set_begin_day(int day) {
        if(day < 0){
            throw new IllegalArgumentException("Error: cannot set begin day < 0");
        }
        begin_day_ = day;
    }

    // Methods to increment or decrement day data
    public void incr_current_day() {current_day_ += 1;}
    public void decr_current_day() {if(current_day_ > 0) {current_day_ -= 1;}}
    public void incr_begin_day() {set_current_day(get_current_day() + 1);} //idk if we will actually need this
    public void decr_begin_day() {if(begin_day_ > 0) {begin_day_ -= 1;}}
}
