package ch.uzh.inf01.cobol.oop;

import java.util.ArrayList;


public class TestDriver {

    public static void main(String[] args) {
        Human paul = new Human();
        paul.setName("Paul");
        paul.setAge(13);
        paul.setFavoriteDish("Pizza");
        paul.setMale(true);
        paul.read();
        paul.write("Hello World");

        Human oma = new Human();
        oma.setName("Oma Hugentobler");
        oma.setAge(81);
        oma.setFavoriteDish("Apfelkuchen");
        oma.setMale(false);
        oma.setNephew(paul);
        oma.read();
        oma.write("Good morning starshine!");

        Cat miezi = new Cat();
        miezi.setName("Miezi");
        miezi.setAge(2);
        miezi.setFavoriteDish("Katzi-Katzenfutter");
        miezi.setMale(false);
        miezi.setOwner(oma);
        miezi.setCoatColor("tigered");
        miezi.giveSound();
        miezi.playWithBallOfWool();

        Dog lupo = new Dog();
        lupo.setName("Lupo");
        lupo.setAge(4);
        lupo.setFavoriteDish("Wurst");
        lupo.setMale(true);
        lupo.setOwner(paul);
        lupo.setCoatColor("brown");
        lupo.digForBone();
        lupo.giveSound();

        ArrayList<Creature> listOfCreatures = new ArrayList<Creature>(4);
        listOfCreatures.add(paul);
        listOfCreatures.add(oma);
        listOfCreatures.add(miezi);
        listOfCreatures.add(lupo);

        /*
         * Test toString() and favoriteDish/eat().
         */
        for (Creature element : listOfCreatures) {
            System.out.println(element);
            element.eat("Apfelkuchen");
        }

        /*
         * Test nephew/getNephew()/hasNephew() (only for humans).
         */
        for (Creature element : listOfCreatures) {
            if (element instanceof Human) {
                if (((Human) element).hasNephew()) {
                    System.out.println(element.getName()
                            + " has a nephew. His name is "
                            + ((Human) element).getNephew().getName());
                } else {
                    System.out.println(element.getName()
                            + " does not have a nephew.");
                }
            }
        }

    }

}
