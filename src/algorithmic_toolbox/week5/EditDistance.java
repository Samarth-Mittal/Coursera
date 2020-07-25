package algorithmic_toolbox.week5;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int k=sc.nextInt();
        editDistance(a,b);
    }

    private static void editDistance(String a, String b) {
        int n=a.length(), m=b.length(),i,j;
        int[][] d=new int[n+1][m+1];
        for(i=0;i<=n;i++){
            d[i][0]=i;
        }
        for(i=1;i<=m;i++){
            d[0][i]=i;
        }
        for(j=1;j<=m;j++){
            for(i=1;i<=n;i++){
                int insertion=d[i][j-1]+1;
                int deletion=d[i-1][j]+1;
                int mismatch=d[i-1][j-1]+1;
                int match=d[i-1][j-1];
                if(a.charAt(i-1)==b.charAt(j-1)){
                    d[i][j]=minimum(insertion, deletion, match);
                }else{
                    d[i][j]=minimum(insertion, deletion, mismatch);
                }
            }
        }
        System.out.println(d[n][m]);
    }

    private static int minimum(int x, int y, int z) {
        if(x<=y&&x<=z){
            return x;
        }else if(y<=x&&y<=z){
            return y;
        }else{
            return z;
        }
    }
}
