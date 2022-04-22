package edu.iu.c212.models;

import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Staff {

    private String fullName;
    private int age;
    private String role;
    private String availability;

    public Staff(String name, int age, String role, String availability) {
        this.fullName = name;
        this.age = age;
        this.role = role;
        this.availability = availability;
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

    public static void hire(String staffName, int age, String role) throws IOException {
        ArrayList storeLines = (ArrayList) FileUtils.readStaffFromFile();
        for (int i =0; i<storeLines.size(); i++) {
            System.out.println(storeLines.get(i));
        }
    }
/*
    public static void fire(String staffName) throws IOException {
        File fileInput = new File("resources/staff_availability_IN.txt");
        Scanner in = new Scanner(fileInput);
        ArrayList storeLines = new ArrayList<String>();
    }

    public static void promote(String staffName, String role) throws IOException {
        File fileInput = new File("resources/staff_availability_IN.txt");
        Scanner in = new Scanner(fileInput);
        ArrayList storeLines = new ArrayList<String>();
    }
*/
    public static void main(String[] args) throws IOException{
        hire("Tim",3,"M");
    }
}
