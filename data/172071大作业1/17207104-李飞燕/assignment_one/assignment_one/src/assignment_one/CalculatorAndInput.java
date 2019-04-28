package assignment_one;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CalculatorAndInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("src\\assignment_one\\calculatexpression");
		File p = new File("src\\assignment_one\\calculatresult");
		PrintWriter output = new PrintWriter(p);
		output.close();
		operation(f,p);
	}
	
	public static void operation( File f, File p) throws IOException {
		Scanner inputflie = new Scanner(f);	
		String[] expression =new String[30];
		String postfixExpression = "";
		int i = 0;
		while(inputflie.hasNext()){
			expression[i]= inputflie.nextLine();
			if(sameExpression(expression, i)){
				i++;
				continue;
			}
			String tempexpression = expression[i];
			if(TestExpression.testExpression(tempexpression,p)){
				FileWriter outputfile = new FileWriter(p,true);
				postfixExpression = TransferExpression.transfer( expression[i] , postfixExpression);
				int result = CalculatPostExpression.calculatPostExpression(postfixExpression);
				outputfile.write(expression[i++] + "="+result+"\n\n");
				outputfile.close();
			}
		}
		inputflie.close();
	}

	public static boolean sameExpression(String[] expression,int number){
		String present = expression[number];
		for(int i = number - 1; i>=0; i--){
			String string = expression[i]; 
			if(present.equals(string))
				return true;
		}
		return false;
	}
}