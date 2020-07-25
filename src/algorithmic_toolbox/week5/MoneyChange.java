package algorithmic_toolbox.week5;

import java.util.Scanner;

public class MoneyChange {

    static int change(int n, int m[]){
        int[] a=new int[n+1];
        int i,j;
        a[0]=0;
        for(i=1;i<=n;i++){
            a[i]=Integer.MAX_VALUE;
        }
        for(i=1;i<=n;i++){
            for(j=0;j<m.length;j++){
                if(m[j]<=i){
                    int al_coins=a[i-m[j]];
                    if(al_coins+1<a[i]){
                        a[i]=al_coins+1;
                    }
                }
            }
        }
        return a[n];
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] m={1,3,4};
        System.out.println(change(n,m));
    }
}
