package algorithmic_toolbox.week6;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumAmountOfGold {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int W=sc.nextInt();
        int n=sc.nextInt();
        int[] w=new int[n];
        int i,j;
        for(i=0;i<n;i++){
            w[i]=sc.nextInt();
        }
        Arrays.sort(w);
        int[][] a=new int[n+1][W+1];
        for(i=0;i<=n;i++){
            a[i][0]=0;
        }
        for(i=0;i<=W;i++){
            a[0][i]=0;
        }
        for(i=1;i<=n;i++){
            for(j=1;j<=W;j++){
                a[i][j]=a[i-1][j];
                if(w[i-1]<=j){
                    if(a[i][j]<a[i-1][j-w[i-1]]+w[i-1]){
                        a[i][j]=a[i-1][j-w[i-1]]+w[i-1];
                    }
                }
            }

        }
        //Code for displaying the knapsack content matrix
        /*for(i=0;i<=n;i++){
            for(j=0;j<=W;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }*/
        System.out.println(a[n][W]);
    }
}
