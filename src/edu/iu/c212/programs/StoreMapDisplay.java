package edu.iu.c212.programs;

import edu.iu.c212.models.Item;
import edu.iu.c212.utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class StoreMapDisplay extends JPanel{
//    static int WIDTH;
//    static int HEIGHT;
//
//    public StoreMapDisplay() {
//        WIDTH = 700;
//        HEIGHT = 500;
//
//
//    }

    public static int WIDTH = 700;
    public static int HEIGHT = 500;

    public static void display(Item item) {

        JFrame frame = new JFrame("High's Hardware Product Lookup: " + item.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        StoreMap map = new StoreMap(item.getAisleNum());
        frame.setPreferredSize(new Dimension(700, 800));


        // frame add ---------------------------------------
        frame.add(map);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
//        display(FileUtils.readInventoryFromFile().get(0));

    }
}
