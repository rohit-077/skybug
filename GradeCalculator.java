package skybug;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        System.out.println("Enter the number of subjects: ");
        Scanner s  =new Scanner(System.in);
        int subjectsSize = s.nextInt();

        Map<String,Double> subjects = new HashMap<>(subjectsSize);
        for(int i=0;i<subjectsSize;i++){
            System.out.println("Enter the subject name: ");
            Scanner sc = new Scanner(System.in);
            String subjectName= sc.nextLine();
            System.out.println("Enter the marks for " + subjectName + " out of 100: ");
            double marks = sc.nextDouble();
            subjects.put(subjectName,marks);
        }
        double totalMarks=0;
        for(double mark : subjects.values()){
            totalMarks+=mark;
        }
        System.out.println("Total marks scored are: "+ totalMarks + "/" + (100*subjectsSize));
        System.out.println("Total average of all subjects is: "+ totalMarks/subjectsSize);
        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
            double mark = entry.getValue();
            System.out.print(entry.getKey() + " - Grade: ");

            if (mark > 90) {
                System.out.println("S");
            } else if (mark > 80) {
                System.out.println("A");
            } else if (mark > 70) {
                System.out.println("B");
            } else if (mark > 60) {
                System.out.println("C");
            } else if (mark > 50) {
                System.out.println("D");
            } else if (mark > 40) {
                System.out.println("E");
            } else {
                System.out.println("F");
            }
        }
    }
}
