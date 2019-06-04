package personalproject1;

public class Student {
    
   private String firstName;
   private String lastName;
   private double tuitionFees;
   private String dateOfBirth;

    public Student() {
    }

    public Student(String firstName, String lastName, double tuitionFees, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuitionFees = tuitionFees;
        this.dateOfBirth = dateOfBirth;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", tuitionFees=" + tuitionFees + ", dateOfBirth=" + dateOfBirth + '}';
    }
   
   
    
   
}
