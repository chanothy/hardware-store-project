package edu.iu.c212.models;

import edu.iu.c212.utils.FileUtils;

import javax.swing.plaf.FileChooserUI;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Staff
{

    private String fullName;
    private int age;
    private String role;
    private String availability;
    private double hoursAssigned = 0;

    // Staff object constructor
    public Staff(String name, int age, String role, String availability) {
        this.fullName = name;
        this.age = age;
        this.role = role;
        this.availability = availability;
    }
    // name getter
    public String getName(){
        return fullName;
    }

    // age getter
    public int getAge() {
        return age;
    }

    // role getter
    public String getRole(){
        return role;
    }

    // availability getter
    public String getAvailability() { return availability; }

    // setting hours assigned
    public void setHoursAssigned(double n)
    {
        this.hoursAssigned = this.hoursAssigned + n;
    }



    // hiring method
    public static void hire(String staffName, int age, String role, String availability) throws IOException {
        List newStaff = FileUtils.readStaffFromFile();
        newStaff.add(new Staff(staffName,age,role,availability));
        String fullRole = "";
        if (role.equals("C")) {
            fullRole = "Cashier";
        }
        else if (role.equals("M")) {
            fullRole = "Manager";
        }
        else {
            fullRole = "Gardener";
        }
        FileUtils.writeStaffToFile(newStaff);
        FileUtils.writeLineToOutputFile(staffName + " has been hired as a " + fullRole);
    }

    // firing method
    public static void fire(String staffName) throws IOException {
        List newStaff = FileUtils.readStaffFromFile();
        ArrayList updateStaff = new ArrayList<Staff>();
        for (int i = 0; i<newStaff.size(); i++) {
            if (((Staff) newStaff.get(i)).getName().equals(staffName)) {
                continue;
            }
            else {
                updateStaff.add(newStaff.get(i));
            }
        }
        FileUtils.writeStaffToFile(updateStaff);
        FileUtils.writeLineToOutputFile(staffName + " was fired");

    }

    // promotion method
    public static void promote(String staffName, String role) throws IOException {
        List newStaff = FileUtils.readStaffFromFile();
        ArrayList updateStaff = new ArrayList<Staff>();
        for (int i = 0; i<newStaff.size(); i++) {
            if (((Staff) newStaff.get(i)).getName().equals(staffName)) {
                updateStaff.add(new Staff(staffName, ((Staff) newStaff.get(i)).getAge(), role, ((Staff) newStaff.get(i)).getAvailability()));
            }
            else {
                updateStaff.add(newStaff.get(i));
            }
        }
        String fullRole;
        if (role.equals("C")) {
            fullRole = "Cashier";
        }
        else if (role.equals("M")) {
            fullRole = "Manager";
        }
        else {
            fullRole = "Gardener";
        }
        FileUtils.writeStaffToFile(updateStaff);
        FileUtils.writeLineToOutputFile(staffName + " was promoted to " + fullRole);
    }

    public static void test() throws IOException{
//        hire("Sierra Napier", 18, "C", "M.W.F");
//        promote("Addmanda Smith", "C");
//        hire("Tim Chan", 18, "M", "M.W.F");
//        fire("Sierra Napier");
//        fire("Tim Chan");
//        System.out.println(FileUtils.readInventoryFromFile().get(0));
//        System.out.println(FileUtils.readInventoryFromFile().get(1).getName());
    }

}
