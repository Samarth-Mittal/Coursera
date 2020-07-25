package algorithmic_toolbox.week4;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i;
        int[] a=new int[n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sort(a,0,n-1);
        int m=n/2,c=0;
        for(i=0;i<n;i++){
            if(a[i]==a[m]){
                c++;
            }
        }
        if(c>(n/2)){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }

    private static void sort(int[] a, int l, int r) {
        if(l<r){
            int m=(l+r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1=m-l+1,n2=r-m,i,j,k;
        int[] A=new int[n1];
        int[] B=new int[n2];
        for(i=0;i<n1;i++){
            A[i]=a[l+i];
        }
        for(i=0;i<n2;i++){
            B[i]=a[m+i+1];
        }
        for(i=0,j=0,k=l;i<n1&&j<n2;k++){
            if(A[i]<B[j]){
                a[k]=A[i++];
            }
            else{
                a[k]=B[j++];
            }
        }
        while(i<n1){
            a[k++]=A[i++];
        }
        while(j<n2){
            a[k++]=B[j++];
        }
    }
}