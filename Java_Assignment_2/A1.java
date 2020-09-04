import java.util.Scanner;
public class A1
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        String s=scan.nextLine();
        String s1=scan.nextLine();
        int n=s.length();
        int m=s1.length();
        int i=0,flag=0,a=0,b=0;
        while(i<n && i<m){
            a=s.charAt(i);
            b=s1.charAt(i);
            if(a!=b){
                flag=1;
                break;
            }
            i++;
        }
        if(flag==1){
            System.out.println(a-b);
        }
        else{
            if(n>m)
            System.out.println(n-m);
            else if(m>n)
            System.out.println(m-n);
            else
            System.out.println("0");
        }
        
        
	}
}