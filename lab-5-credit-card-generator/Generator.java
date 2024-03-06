import java.util.Scanner;
import java.lang.Math;
public class Generator {
    public static void main(String[] args) {

        while (true) {
            long number = generateCard();
            boolean isBetweenThirteenAndSixteenValid = betweenThirteenAndSixteen(number);
            boolean isTheCardValid = isValid(number);
            int a = sumOfDoubleEvenPlace(number);
            int b = sumOfOddPlace(number);
            boolean isModTenValid = modTen(a, b);

            if (isTheCardValid && isModTenValid && isBetweenThirteenAndSixteenValid) {
                System.out.println(number);
                break;
            }
        }

    }
/////////////////////////////////////////////////////////
    public static long generateCard(){
        long num = (long)(Math.random()*1000000000000000L);
        return num;
    }

    /**checks if the number is within range*/
    public static boolean betweenThirteenAndSixteen(long number){
        int length = getSize(number);
        if (length>=13&&length<=16) return true;
        else return false;
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number){
        boolean visa = prefixMatched(number, 4);
        boolean master = prefixMatched(number, 5);
        boolean discover = prefixMatched(number, 6);
        int prefix = (int) getPrefix(number, 2);
        if(visa||master||discover)
            return true;
        else if(prefix == 37)
            return true;
        else
            return false;
    }


    /** Get the result if the card number is valid */
    public static int sumOfDoubleEvenPlace(long number){
        int length = getSize(number);
        long quotient=0;
        int remainder=0;
        int afterDoubled=0;
        int sumOfDouble=0;
        //System.out.println("length =" + length);
        for (int i=1;i<=length;i++){
            quotient = number/10;
            if (i%2==0){
                remainder = (int)(number%10);
                afterDoubled = getDigit(remainder);
                sumOfDouble = sumOfDouble+afterDoubled;
            }
            number = quotient;
            //System.out.println("i= "+i+" sumOfDouble= " + sumOfDouble + " afterDoubled=" + afterDoubled + " quotient=" + quotient);
        }
        return sumOfDouble;
    }


    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int digit){
        int afterIMultipliedItByTwo = digit * 2;
        if (afterIMultipliedItByTwo<10){
            return afterIMultipliedItByTwo;
        }
        else {
           int a= afterIMultipliedItByTwo%10;
           int b = afterIMultipliedItByTwo/10;
           return a+b;
        }
    }


    public static int sumOfOddPlace(long number){
        int length = getSize(number);
        long quotient=0;
        int remainder=0;
        int sum=0;
        for (int i=1;i<=length;i++){
            quotient = number/10;
            if (i%2==1){
                remainder = (int)(number%10);
                sum = sum+remainder;
            }
            number = quotient;
        }
        return sum;
    }


    /** Return true if mod ten algorithm is valid
     * else return false */
    public static boolean modTen(int a, int b){
        int dividend = a+b;
        if (dividend%10==0) return true;
        else return false;
    }


    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        int prefix = (int)getPrefix(number, 1);
        if (prefix==d)
            return true;
        else
            return false;
    }


    /** Return the number of digits in d */
    public static int getSize(long d){
        String cardLength = Long.toString(d);
        return (cardLength.length());
    }


    /** Return the first k number of digits from number. If the
     *  number of digits in number is less than k, return number.
     *  k is num of bits */
    public static long getPrefix(long number, int k){
        String digits = Long.toString(number);
        String prefix = digits.substring(0,k);//k means the number before k
        long out = Long.parseLong(prefix);
        return out;
    }


}
