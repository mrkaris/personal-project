package personalproject1;

import java.util.ArrayList;
import java.util.List;

public class Synthetic {
    
    //No comment.

    public static List<Student> SynthStudent() {
        List<Student> students = new ArrayList();
        students.add(new Student("Jon", "Snow", 200, "01/01/1998"));
        students.add(new Student("Daenerys", "Targaryen", 200, "02/02/1998"));
        students.add(new Student("Jaime", "Lanister", 200, "04/01/1994"));
        students.add(new Student("Arya", "Stark", 200, "02/04/1998"));
        students.add(new Student("Jorah", "Mormont", 200, "01/01/1998"));
        students.add(new Student("Grey", "Worm", 200, "12/11/1999"));
        students.add(new Student("Samwell", "Tarly", 200, "19/02/1997"));
        students.add(new Student("Ramsey", "Bolton", 200, "04/11/1996"));
        students.add(new Student("Khal", "Drogo", 200, "10/08/1995"));
        students.add(new Student("Robert", "Baratheon", 200, "21/03/1992"));
        return students;
    }

    public static List<Course> SynthCourses() {
        List<Course> courses = new ArrayList();
        courses.add(new Course("Java", "Full-time", "Advanced", "03/06/2019", "02/12/2019"));
        courses.add(new Course("PHP", "Full-time", "Advanced", "04/06/2019", "05/12/2019"));
        courses.add(new Course("C#", "Full-time", "Beginner", "07/06/2019", "05/12/2019"));
        courses.add(new Course("HTML", "Part-time", "Beginner", "05/06/2019", "04/12/2019"));
        courses.add(new Course("JavaScript", "Part-time", "Beginner", "04/06/2019", "05/12/2019"));
        return courses;
    }

    public static List<Trainer> SynthTrainer() {
        List<Trainer> trainers = new ArrayList();
        trainers.add(new Trainer("Gandalf", "TheGrey", "Pyrotechnics"));
        trainers.add(new Trainer("Albus", "Dumbledoor", "Advanced Wizardry"));
        trainers.add(new Trainer("Frodo", "Baggings", "Ringcraft"));
        trainers.add(new Trainer("Bruce", "Wayne", "Realestate"));
        trainers.add(new Trainer("Tony", "Stark", "Robotics"));
        trainers.add(new Trainer("Severous", "Snape", "Potions"));

        return trainers;
    }

    public static List<Assignment> SynthAssignments() {
        List<Assignment> assignments = new ArrayList();
        assignments.add(new Assignment("Hotel", "Build a hotel manager", "04/11/2019", "100", "100"));
        assignments.add(new Assignment("School", "Build a school manager", "06/11/2019", "100", "100"));
        assignments.add(new Assignment("Primes", "Find all primes", "14/11/2019", "100", "100"));
        assignments.add(new Assignment("Fireball", "Cast a Fireball", "18/11/2019", "100", "100"));
        assignments.add(new Assignment("Potion of Luck", "Brew a luck potion", "11/11/2019", "100", "100"));
        assignments.add(new Assignment("Synthetic Data", "Make up some synthetic data", "07/11/2019", "100", "100"));
        return assignments;
    }

    public static List<CourseRelate> SynthCourseRelate() {
        List<Course> courses = SynthCourses();
        List<Student> students = SynthStudent();
        List<Student> stc1 = new ArrayList();
        stc1.add(students.get(0));
        stc1.add(students.get(1));
        stc1.add(students.get(2));
        List<Student> stc2 = new ArrayList();
        stc2.add(students.get(3));
        stc2.add(students.get(4));
        stc2.add(students.get(5));
        stc2.add(students.get(6));
        List<Student> stc3 = new ArrayList();
        stc3.add(students.get(7));
        stc3.add(students.get(8));
        stc3.add(students.get(9));
        List<Student> stc4 = new ArrayList();
        stc4.add(students.get(0));
        stc4.add(students.get(1));
        stc4.add(students.get(2));
        stc4.add(students.get(3));
        List<Student> stc5 = new ArrayList();
        stc5.add(students.get(1));
        stc5.add(students.get(5));
        List<CourseRelate> crlist = new ArrayList();
        crlist.add(new CourseRelate(courses.get(0), stc1));
        crlist.add(new CourseRelate(courses.get(1), stc2));
        crlist.add(new CourseRelate(courses.get(2), stc3));
        crlist.add(new CourseRelate(courses.get(3), stc4));
        crlist.add(new CourseRelate(courses.get(4), stc5));
        return crlist;
    }

