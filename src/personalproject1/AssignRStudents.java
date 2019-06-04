package personalproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignRStudents {

    Student student;
    List<Assignment> assignments;

    public AssignRStudents() {
    }

    public AssignRStudents(Student student, List<Assignment> assignments) {
        this.student = student;
        this.assignments = assignments;
    }
    
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

   

    

    public static void assignmentMenu(List<Student> c, List<Assignment> s, List<AssignRStudents> cr, Scanner sc) {

        int ind = 0;    //index helper variable for later use in cr 
        if (c.isEmpty()) {
            
            System.out.println("No Assignments added");
        } else if (s.isEmpty()) {
            System.out.println("No Students added");
        } else {
            //Students and assignments exist so start processing
            for (int i = 0; i < c.size(); i++) {    //printing options
                System.out.println("[" + (i + 1) + "]-" + c.get(i).getFirstName()+" "+c.get(i).getLastName());
            }

            int deikths = Helpers.testIndex(sc, "Student", c);
            if (cr.isEmpty()) {
                //AssignRStudent list is empty.
                //Create new AssignRStudents and sets Student
                AssignRStudents cr1 = new AssignRStudents();
                cr.add(cr1);
                cr1.setStudent(c.get(deikths - 1));
                ind = 0;        
            } else if (!cr.isEmpty()) {
                //AssignRstudents already exists, check for duplicates
                boolean nosuchobject = false;
                for (int i = 0; i < cr.size(); i++) {
                    
                    if (c.get(deikths - 1).equals(cr.get(i).getStudent())) {
                        //Found Student in AssignRStudent assign index number and break
                        nosuchobject = false;
                        ind = i;
                        break;
                    } else {
                        nosuchobject = true; //this is be redundant, could have set nosuchobject true

                    }
                }
                if (nosuchobject) {
                    //No object found. Creat new
                    AssignRStudents cr1 = new AssignRStudents();
                    cr.add(cr1);
                    cr1.setStudent(c.get(deikths - 1));
                    ind = cr.indexOf(cr1);
                }
            }
            for (int i = 0; i < s.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + s.get(i).getTitle());
            }
            System.out.println("\n");
            int deikthsM = Helpers.testIndex(sc, "Assignment", s);
            
            boolean noAssignmentinList = false;
            
            if (cr.get(ind).assignments==null) {
                //No list assignmets exist. Create new
                cr.get(ind).assignments = new ArrayList();
                cr.get(ind).assignments.add(s.get(deikthsM - 1));
            } else{
                //Check if assignment is already assigned
                for (int i = 0; i < cr.get(ind).assignments.size(); i++) {
                    if (cr.get(ind).assignments.get(i).equals(s.get(deikthsM - 1))) {
                        System.out.println("Assignment already added to student");
                        noAssignmentinList = false;
                        break;
                    } else {
                        noAssignmentinList = true;
                    }
                }
            }
            if (noAssignmentinList) {
                cr.get(ind).assignments.add(s.get(deikthsM - 1));
            }

        }
       
    }

    public static void viewAssignmentStudents(List<AssignRStudents> cr, List<Student> s, Scanner sc) {
        if (cr.isEmpty()) {
            System.out.println("No Assignments added to Students yet");
        } else {
            for (int i = 0; i < cr.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + cr.get(i).student.getFirstName()+" "+cr.get(i).student.getLastName());
            }

            int deikths = Helpers.testIndex(sc, "Student", cr);
            System.out.println("\nCOURSE: " + cr.get(deikths - 1).student.getFirstName()+" "+cr.get(deikths - 1).student.getLastName());
            for (Assignment e : cr.get(deikths - 1).assignments) {
                System.out.println(e.getTitle());
            }
        }
    }

}
