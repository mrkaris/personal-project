package personalproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonalProject1 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList();
        List<Trainer> trainers = new ArrayList();
        List<Course> courses = new ArrayList();
        List<Assignment> assignments = new ArrayList();
        List<CourseRelate> crlist = new ArrayList();
        List<CourseRTrainer> crtlist = new ArrayList();
        List<CourseRAssignment> cralist = new ArrayList();
        List<AssignRStudents> ars = new ArrayList();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        String input;
        String input2;
        String input3;
        String input4;
        String input5;
        do {
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("\nMAIN MENU\n");
            System.out.println("[1]Enter Data    [2]-View Data      [3]-View Data(synthetic)    [0]-Exit\n\n type in your option and press enter");
            input = sc.next();
            switch (input) {
                //<editor-fold defaultstate="collapsed" desc="CASE 2-View Data">
                case ("2"):
                    Scanner sc4 = new Scanner(System.in);
                    do {
                        System.out.println("\n - PRINT MENU - \n");
                        System.out.println("[1]-List of Students    [2]-List of Trainers   [3]-List of Courses     [4]-List of Assignments\n"
                                + "[5]Students per Course       [6]-Trainers per Course     [7]-Assignments per Course\n"
                                + "[8]-Assignments per Student      [9]-Students with more than one Course\n["
                                + "10]-Student Assignments per week(user input)    [0]-Back to main menu\n\n type in your option and press enter");
                        input3 = sc4.next();
                        switch (input3) {
                            case ("1"):
                                //Student.
                                continue;
                            case ("2"):
                                if (trainers.isEmpty()) {
                                    System.out.println("No trainers added");
                                    continue;
                                }
                                for (Trainer e : trainers) {
                                    System.out.println(e.toString());
                                }
                                continue;
                            case ("3"):
                                if (courses.isEmpty()) {
                                    System.out.println("No courses added");
                                    continue;
                                }
                                for (Course e : courses) {
                                    System.out.println(e.toString());
                                }
                                System.out.println("\n");
                                continue;
                            case ("4"):

                                if (assignments.isEmpty()) {
                                    System.out.println("No assignments added");
                                    continue;
                                }
                                for (Assignment e : assignments) {
                                    System.out.println(e.toString());
                                }
                                continue;
                            case ("5"):
                                CourseRelate.viewCourseStudents(crlist, students, sc);
                                continue;
                            case ("6"):
                                CourseRTrainer.viewCourseTrainers(crtlist, trainers, sc);
                                continue;
                            case ("7"):
                                CourseRAssignment.viewCourseAssignments(cralist, students, sc);
                                continue;
                            case ("8"):
                                AssignRStudents.viewAssignmentStudents(ars, students, sc);
                                continue;
                            case ("9"):
                                Helpers.printStudentsWithCourses(crlist);
                                continue;
                            case ("10"):
                                String date;
                                System.out.println("Type the date you wish to check (dd/mm/yyyy) (e.g. 02/02/2019) ");
                                date = sc2.next();

                                while (Helpers.isDateValid(date) == false) {
                                    System.out.println("Not a valid Date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                    date = sc2.next();
                                }
                                Helpers.StudentsDueDate(ars, date);
                                continue;
                            case ("0"):
                                break;
                            default:
                                System.out.println("\nNot an option\n");

                        }
                    } while (!input3.equals("0"));

                    continue;
//</editor-fold>
                case ("1"):
                    do {
                        System.out.println("\n ADDING MENU \n");
                        System.out.println("[1]-Add Student    [2]-Add Trainers   [3]-Manage Courses \n[4]-Manage Assignments    [0]-Back to main menu\n\n type in your option and press enter");
                        input2 = sc2.next();
                        switch (input2) {
                            //<editor-fold defaultstate="collapsed" desc="Case 1 -Student Add">
                            case ("1"):
                                int num = Helpers.testPositive(sc2, "students");
                                for (int i = 0; i < num; i++) {
                                    Student s = new Student();
                                    students.add(s);
                                    System.out.println("Type in n." + (i + 1) + " student's first name ");
                                    String name = sc2.next();
                                    s.setFirstName(name);
                                    System.out.println("Type in n." + (i + 1) + " student's last name ");
                                    name = sc2.next();
                                    s.setLastName(name);

                                    double fees;
                                    do {
                                        System.out.println("Type in n." + (i + 1) + " student's tuition fees (positive number)");
                                        while (!sc2.hasNextInt()) {
                                            System.out.println("must be a number ");
                                            sc2.next();
                                        }
                                        fees = sc2.nextInt();
                                    } while (num <= 0);
                                    s.setTuitionFees(fees);
                                    System.out.println("Type in n." + (i + 1) + " student's date of birth(dd/mm/yyyy) (e.g. 02/02/1999) ");
                                    name = sc2.next();

                                    while (!Helpers.isDateValid(name)) {
                                        System.out.println("Not a valid date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                        name = sc2.next();
                                    }
                                    s.setDateOfBirth(name);
                                }
                                System.out.println("Entries have been added succesfully\n\n");
                                continue;
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="Case 2 -Trainer Add">
                            case ("2"):
                                int nums = Helpers.testPositive(sc2, "trainers");

                                for (int i = 0; i < nums; i++) {
                                    Trainer s = new Trainer();
                                    trainers.add(s);
                                    System.out.println("Type in n." + (i + 1) + " trainer's first name ");
                                    String name = sc2.next();
                                    s.setFirstName(name);
                                    System.out.println("Type in n." + (i + 1) + " trainer's last name ");
                                    name = sc2.next();
                                    s.setLastName(name);
                                    System.out.println("Type in n." + (i + 1) + " trainer's subject ");
                                    name = sc2.next();
                                    s.setSubject(name);
                                }
                                System.out.println("Entries have been added succesfully\n");

                                continue;
//</editor-fold>
                            case ("3"):
                                //--- COURSE MENU ----- 
                                do {
                                    System.out.println("[1]-Add Course      [2]-Add Student to Course       [3]-Add Assignment to Course\n[4]-Add Trainer to Course     [0]-Back to adding menu\n type in your option and press enter");
                                    input3 = sc2.next();
                                    switch (input3) {
                                        //<editor-fold defaultstate="collapsed" desc="Case 1 -Add Course">
                                        case ("1"):
                                            int nums1 = Helpers.testPositive(sc2, "courses");

                                            for (int i = 0; i < nums1; i++) {
                                                Course c = new Course();
                                                courses.add(c);
                                                System.out.println("Type in n." + (i + 1) + " courses's title");
                                                sc2.nextLine();
                                                String name = sc2.nextLine();
                                                c.setTitle(name);
                                                System.out.println("Type in n." + (i + 1) + " course's type");
                                                name = sc2.nextLine();
                                                c.setType(name);
                                                do {
                                                    System.out.println("Type in \"1\" for full-time or \"2\" for part-time");
                                                    name = sc2.next();
                                                    switch (name) {
                                                        case ("1"):
                                                            c.setStream("Full-time");
                                                            break;
                                                        case ("2"):
                                                            c.setStream("Part-time");
                                                            break;
                                                        default:
                                                            System.out.println("Not an option\n");
                                                    }
                                                } while (!name.equals("1") && !name.equals("2"));
                                                System.out.println("Type in n." + (i + 1) + " course's start date(dd/mm/yyyy) (e.g. 02/02/2019) ");
                                                name = sc2.next();

                                                while (Helpers.isDateValid(name) == false) {
                                                    System.out.println("Not a valid Date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                                    name = sc2.next();
                                                }
                                                c.setStart_date(name);
                                                System.out.println("Type in n." + (i + 1) + " course's end date(dd/mm/yyyy) (e.g. 02/04/2019) ");
                                                name = sc2.next();

                                                while (!Helpers.isDateValid(name)) {
                                                    System.out.println("Not a valid Date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                                    name = sc2.next();
                                                }
                                                c.setEnd_date(name);

                                            }
                                            System.out.println("Entries have been added succesfully\n");
                                            break;
//</editor-fold>
                                        case ("2"):
                                            CourseRelate.courseMenu(courses, students, crlist, sc);
                                            continue;
                                        case ("3"):
                                            CourseRAssignment.courseAssignMenu(courses, assignments, cralist, sc);
                                            continue;
                                        case ("4"):
                                            CourseRTrainer.coursetrainerMenu(courses, trainers, crtlist, sc);
                                            continue;
                                        case ("0"):
                                            break;
                                        default:
                                            System.out.println("\nNot an option\n");
                                    }
                                } while (!input3.equals("0"));
                                continue;
                            case ("4"):
                                do {
                                    // ADD ASSIGNMENTS MENU
                                    System.out.println("[1]-Add Assignment      [2]-Add Student to Assignment    [0]-Back to adding menu\n type in your option and press enter");
                                    input4 = sc2.next();
                                    switch (input4) {
                                        //<editor-fold defaultstate="collapsed" desc="Case 1 -Add assignment">
                                        case ("1"):
                                            int nums1 = Helpers.testPositive(sc2, "assignments");

                                            for (int i = 0; i < nums1; i++) {
                                                Assignment as = new Assignment();
                                                assignments.add(as);
                                                System.out.println("Type in n." + (i + 1) + " assignment's title");
                                                String name;
                                                sc2.nextLine();
                                                name = sc2.nextLine();

                                                as.setTitle(name);
                                                System.out.println("Type in n." + (i + 1) + " assignment's description");
                                                name = sc2.nextLine();
                                                as.setDescription(name);

                                                System.out.println("Type in n." + (i + 1) + " assignment's due date(dd/mm/yyyy) (e.g. 02/02/2019) ");
                                                name = sc2.next();

                                                while (!Helpers.isDateValid(name)) {
                                                    System.out.println("Not a valid Date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                                    name = sc2.next();
                                                }
                                                as.setSubDateTime(name);
                                                System.out.println("Type in n." + (i + 1) + " assignment's oral mark");
                                                name = sc2.next();
                                                as.setOralMark(name);
                                                System.out.println("Type in n." + (i + 1) + " assignment's total mark");
                                                name = sc2.next();
                                                as.setTotalMark(name);
                                            }
                                            System.out.println("Entries have been added succesfully\n");
                                            break;
//</editor-fold>
                                        case ("2"):
                                            //INSERT STUDENTS TO ASSIGNMENT HERE
                                            AssignRStudents.assignmentMenu(students, assignments, ars, sc);
                                        case ("0"):
                                            break;
                                        default:
                                            System.out.println("\nNot an option\n");

                                    }
                                } while (!input4.equals("0"));

                            case ("0"):
                                break;
                            default:
                                System.out.println("\nNot an option\n");
                        }

                    } while (!input2.equals("0"));
                    break;
                case ("3"):
                    //SYNTHETIC TABLES
                    List<Student> students2 = Synthetic.SynthStudent();
                    List<Trainer> trainers2 = Synthetic.SynthTrainer();
                    List<Course> courses2 = Synthetic.SynthCourses();
                    List<Assignment> assignments2 = Synthetic.SynthAssignments();
                    List<CourseRelate> crlist2 = Synthetic.SynthCourseRelate();
                    List<CourseRTrainer> crtlist2 = Synthetic.SynthCourseRTrainer();
                    List<CourseRAssignment> cralist2 = Synthetic.SynthCourseRAssignment();
                    List<AssignRStudents> ars2 = Synthetic.SynthAssignRStudents();
                    do {
                        System.out.println("\n - SYNTHETIC PRINT MENU - \n");
                        System.out.println("[1]-List of Students    [2]-List of Trainers   [3]-List of Courses     [4]-List of Assignments\n"
                                + "[5]Students per Course       [6]-Trainers per Course     [7]-Assignments per Course\n"
                                + "[8]-Assignments per Student      [9]-Students with more than one Course\n["
                                + "10]-Student Assignments per week(user input)    [0]-Back to main menu\n\n type in your option and press enter");
                        input5 = sc2.next();
                        switch (input5) {
                            case ("1"):
                                if (students2.isEmpty()) {
                                    System.out.println("No students added");
                                    continue;
                                }
                                for (Student e : students2) {
                                    System.out.println(e.toString());
                                }
                                continue;
                            case ("2"):
                                if (trainers2.isEmpty()) {
                                    System.out.println("No trainers added");
                                    continue;
                                }
                                for (Trainer e : trainers2) {
                                    System.out.println(e.toString());
                                }
                                continue;
                            case ("3"):
                                if (courses2.isEmpty()) {
                                    System.out.println("No courses added");
                                    continue;
                                }
                                for (Course e : courses2) {
                                    System.out.println(e.toString());
                                }
                                System.out.println("\n");
                                continue;
                            case ("4"):

                                if (assignments2.isEmpty()) {
                                    System.out.println("No assignments added");
                                    continue;
                                }
                                for (Assignment e : assignments2) {
                                    System.out.println(e.toString());
                                }
                                continue;
                            case ("5"):
                                CourseRelate.viewCourseStudents(crlist2, students2, sc);
                                continue;
                            case ("6"):
                                CourseRTrainer.viewCourseTrainers(crtlist2, trainers2, sc);
                                continue;
                            case ("7"):
                                CourseRAssignment.viewCourseAssignments(cralist2, students2, sc);
                                continue;
                            case ("8"):
                                AssignRStudents.viewAssignmentStudents(ars2, students2, sc);
                                continue;
                            case ("9"):
                                Helpers.printStudentsWithCourses(crlist2);
                                continue;
                            case ("10"):
                                String date;
                                System.out.println("Type the date you wish to check (dd/mm/yyyy) (e.g. 02/02/2019) ");
                                date = sc2.next();

                                while (Helpers.isDateValid(date) == false) {
                                    System.out.println("Not a valid Date. Must be in the form : dd/mm/yyyy (e.g. 02/02/1999)");
                                    date = sc2.next();
                                }
                                Helpers.StudentsDueDate(ars2, date);
                                continue;
                            case ("0"):
                                break;
                            default:
                                System.out.println("\nNot an option\n");

                        }
                    } while (!input5.equals("0"));

                    continue;
                case ("0"):

                    break;
                default:
                    System.out.println("\nNot an option\n");
            }

        } while (!input.equals("0"));
        sc.close(); //dont forget to close all scanners, dunno why i have 2...
        sc2.close();

        System.out.println("Goodbye");

    }

}
