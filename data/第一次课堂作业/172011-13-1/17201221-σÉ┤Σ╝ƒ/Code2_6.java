
public class Code2_6 {
	private static java.util.Scanner input;

	public static void main(String[] args){
		input = new java.util.Scanner(System.in);
		System.out.print("Enter an integer between 0 and 1000:");
		int number = input.nextInt();
		int a=number%10;
		int s=number/10;
		int b=s%10;
		s=s/10;
		int c=s%10;
		int sum=a+b+c;
		System.out.println("The sun of all digits in "+number+" is "+sum);
	}
}
