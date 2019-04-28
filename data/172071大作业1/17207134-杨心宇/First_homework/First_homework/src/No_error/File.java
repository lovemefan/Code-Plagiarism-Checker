package No_error;

import java.io.*;
import java.util.*;

class FileOperation {

	void WriteTheResult(Expression exp) throws java.io.IOException {
		FileWriter fw = null;
		try {
			File file = new File("src\\No_error\\output");
			fw = new FileWriter(file, true);
		} catch (IOException exception) {
			System.out.println(exception.getMessage());

		}

		PrintWriter pw = new PrintWriter(fw);

		switch (exp.TypeOfError) {
		case 0:
			pw.println(exp.expression);
			break;
		case 1:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#表达式为空");
			break;
		case 2:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#表达式中有空括号");
			break;
		case 3:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#表达式包含非法字符");
			break;
		case 4:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#括号不匹配");
			break;
		case 5:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#运算符连续");
			break;
		case 6:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#运算符前无运算数");
			break;
		case 7:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#运算符后无运算数");
			break;
		case 8:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#括号非第一个字符且之前无运算数");
			break;
		case 9:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#小括号后无运算数，括号非最后一个字符");
			break;
		case 10:
			pw.print(exp.expression.substring(0,2));
			pw.println("ERROR");
			pw.println("  #零不能作为除数");
		case 11 :
			break;
		

		}
		
		try {
			pw.flush();
			pw.close();
			fw.close();

		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}

	}
	void ReadExpression(Expression[] expression) throws java.io.IOException {
		try {
			int i = 0;
			File file = new File("src\\No_error\\expression");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				expression[i].expression = input.nextLine();
				i++;
			}

		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}

	}
	
	
	
	int  GetLine()throws java.io.IOException {
		int i = 0;
		try {
			File file = new File("src\\No_error\\expression");
			Scanner input = new Scanner(file);
			System.out.println("要计算的表达式为:");
			 while( input.hasNext()) {
				 System.out.println(input.nextLine());
				 i++;
			 }
		}
		catch(IOException exception) {
			System.out.println(exception.getMessage());
		}
			
			return i;
	}
			

}
