import java.util.Scanner;
public class reverse{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String sentence = sc.nextLine();
        String reversedSentence = reverse(sentence);
        System.out.println(reversedSentence);
        sc.close();
    }
    public static String reverse(String str){
        String[] words = str.split("");
        StringBuilder reversed = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            reversed.append(words[i]);
            if(i!=0){
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}