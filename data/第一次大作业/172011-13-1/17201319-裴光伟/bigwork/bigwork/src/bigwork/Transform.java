package bigwork;

import java.util.Scanner;

public class Transform {
	// �����ļ��л�õı��ʽת���ɹ̶���ʽ
		public static String transformExp(String exp) {
			String exp2 = "";
			if(!RegularExpression.errorPan(exp)){
				for (int i = 0; i < exp.length() - 1; i++) {// ���ַ����еı��ʽת��Ϊ�̶���ʽ
					char p = exp.charAt(i);
					char q = exp.charAt(i + 1);
					if (Character.isDigit(q) && Character.isDigit(p))// ���Ϊ����������Ҫ�ո�
						exp2 = exp2 + p;
					else
						exp2 = exp2 + p + " ";
				}
				exp2 = exp2 + exp.charAt(exp.length() - 1);// �������ַ����뵽�µ��ַ���
			}
			else
				exp2 = exp;
			return exp2;
		}
		
		//���ַ����Ŀո�ȥ��
		public static String transformNoBlank(String exp){
			String exp1 = "";
			Scanner input = new Scanner(exp);
			while (input.hasNext()) {// ���ļ��еı��ʽ�����ַ���
				exp1 += input.next();
			}
			input.close();
			return exp1;
		}

		// ����׺���ʽת���ɺ�׺���ʽ
		public static String transformExpLast(String exp) {
			Stack stack = new Stack(new Node(), new Node());// �����ڵ�Ϊ�յ�ջ
			Scanner input = new Scanner(exp);
			Queue q = new Queue(100);
			String exp1 = null;
			if(!RegularExpression.errorPan(exp)){
				while (input.hasNext()) {
					inStack(input, q, stack);
				}
				input.close();
				while (stack.getStackBottom() != stack.getStackTop()) {// ��ջ��ʣ�����������뵽����
					Queue.inLine(q, stack.outTopStack() + " ");
				}
				exp1 = Queue.queueToStr(q);// ������������ַ�����
			}
			else
				exp1 = exp;
			
			return exp1;
		}
		
		//��ջ����
		public static void inStack(Scanner input, Queue q,Stack stack){
			String ch = input.next();// �ж��Ƿ�Ϊ����
			boolean pan = ch.matches("\\d*");
			if (pan)// ���Ϊ���������������
				Queue.inLine(q, ch + " ");
			else {
				switch (ch) {
				case "+":
					pan(stack, 2, '+', q);
					break;
				case "-":
					pan(stack, 2, '-', q);
					break;
				case "*":
					pan(stack, 3, '*', q);
					break;
				case "/":
					pan(stack, 3, '/', q);
					break;
				case "(":
					pan(stack, 1, '(', q);
					break;
				case ")":
					pan(stack, 4, ')', q);
					break;
				}
			}
		}
		
		// ������Ĵ���ջ�Ĺ���
		public static void pan(Stack stack, int topdata, char ch, Queue q) {
			if (topdata == 4) {// Ϊ�����Ž�������֮ǰ��������������
				while (stack.getStackTop().gettopData() != 1 && stack.getStackBottom() != stack.getStackTop())
					Queue.inLine(q, stack.outTopStack() + " ");
				stack.outTopStack();// �������Ŷ���
			} else if (topdata == 1)
				stack.printStack(ch, topdata);// Ϊ������ֱ����ջ
			
			
			else if (topdata > stack.getStackTop().gettopData()) {
				stack.printStack(ch, topdata);// ������������ȼ�����ջ��ֱ������
			} else {
				Queue.inLine(q, stack.outTopStack() + " ");// ���ȼ�����ջ��������������
				if (topdata <= stack.getStackTop().gettopData())// ���µ�ջ���ж����ȼ�
					Queue.inLine(q, stack.outTopStack() + " ");
				stack.printStack(ch, topdata);
			}

		}
}
