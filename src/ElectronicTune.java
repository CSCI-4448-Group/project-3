public class ElectronicTune implements TuneBehavior{
    public void tune(Item item) {
        if(!item.get_tuned()){
            item.set_tuned(true);
        }
    }
}