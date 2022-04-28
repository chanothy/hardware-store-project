package edu.iu.c212;

import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StaffScheduler
{
    // instance variables
    private static ArrayList<String[]> shifts = new ArrayList<>();
    private static ArrayList<String> outSchedule = new ArrayList<>();

    // constructor
    public StaffScheduler()
    {

    }

    // method to read shift schedule input
    private static ArrayList<String[]> readShiftScheduler() throws FileNotFoundException
    {
        // scanning in the patient file and adding it to the array list
        try {
            File scheduleFile = new File("src/edu/iu/c212/resources/shift_schedules_IN.txt");
            Scanner inFile = new Scanner(scheduleFile);

            while (inFile.hasNext()) {
                String day = inFile.next();
                int opens = inFile.nextInt();
                int closes = inFile.nextInt();

                // take opening and closing hours and get how long the shift is
                int rawDuration = closes - opens;
                //System.out.println(rawDuration);
                double hours = rawDuration / 100;
                //System.out.println(hours);
                double minuteRemainder = rawDuration % 100;
                double hourDecimal = minuteRemainder / 60;
                double decimalHours = hours + hourDecimal;

                String returnHours = Double.toString(decimalHours);

                // add day and hours to return array list
                String[] tempArr = {day, returnHours};
                shifts.add(tempArr);

            }
            inFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return shifts;
    }

    // schedule employees --> where scheduling logic goes
    public static ArrayList<String> createSchedule(ArrayList<Staff> staffList)
    {
        // read in shift schedule
        try {
            readShiftScheduler();  // [day, hours]
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        // arr of managers
        ArrayList<Staff> managers = new ArrayList<>();
        for(int i = 0; i < staffList.size(); i++)
        {
            if(staffList.get(i).getRole().equals("M"))
            {
                managers.add(staffList.get(i));
            }
        }

        // arr of cashiers
        ArrayList<Staff> cashiers = new ArrayList<>();
        for(int i = 0; i < staffList.size(); i++)
        {
            if(staffList.get(i).getRole().equals("C"))
            {
                cashiers.add(staffList.get(i));
            }
        }

        // arr of gardening experts
        ArrayList<Staff> gardeningExperts = new ArrayList<>();
        for(int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getRole().equals("G")) {
                gardeningExperts.add(staffList.get(i));
            }
        }
        for(int j = 0; j < shifts.size(); j++)
        {
            String[] dayHours = shifts.get(j);
            String day = dayHours[0];
            double hours = Double.parseDouble(dayHours[1]);


            String tempStr;

            tempStr = day;

            // schedule managers
            for (int i = 0; i < managers.size(); i++)
            {
                if(managers.get(i).checkAvailability(day))
                {
                    tempStr = tempStr + " (" + managers.get(i).getName() + ")";
                    managers.get(i).setHoursAssigned(hours);
                    // re-sort manager
                    Collections.sort(managers);
                    break;
                }
            }

            // schedule cashiers
            for (int i = 0; i < cashiers.size(); i++)
            {
                if(cashiers.get(i).checkAvailability(day))
                {
                    tempStr = tempStr + " (" + cashiers.get(i).getName() + ")";
                    cashiers.get(i).setHoursAssigned(hours);
                    // re-sort cashiers
                    Collections.sort(cashiers);
                    break;
                }
            }

            // schedule gardening experts
            for (int i = 0; i < gardeningExperts.size(); i++)
            {
                if(gardeningExperts.get(i).checkAvailability(day))
                {
                    tempStr = tempStr + " (" + gardeningExperts.get(i).getName() + ")";
                    gardeningExperts.get(i).setHoursAssigned(hours);
                    // re-sort gardening experts
                    Collections.sort(gardeningExperts);
                    break;
                }
            }

            outSchedule.add(tempStr);
        }

        // GET CODE TO ADD CURRENT DATE AND TIME
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/dd/yyyy");
        String formattedDate = dateTime.format(df);
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HHmm");
        String formattedTime = dateTime.format(tf);
        String finalDateTime = "Created on " + formattedDate + " at " + formattedTime;

        outSchedule.add(0,finalDateTime);

        return outSchedule;

    }

}
