import java.util.Scanner;
public class A6
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        
        while(num!=1){
            System.out.println(num);
            if(num%2==1){
                num=num*3;
                num=num+1;
            }
            else{
                num=num/2;
            }
        }
        System.out.println(num);
	}
}