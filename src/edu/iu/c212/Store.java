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
        int i = 0;
        // read the input file
        try {
            List<String> listInput = FileUtils.readCommandsFromFile();
            System.out.println(listInput);

            while (i < listInput.size()) {
                String line = listInput.get(i);
                //ADD;Cordless Screwdriver;30;1;2
                String[] lineArr = line.split(",");

                for(int j = 0; j < lineArr.length; j++)
                {
                    System.out.println(lineArr[j]);


                    if (lineArr[i].equals("ADD")) {

                    } else if (lineArr[i].equals("COST")) {

                    } else if (lineArr[i].equals("FIND")) {

                    } else if (lineArr[i].equals("SELL")) {

                    } else if (lineArr[i].equals("QUANTITY")) {

                    } else if (lineArr[i].equals("FIRE")) {
                        // match name in staffArrList to be fired

                        // to do:
                        // read full name from input.txt
                        // check staffArrList to see if name is in list

                    /*
                    String first = inFile.next();
                    System.out.println(first);
                    String last = inFile.next();
                    System.out.println(last);
                    String fullName = first + " " + last;
                    fullName.replaceAll("'", "");
                    System.out.println(fullName);

                    int arrSize = staffArrList.size();

                    for(int i = 0; i < staffArrList.size(); i++)
                    {
                        if(staffArrList.get(i).getName().equals(fullName))
                        {
                            staffArrList.remove(staffArrList.get(i));
                            System.out.println(fullName + " was fired.");
                        }
                    }
                    if(arrSize == staffArrList.size())
                    {
                        System.out.println("ERROR: " +  fullName + " cannot be found.");
                    }
                    saveStaffFromFile();
                     */
                    } else if (lineArr[i].equals("HIRE")) {
                        try {
                            ArrayList<Staff> newStaff = Staff.hire("Lewis hamilton", 35, "G", "M.T.W.T.F.SAT");
                            this.staffArrList = newStaff;
                            saveStaffFromFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (lineArr[i].equals("PROMOTE")) {

                    } else if (lineArr[i].equals("SCHEDULE")) {
                        StaffScheduler staffScheduler = new StaffScheduler();
                        staffScheduler.createSchedule((ArrayList) staffArrList);
                    } else if (lineArr[i].equals("SAW")) {

                    } else if (lineArr[i].equals("EXIT")) {

                    } else {
                        System.out.println("Your command was not recognized.");
                    }
                }
                i++;
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
