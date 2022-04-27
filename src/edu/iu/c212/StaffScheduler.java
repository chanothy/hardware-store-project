package edu.iu.c212;

import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffScheduler
{
    // instance variables
    private static ArrayList<String[]> shifts = new ArrayList<>();

    // constructor
    public StaffScheduler()
    {

    }

    // method to read shift schedule input
    private static ArrayList<String[]> readShiftScheduler() throws FileNotFoundException
    {
        // scanning in the patient file and adding it to the array list
        try {
            File scheduleFile = new File("src/edu/iu/c212/resources/shift_schedules_IN.txt");
            Scanner inFile = new Scanner(scheduleFile);

            while (inFile.hasNext()) {
                String day = inFile.next();
                int opens = inFile.nextInt();
                int closes = inFile.nextInt();

                // take opening and closing hours and get how long the shift is
                double hours = closes - opens;
                String returnHours = Double.toString(hours);

                // add day and hours to return array list
                String[] tempArr = {day, returnHours};
                shifts.add(tempArr);

            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return shifts;
    }

    // schedule employees --> where scheduling logic goes
    public static void createSchedule(ArrayList<Staff> staffList)
    {
        // read in shift schedule
        try {
            readShiftScheduler();  // [day, hours]
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }



    }

}
