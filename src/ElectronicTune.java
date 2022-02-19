public class ElectronicTune implements TuneBehavior{
    public void tuneStringed(Stringed item) {
        if(!item.get_tuned()){
            item.set_tuned(true);
        }
    }

    public void tuneWind(Wind item){
        if(!item.get_adjusted()){
            item.set_adjusted(true);
        }
    }

    public void tunePlayers(Players item){
        if(!item.get_equalized()){
            item.set_equalized(true);
        }
    }
}