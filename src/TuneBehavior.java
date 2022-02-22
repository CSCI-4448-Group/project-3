import java.util.Random;
public interface TuneBehavior{
    public Random rand_ = new Random();
    public void tune(Item item);
}