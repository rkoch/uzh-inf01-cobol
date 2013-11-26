package ch.uzh.inf01.cobol.recursion;

public class Rekursion {

    public static long fac(int pNum) {
        if (pNum == 0 || pNum == 1) {
            return 1; // Exit condition
        }
        return pNum * fac(pNum - 1);
    }

    public static String invert2(String pStr) {
        if (pStr.length() == 1) {
            return pStr; // Exit condition
        }
        return invert2(pStr.substring(1)) + pStr.charAt(0);
    }

    public static int gcd(int pNum1, int pNum2) {
        if (pNum2 == 0) {
            return pNum1; // Exit condition
        } else if (pNum2 > pNum1) {
            return gcd(pNum2, pNum1);
        } else {
            return gcd(pNum2, pNum1 % pNum2);
        }
    }

    public static void main(String[] pArgs) {
        System.out.println("fac(5) = " + fac(5));
        System.out.println("invert(\"Hallo Welt\") = " + invert2("Hallo Welt"));
        System.out.println("gcd(12,8) = " + gcd(4, 8));
    }

}







