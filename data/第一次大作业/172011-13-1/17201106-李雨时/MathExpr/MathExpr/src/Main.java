import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		/*System.out.print("Please input the filename which contains the expression: ");
		String filename = input.nextLine();*/
		input.close();
		Reader reader = new Reader("C:\\Users\\13699\\Desktop\\test.txt");
		//Writer writer = new Writer("C:\\Users\\d310\\Desktop\\result.txt");
		Writer writer = new Writer("C:\\Users\\13699\\Desktop\\result.txt");
		while (reader.hasNextLine()) {
			String expr = reader.nextLine();
			if (expr.equals("")) {
				writer.writeLine("#ERROR\r\nempty line"+"\r\n");
			} else {
				int res = MathExpr.parseExpr(expr);
				if (MathExpr.isValid) {
					writer.writeLine(expr+"="+res+"\r\n");
				} else {
					writer.writeLine("#ERROR\r\n"+expr+"\r\n");
				}
			}
		}
		input.close();
		reader.close();
		writer.close();
	}
}
