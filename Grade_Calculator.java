package Task2;

import java.util.Scanner;

public class Grade_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input: Marks obtained in each subject
        double[] subjectMarks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            subjectMarks[i] = scanner.nextDouble();
        }

        // Calculate total marks
        double totalMarks = calculateTotalMarks(subjectMarks);

        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Assign grades
        String grade = assignGrade(averagePercentage);

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Function to calculate total marks
    public static double calculateTotalMarks(double[] subjectMarks) {
        double total = 0;
        for (double marks : subjectMarks) {
            total += marks;
        }
        return total;
    }

    // Function to calculate average percentage
    public static double calculateAveragePercentage(double totalMarks, int numSubjects) {
        return (totalMarks / (numSubjects * 100)) * 100;
    }

    // Function to assign grades based on the average percentage
    public static String assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
