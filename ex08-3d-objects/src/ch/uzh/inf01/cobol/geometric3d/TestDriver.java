package ch.uzh.inf01.cobol.geometric3d;


public class TestDriver {

    public static void main(String[] pArgs) {
        I3DObject[] objectList = new I3DObject[4];

        try {
            objectList[0] = new Cuboid(10, 20, 30);
            objectList[1] = new RegularPyramid(10, 6, 5);
            objectList[2] = new RightCircularCylinder(15, 10);
            objectList[3] = new Sphere(10);

            for (I3DObject element : objectList) {
                System.out.println(element.getVolume());
            }
        } catch (Exception pEx) {
            System.out.println(pEx.getMessage());
        }
    }

}
