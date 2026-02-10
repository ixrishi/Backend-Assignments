
class Employee {

    private static String companyName ="InnovaTech";

    private final int id;
    private String name;
    private double salary;


    public Employee(int id, String name, double salary) {
        if (id <= 0) {
            throw new IllegalArgumentException("Employee id must be positive");
        }
        this.id = id;
        setSalary(salary);
        setName(name);

    }

    public static void setCompanyName(String companyName) {
        if(companyName == null) throw new IllegalArgumentException("Company name cannot be null");
        Employee.companyName = companyName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException( "Name cannot be null");
        this.name = name;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", company='" + companyName + '\'' +
                '}';
    }
}

public class Problem5 {

    public static void main(String[] args) {

        Employee.setCompanyName("Innovatech");
        
        Employee emp1 = new Employee(1, "Rohith", 5000.0);
        Employee emp2 = new Employee(2, "Ananya", 6000.0);
        
        System.out.println(emp1);
        System.out.println("Annual Salary: " + emp1.calculateAnnualSalary());

        System.out.println();

        System.out.println(emp2);
        System.out.println("Annual Salary: " + emp2.calculateAnnualSalary());
    }
}
