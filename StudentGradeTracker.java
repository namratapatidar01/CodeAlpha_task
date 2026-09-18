
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Student {
         String name;
         int marks;
         Student ( String name , int marks){
             this.name = name;
              this.marks = marks ;

         }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.println( "===== student grade marks ====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        
        for (int i = 0; i < n; i++) {

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        Student highest = students.get(0);
        Student lowest = students.get(0);
        int total =0;
        System.out.println("\n===== STUDENT GRADE REPORT =====");

        for (Student s : students) {

            total = total + s.marks;

            if (s.marks > highest.marks) {
                highest = s;
            }

            if (s.marks< lowest.marks) {
                lowest = s;
            }
            System.out.println( s.name + " - " + s.marks  + getGrade(s.marks));
        }

        
        double average = (double ) total / students.size();

        
        System.out.println("\n===== SUMMARY REPORT =====");
        System.out.println("\n Average Marks:" + average);
        System.out.println("Highest Marks:" + highest.name +  " (" + highest.marks + ")");
        System.out.println("Lowest Marks: " + lowest.name +   " (" + lowest.marks + ")");

        sc.close();
    }
    static String getGrade( int marks){
        if ( marks>=90 )
            return " A+";
else if ( marks>=80 )
            return " A";
       else if ( marks>=70 )
            return " B";
else if ( marks>=60 )
            return " C";
else if ( marks>=50 )
            return " D";
else
    return "F";


}
}

