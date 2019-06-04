package personalproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRelate {
    /*
    Not commenting,the structure is identical to AssignRStudents
    Check the comments in AssignRStudents because i'm lazy
    */

    Course course;
    List<Student> students;

    public CourseRelate() {
    }

    public CourseRelate(Course course, List<Student> students) {
        this.course = course;
        this.students = students;
    }
    
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseRelate{" + "course=" + course + ", students=" + students + '}';
    }

    public static void courseMenu(List<Course> c, List<Student> s, List<CourseRelate> cr, Scanner sc) {

        int ind = 0;
        if (c.isEmpty()) {
            System.out.println("No Courses added");
        } else if (s.isEmpty()) {
            System.out.println("No Students added");
        } else {
            for (int i = 0; i < c.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + c.get(i).getTitle());
            }
//            System.out.println("Dialekse Course");
//            String input = sc.next();
            int deikths = Helpers.testIndex(sc, "Course", c);
            if (cr.isEmpty()) {
                CourseRelate cr1 = new CourseRelate();
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
                    CourseRelate cr1 = new CourseRelate();
                    cr.add(cr1);
                    cr1.setCourse(c.get(deikths - 1));
                    ind = cr.indexOf(cr1);
                }
            }
            for (int i = 0; i < s.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + s.get(i).getFirstName() + " " + s.get(i).getLastName());
            }
            System.out.println("\n");
            int deikthsM = Helpers.testIndex(sc, "Student", s);
            //
            boolean noStudentinList = false;
            if (cr.get(ind).students==null) {
                cr.get(ind).students = new ArrayList();
                cr.get(ind).students.add(s.get(deikthsM - 1));
            } else{
                for (int i = 0; i < cr.get(ind).students.size(); i++) {
                    if (cr.get(ind).students.get(i).equals(s.get(deikthsM - 1))) {
                        System.out.println("Student already added to the course");
                        noStudentinList = false;
                        break;
                    } else {
                        noStudentinList = true;
                    }
                }
            }
            if (noStudentinList) {
                cr.get(ind).students.add(s.get(deikthsM - 1));
            }

        }
        //System.out.println(cr);
    }

    public static void viewCourseStudents(List<CourseRelate> cr, List<Student> s, Scanner sc) {
        if (cr.isEmpty()) {
            System.out.println("No Students added to Courses yet");
        } else {
            for (int i = 0; i < cr.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + cr.get(i).course.getTitle());
            }

            int deikths = Helpers.testIndex(sc, "Course", cr);
            System.out.println("\nCOURSE: " + cr.get(deikths - 1).course.getTitle());
            for (Student e : cr.get(deikths - 1).students) {
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }
        }
    }

}
