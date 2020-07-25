package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MoneyChange {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0,i=0;
        int[] a={10,5,1};
        while(i<3){
            sum+=n/a[i];
            n=n%a[i++];
        }
        System.out.println(sum);
    }
}