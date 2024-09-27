import java.util.Scanner;
 public class squarecube{
     public static double findsquare(double no){
         return no*no;
     }
     public static double findcube(double no){
         return no*no*no;
     }
     public static void main(String[] args){

         Scanner sc = new Scanner(System.in);
         System.out.println("Enter a number ");
         double no = sc.nextDouble();
         double square = findsquare(no);
         double cube = findcube(no);
         System.out.println("The square is "+findsquare(no));
         System.out.println("The cube is "+findcube(no));
     }
 }