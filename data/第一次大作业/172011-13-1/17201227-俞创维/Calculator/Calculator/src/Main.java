import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("������һ����+-*/()�ı��ʽ");
		String expression = input.nextLine();
		System.out.println(expression + " =" +Work. evalExp(expression));
		input.close();
	}
}
 
