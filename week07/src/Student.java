import java.util.*;

public class Student{
    private final int id;
    private final String name;
    private double score;
    private final String major;

    public Student(int id, String name, double score, String major) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.major = major;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }
    public String getMajor() { return major; }

    public void setScore(double score) { this.score = score; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass()!=this.getClass()){
            return false;
        }
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', score=%.1f, major='%s'}",
                id, name, score, major);
    }


}