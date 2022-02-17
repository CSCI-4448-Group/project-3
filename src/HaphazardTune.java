public class HaphazardTune implements TuneBehavior{
    public void tune(Item item){
        if(rand_.nextInt(100) >= 50){
            return;
        }

        if(item instanceof Stringed){
            Stringed stringItem = (Stringed)item; //cast it to a stringed item
            stringItem.set_tuned(!stringItem.get_tuned()); //invert the boolean
        }
        else if(item instanceof Wind){
            Wind windItem = (Wind)item;
            windItem.set_adjusted(!windItem.get_adjusted());
        }
        else{
            Players playerItem = (Players)item;
            playerItem.set_equalized(!playerItem.get_equalized());
        }
    }
}