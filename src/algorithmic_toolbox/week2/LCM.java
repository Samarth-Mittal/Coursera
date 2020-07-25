package algorithmic_toolbox.week2;

import java.util.Scanner;

public class LCM {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(((((long)a)*b)/hcf(a,b)));
    }

    private static int hcf(int a, int b) {
        if(b==0){
            return a;
        }
        else{
            return hcf(b,a%b);
        }
    }
}
