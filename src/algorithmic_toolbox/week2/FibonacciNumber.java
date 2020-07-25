package algorithmic_toolbox.week2;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        if(n==0)
            System.out.println("0");
        else {
            if (n == 1)
                a[0] = 1;
            else {
                a[0] = 1;
                a[1] = 1;
            }
            for (int i = 2; i < n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            System.out.println(a[n-1]);
        }
    }
}