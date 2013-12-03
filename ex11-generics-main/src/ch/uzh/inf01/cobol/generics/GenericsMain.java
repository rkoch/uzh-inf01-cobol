package ch.uzh.inf01.cobol.generics;

import java.util.ArrayList;


public class GenericsMain {

    // This does obviously not compiling
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(333);
        int s = list.get(0);
        System.out.println(s);
    }

}
