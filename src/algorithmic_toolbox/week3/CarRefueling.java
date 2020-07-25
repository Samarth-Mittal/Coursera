package algorithmic_toolbox.week3;

import java.util.Scanner;

public class CarRefueling {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int d=sc.nextInt();
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] a=new int[n+2];
        int i,max=0,c=0,t=0;
        a[0]=0;
        a[n+1]=d;
        for(i=1;i<n+1;i++){
            a[i]=sc.nextInt();
        }
        for(i=1;i<n+2;i++){
            if(a[i]-a[i-1]>m) {
                c=-1;
                break;
            }
            else if(a[i]-t<=m&&max<a[i]){
                max=a[i];
            }
            else {
                c++;
                t = max;
                i--;
            }
        }
        System.out.println(c);
    }
}
