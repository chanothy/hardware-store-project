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


    // constructor
    public Store()
    {

    }

    public List<Item> getItemsFromFile()
    {
        List<Item> inventoryArrList = new ArrayList<Item>();
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

    }

    public void saveItemsFromFile()
    {

    }

    public void saveStaffFromFile()
    {

    }

    public void takeAction()
    {

    }
}
