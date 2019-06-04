package personalproject1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Helpers {

    public static boolean isDateValid(String x) {
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(x, frmt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int testPositive(Scanner sc, String entity) {
        int num;
        do {
            System.out.println("How many " + entity + " do you wish to add?(enter a positive number)");
            while (!sc.hasNextInt()) {
                System.out.println("must be a number ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);
        return num;
    }

    public static int testIndex(Scanner sc, String type, List c) {
        int num;
        do {
            System.out.println("Choose " + type + " (1-" + c.size() + ")");
            while (!sc.hasNextInt()) {
                System.out.println("must be a number between 1 and " + c.size());
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0 || c.size() < num);
        return num;
    }
    //Print Students with more thn one Course
    public static void printStudentsWithCourses(List<CourseRelate> cr) {
        if (cr.isEmpty()) {
            System.out.println("No Students related to courses yet");
        } else {
            //Helper Lists to print the data
            List<Student> helperL = new ArrayList(); //List To hold Distinct Students
            List<Student> helperList = new ArrayList();

            for (CourseRelate e : cr) {
                //Extract Students from CourseRelate list
                for (Student el : e.students) {
                    helperList.add(el);
                }
            }
            //Create HashSet to check to prevent duplicates
            Set<Student> s = new HashSet<>();
            for (Student name : helperList) {
                if (s.add(name) == false && !helperL.contains(name)) {
                    //If Student name cant be added in the set means Student is assigned to more than 1 course
                    //if Student is already in the printing list he will not be added again
                    helperL.add(name);
                }
            }
            for (Student x : helperL) {
                System.out.println(x.getFirstName() + " " + x.getLastName());
            }
        }

    }

    public static void StudentsDueDate(List<AssignRStudents> asr, String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(input, formatter);
        LocalDate firstDayofWeek = date;
        LocalDate lastDayofWeek = date;
        while (firstDayofWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDayofWeek = firstDayofWeek.minusDays(1);
        }
        while (lastDayofWeek.getDayOfWeek() != DayOfWeek.SUNDAY) {
            lastDayofWeek = lastDayofWeek.plusDays(1);
        }
        System.out.println("");
        int counter = 0;
        HashSet<String> helpset = new HashSet();
        String hstring;
        for (AssignRStudents a : asr) {
            for (Assignment as : a.assignments) {
                LocalDate dateFromList = LocalDate.parse(as.getSubDateTime(), formatter);
                if ((dateFromList.isAfter(firstDayofWeek) || dateFromList.isEqual(firstDayofWeek))
                        && (dateFromList.isBefore(lastDayofWeek) || dateFromList.isEqual(lastDayofWeek))) {
                    hstring = (a.student.getFirstName() + " " + a.student.getLastName());
                    helpset.add(hstring);
                    counter += 1;
                }
            }

        }
        if (counter == 0) {
            System.out.println("\nNo result on that week");
        } else {
            for (String h : helpset) {
                System.out.println(h);
            }
        }

    }


}
