package algorithmic_toolbox.week4;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i;
        int[] a=new int[n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int[] b=new int[k] ;
        for(i=0;i<k;i++){
            b[i]=sc.nextInt();
            System.out.print(binarySearch(a,0,n-1,b[i])+" ");
        }
    }

    private static int binarySearch(int[] a, int l, int r, int key) {
        int m=(l+r)/2;
        if(l>r&&a[m]!=key){
            return -1;
        }
        else if(a[m]==key) {
            return m;
        }
        else if(a[m]>key){
            return binarySearch(a,l,m-1,key);
        }
        else{
            return binarySearch(a,m+1,r,key);
        }
    }
}