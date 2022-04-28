package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SawPrimePlanks {

    // checks if prime
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    // recursion to get the prime length of sawed plank
    public static int sawPlank(int longPlankLength) {
        int plankLength = longPlankLength;
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

    // Actual saw method that updates inventory.txt and output.txt with sawed planks
    public static void saw() throws IOException {
        List inv = FileUtils.readInventoryFromFile();
        for (int i = 0; i < inv.size(); i++) {
            if (((Item) inv.get(i)).getName().contains("Plank")) {
                Item item = (Item) inv.get(i);
                int orginalLen = Integer.parseInt(item.getName().split("-")[1]);
                int aisle = item.getAisleNum();
                int newSize = sawPlank(orginalLen);
                int cost = newSize * newSize;
                int quant = item.getQuantity() * (orginalLen / newSize);
                String name = "Plank-" + newSize;
                inv.set(i, new Item(name, cost, quant, aisle));
            }
        }
        FileUtils.writeInventoryToFile(inv);
        FileUtils.writeLineToOutputFile("Planks sawed.");
    }

    // returns list of prime plank lengths
    public static List<Integer> getPlankLengths(int longPlankLength) throws IOException {
        int plankLength = longPlankLength;
        int primeLen = sawPlank(plankLength);
        int howMany = plankLength / primeLen;
        ArrayList plankArray = new ArrayList<Integer>();
        for (int i = 0; i<howMany; i++) {
            plankArray.add(primeLen);
        }
        return plankArray;
    }


    public static void main(String[] args) throws IOException{
//        System.out.println(getPlankLengths(195));
//        System.out.println(616%2);
    }
}
