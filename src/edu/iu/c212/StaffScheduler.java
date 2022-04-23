package edu.iu.c212;

import edu.iu.c212.models.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffScheduler
{
    // instance variables
    private static ArrayList<StaffScheduler> staffAvailability =  new ArrayList<StaffScheduler>();
    private static ArrayList<String> shifts = new ArrayList<>();
    private static ArrayList<String> outSchedule = new ArrayList<>();
    private String name;
    private int age;
    private String position;
    private String daysAvailable;

    // could make staff scheduler with input as an array list object and create a constructor
    public StaffScheduler(String name, int age, String position, String days)
    {
            this.name = name;
            this.age = age;
            this.position = position;
            this.daysAvailable = days;
    }

    // method to read in the data frm staff availability and add it into the arrayList staffAvailability
    public static void readStaffAvailability(String filePath) throws FileNotFoundException
    {
        // scanning in the patient file and adding it to the array list
        try {
            File patientFile = new File(filePath);
            Scanner inFile = new Scanner(patientFile);
            while (inFile.hasNext()) {
                String fileFirst = inFile.next();
                String fileLast = inFile.next();
                int fileAge = inFile.nextInt();
                String filePosition = inFile.next();
                String fileDays = inFile.next();

                String fileName = fileFirst + " " + fileLast;


                StaffScheduler  newStaffMember= new StaffScheduler(fileName, fileAge, filePosition, fileDays);
                staffAvailability.add(newStaffMember);

            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // creates an array list for the schedule that I need to fill
    public static void readShiftSchedules(String filePath) throws FileNotFoundException
    {
        // scanning in the patient file and adding it to the array list
        try {
            File patientFile = new File(filePath);
            Scanner inFile = new Scanner(patientFile);
            while (inFile.hasNext()) {
                String fileDay = inFile.next();
                int fileStart = inFile.nextInt();
                int fileEnd = inFile.nextInt();


                String newSchedule= (fileDay +" "+  fileStart +" "+ fileEnd);
                shifts.add(newSchedule);

            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    // method calculates total hours that need to be scheduled
    //public static int[] totalHours()
    //{

    //}

    // schedule employees
    public static void createSchedule()
    {

    }

    public static void main(String[] args)
    {

    }

}
