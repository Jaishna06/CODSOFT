import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects=sc.nextInt();
        int[] marks=new int[numOfSubjects];
        int totalMarks=0;
        for (int i=0;i<numOfSubjects;i++) {
        System.out.print("Enter marks obtained in subject "+(i+1)+"(out of 100):" );
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }
        double avgPercentage = (double) totalMarks / numOfSubjects;
        String grade;
        if (avgPercentage >= 90) {
            grade = "A";
        } else if (avgPercentage >= 80) {
            grade = "B";
        } else if (avgPercentage >= 70) {
            grade = "C";
        } else if (avgPercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("\nResults:");
        System.out.println("Total Marks: "+totalMarks+" / " +(numOfSubjects*100));
        System.out.println("Average Percentage: " +avgPercentage+" %");
        System.out.println("Grade: "+grade);
        sc.close();
    }
}