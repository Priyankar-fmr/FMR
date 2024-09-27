import java.util.Scanner;
public class concat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        String fullName = firstName + " " + lastName;
        System.out.print("Your fullname is : " + fullName);
    }
}