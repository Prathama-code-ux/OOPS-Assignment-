import java.util.*;

class Employee{
    private String name;
    private int id;
    private String address;
    private double salary;

    public Employee(String name, int id, String address, double salary){
        this.name = name;
        this.id = id;
        this.address = address;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getAddress() { return address; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setAddress(String address) { this.address = address; }
    public void setSalary(double salary) { this.salary = salary; }
}

class Dept{
    private String name;
    private String location;
    private int yearestablishment;
    private HashMap <Integer, Employee> employees;

    public Dept(String name, String location, int yearestablishment){
        this.name = name;
        this.location = location; 
        this.yearestablishment = yearestablishment;
        employees = new HashMap<>();
    }

    public void addEmployee(Employee e1){
        employees.put(e1.getId(), e1);
    }

    public void removeEmployee(int id){
        employees.remove(id);
    }

    public double calcTotalSalary(){
        double totalSalary = 0;
        for(Employee emp : employees.values()){
            totalSalary += emp.getSalary() * 12;
        }
        return totalSalary;
    }
}

public class Staff {
    public static void main(String[] args){
        Dept itDept = new Dept("Information Technology", "Jadavpur", 1975);

        itDept.addEmployee(new Employee("Alice", 101, "New York", 5000.0));
        itDept.addEmployee(new Employee("Bob", 102, "San Francisco", 6000.0));
        itDept.addEmployee(new Employee("Charlie", 103, "Chicago", 4500.0));
        itDept.addEmployee(new Employee("Diana", 104, "Los Angeles", 7000.0));
        itDept.addEmployee(new Employee("Evan", 105, "Seattle", 5500.0));

        double totalSalary = itDept.calcTotalSalary();
        System.out.println("Department: " + itDept.calcTotalSalary());
        System.out.printf("Total annual salary to be paid to all employees: $%,.2f%n", totalSalary);
    }
}
