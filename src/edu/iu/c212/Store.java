package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    }

    public void saveStaffFromFile()
    {

    }

    public void takeAction()
    {
        // getting Array Lists filled with inventory and staff
        getItemsFromFile();
        getStaffFromFile();

        // read the input file


    }
}
