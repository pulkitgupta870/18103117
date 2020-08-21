import java.io.*;
import java.util.*;
public class A2{
	public static boolean match(String str,String[] v)
	{
		for(String st:v)
		{
			if(st.equals(str))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String text=sc.nextLine();
		String[] para=new String[1000000];
		int si=0;
		String temp="";
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)==' '||text.charAt(i)=='.'||text.charAt(i)==','||text.charAt(i)=='?'||text.charAt(i)=='!'||text.charAt(i)=='\"')
			{
				para[si]=temp;
				si++;
				para[si]=Character.toString(text.charAt(i));
				si++;
				temp="";
			}
			else
			{
				temp+=Character.toString(text.charAt(i));
			}
		}
		if(temp!="")
		{
			para[si]=temp;
			si++;
		}
		
		int a=sc.nextInt();
		sc.nextLine();
		String v[]=new String[a];
		for(int i=0;i<a;i++)
		{
			v[i]=sc.nextLine();
		}
		for(int i=0;i<para.length;i++)
		{
			if(match(para[i],v))
			{
				String tmp=Character.toString(para[i].charAt(0));
				for(int j=1;j<para[i].length();j++)
				{
					tmp+="*";
				}
				para[i]=tmp;
			}
		}
		
		for(int i=0;i<si;i++)
		{
			System.out.print(para[i]);
		}
	}
}