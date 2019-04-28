package bigAssignments.calculator;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Calculator {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 键入请求（表达式）
		Scanner input = new Scanner(System.in);	
		String Exp = " ";
		String  ch  = " ";
		File fileIn = new File("E:\\Eclipse\\src\\bigAssignments\\calculator\\Input");
		System.out.println("您可输入以回车符作为分割的各个请求，并以'#'作为请求输入的结束标志");
		System.out.print("请输入：");
		Expression exp;
		exp = new Expression(fileIn); // 清空初始化文档
		while(Exp.charAt(0) != '#' || ch.compareTo("Y") != 0) {
			Exp = input.nextLine();
			exp = new Expression(Exp);
			if(Exp.charAt(0) != '#')
				exp.SaveExp(fileIn);
			else if(Exp.charAt(0) == '#') {
				System.out.print("您是否确认结束输入，若确认请输入' Y ',否则键入任意字符：");
				ch = input.nextLine();
				if(ch.equals('Y'))
					break;
			}
			else
				continue;
			
		}
		input.close();
		JudgeLegal judge = new JudgeLegal();
		judge.Judge(fileIn);
	}
}
