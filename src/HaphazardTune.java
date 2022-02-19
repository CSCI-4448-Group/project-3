public class HaphazardTune implements TuneBehavior{
    public void tuneStringed(Stringed item) {
        if (rand_.nextInt(100) < 50) {
            item.set_tuned(!item.get_tuned());
        }
    }

    public void tuneWind(Wind item){
        if(rand_.nextInt(100)<50){
            item.set_adjusted(!item.get_adjusted());
        }
    }

    public void tunePlayers(Players item){
        if(rand_.nextInt(100)<50){
            item.set_equalized(!item.get_equalized());
        }
    }
}