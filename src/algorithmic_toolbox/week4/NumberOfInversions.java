package algorithmic_toolbox.week4;

import java.util.Scanner;

public class NumberOfInversions {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i,j,c=0;
        int[] a=new int[n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(a[i]>a[j]){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                    c++;
                }
            }
        }
        /*for(i=0,j=n-1;i<j;){
            if(a[j]<a[i]){
                int t=a[j];
                a[j]=a[i];
                a[i]=t;
                i++;
                c++;
            }
            else if(a[j]>a[i]){
                j--;
            }
            else{
                i++;
            }
        }*/
        System.out.println(c);
    }
}