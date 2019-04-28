import java.util.Scanner;

public class SumOfInteger {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
	
			int number;
			int sum = 0;
			while(true) {
				System.out.print("Enter a number between 0 and 1000: ");
				number =   input.nextInt();
				if(number < 0 || number > 1000) {
				}
				else {
					break;
				}
			}
			int x = number / 10;
			if(x == 0) {
				sum = number;
			}
			while(x >= 1) {
				int first = number % 10;
				x= number / 10;
				number = x;
				sum = sum + first;
			}
			System.out.println("The sum of the digits is : " + sum);
		}
		finally {
			input.close();
		}
	}

}
