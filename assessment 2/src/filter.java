import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class filter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<String> employees = new ArrayList<>();
        System.out.println("Enter the number of employees: ");
        int noofemployees = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < noofemployees; i++) {
            System.out.println("Enter the employee name: ");
            String employeename = sc.nextLine();
            employees.add(employeename);
        }
        List<String>filter = employees.stream()
                .filter(name-> name.startsWith("A")||name.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println("Employees whose name starts with A: ");
        filter.forEach(System.out::println);

    }
}