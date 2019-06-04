package personalproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRAssignment {
    /*
    Not commenting,the structure is identical to AssignRStudents
    Check the comments in AssignRStudents because i'm lazy
    */

    Course course;
    List<Assignment> assignments;

    public CourseRAssignment() {
    }

    public CourseRAssignment(Course course, List<Assignment> assignments) {
        this.course = course;
        this.assignments = assignments;
    }
    
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    

    public static void courseAssignMenu(List<Course> c, List<Assignment> s, List<CourseRAssignment> cr, Scanner sc) {

        int ind = 0;
        if (c.isEmpty()) {
            System.out.println("No Courses added");
        } else if (s.isEmpty()) {
            System.out.println("No Assignments added");
        } else {
            for (int i = 0; i < c.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + c.get(i).getTitle());
            }

            int deikths = Helpers.testIndex(sc, "Course", c);
            if (cr.isEmpty()) {
                CourseRAssignment cr1 = new CourseRAssignment();
                cr.add(cr1);
                cr1.setCourse(c.get(deikths - 1));
                ind = 0;
            } else if (!cr.isEmpty()) {
                boolean nosuchobject = false;
                for (int i = 0; i < cr.size(); i++) {
                    if (c.get(deikths - 1).equals(cr.get(i).getCourse())) {
                        nosuchobject = false;
                        ind = i;
                        break;
                    } else {
                        nosuchobject = true;

                    }
                }
                if (nosuchobject) {
                    CourseRAssignment cr1 = new CourseRAssignment();
                    cr.add(cr1);
                    cr1.setCourse(c.get(deikths - 1));
                    ind = cr.indexOf(cr1);
                }
            }
            for (int i = 0; i < s.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + s.get(i).getTitle());
            }
            System.out.println("\n");
            int deikthsM = Helpers.testIndex(sc, "Student", s);
            //
            boolean noStudentinList = false;
            if (cr.get(ind).assignments==null) {
                cr.get(ind).assignments = new ArrayList();
                cr.get(ind).assignments.add(s.get(deikthsM - 1));
            } else{
                for (int i = 0; i < cr.get(ind).assignments.size(); i++) {
                    if (cr.get(ind).assignments.get(i).equals(s.get(deikthsM - 1))) {
                        System.out.println("Assignment already added to the course");
                        noStudentinList = false;
                        break;
                    } else {
                        noStudentinList = true;
                    }
                }
            }
            if (noStudentinList) {
                cr.get(ind).assignments.add(s.get(deikthsM - 1));
            }

        }
        //System.out.println(cr);
    }

    public static void viewCourseAssignments(List<CourseRAssignment> cr, List<Student> s, Scanner sc) {
        if (cr.isEmpty()) {
            System.out.println("No Assignments added to Courses yet");
        } else {
            for (int i = 0; i < cr.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + cr.get(i).course.getTitle());
            }

            int deikths = Helpers.testIndex(sc, "Course", cr);
            System.out.println("\nCOURSE: " + cr.get(deikths - 1).course.getTitle());
            for (Assignment e : cr.get(deikths - 1).assignments) {
                System.out.println(e.getTitle());
            }
        }
    }

}
