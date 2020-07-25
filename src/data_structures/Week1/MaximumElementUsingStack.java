package data_structures.Week1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumElementUsingStack {
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int n=sc.nextInt();
        int i,k;
        String s="";
        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> max=new Stack<Integer>();
        for(i=0;i<n;i++){
            s=sc.nextLine();
            if(s.equals("max")==true){
                System.out.println(max.peek());
            }else if(s.equals("pop")==true){
                k=stack.pop();
                if(max.peek()==k){
                    k=max.pop();
                }
            }else{
                k=Integer.parseInt(s.substring(s.indexOf(' ')+1));
                stack.push(k);
                if(max.empty()||k>=max.peek()){
                    max.push(k);
                }
            }
        }
    }
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream input){
            try{
                br=new BufferedReader(new InputStreamReader(input));
            }catch(Exception e){
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
