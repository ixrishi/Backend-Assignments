
class Student {

    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        setId(id);
        setName(name);
        setMarks(marks);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if(name  == null) throw new IllegalArgumentException("name can't be null");
        this.name = name;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public boolean isPassed() {
        return marks >= 40;
    }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", passed=" + isPassed() +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Student student = new Student(1, "Alice", 85);
        System.out.println(student);
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Marks: " + student.getMarks());
        System.out.println("Has the student passed? " +
        (student.isPassed() ? "Yes" : "No"));
        
        Student student2 = new Student(2, null, 106);
    }
}
