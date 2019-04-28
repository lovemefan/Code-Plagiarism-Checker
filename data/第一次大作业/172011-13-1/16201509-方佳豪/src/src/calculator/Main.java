package calculator;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	private static Calculator calculator;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		try {
			//scanner=new Scanner(System.in);
			Scanner scanner=new Scanner(new FileInputStream("D:/test.txt"));
			calculator = new Calculator();
			calculator.setPrintWriter("D:\\result.txt");
			while (scanner.hasNext()) {
				calculator.input(scanner.nextLine().trim());
				calculator.cal();
			}
			calculator.closePrintWriter();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
