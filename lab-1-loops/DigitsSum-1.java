
import java.util.Scanner;

public class DigitsSum {
    public static void main(String[] args) {

        //does the 5 test runs
        for (int i=0;i<5;i++) { //start of for loop

            //sets the variables to zero every time
            int input=0;
            int oldSum=0;
            int quotient=0;
            int remainder=0;
            int sum=0;

            //scans for input
            Scanner sc = new Scanner(System.in);
            System.out.print("Insert number between 0 and 1000: ");
            input = sc.nextInt();

            //gets the "solution"
            while (input > 0) {//start of while loop
                quotient = input / 10;//removes last digit
                remainder = input % 10;//extracts last digit
                sum = oldSum + remainder;//current remainder is added to previous digits
                input = quotient;//sets input to the number that had an extracted digit
                oldSum = sum;//remainder for current number and previous digits added together is = oldSum
            }//end of while loop

            //prints the "solution"
            System.out.println("Test run: "+(i+1)+", sum of digits: " + sum);

        }//end of for loop (loops 5 times because 5 test runs)

    }
}
