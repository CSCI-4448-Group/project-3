import java.util.Random;
public interface TuneBehavior{
    public Random rand_ = new Random();
    public default void tune(Item item){
        if(item instanceof Stringed){
            tuneStringed((Stringed)item);
        }
        else if(item instanceof Wind){
            tuneWind((Wind)item);
        }
        else if(item instanceof Players){
            tunePlayers((Players)item);
        }
        else{
            throw new IllegalArgumentException("tune() called on invalid item type: " + item.get_item_type());
        }
    }
    public void tuneStringed(Stringed item);
    public void tuneWind(Wind item);
    public void tunePlayers(Players item);
}