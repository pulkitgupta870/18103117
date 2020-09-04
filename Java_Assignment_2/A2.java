import java.util.Scanner;
public class A2
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        
        int arr[]=new int[21];
        int i=0,j=0;
        for(i=0;i<21;i++)
        arr[i]=0;
        for(i=0;i<num;i++){
            int x=scan.nextInt();
            arr[x]++;
        }
        for(i=0;i<21;i++){
            for(j=0;j<arr[i];j++)
            System.out.print(i+" ");
        }
	}
}