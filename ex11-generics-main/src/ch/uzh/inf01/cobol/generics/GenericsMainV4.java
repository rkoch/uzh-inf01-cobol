package ch.uzh.inf01.cobol.generics;



public class GenericsMainV4<T, U, V, W, X, Y extends Number> {


    public void doSomething(Y pEntry) {
//        List<T> list = new ArrayList<>();
//        list.add(pEntry);
//        T s = list.get(0);
//        System.out.println(s);
//        pEntry.
    }

    public static void main(String[] args) {
        GenericsMainV4<String, String, Integer, Short, Boolean, Number> app = new GenericsMainV4<>();
        app.doSomething(new Long(3));
    }

}
