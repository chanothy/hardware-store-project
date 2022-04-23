package edu.iu.c212;

import java.util.ArrayList;

public class SawPrimePlanks {

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static int sawPlank(int plankLength) {
        if (isPrime(plankLength)) {
            return plankLength;
        }
        else {
            for (int i=2; i<10; i++) {
                if (plankLength%i ==0) {
                    plankLength = plankLength / i;
                    break;
                }
            }
            return sawPlank(plankLength);
        }
    }

    public static ArrayList sawPlankArray(int plankLength) {
        int primeLen = sawPlank(plankLength);
        int howMany = plankLength / primeLen;
        ArrayList plankArray = new ArrayList<Integer>();
        for (int i = 0; i<howMany; i++) {
            plankArray.add(primeLen);
        }
        return plankArray;
    }

    public static void main(String[] args) {
        System.out.println(sawPlankArray(195));
//        System.out.println(616%2);
    }
}
