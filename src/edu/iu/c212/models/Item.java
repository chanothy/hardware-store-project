package edu.iu.c212.models;

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


    // add method
    public static void add()
    {

    }

    // cost method
    public static double cost()
    {

    }


    // find method
    public static Item find()
    {

    }

}
