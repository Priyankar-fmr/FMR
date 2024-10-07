import java.util.Scanner;
import java.util.LinkedList;

public class linkedlist {
    public static void main(String[] args) {
        linkedlist<String> linkedlist = new linkedlist<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 4 elements for the Linkedlist");
        for(int i=0;i<4;i++){
            System.out.println("Element "+(i+1)+":");
            String element = sc.nextLine();
            linkedlist.add(element);
        }

        System.out.println("Original LinkedList: "+linkedlist);
        System.out.println("Enter the inddex of the element to be removed");
        int index = sc.nextInt();

        if(index>=0 && index<4){
            linkedlist.remove(index);
            System.out.println("Linkedlist after removing the index: "+linkedlist);}
        else{
            System.out.println("Invalid Index");
        }
        scanner.close();
    }
}