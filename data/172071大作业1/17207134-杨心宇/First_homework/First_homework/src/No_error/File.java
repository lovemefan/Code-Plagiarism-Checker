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
			pw.println("  "+"#���ʽΪ��");
			break;
		case 2:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���ʽ���п�����");
			break;
		case 3:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���ʽ�����Ƿ��ַ�");
			break;
		case 4:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���Ų�ƥ��");
			break;
		case 5:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���������");
			break;
		case 6:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#�����ǰ��������");
			break;
		case 7:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���������������");
			break;
		case 8:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#���ŷǵ�һ���ַ���֮ǰ��������");
			break;
		case 9:
			pw.print(exp.expression);
			pw.println("ERROR");
			pw.println("  "+"#С���ź��������������ŷ����һ���ַ�");
			break;
		case 10:
			pw.print(exp.expression.substring(0,2));
			pw.println("ERROR");
			pw.println("  #�㲻����Ϊ����");
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
			System.out.println("Ҫ����ı��ʽΪ:");
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
