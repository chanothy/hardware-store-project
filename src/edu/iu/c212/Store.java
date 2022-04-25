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
        try {
            File inputFile = new File("src/edu/iu/c212/resources/input.txt");
            Scanner inFile = new Scanner(inputFile);

            while (inFile.hasNextLine()) {
                String command = inFile.next();

                if(command.equals("ADD"))
                {

                }
                else if(command.equals("COST"))
                {

                }
                else if(command.equals("FIND"))
                {

                }
                else if(command.equals("SELL"))
                {

                }
                else if(command.equals("QUANTITY"))
                {

                }
                else if(command.equals("FIRE"))
                {
                    // match name in staffArrList to be fired

                    // to do:
                    // read full name from input.txt
                    // check staffArrList to see if name is in list
                    inFile.useDelimiter("[^a-zA-z\s]");
                    String first = inFile.next();
                    System.out.println(first);

                    inFile.useDelimiter("[^a-zA-z\\s]");
                    String last = inFile.next();
                    System.out.println(last);
                    String fullName = first + " " + last;
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
                }
                else if(command.equals("HIRE"))
                {

                }
                else if(command.equals("PROMOTE"))
                {

                }
                else if(command.equals("SCHEDULE"))
                {

                }
                else if(command.equals("SAW"))
                {

                }
                else if(command.equals("EXIT"))
                {

                }
                else
                {
                    System.out.println("Your command was not recognized.");
                }



            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
