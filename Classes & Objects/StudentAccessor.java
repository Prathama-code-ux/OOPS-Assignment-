public class StudentAccessor {
    static class Student {
        private String name;
        private int roll;

        public Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }

        public String getName() {
            return name;
        }

        public int getRoll() {
            return roll;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("John", 101);
        Student s2 = new Student("Mary", 102);

        System.out.println("Student 1 Details:");
        System.out.println("Name: " + s1.getName());
        System.out.println("Roll: " + s1.getRoll());

        System.out.println("Student 2 Details:");
        System.out.println("Name: " + s2.getName());
        System.out.println("Roll: " + s2.getRoll());
    }
}
