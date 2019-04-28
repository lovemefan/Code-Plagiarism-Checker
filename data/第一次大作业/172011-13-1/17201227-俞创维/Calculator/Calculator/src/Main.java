import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个含+-*/()的表达式");
		String expression = input.nextLine();
		System.out.println(expression + " =" +Work. evalExp(expression));
		input.close();
	}
}
 
