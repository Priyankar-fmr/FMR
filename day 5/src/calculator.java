import java.util.Scanner;
class calculator{
    public int addition(int a, int b){
        return a+b;
    }
    public int subtraction(int a, int b){
        return a-b;
    }
    public int multiplication(int a, int b){
        return a*b;
    }
    public double division(int a, int b, double[] remainder){
        if(b==0){
            throw new ArithmeticException("Division by zero");
        }
        remainder[0]=a%b;
        return(double)a/b;
    }
}
public class program{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        calculator cal = new calculator();
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        System.out.println("Enter an operator: ");
        char op = sc.next().charAt(0);
        switch(op){
            case '+': System.out.println(cal.addition(a, b));break;
            case '-': System.out.println(cal.subtraction(a, b));break;
            case '*': System.out.println(cal.multiplication(a, b));break;
            case '/': double[] remainder = new double[a];
                      double[] quotient = cal.division( a,b,remainder);
                      System.out.println("Quotient: "+quotient);
                      System.out.println("Remainder: "+remainder);
                      break ;
            default: System.out.println("Invalid operator");
        }
        sc.close();
    }
}