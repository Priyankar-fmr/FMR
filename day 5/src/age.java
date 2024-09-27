import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;
class person{
    private String name;
    private String lastname;
    private LocalDate dob;
    public person(String name, String lastname, LocalDate dob){
        this.name=name;
        this.lastname=lastname;
        this.dob=dob;
    }
    public String getName(){
        return name;
    }
    public String setname() {
        this.name = name;
    }

    public String getLastname () {
        return lastname;
    }
    public void setLastName (String lastname){
        this.lastname = lastname;
    }
    public LocalDate getDateOfBirth (LocalDate dob){
        this.dob = dob;
    }
    public String getAdult () {
        int age = calculateAge();
    }
    private int calculateAge () {
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears();
    }
    public void displayDetails () {
        System.out.println("Name: " + name);
        System.out.println("Lastname: " + lastname);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Age: " + calculateAge());
        System.out.println("Status: " + getAdult());
    }
}
public class age{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your date of birth: ");
        String dob = sc.nextLine();
        person person = new person(firstName, lastName, LocalDate.parse(dob));
        person.displayDetails();
        sc.close();

    }
}