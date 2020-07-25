package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MaximumValueOfTheLoot {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double W=sc.nextDouble();
        int i,j;
        double sum=0;
        int[] v=new int[n];
        int[] w=new int[n];
        double[] a=new double[n];
        for(i=0;i<n;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
            a[i]=((double)v[i])/w[i];
            double temp=a[i];
            int tempw=w[i],tempv=v[i];
            j=i-1;
            while(j>=0&&temp>a[j]){
                a[j+1]=a[j];
                w[j+1]=w[j];
                v[j+1]=v[j];
                j--;
            }
            a[j+1]=temp;
            w[j+1]=tempw;
            v[j+1]=tempv;
        }
        for(i=0;W>0&&i<n;i++){
            if(W-w[i]>=0){
                sum+=v[i];
                W-=w[i];
            }
            else{
                sum+=(W*a[i]);
                W=0;
            }
        }
        System.out.println(sum);
    }
}
