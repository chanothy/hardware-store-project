package edu.iu.c212.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff {

    private String fullName;
    private int age;
    private String role;

    public Staff(String name, int age, String role) {
        this.fullName = name;
        this.age = age;
        this.role = role;
    }
    public String getName(){
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getRole(){
        return role;
    }

    public static void hire(String staffName, int age, String role) throws FileNotFoundException {
        File fileInput = new File("files/staff.txt");
        Scanner in = new Scanner(fileInput);
        ArrayList storeLines = new ArrayList<String>();
    }

    public static void fire(String staffName) throws FileNotFoundException {
        File fileInput = new File("files/staff.txt");
        Scanner in = new Scanner(fileInput);
        ArrayList storeLines = new ArrayList<String>();
    }

    public static void promote(String staffName, String role) throws FileNotFoundException {
        File fileInput = new File("files/staff.txt");
        Scanner in = new Scanner(fileInput);
        ArrayList storeLines = new ArrayList<String>();
    }
}
