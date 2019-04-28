import java.util.Scanner;

public class Homework_3_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int guess[] = new int[3];
		int in[] = new int[3];
		int n,m,k;
		int flag = 1;
		
		n = 0;
		for (int i = 0; i < 3; i++) {
			guess[i] = (int)(Math.random() * 10);
			n = n * 10 + guess[i];
		}
		
		
		System.out.println("Please input a three bit integers:");
		m = input.nextInt();
		
		in[0] = m % 10;
		in[1] = (m / 10) % 10;
		in[2] = (m / 100) % 10;
		k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (guess[i] == in[j]) {
					k++;
					break;
				}
			}
		}
		if (n == m) {
			System.out.println("You win 10000 dollars!");
		}
		else if (k == 3) {
			System.out.println("You win 3000 dollars!");
		}
		else if (k < 3 && k > 0) {
			System.out.println("You win 1000 dollars!");
		}
		else {
			System.out.println("Nothing!");
		}
		
	}
}