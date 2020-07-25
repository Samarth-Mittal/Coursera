package algorithmic_toolbox.week2;

import java.util.Scanner;

class JumpingNumbersGFG {
    public static void main (String[] args) {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            System.out.print("0 ");
            for(int i=1;i<=n;i++){
                int d=digits(i);
                int[] a=new int[d];
                int c=i;
                for(int j=d-1;j>=0;j--){
                    a[j]=c%10;
                    c=c/10;
                }
                int res=jumpingNumbers(a,0,d-1);
                if(res==1){
                    System.out.print(i+" ");
                }
		        /*if(d==1){
		            System.out.print(i+" ");
		        }
		        else{
		            int r=jumpingNumber(i,d);
		            if(r==1){
		                System.out.print(i+" ");
    		        }
	    	        else if(r==2){
		                if(d>2){
		                    int n1,n2,n3;
		                    n2=(i/((int)Math.pow(10,d/2)))%10;
		                    n1=(i/((int)Math.pow(10,(d/2)+1)))%10;
		                    n3=(i/((int)Math.pow(10,(d/2)-1)))%10;
    		                if(((int)Math.abs(n1-n2))==1&&((int)Math.abs(n2-n3))==1){
        		                System.out.print(i+" ");
	        	            }
		                }
		            }
		        }*/



            }
            System.out.println();
            t--;
        }
    }
    public static int digits(int n){
        int c=0;
        while(n>0){
            c++;
            n=n/10;
        }
        return c;
    }
/*	public static int jumpingNumber(int n, int c){
	    if(c==0){
	        return 1;
	    }
	    else if(c==1){
	        return 2;
	    }
	    else if(((int)Math.abs((n/((int)(Math.pow(10,c-1))))-(n%10)))>=c){
	        return 0;
	    }
	    else{
	        if(c==2){
	            if((int)Math.abs(n/10-n%10)==1){
	                return 1;
	            }
	            else{
	                return 0;
	            }
	        }
	        else{
    	        return jumpingNumber((n%((int)(Math.pow(10,c-1))))/10,c-2);
	        }
	    }
	}
	*/

    public static int jumpingNumbers(int[] a,int l,int r){
        int m=(l+r)/2;
        if(l==r){
            return 1;
        }
        else if(((int)Math.abs(a[m+1]-a[m]))!=1){
            return 0;
        }
        else{
            int r1=jumpingNumbers(a,l,m);
            int r2=jumpingNumbers(a,m+1,r);
            if(r1==1&&r2==1){
                return 1;
            }
            return 0;
        }
    }
}