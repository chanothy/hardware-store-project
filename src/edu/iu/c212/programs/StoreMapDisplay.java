package edu.iu.c212.programs;

import javax.swing.*;
import java.awt.*;
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

    public static void display(int i) {

        JFrame frame = new JFrame("map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        StoreMap map = new StoreMap(i);
        frame.setPreferredSize(new Dimension(700, 800));


        // frame add ---------------------------------------
        frame.add(map);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        display(9);

    }
}
