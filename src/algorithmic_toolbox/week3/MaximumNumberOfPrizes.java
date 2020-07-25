package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MaximumNumberOfPrizes {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n= (int) (((Math.sqrt(((double)x)*8+1))-1)/2);
        System.out.println(n);
        for(int i=1;i<n;i++){
            System.out.print(i+" ");
            x-=i;
        }
        System.out.print(x);
    }
}
