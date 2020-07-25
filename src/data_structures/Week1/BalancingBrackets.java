package data_structures.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class StackElement {
    StackElement(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

public class BalancingBrackets {
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner(System.in);
        String s = sc.nextLine();
        int pos = 0;
        Stack<StackElement> stack = new Stack<StackElement>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                StackElement b = new StackElement(ch, i+1);
                stack.push(b);
            }else if (ch == ')' || ch == ']' || ch == '}') {
                if(stack.empty()) {
                    pos = i + 1;
                    break;
                }
                StackElement top = stack.pop();
                if(!top.match(ch)) {
                    pos = i + 1;
                    break;
                }
            }
        }
        if(pos==0 && stack.empty())
            System.out.println("Success");
        else {
            if(pos == 0) {
                while(stack.size()>1)
                    stack.pop();
                pos = stack.peek().position;
            }
            System.out.println(pos);
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

/*public class BalancingBrackets {
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        String s=sc.nextLine();
        int i,l=s.length(),f=1;
        Stack<Character> stack=new Stack<Character>();
        for(i=0;i<l;i++){
            char ch=s.charAt(i);
            if(ch!=')'&&ch!='}'&&ch!=']'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    f=0;
                    System.out.println(i+1);
                    break;
                }
                char ch1=' ';
                do{
                    if(stack.isEmpty())
                        break;
                    ch1=stack.pop();
                }while(ch1!='('&&ch1!='{'&&ch1!='[');
                if((ch==')'&&ch1=='(')||(ch=='}'&&ch1=='{')||(ch==']'&&ch1=='[')){
                    continue;
                }else{
                    f=0;
                    System.out.println(i+1);
                }
            }
        }
        if(!stack.isEmpty()){

            char ch1=' ';
            do{
                if(stack.isEmpty())
                    break;
                ch1=stack.pop();
            }while(ch1!='('&&ch1!='{'&&ch1!='[');
            if(ch1=='('||ch1=='{'||ch1=='['){
                stack.push(ch1);
            }
        }
        if(stack.isEmpty()&&f==1){
            System.out.println("Success");
        }
        else if(f==1){
            System.out.println(i);
        }
    }

    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream input){
            try{
                br=new BufferedReader(new InputStreamReader(input));
            }catch (Exception e){
                e.printStackTrace();;
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

        String nextLine(){
            String s="";
            try{
                s=br.readLine();
            }catch (Exception e){
                e.printStackTrace();
            }
            return s;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}*/