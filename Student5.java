import java.util.Scanner;

class Student5 {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    
    public Student5(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }


    public boolean checkEligibility() {
        return this.marks >= 50;
    }


    public double calculateFee() {
        return this.courseCredits * 1500.0;
    }

    public double calculateScholarship(double totalFee) {
        double scholarshipPercent = 0.0;
        if (this.marks >= 85) {
            scholarshipPercent = 0.20; // 20% scholarship
        } else if (this.marks >= 70 && this.marks <= 84) {
            scholarshipPercent = 0.10; // 10% scholarship
        }
        return totalFee * scholarshipPercent;
    }
    public double calculateFinalFee(double totalFee, double scholarshipAmount) {
        return totalFee - scholarshipAmount;
    }

    public void displayDetails(double totalFee, double scholarshipAmount, double finalFee) {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Registered Course  : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.println("Total Course Fee   : Rs. " + totalFee);
        System.out.println("Scholarship Amount : Rs. " + scholarshipAmount);
        System.out.println("Final Payable Fee  : Rs. " + finalFee);
        System.out.println("------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

       
        Student5 student = new Student5 (name, roll, marks, course, credits);

        
        if (student.checkEligibility()) {
            
            double totalFee = student.calculateFee();
            double scholarship = student.calculateScholarship(totalFee);
            double finalFee = student.calculateFinalFee(totalFee, scholarship);

  
            student.displayDetails(totalFee, scholarship, finalFee);
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for registration due to low marks (below 50).");
        }

        scanner.close();
    }
}
