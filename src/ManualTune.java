public class ManualTune implements TuneBehavior{
    //Each tune function is of the form "If item isnt tuned and we win 80% chance roll, tune the item"
    //                                  "Else if item is tuned and we win 20% chance roll, untune the item"

    public void tuneStringed(Stringed item){
        if(!item.get_tuned() && rand_.nextInt(100) < 80){
            item.set_tuned(true);
        }
        else if(item.get_tuned() && rand_.nextInt(100) < 20){
            item.set_tuned(false);
        }
    }
    public void tuneWind(Wind item){
        if(!item.get_adjusted() && rand_.nextInt(100) < 80){
            item.set_adjusted(true);
        }
        else if(item.get_adjusted() && rand_.nextInt(100) < 20){
            item.set_adjusted(false);
        }
    }
    public void tunePlayers(Players item){
        if(!item.get_equalized() && rand_.nextInt(100) < 80){
            item.set_equalized(true);
        }
        else if(item.get_equalized() && rand_.nextInt(100) < 20){
            item.set_equalized(false);
        }
    }
}