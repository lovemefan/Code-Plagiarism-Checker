package bigwork;

import java.util.Scanner;

public class Main {

	// ����������ͷ���ʵ�ּ��׼�����
	public static void main(String[] args) throws Exception {
		String[] exp = IO.scan();// ���ļ����ַ������鴫��exp
		String[] exp1 = atFirst(exp);// ��ԭʼ���󱣴浽���ַ�������
		int s = IO.shu(exp);// �����������Ч��
		trans(exp, s);// ���ַ���תΪ�޿ո��ж�
		String[] result = new String[s];
		for (int i = 0; i < s; i++) {
			String a = Transform.transformExp(exp[i]);// ���ļ�������ı��ʽת��Ϊ�̶���ʽ
			String b = Transform.transformExpLast(a);// ���̶���ʽת��Ϊ��׺���ʽ
			double c = airth(b, exp, i);
			if (RegularExpression.errorPan(b))// ����д���ֱ�����
				result[i] = b;
			else if (RegularExpression.errorPan(exp[i]))// ������ֳ���Ϊ0���
				result[i] = exp[i];
			else
				result[i] = Transform.transformNoBlank(exp1[i]) + "=" + c;
		}
		IO.prin(result, s);// ��������뵽�ļ�
	}

	// ��ԭʼ���󱣴浽���ַ�������
	public static String[] atFirst(String[] exp) {
		String[] exp1 = new String[1000];
		for (int i = 0; i < 1000; i++)
			exp1[i] = exp[i];
		return exp1;
	}

	// ���ַ���תΪ�޿ո��ж�
	public static void trans(String[] exp, int s) {
		for (int i = 0; i < s; i++) {
			if (!RegularExpression.errorPan(exp[i]))// ����û��ת��������
				exp[i] = Transform.transformNoBlank(exp[i]);//���ַ����Ŀո�ȥ��
		}
		RegularExpression.RegularExp(exp, s);
	}

	// ��ת����ɵĺ�׺���ʽ���м���
	public static double airth(String exp, String[] exp1, int i) {
		Stack stack1 = new Stack(new Node(), new Node());// ջ��ʼ��
		Scanner input = new Scanner(exp);
		double result = 0;
		if (!RegularExpression.errorPan(exp1[i]))// ����û����������
			result = airthmetic(input, stack1, exp1, i);
		input.close();
		return result;
	}

	// ��׺���ʽ�ļ��㷽��
	public static double airthmetic(Scanner input, Stack stack1, String[] exp1, int i) {
		double a = 0;
		double b = 0;
		double result = 0;
		while (input.hasNext()) {
			String ch = input.next();// �ж��Ƿ�Ϊ����
			boolean pan = ch.matches("\\d*");
			if (pan) {// Ϊ���ֽ����ִ���ջ
				int intvalue = Integer.parseInt(ch);
				stack1.printStack(intvalue);
			} else {// Ϊ���Ŵ�ջȡ��2�����ּ���
				switch (ch) {
				case "+":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b + a;
					stack1.printStack(result);
					break;
				case "-":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b - a;
					stack1.printStack(result);
					break;
				case "*":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					result = b * a;
					stack1.printStack(result);
					break;
				case "/":
					a = stack1.outDoubleStack();
					b = stack1.outDoubleStack();
					if (a == 0) {// ����Ϊ0�������
						exp1[i] = RegularExpression.errorPrint(exp1[i], "#���ʽ�ڳ���Ϊ0");
						break;
					} else {// ��Ϊ0��ֱ�Ӽ���
						result = b / a;
						stack1.printStack(result);
					}
					break;
				}
			}
		}
		return result;
	}
}
