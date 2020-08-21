import java.io.*;
import java.util.*;
public class A4
{
 
     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String t=sc.nextLine();
	    if(s.length()!=t.length())
	    System.out.println("NO");
	    else{
		int a[]=new int[256];
		int i;
		for(i=0;i<256;i++)
		a[i]=0;
		for(i=0;i<s.length();i++){
		    char c=s.charAt(i);
		    a[+c]++;
		}
		for(i=0;i<t.length();i++){
		    char c=t.charAt(i);
		    a[+c]--;
		}
		int f=0;
		for(i=0;i<256;i++){
		    if(a[i]!=0){
		        f=1;
		        System.out.println("NO");
		        break;
		    }		
		    
		}
		if(f==0)
		System.out.println("Yes");
		
	    }
     }
}
