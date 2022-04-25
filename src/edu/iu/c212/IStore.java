package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import java.util.List;

public interface IStore
{
    //This will call FileUtils.getItemsFromFile that reads in all the items from inventory.txt, and uses System.exit to exit the
    // program if an exception is thrown.
    //Each item will be its own line in the file, and will be of the form "<itemName>  <itemQuantity> <itemCost> <itemAisle>"
    //The inventory.txt is delimited by a space
    List<Item> getItemsFromFile();

    //This will call FileUtils.getStaffFromFile that reads in all the staff from staff_availability_IN.txt, and use System.exit
    //to exit the program if an exception is thrown.
    List<Staff> getStaffFromFile();

    //This will call FileUtils.saveItemsFromFile that saves all the items from inventory.txt, and uses System.exit to exit the
    // program if an exception is thrown.
    void saveItemsFromFile();

    //This will call FileUtils.saveStaffFromFile that saves all the staff from staff_availability_IN.txt, and use System.exit
    // to exit the program if an exception is thrown.
    void saveStaffFromFile();

    //This loads in the inventory and staff information, reads from the input file and takes the correct actions, then finally
    //asks the user to hit Enter to end the program when they're finished.
    //See the rest of the document for possible actions and how they're formatted in the input file
    void takeAction();

}
