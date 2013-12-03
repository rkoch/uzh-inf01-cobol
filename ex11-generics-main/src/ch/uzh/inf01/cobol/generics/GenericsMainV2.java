package ch.uzh.inf01.cobol.generics;

import java.util.ArrayList;


public class GenericsMainV2 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("adf");
        list.add(333);
        int s = (int) list.get(0);
        System.out.println(s);
    }

}
