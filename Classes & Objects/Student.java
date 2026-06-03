import java.util.Scanner;

class customStudent{
    String name;
    int roll;
    double[] marks  = new double[3];
    customStudent(String name, int roll, double m1, double m2, double m3){
        this.name = name;
        this.roll = roll;
        this.marks[0] = m1;
        this.marks[1] = m2;
        this.marks[2] = m3;
    }

    double totalMarks(){
        double total_marks = marks[0] + marks[1] + marks[2];
        return total_marks;
    }

    double avgMarks(){
        double avg_marks = totalMarks()/3;
        return avg_marks;
    }

    void displayInfo(){
        System.out.println("Roll no:" + roll);
        System.out.println("Name:" + name);
        System.out.println("Total marks:" + totalMarks());
        System.out.println("Average marks:" + avgMarks());
        System.out.println("---------------------------");
    }
}

public class Student {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        customStudent[] students = new customStudent[4];
        

    }
}
