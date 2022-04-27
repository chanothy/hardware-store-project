package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store implements IStore
{
    // instance variables
    private List<Item> inventoryArrList = new ArrayList<Item>();
    private List<Staff> staffArrList = new ArrayList<Staff>();

    // constructor
    public Store()
    {
        takeAction();
    }

    public List<Item> getItemsFromFile()
    {
        try {
            // use FileUtils
            inventoryArrList = FileUtils.readInventoryFromFile();

        } catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return inventoryArrList;
    }
    public List<Staff> getStaffFromFile()
    {
        try {
            // use FileUtils
            staffArrList = FileUtils.readStaffFromFile();

        } catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return staffArrList;
    }

    public void saveItemsFromFile()
    {
        try {
          // use file utils
            FileUtils.writeInventoryToFile(inventoryArrList);
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveStaffFromFile()
    {
      try {
            // use file utils
            FileUtils.writeStaffToFile(staffArrList);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void takeAction()
    {
        // getting Array Lists filled with inventory and staff
        getItemsFromFile();
        getStaffFromFile();

        // read the input file
        try {
            List<String> listInput = FileUtils.readCommandsFromFile();

            for(int i = 0; i < listInput.size(); i++)
            {
                String[] tester = listInput.get(i).split(";");

                                                                        // FOR THESE, DON'T FORGET TO FileUtils.writeLineToOutputFile();************************************
                if (tester[0].equals("ADD"))
                {
                    try
                    {

                    } catch()
                    {

                    }

                } else if (tester[0].equals("COST")) {

                } else if (tester[0].equals("FIND")) {

                } else if (tester[0].equals("SELL")) {

                } else if (tester[0].equals("QUANTITY")) {

                } else if (tester[0].equals("FIRE")) {
                    try {
                        ArrayList<Staff> newStaff = Staff.fire(tester[1]);
                        this.staffArrList = newStaff;
                        saveStaffFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("HIRE")) {
                    try {
                        ArrayList<Staff> newStaff = Staff.hire(tester[1], Integer.parseInt(tester[2]), tester[3], tester[4]);
                        this.staffArrList = newStaff;
                        saveStaffFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("PROMOTE")) {

                } else if (tester[0].equals("SCHEDULE"))               // LOOK AT TO CHECK THAT PEOPLE WHO WERE JUST HIRED GOT ADDED TO THE SCHEDULE***************************************
                {
                    StaffScheduler newSchedule = new StaffScheduler();
                    try {
                        FileUtils.writeStoreScheduleToFile(newSchedule.createSchedule((ArrayList)staffArrList));
                    } catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }

                }
                else if (tester[0].equals("SAW")) {

                } else if (tester[0].equals("EXIT")) {

                } else {
                        System.out.println("Your command was not recognized.");
                }
            }

            /*
            for(int i = 0; i < listInput.size(); i++)
            {
                System.out.println(listInput.get(i));
            }

             //*/

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
