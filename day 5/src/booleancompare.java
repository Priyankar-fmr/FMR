import java.util.Scanner;
public class booleancompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x,y;
        System.out.println("Enter the value of x");
        x = sc.nextInt();
        System.out.println("Enter the value of y");
        y = sc.nextInt();
        boolean result = (x < y);
        if(result) {
            System.out.println("x is lesser than y");
        }
        else {
            System.out.println("x is greater than y");
        }
    }
}