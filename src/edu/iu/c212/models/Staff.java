package edu.iu.c212.models;

import edu.iu.c212.utils.FileUtils;

import javax.swing.plaf.FileChooserUI;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public String getAvailability() { return availability; }

    public static void hire(String staffName, int age, String role, String availability) throws IOException {
//        ArrayList storeLines = new ArrayList();
//        for (int i =0; i<FileUtils.readStaffFromFile().size();i++){
//        }
//        storeLines.add(staffName + " " + age + " " + role + " " + availability);
//        for (int i =0; i<storeLines.size(); i++) {
//            System.out.println(storeLines.get(i));
//        }
        List newStaff = FileUtils.readStaffFromFile();
        newStaff.add(new Staff(staffName,age,role,availability));
        FileUtils.writeStaffToFile(newStaff);
    }

    public static void test() throws IOException{
        hire("Sierra Napier", 18, "C", "M.W.F");
//        FileUtils.writeStaffToFile(FileUtils.readStaffFromFile());
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
        test();
    }
}
