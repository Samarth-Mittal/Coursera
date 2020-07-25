package data_structures.Week2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ArrayToHeap {

    static int[] swap(int[] a, int x, int y){
        int t=a[x];
        a[x]=a[y];
        a[y]=t;
        return a;
    }


    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        Queue<Integer> q1=new LinkedList<Integer>();
        Queue<Integer> q2=new LinkedList<Integer>();
        int n=sc.nextInt();
        int i,f=0,c=0;
        int[] a=new int[n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        while(f==0){
            f=1;
            for(i=n-1;i>0;i--){
                if(i%2==1){
                    if(a[i]<a[(i-1)/2]){
                        f=0;
                        a=swap(a,i,(i-1)/2);
                        q1.add((i-1)/2);
                        q2.add(i);
                        c++;
                    }
                }else{
                    if(a[i]<a[(i-1)/2]&&a[i-1]<a[(i-2)/2]){
                        f=0;
                        int t=((a[i]<a[i-1])?i:i-1);
                        a=swap(a, t,(i-1)/2);
                        q1.add((i-1)/2);
                        q2.add(t);
                        c++;
                    }else if(a[i]<a[(i-1)/2]){
                        f=0;
                        c++;
                        a=swap(a,i,(i-1)/2);
                        q1.add((i-1)/2);
                        q2.add(i);
                    }else if(a[i-1]<a[(i-2)/2]){
                        f=0;
                        c++;
                        a=swap(a,i-1,(i-2)/2);
                        q1.add((i-2)/2);
                        q2.add(i-1);
                    }
                    i--;
                }
            }
        }
        System.out.println(c);
        while(q1.size()!=0){
            System.out.println(q1.remove()+" "+q2.remove());
        }
    }

    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream input){
            try{
                br=new BufferedReader(new InputStreamReader(input));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        String next(){
            while(st==null||!st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
