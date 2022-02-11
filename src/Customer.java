import java.util.Random;
abstract class Customer extends Person {
     // Customer extends Person
    public Customer(String name) {
        super(name);
    }

    // This function helps with buying and selling functionality if we choose to buy during haggling
    public boolean haggle_roll(int percentChance){
        Random rand = new Random();
        return rand.nextInt(100) < percentChance;
    }
}

