import java.util.Scanner;
public class Three {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
			System.out.print("Enter a number from 0 to 1000:");
				int integer = input.nextInt();
					int sum = integer%10 + (integer/10)%10 + integer/100;
						System.out.println("The integer's three num's all is" + sum);
	}
}
