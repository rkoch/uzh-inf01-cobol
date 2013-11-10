package ch.uzh.inf01.cobol.oop;

public class Dog
        extends Animal {

    @Override
    public void giveSound() {
        System.out.println("Wuff!");
    }

    public void digForBone() {
        System.out.println("I'm digging for a bone.");
    }

}
