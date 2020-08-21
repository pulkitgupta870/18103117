import java.io.*;
import java.util.*;
public class A1
{
static int ans=0;
    static void per(String s,String t,String a){
        if(t.length()==0){
            String n=s;
            while(10<20){
		    int k=n.indexOf(a);
		    if(k==-1 )
		    break;
		    n=n.substring(k+1);
		    ans++;
		    
		    }
        }
        else{
            for (int i = 0; i < t.length(); i++) { 
            char ch = t.charAt(i); 
            String r = t.substring(0, i) + t.substring(i + 1); 
            per(s,r,a+ch); 
        }
        }
    }
     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String t=sc.nextLine();
	
		per(s,t,"");
		System.out.println(ans);
     }
}