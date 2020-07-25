package algorithmic_toolbox.week2;

import java.util.Scanner;

public class LastDigitOfSumOfFibonacciNumbersFromMtoN {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long m=sc.nextLong();
        long n=sc.nextLong();
        System.out.println(fib(m,n));
    }

    private static long fib(long m, long n) {
        long a=1,b=0,i=0,c=1,sum=0;
        while(i<=n){
            if (i>=m){
                sum+=c;
            }
            c=(a+b)%10;
            a=b%10;
            b=c%10;
            i++;
        }
        if(m==0)
            return (sum-1)%10;
        return (sum%10);
    }
}