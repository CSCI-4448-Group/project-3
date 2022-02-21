public class HaphazardTune implements TuneBehavior {
    public void tune(Item item){
        if (rand_.nextInt(100) < 50) {
            item.set_tuned(!item.get_tuned());
        }
    }
}