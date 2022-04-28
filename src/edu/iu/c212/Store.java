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

                // in this if/else if/ else block, we could have streamlined out code so that most of the logic would
                // be here instead of in the item class and staff class, however when we wrote these programs, it was
                // before we had some key input information.

                if (tester[0].equals("ADD"))
                {
                    try {
                        ArrayList<Item> newItem = Item.add(tester[1], Integer.parseInt(tester[2]), Integer.parseInt(tester[3]), Integer.parseInt(tester[4]));
                        //***********************************************
                        for(int j = 0; j < newItem.size(); j++)
                        {
                            if(!(inventoryArrList.get(j).getName().equals(newItem.get(j).getName())))
                            {
                                inventoryArrList.add(newItem.get(j));
                            }
                        }

                        saveItemsFromFile();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("COST"))
                {
                    try{
                        Item.cost(tester[1]);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("FIND"))
                {
                    try {
                        Item.find(tester[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("SELL"))
                {
                    try{
                        ArrayList<Item> updatedArrList = Item.sell(tester[1], Integer.parseInt(tester[2]));
                        this.inventoryArrList = updatedArrList;
                        saveItemsFromFile();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("QUANTITY"))
                {
                    try{
                        Item.quantity(tester[1]);
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("FIRE")) {
                    try {
                        ArrayList<Staff> newStaff = Staff.fire(tester[1]);
                        this.staffArrList = newStaff;
                        saveStaffFromFile();
                        FileUtils.writeLineToOutputFile(tester[1] + " was fired");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("HIRE")) {
                    try {
                        ArrayList<Staff> newStaff = Staff.hire(tester[1], Integer.parseInt(tester[2]), tester[3], tester[4]);
                        this.staffArrList = newStaff;
                        saveStaffFromFile();

                        String role = "";
                        if(tester[3].equals("M"))
                        {
                            role = "Manager";
                        }
                        else if(tester[3].equals("C"))
                        {
                            role = "Cashier";
                        }
                        else if(tester[3].equals("G"))
                        {
                            role = "Gardening Expert";
                        }
                        FileUtils.writeLineToOutputFile(tester[1] + " has been hired as a " + role);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("PROMOTE")) {

                    try {
                        ArrayList<Staff> newStaff = Staff.promote(tester[1], tester[2]);
                        this.staffArrList = newStaff;
                        saveStaffFromFile();

                        String role = "";
                        if(tester[2].equals("M"))
                        {
                            role = "Manager";
                        }
                        else if(tester[2].equals("C"))
                        {
                            role = "Cashier";
                        }
                        else if(tester[2].equals("G"))
                        {
                            role = "Gardening Expert";
                        }
                        FileUtils.writeLineToOutputFile(tester[1] + " was promoted to " + role);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("SCHEDULE"))
                {
                    StaffScheduler newSchedule = new StaffScheduler();
                    try {
                        FileUtils.writeStoreScheduleToFile(newSchedule.createSchedule((ArrayList)staffArrList));
                        FileUtils.writeLineToOutputFile("Schedule created");
                    } catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }

                }
                else if (tester[0].equals("SAW")) {
                    try{
                        SawPrimePlanks.saw();
                    } catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                } else if (tester[0].equals("EXIT")) {
                    break;
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
