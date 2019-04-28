import java.util.Scanner;
public class Test3_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a three-integer");
		int a = input.nextInt();
		int bit = a % 10;
		int ten = a / 10 % 10;
		int hun = a / 100;
		int num = (int)(Math.random()*900+100);
		System.out.println("The lottery number is"+num);
		if(bit==num%10&&ten==num/10%10&&hun==num/100)
		System.out.println("Gongratulations on winning the frist prize.The prize is $10000");
		 if(bit==num%10||bit==num/10%10||bit==num/100){
			if(ten==num%10||ten==num/10%10||ten==num/100)
				if(hun==num%10||hun==num/10%10||hun==num/100)
					System.out.println("Gongratulations on winning the second prize.The prize is $3000");
		 }
		if(bit==num%10||ten==num/10%10||hun==num/100)
			System.out.println("Gongratulations on winning the third prize.The prize is $1000");
		else 
			System.out.println("sorry,you didn't win");
}
}