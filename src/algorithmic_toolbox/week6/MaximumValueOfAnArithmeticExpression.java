package algorithmic_toolbox.week6;

import java.math.BigInteger;
import java.util.Scanner;

public class MaximumValueOfAnArithmeticExpression {

    static BigInteger minimum(BigInteger a, BigInteger b){
        if(a.compareTo(b)==1){
            return b;
        }
        return a;
    }

    static BigInteger maximum(BigInteger a, BigInteger b){
        if(a.compareTo(b)==1){
            return a;
        }
        return b;
    }

    static BigInteger[] minMax(BigInteger[][] a, char[] op, int i, int j){
        int n=a.length;
        BigInteger A,B,C,D;
        BigInteger[] m={new BigInteger(Integer.toString(Integer.MAX_VALUE)), new BigInteger(Integer.toString(Integer.MIN_VALUE))};         //m[]={min,max};
        for(int k=i;k<j;k++){
            switch(op[k]){
                case '*':
                    A=a[i][k].multiply(a[k+1][j]);
                    B=a[i][k].multiply(a[j][k+1]);
                    C=a[k][i].multiply(a[k+1][j]);
                    D=a[k][i].multiply(a[j][k+1]);
                    break;
                case '-':
                    A=a[i][k].subtract(a[k+1][j]);
                    B=a[i][k].subtract(a[j][k+1]);
                    C=a[k][i].subtract(a[k+1][j]);
                    D=a[k][i].subtract(a[j][k+1]);
                    break;
                case '+':
                    A=a[i][k].add(a[k+1][j]);
                    B=a[i][k].add(a[j][k+1]);
                    C=a[k][i].add(a[k+1][j]);
                    D=a[k][i].add(a[j][k+1]);
                    break;
                default:
                    A=BigInteger.ZERO;
                    B=BigInteger.ZERO;
                    C=BigInteger.ZERO;
                    D=BigInteger.ZERO;
            }
            BigInteger min=minimum(A,minimum(B,minimum(C,D)));
            BigInteger max=maximum(A,maximum(B,maximum(C,D)));
            if(m[0].compareTo(min)==1){
                m[0]=min;
            }
            if(m[1].compareTo(max)==-1){
                m[1]=max;
            }
        }
        return m;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int l=s.length();
        int n=l/2;
        BigInteger[][] a=new BigInteger[n+1][n+1];
        for(int ij=0;ij<=n;ij++){
            for(int ji=0;ji<=n;ji++){
                a[ij][ji]=BigInteger.ZERO;
            }
        }
        char[] op=new char[n];
        int i,j,k;
        for(i=0,j=0,k=0;i<l;i++){
            if(i%2==0){
                a[j][j++]=new BigInteger(Integer.toString(s.charAt(i)-48));
            }else{
                op[k++]=s.charAt(i);
            }
        }
        for(k=0;k<=n;k++){
            for(i=0;i<=n-k;i++){
                j=i+k;
                BigInteger[] m=minMax(a,op,i,j);
                if(m[0].compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE)))!=0){
                    if(a[j][i].compareTo(m[0])==1||a[j][i].compareTo(BigInteger.ZERO)==0){
                        a[j][i]=m[0];
                    }
                }
                if(m[1].compareTo(new BigInteger(Integer.toString(Integer.MIN_VALUE)))!=0){
                    if(a[i][j].compareTo(m[1])==-1||a[i][j].compareTo(BigInteger.ZERO)==0){
                        a[i][j] = m[1];
                    }
                }
            }
        }
        System.out.println(a[0][n]);
    }
}