package bigAssignments.calculator;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Calculator {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// �������󣨱��ʽ��
		Scanner input = new Scanner(System.in);	
		String Exp = " ";
		String  ch  = " ";
		File fileIn = new File("E:\\Eclipse\\src\\bigAssignments\\calculator\\Input");
		System.out.println("���������Իس�����Ϊ�ָ�ĸ������󣬲���'#'��Ϊ��������Ľ�����־");
		System.out.print("�����룺");
		Expression exp;
		exp = new Expression(fileIn); // ��ճ�ʼ���ĵ�
		while(Exp.charAt(0) != '#' || ch.compareTo("Y") != 0) {
			Exp = input.nextLine();
			exp = new Expression(Exp);
			if(Exp.charAt(0) != '#')
				exp.SaveExp(fileIn);
			else if(Exp.charAt(0) == '#') {
				System.out.print("���Ƿ�ȷ�Ͻ������룬��ȷ��������' Y ',������������ַ���");
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
