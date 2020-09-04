import java.util.Scanner;
public class A3
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        String s = scan.nextLine();
        char arr[] = s.toCharArray();
        int n=arr.length;
        int i,j;
        for(i=0;i<n;i++){
            int b=(int)arr[i];
            if(b>=65 && b<=90)
            b=b-65;
            else
            b=b-97;
            for(j=i+1;j<n;j++){
                int c=(int)arr[j];
                if(c>=65 && c<=90)
                c=c-65;
                else
                c=c-97;
                if(c<b){
                    char temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    
                }
            }
        }
        for(i=0;i<n;i++)
        System.out.print(arr[i]);
        
        
	}
}