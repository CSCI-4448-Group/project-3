public class ManualTune implements TuneBehavior{
    //Each tune function is of the form "If item isnt tuned and we win 80% chance roll, tune the item"
    //                                  "Else if item is tuned and we win 20% chance roll, untune the item"
    public void tune(Item item){
        if(!item.get_tuned() && rand_.nextInt(100) < 80){
            item.set_tuned(true);
        }
        else if(item.get_tuned() && rand_.nextInt(100) < 20){
            item.set_tuned(false);
        }
    }
}