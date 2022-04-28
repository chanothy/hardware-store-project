package edu.iu.c212.models;

import edu.iu.c212.programs.StoreMapDisplay;
import edu.iu.c212.utils.FileUtils;

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
        for (int i = 0; i< newItems.size(); i++) {
            if (((Item) newItems.get(i)).getName().equals(itemName)) {
                return (ArrayList) newItems;
            }
        }
        newItems.add(new Item(itemName,cost,itemQuantity,itemAisle));
        return (ArrayList) newItems;
    }

    public static void cost(String itemName) throws  IOException{
        List items = FileUtils.readInventoryFromFile();
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                FileUtils.writeLineToOutputFile(itemName + ": $" + (((int)((Item)items.get(i)).getPrice())));
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

    public static ArrayList sell(String itemName, int quantity) throws IOException{
        ArrayList items = new ArrayList();
        for (int i = 0; i<FileUtils.readInventoryFromFile().size(); i++) {
            items.add(FileUtils.readInventoryFromFile().get(i));
        }
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                int cost = (int)((Item)items.get(i)).getPrice();
                int origQuantity = ((Item)items.get(i)).getQuantity();
                int aisle = ((Item)items.get(i)).getAisleNum();
                if (origQuantity - quantity < 0) {
                    FileUtils.writeLineToOutputFile("Error: " + itemName + " could not be sold");
                    return items;
                }
                else if (origQuantity - quantity == 0) {
                    items.remove(items.get(i));
                    FileUtils.writeLineToOutputFile(quantity + " " + itemName + " was sold");
                    return items;
                }
                else {
                    items.set(i, new Item(itemName, cost, origQuantity - quantity, aisle));
                    FileUtils.writeLineToOutputFile(quantity + " " + itemName + " was sold");
                    return items;
                }
            }
        }
        FileUtils.writeLineToOutputFile("Error: " + itemName + " could not be sold");
        return items;
    }

    public static void quantity(String itemName) throws IOException{
        List items = FileUtils.readInventoryFromFile();
        for (int i = 0; i< items.size(); i++) {
            if (((Item)items.get(i)).getName().equals(itemName)) {
                FileUtils.writeLineToOutputFile(itemName + " quantity: " + Integer.toString(((int)((Item)items.get(i)).getQuantity())));
            }
        }
    }

}
