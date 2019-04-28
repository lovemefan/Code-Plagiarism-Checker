package onetime;
import java.util.Scanner;
public class Sum {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Enter a number between 0 and 1000:");
		int num=scan.nextInt();
		int remainder=0;
		int result=0;
		int sum=0;
		if(num>=0&&num<=9){
			sum=num;
		}else if(num>=10&&num<=99){
			remainder=num%10;
			result=num/10;
			sum=remainder+result;
		}else if(num>=100&&num<=999){
			remainder=num%10+num/10%10;;
			
			result=num/10/10;
			sum=remainder+result;
		}else{
			sum=num/1000;
		}
		
		System.out.println("The sum of the digits is "+sum);
		
		
		
		
		
		
		
	}

}
