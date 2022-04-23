package edu.iu.c212;

import edu.iu.c212.models.Staff;

import java.util.ArrayList;

public class StaffScheduler
{
    // instance variables
    private static ArrayList<StaffScheduler> staffAvailability =  new ArrayList<StaffScheduler>();
    private static ArrayList<String> outSchedule = new ArrayList<>();
    private String name;
    private int age;
    private char position;
    private String daysAvailable;

    // could make staff scheduler with input as an array list object and create a constructor
    public StaffScheduler(String name, int age, char position, String days)
    {
        this.name = name;
        this.age = age;
        this.position = position;
        this.daysAvailable = days;

    }

    // method to read in the data and add it into the arrayLists
    public static void read()
    {

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
