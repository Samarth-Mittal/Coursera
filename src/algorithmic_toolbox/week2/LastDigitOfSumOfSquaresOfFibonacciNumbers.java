package algorithmic_toolbox.week2;

import java.util.Scanner;

public class LastDigitOfSumOfSquaresOfFibonacciNumbers {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        System.out.println(fib(n));
    }

    private static long fib(long n) {
        long a=1,b=0,i=0,c=0,sum=0;
        while(i<n){
            c=(a+b)%10;
            sum=sum+(c*c)%10;
            a=b%10;
            b=c%10;
            i++;
        }
        return (sum%10);
    }
}