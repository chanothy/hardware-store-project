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
        try
        {
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
            System.out.println(listInput.get(0));

            for(int i = 0; i < listInput.size(); i++)
            {

                if (listInput.get(0).equals("ADD")) {

                } else if (listInput.get(0).equals("COST")) {

                } else if (listInput.get(0).equals("FIND")) {

                } else if (listInput.get(0).equals("SELL")) {

                } else if (listInput.get(0).equals("QUANTITY")) {

                } else if (listInput.get(0).equals("FIRE")) {

                } else if (listInput.get(0).equals("HIRE")) {
                    try {
                        ArrayList<Staff> newStaff = Staff.hire("Lewis hamilton", 35, "G", "M.T.W.T.F.SAT");
                        this.staffArrList = newStaff;
                        saveStaffFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (listInput.get(0).equals("PROMOTE")) {

                } else if (listInput.get(0).equals("SCHEDULE")) {
                    StaffScheduler staffScheduler = new StaffScheduler();
                    staffScheduler.createSchedule((ArrayList) staffArrList);
                } else if (listInput.get(0).equals("SAW")) {

                } else if (listInput.get(0).equals("EXIT")) {

                } else {
                        System.out.println("Your command was not recognized.");
                }
            }

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
