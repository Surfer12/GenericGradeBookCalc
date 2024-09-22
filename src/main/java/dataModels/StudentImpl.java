package dataModels;

public class StudentImpl extends Student<Integer> {
    private String name;
    private Integer grade;

    public StudentImpl(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    // Override necessary methods from Student
}