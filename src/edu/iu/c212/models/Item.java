package edu.iu.c212.models;

import edu.iu.c212.programs.StoreMapDisplay;
import edu.iu.c212.utils.FileUtils;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Item
{
    // instance variables
    private String name;
    private double price;
    private int quantity;
    private int aisleNum;

    // constructor
    public Item(String name, double price, int quantity, int aisleNum)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.aisleNum = aisleNum;
    }

    // getters
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getAisleNum()
    {
        return aisleNum;
    }

    public static ArrayList add(String itemName, int cost, int itemQuantity, int itemAisle) throws IOException {
        List newItems = FileUtils.readInventoryFromFile();
        newItems.add(new Item(itemName,cost,itemQuantity,itemAisle));
        return (ArrayList) newItems;
    }

    public static void cost(String itemName) throws  IOException{
        List items = FileUtils.readInventoryFromFile();
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                FileUtils.writeLineToOutputFile(itemName + ": $" + Integer.toString(((int)((Item)items.get(i)).getPrice())));
            }
        }
//        FileUtils.writeLineToOutputFile("Error: This " + itemName + " cannot be found.");
    }

    public static void find(String itemName) throws IOException{
        List items = FileUtils.readInventoryFromFile();
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                StoreMapDisplay.display((Item) items.get(i));
                FileUtils.writeLineToOutputFile("Performing store lookup for " + itemName);
                return;
            }
        }
        FileUtils.writeLineToOutputFile("Error: " + itemName + " cannot be found.");
    }

}
