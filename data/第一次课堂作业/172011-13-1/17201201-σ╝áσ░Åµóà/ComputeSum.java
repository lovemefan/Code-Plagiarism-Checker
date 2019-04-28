import java.util.Scanner;

public class ComputeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input a integer(0-1000):");
		@SuppressWarnings("resource")
		Scanner input =new Scanner(System.in);
		int number=input.nextInt();
		int ge=0,shi=0,bai=0,f=0,sum=0;
		if(number<100){
		ge=number%10;
		shi=number/10;
		sum=ge+shi;
		System.out.println("The sum of the integer is " + sum);
		}
		else if(number<1000){
			ge=number%10;
			f=number/10;
			shi=f%10;
			ge=f%10;
			bai=f/10;
			sum=ge+shi+bai;
			System.out.println("The sum of the integer is " + sum);
		}

	}

}
