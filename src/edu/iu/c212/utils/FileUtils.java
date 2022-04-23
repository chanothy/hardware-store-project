package edu.iu.c212.utils;
import edu.iu.c212.models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class FileUtils {
    private static File inputFile = new File("src/edu/iu/c212/resources/input.txt");
    private static File outputFile = new File("src/edu/iu/c212/resources/output.txt");
    private static File inventoryFile = new File("src/edu/iu/c212/resources/inventory.txt");
//    private static File staffFile = new File("../resources/staff.txt");
    private static File staffAvailabilityFile = new File("src/edu/iu/c212/resources/staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("src/edu/iu/c212/resources/shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("src/edu/iu/c212/resources/store_schedule_OUT.txt");

//    public static List<Item> readInventoryFromFile() throws IOException {
//        System.out.println(inventoryFile/*.toURI()*/.getPath() + "\n" + inventoryFile.exists());
        // depending on your OS, toURI() may need to be used when working with paths
        // TODO
//        Scanner in = new Scanner(inventoryFile);
//        ArrayList storeLines = new ArrayList<String>();
//        while (in.hasNextLine()) {
//            storeLines.add(in.nextLine());
//        }
//        return storeLines;
//    }

    public static List<Staff> readStaffFromFile() throws IOException {
        // TODO
//        System.out.println(staffAvailabilityFile/*.toURI()*/.getPath() + "\n" + staffAvailabilityFile.exists());
        Scanner in = new Scanner(staffAvailabilityFile);
        ArrayList staffLines = new ArrayList<Staff>();
        while (in.hasNextLine()) {
            String[] splitLine = ((String) in.nextLine()).split(" ");
            String name = splitLine[0] + " " + splitLine[1];
            Integer age = Integer.parseInt(splitLine[2]);
            String job = splitLine[3];
            String avail = splitLine[4];
            staffLines.add(new Staff(name,age,job,avail));
        }
        return staffLines;
    }

//    public void writeInventoryToFile(List<Item> items) throws IOException{
//        // TODO
//
//    }

    public static void writeStaffToFile(List<Staff> employees) throws IOException{
        // TODO
        ArrayList staff = new ArrayList<String>();
        for (int i = 0; i<employees.size(); i++) {
            staff.add(employees.get(i).getName() + " " + employees.get(i).getAge() + " " + employees.get(i).getRole() + " " + employees.get(i).getAvailability());
//            System.out.println(staff.get(i));
        }
        PrintWriter out = new PrintWriter(staffAvailabilityFile);
        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i));
            out.println(staff.get(i));
        }

        out.close();


//        for (int i = 0; i<employees.size(); i++) {
//            String name = employees.get(i).getName();
//            Integer age = employees.get(i).getAge();
//            String job = employees.get(i).getRole();
//            String avail = employees.get(i).getAvailability();
//            staff.add(new Staff(name,age,job,avail));
//            System.out.println(name);
//        }
//

    }

//    public static List<String> readCommandsFromFile() throws IOException {
//        // TODO
//        return null;
//    }
//
//    public static void writeStoreScheduleToFile(List<String> lines) {
//        // TODO
//    }
//
//    public static void writeLineToOutputFile(String line) {
//        // TODO
//    }

}