    public static List<CourseRTrainer> SynthCourseRTrainer() {
        List<Course> courses = SynthCourses();
        List<Trainer> trainers = SynthTrainer();
        List<Trainer> trc1 = new ArrayList();
        trc1.add(trainers.get(0));
        trc1.add(trainers.get(1));
        List<Trainer> trc2 = new ArrayList();
        trc2.add(trainers.get(4));
        trc2.add(trainers.get(3));
        List<Trainer> trc3 = new ArrayList();
        trc3.add(trainers.get(5));
        List<Trainer> trc4 = new ArrayList();
        trc4.add(trainers.get(2));
        List<Trainer> trc5 = new ArrayList();
        trc5.add(trainers.get(0));
        
        List<CourseRTrainer> crtlist = new ArrayList();
        crtlist.add(new CourseRTrainer(courses.get(0), trc1));
        crtlist.add(new CourseRTrainer(courses.get(1), trc2));
        crtlist.add(new CourseRTrainer(courses.get(2), trc3));
        crtlist.add(new CourseRTrainer(courses.get(3), trc4));
        crtlist.add(new CourseRTrainer(courses.get(4), trc5));
        return crtlist;
    }

    public static List<CourseRAssignment> SynthCourseRAssignment() {
        List<Assignment> assignments = SynthAssignments();
        List<Course> courses = SynthCourses();
        List<Assignment> as1= new ArrayList();
        as1.add(assignments.get(0));
        as1.add(assignments.get(1));
        List<Assignment> as2= new ArrayList();
        as2.add(assignments.get(0));
        as2.add(assignments.get(1));
        List<Assignment> as3= new ArrayList();
        as3.add(assignments.get(2));
        List<Assignment> as4= new ArrayList();
        as4.add(assignments.get(3));
        List<Assignment> as5= new ArrayList();
        as5.add(assignments.get(4));
        as5.add(assignments.get(5));
        List<CourseRAssignment> cralist = new ArrayList();
        cralist.add(new CourseRAssignment(courses.get(0), as1));
        cralist.add(new CourseRAssignment(courses.get(1), as2));
        cralist.add(new CourseRAssignment(courses.get(2), as3));
        cralist.add(new CourseRAssignment(courses.get(3), as4));
        cralist.add(new CourseRAssignment(courses.get(4), as5));
        return cralist;
    }

    public static List<AssignRStudents> SynthAssignRStudents() {
        List<Assignment> assignments = SynthAssignments();
        List<Student> students = SynthStudent();
        List<Assignment> as1= new ArrayList();
        as1.add(assignments.get(0));
        as1.add(assignments.get(1));
        List<Assignment> as2= new ArrayList();
        as2.add(assignments.get(0));
        as2.add(assignments.get(1));
        List<Assignment> as3= new ArrayList();
        as3.add(assignments.get(2));
        List<Assignment> as4= new ArrayList();
        as4.add(assignments.get(3));
        List<Assignment> as5= new ArrayList();
        as5.add(assignments.get(4));
        as5.add(assignments.get(5));
        
        
        List<AssignRStudents> ars = new ArrayList();
        ars.add(new AssignRStudents(students.get(0), as1));
        ars.add(new AssignRStudents(students.get(1), as1));
        ars.add(new AssignRStudents(students.get(2), as1));
        ars.add(new AssignRStudents(students.get(3), as2));
        ars.add(new AssignRStudents(students.get(4), as2));
        ars.add(new AssignRStudents(students.get(5), as2));
        ars.add(new AssignRStudents(students.get(6), as3));
        ars.add(new AssignRStudents(students.get(7), as3));
        ars.add(new AssignRStudents(students.get(8), as4));
        ars.add(new AssignRStudents(students.get(9), as5));
        
        return ars;
    }

}
