import java.util.HashMap;
import java.util.Map;

public class Tabulation {
    static class Student {
        private String name;
        private int rollNo;
        private String[] subjects;

        public Student(String name, int rollNo, String[] subjects) {
            this.name = name;
            this.rollNo = rollNo;
            this.subjects = subjects;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getRollNo() { return rollNo; }
        public void setRollNo(int rollNo) { this.rollNo = rollNo; }

        public String[] getSubjects() { return subjects; }
        public void setSubjects(String[] subjects) { this.subjects = subjects; }
    }

    static class TabulationSheet {
        private String subjectName;
        private HashMap<Integer, Integer> marks = new HashMap<>();

        public TabulationSheet(String subjectName) {
            this.subjectName = subjectName;
        }

        public void addMark(int rollNo, int mark) {
            marks.put(rollNo, mark);
        }

        public int getMark(int rollNo) {
            return marks.getOrDefault(rollNo, 0);
        }

        public String getSubjectName() { return subjectName; }
    }

    static class MarkSheet {
        private String studentName;
        private HashMap<String, Integer> marks = new HashMap<>();

        public void addStudentName(String name) {
            this.studentName = name;
        }

        public void addMark(String subjectName, int mark) {
            marks.put(subjectName, mark);
        }

        public void printMarkSheet() {
            System.out.println("Mark Sheet for: " + studentName);
            for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] subjects = {"Math", "Physics", "Chemistry", "English", "Computer"};

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

        TabulationSheet[] sheets = {math, physics, chemistry, english, computer};

        Student[] students = {s1, s2, s3};
        MarkSheet[] markSheets = new MarkSheet[3];

        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            markSheets[i] = new MarkSheet();
            markSheets[i].addStudentName(s.getName());
            for (TabulationSheet sheet : sheets) {
                markSheets[i].addMark(sheet.getSubjectName(), sheet.getMark(s.getRollNo()));
            }
        }

        for (MarkSheet ms : markSheets) {
            ms.printMarkSheet();
        }
    }
}