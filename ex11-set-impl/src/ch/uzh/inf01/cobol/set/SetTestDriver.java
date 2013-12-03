package ch.uzh.inf01.cobol.set;


public class SetTestDriver {

    public static void main(String[] args) {
        Set<String> a = new Set<>(new String[] { "a1", "a2", "a1" });
        System.out.println(a);
        // Output: [a1, a2]
        Set<String> b = new Set<String>();
        b.add("b1");
        b.toArrayList().add("b1");
        b.toArrayList().add("b1");
        b.toArrayList().add("b1");
        b.toArrayList().add("b1");
        b.add("a1");
        b.contains("a1");
        b.add(a);
        b.add("b2");
        System.out.println(b);
        // Output: [b1, a1, a2, b2]
        Set<Object> c = new Set<Object>().add("c1").add(5).add(true);
        System.out.println(c);
        // Output: [c1, 5, true] System.out.println(c.contains("c1"));
        // Output: true
        System.out.println(c.size());
        // Output: 3
        System.out.println(c.remove(5));
        // Output: [c1, true]
    }

}
