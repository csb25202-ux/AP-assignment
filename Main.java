import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1, "Rohit");
        s1.addCourse("Math");
        s1.addCourse("Physics");
        s1.addScore("Math", 85);
        s1.addScore("Physics", 90);

        Student s2 = new Student(2, "Aman");
        s2.addCourse("Math");
        s2.addCourse("Chemistry");
        s2.addScore("Math", 95);
        s2.addScore("Chemistry", 80);

        Student s3 = new Student(3, "Neha");
        s3.addCourse("Physics");
        s3.addCourse("Chemistry");
        s3.addScore("Physics", 70);
        s3.addScore("Chemistry", 88);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        List<Student> topStudents = StudentAnalyzer.getTopNStudents(students, 2);
        System.out.println("Top Students:");
        for (Student student : topStudents) {
            System.out.println(student.getId() + " - " + student.getName() + " (Avg: " + String.format("%.2f", student.getAverageScore()) + ")");
        }

        System.out.println("\nAverage Score Per Course:");
        Map<String, Double> courseAverage = StudentAnalyzer.getAverageScorePerCourse(students);
        for (Map.Entry<String, Double> entry : courseAverage.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue()));
        }

        System.out.println("\nAll Courses:");
        Set<String> allCourses = StudentAnalyzer.getAllUniqueCourses(students);
        System.out.println(allCourses);
    }
}

/*
Time Complexity of Computing Course Averages : O(n)
time Complexity of Sorting Top N Students : O(nlogn)
*/