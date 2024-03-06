package kem.kempanee;
import java.util.Scanner;
public class commaRemover {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("sample run: " + (i+1) + " , insert a number between 1,000 and 999,999. please add commas too: ");
            String numbers = input.next();
            int asdf = numbers.length();
            System.out.print("Answer is: "+numbers.substring(0,asdf-4));
            System.out.println(numbers.substring(asdf-3,asdf));
        }
    }
}
