package ch.uzh.inf01.cobol.generics;

import java.util.ArrayList;
import java.util.List;


public class GenericsMainV3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(333);
        int s = list.get(0); // <-- autoboxing baby
        System.out.println(s);
    }

}
