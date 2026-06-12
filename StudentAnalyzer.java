import java.util.*;
import java.util.stream.Collectors;

public class StudentAnalyzer {

    public static List<Student> getTopNStudents(List<Student> students, int n) {

        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageScore).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getAverageScorePerCourse(List<Student> students) {

        Map<String, Double> courseAverage = new HashMap<>();

        Map<String, List<Integer>> courseScores = new HashMap<>();

        for (Student student : students) {
            for (String course : student.getCourses()) {

                int score = student.getScores().getOrDefault(course, 0);

                courseScores
                        .computeIfAbsent(course, k -> new ArrayList<>())
                        .add(score);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : courseScores.entrySet()) {

            double avg = entry.getValue()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);

            courseAverage.put(entry.getKey(), avg);
        }

        return courseAverage;
    }

    public static Set<String> getAllUniqueCourses(List<Student> students) {

        return students.stream()
                .flatMap(student -> student.getCourses().stream())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
