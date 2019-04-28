package dmz;

import java.util.Scanner;

public class Problem3_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits) : ");
		String guessLottery = input.nextLine();
		String getLottery = "123";//"" + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10);
		System.out.println("The lottery number is " + getLottery);
		if(getLottery.equals(guessLottery)) {
			System.out.println("Exact match: your win $10,000");
		}
		else if((guessLottery.charAt(0) == getLottery.charAt(0) 
				&& guessLottery.charAt(1) == getLottery.charAt(2) 
				&& guessLottery.charAt(2) == getLottery.charAt(1)) 
				|| (guessLottery.charAt(0) == getLottery.charAt(1) 
					&& ((guessLottery.charAt(1) == getLottery.charAt(2) 
					&& guessLottery.charAt(2) == getLottery.charAt(0))
					|| (guessLottery.charAt(1) == getLottery.charAt(0) 
					&& guessLottery.charAt(2) == getLottery.charAt(2)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(2) 
					&& ((guessLottery.charAt(1) == getLottery.charAt(1) 
					&& guessLottery.charAt(2) == getLottery.charAt(0))
					|| (guessLottery.charAt(1) == getLottery.charAt(0) 
					&& guessLottery.charAt(2) == getLottery.charAt(1))))) {
			System.out.println("Match all digits: your win $3,000");
		}
		else if((guessLottery.charAt(0) == getLottery.charAt(0) 
				&& ((guessLottery.charAt(1) == getLottery.charAt(1) 
				&& guessLottery.charAt(2) != getLottery.charAt(2)) 
					|| (guessLottery.charAt(1) == getLottery.charAt(2) 
					&& guessLottery.charAt(2) != getLottery.charAt(1)) 
					|| (guessLottery.charAt(2) == getLottery.charAt(1) 
					&& guessLottery.charAt(1) != getLottery.charAt(2)) 
					|| (guessLottery.charAt(2) == getLottery.charAt(2) 
					&& guessLottery.charAt(1) != getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(1) 
						&& ((guessLottery.charAt(1) == getLottery.charAt(0) 
						&& guessLottery.charAt(2) != getLottery.charAt(2)) 
						|| (guessLottery.charAt(1) == getLottery.charAt(2) 
						&& guessLottery.charAt(2) != getLottery.charAt(0)) 
						|| (guessLottery.charAt(2) == getLottery.charAt(0) 
						&& guessLottery.charAt(1) != getLottery.charAt(2)) 
						|| (guessLottery.charAt(2) == getLottery.charAt(2) 
						&& guessLottery.charAt(1) != getLottery.charAt(0)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(2) 
						&& ((guessLottery.charAt(1) == getLottery.charAt(1) 
						&& guessLottery.charAt(2) != getLottery.charAt(0)) 
						|| (guessLottery.charAt(1) == getLottery.charAt(0) 
						&& guessLottery.charAt(2) != getLottery.charAt(1)) 
						|| (guessLottery.charAt(2) == getLottery.charAt(1) 
						&& guessLottery.charAt(1) != getLottery.charAt(0)) 
						|| (guessLottery.charAt(2) == getLottery.charAt(0) 
						&& guessLottery.charAt(1) != getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) != getLottery.charAt(0) 
						&& ((guessLottery.charAt(1) == getLottery.charAt(1) 
						&& guessLottery.charAt(2) == getLottery.charAt(2))
						|| (guessLottery.charAt(1) == getLottery.charAt(2) 
						&& guessLottery.charAt(2) == getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) != getLottery.charAt(1) 
						&& ((guessLottery.charAt(1) == getLottery.charAt(0) 
						&& guessLottery.charAt(2) == getLottery.charAt(2))
						|| (guessLottery.charAt(1) == getLottery.charAt(2) 
						&& guessLottery.charAt(2) == getLottery.charAt(0)))) 
				|| (guessLottery.charAt(0) != getLottery.charAt(2) 
						&& ((guessLottery.charAt(1) == getLottery.charAt(0) 
						&& guessLottery.charAt(2) == getLottery.charAt(1))
						|| (guessLottery.charAt(1) == getLottery.charAt(1) 
						&& guessLottery.charAt(2) == getLottery.charAt(0))))) {
			System.out.println("Match two digits: your win $2,000");
		}
		else if((guessLottery.charAt(0) != getLottery.charAt(0) 
				&& ((guessLottery.charAt(1) != getLottery.charAt(1) 
				&& guessLottery.charAt(2) == getLottery.charAt(2)) 
					|| (guessLottery.charAt(1) != getLottery.charAt(2) 
					&& guessLottery.charAt(2) == getLottery.charAt(1)) 
					|| (guessLottery.charAt(2) != getLottery.charAt(1) 
					&& guessLottery.charAt(1) == getLottery.charAt(2)) 
					|| (guessLottery.charAt(2) != getLottery.charAt(2) 
					&& guessLottery.charAt(1) == getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) != getLottery.charAt(1) 
						&& ((guessLottery.charAt(1) != getLottery.charAt(0) 
						&& guessLottery.charAt(2) == getLottery.charAt(2)) 
						|| (guessLottery.charAt(1) != getLottery.charAt(2) 
						&& guessLottery.charAt(2) == getLottery.charAt(0)) 
						|| (guessLottery.charAt(2) != getLottery.charAt(0) 
						&& guessLottery.charAt(1) == getLottery.charAt(2)) 
						|| (guessLottery.charAt(2) != getLottery.charAt(2) 
						&& guessLottery.charAt(1) == getLottery.charAt(0)))) 
				|| (guessLottery.charAt(0) != getLottery.charAt(2) 
						&& ((guessLottery.charAt(1) != getLottery.charAt(1) 
						&& guessLottery.charAt(2) == getLottery.charAt(0)) 
						|| (guessLottery.charAt(1) != getLottery.charAt(0) 
						&& guessLottery.charAt(2) == getLottery.charAt(1)) 
						|| (guessLottery.charAt(2) != getLottery.charAt(1) 
						&& guessLottery.charAt(1) == getLottery.charAt(0)) 
						|| (guessLottery.charAt(2) != getLottery.charAt(0) 
						&& guessLottery.charAt(1) == getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(0) 
						&& ((guessLottery.charAt(1) != getLottery.charAt(1) 
						&& guessLottery.charAt(2) != getLottery.charAt(2))
						|| (guessLottery.charAt(1) != getLottery.charAt(2) 
						&& guessLottery.charAt(2) != getLottery.charAt(1)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(1) 
						&& ((guessLottery.charAt(1) != getLottery.charAt(0) 
						&& guessLottery.charAt(2) != getLottery.charAt(2))
						|| (guessLottery.charAt(1) != getLottery.charAt(2) 
						&& guessLottery.charAt(2) != getLottery.charAt(0)))) 
				|| (guessLottery.charAt(0) == getLottery.charAt(2) 
						&& ((guessLottery.charAt(1) != getLottery.charAt(0) 
						&& guessLottery.charAt(2) != getLottery.charAt(1))
						|| (guessLottery.charAt(1) != getLottery.charAt(1) 
						&& guessLottery.charAt(2) != getLottery.charAt(0))))) {
			System.out.println("Match one digits: your win $1,000");
		}
		else {
			System.out.println("Sorry, no match");
		}
	}

}
