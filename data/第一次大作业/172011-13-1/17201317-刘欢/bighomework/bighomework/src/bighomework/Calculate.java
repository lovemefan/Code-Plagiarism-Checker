package bighomework;

//Calculate���޲ι��췽��
public class Calculate {
	public Calculate() {

	}

	// ��ȡ�ַ�������һλ�����в���
	public String realCal(Stack stack, char s1) {
		String s2 = "";
		String s6 = "";
		if (s1 >= '0' && s1 <= '9') {
			s2 = s2 + s1;
			stack.pushStack(stack, s2);// ��������ջ
		} else if (s1 == ' ') {
			s2 = "";
		} else if (s1 == '+' || s1 == '*' || s1 == '-') {
			String s3 = stack.popStack(stack);// ��ȡջ��Ԫ��
			String s4 = stack.popStack(stack);// ��ȡջ��Ԫ��
			String s5 = startCal(s3, s4, s1);// ��������
			stack.pushStack(stack, s5);// �������������ջ
			s6 = s5;
		}
		return s6;
	}

	// �����ַ����ľ������
	public String Cal(String s) {
		Stack stack = new Stack();
		stack.StackBottom = stack.stackTop;
		int x = s.length();
		String s6 = "";
		// ��λ���ַ������в���
		for (int i = 0; i < x - 1; i++) {
			String s2 = "";
			char ch = s.charAt(i);
			char ch1 = s.charAt(i + 1);
			if (ch >= '0' && ch <= '9' && ch1 >= '0' && ch1 <= '9') {
				s2 = s2 + ch + ch1;
				stack.pushStack(stack, s2);// ����λ����ջ
				i++;
			} else if (ch == '/') {
				String s3 = stack.popStack(stack);// ��ȡջ��Ԫ��
				String s4 = stack.popStack(stack); // ��ȡջ��Ԫ��
				double m = Double.parseDouble(s3);// ���ַ�������ת��Ϊ����
				if (m == 0.0) {
					s6 = "s4";
					break;
				} else if (m != 0) {
					String s9 = startCal(s3, s4, ch);// ��������
					stack.pushStack(stack, s9);// �������������ջ
					s6 = s9;
				}
			} else {
				s6 = realCal(stack, ch);
			}

		}
		// System.out.println(s6);
		return s6;
	}

	// ���ַ�������������
	public String startCal(String s1, String s2, char s) {
		double s0 = 0;
		String s3 = "";
		if (s == '+') {
			s0 = Double.parseDouble(s2) + Double.parseDouble(s1);
		} else if (s == '-') {
			s0 = Double.parseDouble(s2) - Double.parseDouble(s1);
		} else if (s == '*') {
			s0 = Double.parseDouble(s2) * Double.parseDouble(s1);
		} else if (s == '/') {
			s0 = Double.parseDouble(s2) / Double.parseDouble(s1);
		}
		s3 = s3 + s0;
		return s3;
	}
}
