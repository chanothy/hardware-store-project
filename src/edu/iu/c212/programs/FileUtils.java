package edu.iu.c212.programs;
import edu.iu.c212.models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileUtils {
    private static File inputFile = new File("../resources/input.txt");
    private static File outputFile = new File("../resources/output.txt");
    private static File inventoryFile = new File("../resources/inventory.txt");
//    private static File staffFile = new File("../resources/staff.txt");
    private static File staffAvailabilityFile = new File("../resources/staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("../resources/shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("../resources/store_schedule_OUT.txt");

//    public static List<Item> readInventoryFromFile() throws IOException {
//        System.out.println(inventoryFile/*.toURI()*/.getPath() + "\n" + inventoryFile.exists());
//        // depending on your OS, toURI() may need to be used when working with paths
//        // TODO
//        File fileInput = new File("resources/sampleInventory.txt");
//        Scanner in = new Scanner(fileInput);
//        ArrayList storeLines = new ArrayList<String>();
//
//    }

    public static List<Staff> readStaffFromFile() throws IOException {
        // TODO
        Scanner in = new Scanner(staffAvailabilityFile);
        ArrayList staffLines = new ArrayList<String>();
        while (in.hasNextLine()) {
            staffLines.add(in.nextLine());
        }
        return staffLines;
    }

//    public void writeInventoryToFile(List<Item> items) {
//        // TODO
//
//    }

    public void writeStaffToFile(List<Staff> employees) throws IOException{
        // TODO
        PrintWriter output = new PrintWriter(staffAvailabilityFile);
        for (int i = 0; i<employees.size(); i++) {
            output.println(employees.get(i));

        }
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
