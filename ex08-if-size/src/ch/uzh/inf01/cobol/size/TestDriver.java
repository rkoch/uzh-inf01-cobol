package ch.uzh.inf01.cobol.size;


public class TestDriver {

    public static double getSquare(ISize pSize) {
        return pSize.getLength() * pSize.getWidth();
    }

    public static void main(String[] pArgs) {
        ISize[] list = new ISize[4];

        list[0] = new Car(2.5, 1.8, 3);
        list[1] = new Car(2.2, 1.6, 2.6);
        list[2] = new SoccerField(80, 43);
        list[3] = new SoccerField(82, 44);

        for (ISize entry : list) {
            System.out.println(getSquare(entry));
        }
    }

}
