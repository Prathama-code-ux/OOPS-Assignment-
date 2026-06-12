public class Student {
    private String name;
    private int rollNo;
    private double[] marks = new double[3];

    public Student(String name, int rollNo, double m1, double m2, double m3) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks[0] = m1;
        this.marks[1] = m2;
        this.marks[2] = m3;
    }

    public double computeTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    public double computeAverage() {
        return computeTotal() / 3.0;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.println("Total: " + computeTotal());
        System.out.println("Average: " + computeAverage());
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("Alice", 101, 85.0, 90.0, 95.0);
        students[1] = new Student("Bob", 102, 75.0, 80.0, 85.0);
        students[2] = new Student("Charlie", 103, 90.0, 88.0, 92.0);
        students[3] = new Student("Diana", 104, 95.0, 92.0, 94.0);

        for (Student s : students) {
            s.display();
        }
    }
}
