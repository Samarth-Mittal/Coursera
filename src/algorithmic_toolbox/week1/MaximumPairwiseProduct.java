package algorithmic_toolbox.week1;

import java.util.Scanner;

public class MaximumPairwiseProduct {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] num=new long[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        System.out.println((maxProduct(num,n)));
    }

    private static long maxProduct(long num[],int n) {
        int max=-1,max2=-1,i,j;
        for(i=0;i<n;i++){
            if((max==-1)||(num[i]>num[max])){
                max=i;
            }
        }
        for(i=0;i<n;i++){
            if((i!=max)&&((max2==-1)||(num[i]>num[max2]))){
                max2=i;
            }
        }
        return num[max]*num[max2];
    }
}