import java.util.Scanner;

class Employee{
    int id;
    char name;
    float basicSalary;
    float bonus;
    float netSalary;

    public Employee(int id, char name,float basicSalary){
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = 0.0f;
        this.netSalary = 0.0f;
    }

    public void calculateNetSalary(){

    }

    public void calculateBonus(){

    }

    public void displayDetails(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Net Salary: " + netSalary);
    }
}

class PermanentEmployee extends Employee{
    int pf;

    public PermanentEmployee(int id, char name, float basicSalary, int pf){
        super(id, name, basicSalary);
        this.pf = pf;
    }

    public void calculateNetSalary(){
       this.netSalary = this.basicSalary - this.pf;
    }

    public void calculateBonus(){
            if(pf<1000)
            {    this.bonus = 0.10f*this.basicSalary; }
            else if(pf>=1000&&pf<1500)
            {    this.bonus=0.115f*this.basicSalary;  }
             else if(pf>=1500&&pf<1800)
            {    this.bonus=0.12f*this.basicSalary;   }
            else
            {    this.bonus=0.15f*this.basicSalary;   }
        }
    }


    class TemporaryEmployee extends Employee {
        int dailyWages;
        int numberofDays;

        public TemporaryEmployee(int id, char name, float basicSalary, int dailyWages, int numberofDays) {
            super(id, name, basicSalary);
            this.dailyWages = dailyWages;
            this.numberofDays = numberofDays;
        }

        public void calculateNetSalary() {
            this.netSalary = this.dailyWages * this.numberofDays;
        }

        public void calculateBonus() {
            if (dailyWages < 1000) {
                this.bonus = 0.15f * this.netSalary;
            } else if (dailyWages >= 1000 && dailyWages < 1500) {
                this.bonus = 0.12f * this.netSalary;
            } else if (dailyWages >= 1500 && dailyWages < 1750) {
                this.bonus = 0.11f * this.netSalary;
            } else {
                this.bonus = 0.08f * this.netSalary;
            }
        }
    }

    public class payroll {

        public static Employee initializeEmployee(char emptype, int empid, char name, float basicSalary, int pf, int dailywages, int numberofDays) {
            Employee employee = null;
            if (emptype.equalsIgnoreCase("Permanent")) {
                employee = new PermanentEmployee(empid, name, basicSalary, pf);
            } else if (emptype.equalsIgnoreCase("Temporary")) {
                employee = new TemporaryEmployee(empid, name, basicSalary, pf);
            } else {
                System.out.println("Invalid employee type");
            }

            employee.calculateNetSalary();
            employee.calculateBonus();
            return employee;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee type");
            char emptype = sc.nextLine();
            System.out.println("Enter Employee ID: ");
            int empid = sc.nextLine();
            System.out.println("Enter Employee name: ");
            char name = sc.nextLine();
            System.out.println("Enter Employee basic salary :");
            float basicSalary = sc.nextFloat();
            Employee employee = null;

            if (emptype.equalsIgnoreCase("Permanent")) {
                System.out.print("Enter pf amount: ");
                int pf = sc.nextInt();
                employee = initializeEmployee(emptype, empid, basicSalary, pf, name, null, null);
            } else if (emptype.equalsIgnoreCase("Temporary")) {
                System.out.print("Enter daily wage amount: ");
                int dailyWages = sc.nextInt();
                System.out.print("Enter number of days worked: ");
                int numberofDays = sc.nextInt();
                employee = initializeEmployee(emptype, empid, basicSalary, null, dailyWages, numberofDays);
            } else {
                System.out.println("Invalid employee type");
                sc.close();
                return;
            }
            employee.displayDetails();
            sc.close();
        }

}