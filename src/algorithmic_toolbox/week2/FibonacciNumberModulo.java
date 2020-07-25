package algorithmic_toolbox.week2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNumberModulo {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        System.out.println(fib(n,m));
    }

    private static long fib(long n, long m) {
        BigInteger x,y=BigInteger.valueOf(m);
        x= BigDecimal.valueOf(Math.round(Math.pow(((1+Math.sqrt(5))/2),n)/Math.sqrt(5))).toBigInteger();
        System.out.println(x);
        int r=x.mod(y).intValue();
        return r;
    }
}