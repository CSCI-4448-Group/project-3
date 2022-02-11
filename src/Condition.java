import java.util.Random;

// Class to keep track of item condition
public class Condition{

    // String variable for condition
    private String cond_;

    // Constructor checks to see if condition passed in matches an appropriate condition
    Condition(String condition){
        if(condition != "poor" && condition != "fair" && condition != "good" && condition != "very good" && condition != "excellent"){
            throw new IllegalArgumentException("Condition must be valid type");
        }  // Throw an exception if not matching condition
        cond_ = condition; // Set cond_ equal to condition
    }

    // Getters and Setters
    public String get_condition(){return cond_;}
    public void set_condition(String condition){
        if(condition != "poor" && condition != "fair" && condition != "good" && condition != "very good" && condition != "excellent"){
            throw new IllegalArgumentException("Condition must be valid type");
        }
        cond_ = condition;
    }

    // Increase condition to better quality
    public void increaseCondition(){
        if(cond_ == "poor"){cond_ = "fair";}
        else if(cond_ == "fair"){cond_ = "good";}
        else if(cond_ == "good"){cond_ = "very good";}
        else if(cond_ == "very good"){cond_ = "excellent";}
        else{System.out.println("condition is maximum");}
    }

    // Decrease condition to worse quality
    public void decreaseCondition(){
        if(cond_ == "poor"){System.out.println("condition is minimum");}
        else if(cond_ == "fair"){cond_ = "poor";}
        else if(cond_ == "good"){cond_ = "fair";}
        else if(cond_ == "very good"){cond_ = "good";}
        else if(cond_ == "excellent"){cond_ = "very good";}
    }

    // Get a random condition for item
    public static Condition randomCondition(){
        Random rand = new Random();
        String[] conds = {"poor","fair","good","very good", "excellent"};
        return new Condition(conds[rand.nextInt(conds.length)]);
    }
}