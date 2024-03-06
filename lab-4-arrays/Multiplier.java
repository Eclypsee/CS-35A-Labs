package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Multiplier {

    public static void main(String[] args) {
        for (int z=1;z<=5;z++) {
            int[] intarrays = new int[2];
            getInputs(intarrays, z);

           // Get the sign of input. If input >=0, return 1. If input <0, return -1;
            int firstNumSign = getSign(intarrays[0]);

            /* Adjust the input value to positive */
            int value0 = (firstNumSign==1 ? intarrays[0] :-intarrays[0]);

            /* getsize() ignore the leading zero and only report the size without zero.
             * With correct size, no need to worry about leading zero.
             */
            int firstNumLength = getsize(value0);
            int[] firstAry = new int[firstNumLength];
            makeArray(firstAry,value0,firstNumLength);


            //  Process the second input.
            int  secNumSign = getSign(intarrays[1]);
            int value1= (secNumSign==1 ? intarrays[1] :-intarrays[1]);
            int secNumLength = getsize(value1);
            int[] secAry = new int[secNumLength];
            makeArray(secAry,value1,secNumLength);

            // final sign calculation. If sign =1, output >=0. sign =-1, output <0
            int finalSign = firstNumSign * secNumSign;

            // Calculate the multiplication. mOut is an array to get final result.
            int finalLength=firstNumLength+secNumLength;
            int[] mOut = new int[finalLength];
            multiplier(mOut, firstAry, secAry, finalSign);

            // Print output.

            int nonzeroflag=0;
            System.out.print("The answer is: ");


                for (int i = 0; i < finalLength; i++) {
                   if (mOut[i]!=0 || nonzeroflag==1){
                        nonzeroflag=1;
                        System.out.print(mOut[i]);
                    }
                   else if ((i==finalLength-1) && nonzeroflag==0)
                       System.out.print("0");
                }// end for

            System.out.println();

        }
    }


public static void getInputs(int[] intarrays, int i){
    int k = 0;

    while (k < 2) {
        Scanner sc = new Scanner(System.in);
        System.out.print("test run " + i +" : Enter two integers for multiplication.");
        System.out.print(" insert integer "+(k+1)+": ");

            if (sc.hasNextInt()) {
                int tmp = sc.nextInt();
               if  ( tmp == Integer.MIN_VALUE)
               { System.out.println("please enter a valid integer!");}
                else
                   {   intarrays[k] = tmp;
                        k++;}

            } else
                System.out.println("please enter a valid integer!");
    }
}
/** returns false if negative, true is positive*/
public static int getSign(int number){
    int sign= number >=0 ? 1:-1;

    return sign;
}


public static int getsize(int number){

    String str = Integer.toString(number);
    int size  = (str.length());
    return(size);
}


public static void makeArray(int[] array, int number, int size){
        int pos = size-1;
        int q=0;
        int r=0;
        int input=number;
        for (int i=0;i<=size-1;i++){
            q=input/10;
            r=input%10;
            array[pos-i]=r;
            input=q;
        }
}


public static void multiplier(int[] mOut, int[] firstAry, int[] secAry, int finalSign){
   int secLength = secAry.length;
   int pos = secLength-1;
    for (int i=0;i<mOut.length;i++)
        mOut[i] = 0;

   int[] arrayOut = new int[firstAry.length+1];
   for (int j=0 ; j<secLength; j++) {
       multiOneRow(arrayOut, firstAry, secAry[pos - j]);
       finalSum(mOut, arrayOut, j);
   }
    if (mOut[0]!=0) mOut[0] = finalSign * mOut[0];
    else mOut[1] = finalSign * mOut[1];
}


public static void multiOneRow(int[] arrayOut, int[] firstAry, int b ){

        int cin =0;
        int pos=firstAry.length-1;
    for (int i=0 ; i<firstAry.length; i++) {
        int sum= firstAry[pos-i] * b + cin;
        arrayOut[pos-i+1]= sum %10;
        cin = sum/10;
    }
     arrayOut[0] =cin;
}


public static void finalSum(int[] mOut, int[] arrayIn, int bpos){

        int arraypos=arrayIn.length-1;
        int moutpos= mOut.length-bpos-1;
        int cin=0;
    for (int i=0;i<arrayIn.length;i++) {
        int sum = mOut[moutpos - i] + arrayIn[arraypos - i]+cin;
        mOut[moutpos-i] = sum%10;
        cin = sum/10;
    }
}




}
