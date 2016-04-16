import java.util.Random;

public class Tamagotchi {

    private static final int MAX_HUNGER = 90;
    private static final int MIN_HUNGER = 30;
    private static final int MIN_JOY = 30;

    private int joy;
    private int hunger;
    private String name;

    public Tamagotchi(String name, int hunger, int joy) {
        this.name = name;
        this.hunger = hunger;
        this.joy = joy;
    }

    public int getJoy() {
        return joy;
    }

    public void setJoy(int joy) {
        this.joy = joy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void giveBiscuit() {
        Random x = new Random();
        hunger = hunger + x.nextInt(10) + 1;
    }

    public void giveLove() {
        Random x = new Random();
        joy = joy + x.nextInt(10) + 1;  //mettere parametri per random come costante
    }

    public void checkStatus() {
        if (hunger <= MAX_HUNGER && hunger >= MIN_HUNGER) {
            System.out.print(name + " è sazio!");
        } else {
            System.out.print("Oh no! " + name + " ha mangiato troppo ed è morto! :[");
        }
        System.out.println();

        if (joy > MIN_JOY && hunger <= MAX_HUNGER ) {
            System.out.println(name + " è felice :D");
        }
        else {
            System.out.println("Oh no! " + name + " è triste, ha bisogno di carezze!");
        }
    }
}

