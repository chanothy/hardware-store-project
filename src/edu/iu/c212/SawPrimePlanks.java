package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class SawPrimePlanks {
    private static File staffAvailabilityFile = new File("src/edu/iu/c212/resources/staff_availability_IN.txt");


    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

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

    public static void saw() throws IOException {
        List inv = FileUtils.readInventoryFromFile();
        for (int i = 0; i<inv.size(); i++) {
//            if
        }
    }

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

//    public static void saw() throws IOException{
//        // Updates inventory.txt (might move this or change later)
//        ArrayList inv = new ArrayList<String>();
//        List items = FileUtils.readInventoryFromFile();
//        for (int i = 0; i<items.size(); i++) {
//            inv.add(((Item)items.get(i)).getName() + "," + ((Item)items.get(i)).getPrice() + "," + ((Item)items.get(i)).getQuantity() + "," + ((Item)items.get(i)).getAisleNum());
//        }
//        PrintWriter out = new PrintWriter(staffAvailabilityFile);
//        for (int i = 0; i < inv.size(); i++) {
//            System.out.println(inv.get(i));
//            out.println(inv.get(i));
//        }
//        out.close();
//    }

    public static void main(String[] args) throws IOException{
        System.out.println(getPlankLengths(195));
//        System.out.println(616%2);
    }
}
