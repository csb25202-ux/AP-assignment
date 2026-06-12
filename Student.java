import java.util.*;

public class Student {

    private int id;
    private String name;
    private List<String> courses;
    private Map<String, Integer> scores;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void addScore(String course, int score) {
        scores.put(course, score);
    }

    public double getAverageScore() {
        if (courses.isEmpty()) return 0;

        int total = 0;
        for (String course : courses) {
            total += scores.getOrDefault(course, 0);
        }

        return (double) total / courses.size();
    }
}
