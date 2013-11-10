package ch.uzh.inf01.cobol.oop;

public class Cat
        extends Animal {

    @Override
    public void giveSound() {
        System.out.println("Meow!");
    }

    public void playWithBallOfWool() {
        System.out.println("I'm playing with a ball of wool.");
    }


}
