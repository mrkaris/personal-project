package personalproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRTrainer {
    /*
    Not commenting,the structure is identical to AssignRStudents
    Check the comments in AssignRStudents because i'm lazy
    */

    Course course;
    List<Trainer> trainers;

    public CourseRTrainer() {
    }

    public CourseRTrainer(Course course, List<Trainer> trainers) {
        this.course = course;
        this.trainers = trainers;
    }
    
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Trainer> getTrainer() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    @Override
    public String toString() {
        return "CourseRTrainer{" + "course=" + course + ", trainers=" + trainers + '}';
    }
    
    
    

    public static void coursetrainerMenu(List<Course> c, List<Trainer> s, List<CourseRTrainer> cr, Scanner sc) {

        int ind = 0;
        if (c.isEmpty()) {
            System.out.println("No Courses added");
        } else if (s.isEmpty()) {
            System.out.println("No Trainers added");
        } else {
            for (int i = 0; i < c.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + c.get(i).getTitle());
            }
            int deikths = Helpers.testIndex(sc, "Course", c);
            if (cr.isEmpty()) {
                CourseRTrainer cr1 = new CourseRTrainer();
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
                    CourseRTrainer cr1 = new CourseRTrainer();
                    cr.add(cr1);
                    cr1.setCourse(c.get(deikths - 1));
                    ind = cr.indexOf(cr1);
                }
            }
            for (int i = 0; i < s.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + s.get(i).getFirstName() + " " + s.get(i).getLastName());
            }
            System.out.println("\n");
            int deikthsM = Helpers.testIndex(sc, "Trainer", s);
            //
            boolean noObjectinList = false;
            if (cr.get(ind).trainers==null) {
                cr.get(ind).trainers = new ArrayList();
                cr.get(ind).trainers.add(s.get(deikthsM - 1));
            } else{
                for (int i = 0; i < cr.get(ind).trainers.size(); i++) {
                    if (cr.get(ind).trainers.get(i).equals(s.get(deikthsM - 1))) {
                        System.out.println("Trainer already added to the course");
                        noObjectinList = false;
                        break;
                    } else {
                        noObjectinList = true;
                    }
                }
            }
            if (noObjectinList) {
                cr.get(ind).trainers.add(s.get(deikthsM - 1));
            }

        }
    }

    public static void viewCourseTrainers(List<CourseRTrainer> cr, List<Trainer> s, Scanner sc) {
        if (cr.isEmpty()) {
            System.out.println("No Trainers added to Courses yet");
        } else {
            for (int i = 0; i < cr.size(); i++) {
                System.out.println("[" + (i + 1) + "]-" + cr.get(i).course.getTitle());
            }

            int deikths = Helpers.testIndex(sc, "Course", cr);
            System.out.println("\nCOURSE: " + cr.get(deikths - 1).course.getTitle());
            for (Trainer e : cr.get(deikths - 1).trainers) {
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }
        }
    }

}
