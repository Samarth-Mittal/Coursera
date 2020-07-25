package algorithmic_toolbox.week5;

//Similar Code, but still doesn't work: shows TLE
/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

    static void change(int n){
        List<Integer> list=new ArrayList<Integer>();
        while(n>=1){
            list.add(n);
            int m=n;
            m--;
            if(n%2==0&&n/2<=m){
                m=n/2;
            }
            if(n%3==0&&n/3<=m){
                m=n/3;
            }
            n=m;
        }
        System.out.println(list.size()-1);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
//        int[] a=new int[n+1];
//        int i,j;
//        String[] s=new String[n+1];
//        s[0]="";
//        s[1]="1 ";
//        a[0]=-1;
//        a[1]=0;
//        for(i=2;i<=n;i++){
//            a[i]=Integer.MAX_VALUE;
//        }
//        for(i=2;i<=n;i++){
//            a[i]=a[i-1]+1;
//            s[i]=s[i-1]+i+" ";
//            if(i%2==0){
//                if(a[i]>a[i/2]){
//                    a[i]=a[i/2]+1;
//                    s[i]=s[i/2]+i+" ";
//                }
//            }
//            if(i%3==0){
//                if(a[i]>a[i/3]){
//                    a[i]=a[i/3]+1;
//                    s[i]=s[i/3]+i+" ";
//                }
//            }
//        }
//        System.out.println(a[n]+"\n"+s[n]);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        change(n);
    }
}
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    private static List<Integer> change(int n) {
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + 1;
            s[i] = i - 1;
            if (i % 3 == 0) {
                if (a[i / 3] < a[i]) {
                    a[i] = a[i / 3] + 1;
                    s[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (a[i / 2] < a[i]) {
                    a[i] = a[i / 2] + 1;
                    s[i] = i / 2;
                }
            }
        }

        ArrayList<Integer> sequence = new ArrayList<Integer>();

        for (int i = n; i != 0; i = s[i]) {
            sequence.add(i);
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = change(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}