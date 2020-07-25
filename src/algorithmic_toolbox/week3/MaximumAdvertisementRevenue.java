package algorithmic_toolbox.week3;

import java.util.Scanner;

public class MaximumAdvertisementRevenue {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] price=new int[n];
        int[] clicks=new int[n];
        int i,temp,j;
        long sum=0;
        for(i=0;i<n;i++){
            price[i]=sc.nextInt();
            j=i-1;
            temp=price[i];
            while(j>=0&&temp>price[j]){
                price[j+1]=price[j];
                j--;
            }
            price[j+1]=temp;
        }
        for(i=0;i<n;i++){
            clicks[i]=sc.nextInt();
            j=i-1;
            temp=clicks[i];
            while(j>=0&&temp>clicks[j]){
                clicks[j+1]=clicks[j];
                j--;
            }
            clicks[j+1]=temp;
        }
        for(i=0;i<n;i++){
            sum+=(((long)price[i])*clicks[i]);
        }
        System.out.println(sum);
    }
}
