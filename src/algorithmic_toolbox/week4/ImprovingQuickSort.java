package algorithmic_toolbox.week4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

class ImprovingQuickSort{
    public static Random random=new Random();
    public static int[] a;
    public static void main(String args[]) {
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        QuickSort(0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

    private static void QuickSort(int l, int r) {
        if(l<r) {
            int k = random.nextInt(r - l + 1) + l;
            int[] m = partition3(l, r, k);
            QuickSort(l, m[0] - 1);
            QuickSort(m[1]+1, r);
        }
    }

    private static int[] partition3(int l, int r, int k) {
        int[] m={l,r};
        int x=a[k],i=l;
        while(i<=m[1]){
            if(x>a[i]){
                swap(m[0]++,i++);
            } else if(x<a[i]){
                swap(m[1]--,i);
            } else{
                i++;
            }
        }
        return m;
    }

    private static void swap(int i, int j) {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream){
            try{
                br=new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        String next(){
            while(st==null||!st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        float nextFloat(){
            return Float.parseFloat(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        String nextLine(){
            String s="";
            try{
                s=br.readLine();
            }catch (Exception e){
                e.printStackTrace();
            }
            return s;
        }
    }
}