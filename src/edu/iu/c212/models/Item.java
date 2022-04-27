package edu.iu.c212.models;

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

    public static String cost(String itemName) throws  IOException{
        List items = FileUtils.readInventoryFromFile();
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                return Integer.toString(((int)((Item)items.get(i)).getPrice()));
            }
        }
        return "Error: This item cannot be found.";
    }

}
