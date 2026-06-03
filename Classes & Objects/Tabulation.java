import java.util.HashMap;

class Student {
    private String name;
    private int rollNo;
    private String[] subjects;

    public Student(String name, int rollNo, String[] subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String[] getSubjects() {
        return subjects;
    }
}

class TabulationSheet {
    private String subjectName;
    private HashMap<Integer, Integer> marks;

    public TabulationSheet(String subjectName) {
        this.subjectName = subjectName;
        marks = new HashMap<>();
    }

    public void addMark(int rollNo, int mark) {
        marks.put(rollNo, mark);
    }

    public int getMark(int rollNo) {
        return marks.getOrDefault(rollNo, 0);
    }

    public String getSubjectName() {
        return subjectName;
    }
}

class MarkSheet {
    private Student student;
    private TabulationSheet[] sheets;

    public MarkSheet(Student student, TabulationSheet[] sheets) {
        this.student = student;
        this.sheets = sheets;
    }

    public void printMarkSheet() {
        System.out.println("\n----- MARK SHEET -----");
        System.out.println("Name    : " + student.getName());
        System.out.println("Roll No : " + student.getRollNo());

        int total = 0;

        for (int i = 0; i < sheets.length; i++) {
            int mark = sheets[i].getMark(student.getRollNo());

            System.out.println(
                sheets[i].getSubjectName() + " : " + mark
            );

            total += mark;
        }

        System.out.println("Total Marks : " + total);
    }
}

public class Tabulation {
    public static void main(String[] args) {

        String[] subjects = {
                "Math",
                "Physics",
                "Chemistry",
                "English",
                "Computer"
        };

        Student s1 = new Student("Alice", 101, subjects);
        Student s2 = new Student("Bob", 102, subjects);
        Student s3 = new Student("Charlie", 103, subjects);

        TabulationSheet math = new TabulationSheet("Math");
        TabulationSheet physics = new TabulationSheet("Physics");
        TabulationSheet chemistry = new TabulationSheet("Chemistry");
        TabulationSheet english = new TabulationSheet("English");
        TabulationSheet computer = new TabulationSheet("Computer");

        math.addMark(101, 85);
        math.addMark(102, 78);
        math.addMark(103, 90);

        physics.addMark(101, 80);
        physics.addMark(102, 82);
        physics.addMark(103, 88);

        chemistry.addMark(101, 75);
        chemistry.addMark(102, 85);
        chemistry.addMark(103, 92);

        english.addMark(101, 88);
        english.addMark(102, 79);
        english.addMark(103, 84);

        computer.addMark(101, 95);
        computer.addMark(102, 91);
        computer.addMark(103, 89);

        TabulationSheet[] sheets = {
                math, physics, chemistry, english, computer
        };

        MarkSheet m1 = new MarkSheet(s1, sheets);
        MarkSheet m2 = new MarkSheet(s2, sheets);
        MarkSheet m3 = new MarkSheet(s3, sheets);

        m1.printMarkSheet();
        m2.printMarkSheet();
        m3.printMarkSheet();
    }
}