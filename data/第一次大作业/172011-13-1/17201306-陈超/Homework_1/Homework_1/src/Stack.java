
public class Stack {

	private int top; // ջ��
	private int bottom; // ջ��
	private double array[]; // ջ������--����
	private String RPN; // RPN��׺���ʽ

	// ��׺���ʽ������
	public String getRPN() {
		return this.RPN;
	}

	// ջ��Ԫ�ط�����
	public int getTop() {
		return this.top;
	}

	// ջ��Ԫ���޸���
	public void setTop(int top) {
		this.top = top;
	}

	// ջ��Ԫ�ط�����
	public int getBottom() {
		return this.bottom;
	}

	// ջ��Ԫ���޸���
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	// ջ�Ĺ��췽��
	public Stack() {
		// ��ʼ��,����һ����ջ,��ջ����ռ�
		this.array = new double[9999];
		this.top = this.bottom = 0;
		this.RPN = "";
	}
	// ��׺���ʽ
	public String RPN(String expression) {
		Stack stack = new Stack();
		for (int i = 0; i < expression.length(); i++) {
			// ������ֱ�ӽ�ջ
			if (expression.charAt(i) == '(') {
				push(stack, expression.charAt(i));
			}
			// ����ֱ�Ӹ�ֵ����׺���ʽ
			else if (isNumber(expression.charAt(i))) {
				RPN += expression.charAt(i);
			}
			// �Ӽ���ջǰ��ջ���������ջ
			else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				RPN = popSymbol(stack, RPN);
				push(stack, expression.charAt(i));
			}
			// �˳���ջǰ��ջ���˳���ջ
			else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				RPN = popMulDev(stack, RPN);
				RPN += ' ';
				push(stack, expression.charAt(i));
			}
			// ���������ŵ�ջ�����������������
			else if (expression.charAt(i) == ')') {
				RPN = popSymbol(stack, RPN);
				// ����������
				pop(stack);
			}
		}
		// ���ջ������ķ���
		RPN = popAll(stack, RPN);
		return RPN;
	}// ˵��:�����ÿո�ֿ��Ա�calculateResult����

	// �����˳�����
	public String popMulDev(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/') {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// ���������
	public String popSymbol(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.array[stack.top] != '(' && stack.top != 0) {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// ��������ʣ�·���
	public String popAll(Stack stack, String RPN) {
		RPN += ' ';
		while (stack.top != -1) {
			RPN += (char) stack.array[stack.top];
			pop(stack);
		}
		return RPN;
	}

	// �����׺���ʽ
	public double calculateResult(String RPN) {
		// result:����Ľ��
		double result = 0;
		// str1:��ס����
		String str1 = "";
		Stack stack = new Stack();
		// ������׺���ʽ���ҳ�����
		for (int i = 0; i < RPN.length(); i++) {
			if (isNumber(RPN.charAt(i))) {
				str1 += RPN.charAt(i);
			}
			// ���ֽ�ջ
			else if (RPN.charAt(i) == ' ' && str1 != "") {
				double number = Double.parseDouble(str1);
				str1 = "";
				push(stack, number);
			}
			// ����'+'���ӷ�,�����ջ
			else if (RPN.charAt(i) == '+') {
				result = pop(stack) + pop(stack);
				push(stack, result);
			}
			// ����'-'������,�����ջ
			else if (RPN.charAt(i) == '-') {
				double num1 = pop(stack);
				double num2 = pop(stack);
				result = num2 - num1;
				push(stack, result);
			}
			// ����'*'���˷�,�����ջ
			else if (RPN.charAt(i) == '*') {
				result = pop(stack) * pop(stack);
				push(stack, result);
			}
			// ����'/'������,�����ջ
			else if (RPN.charAt(i) == '/') {
				double num1 = pop(stack);
				double num2 = pop(stack);
				result = num2 / num1;
				push(stack, result);
			}
		}
		// ���ؼ�����
		return result;
	}

	// ��ջ ��׺ת��׺
	public void push(Stack stack, char ch) {
		if (stack.top == stack.array.length) {
			System.out.println("stack is full");
			System.exit(0);
		}
		stack.top++;
		stack.array[stack.top] = ch;
	}

	// ����һ����double�͵�ջ ��׺����
	public void push(Stack stack, double number) {
		if (stack.top == stack.array.length) {
			System.out.println("stack is full");
			System.exit(0);
		}
		stack.top++;
		stack.array[stack.top] = number;
	}

	// ��ջ
	public double pop(Stack stack) {
		// e:��סջ��Ԫ��
		double e;
		if (stack.top == -1) {
			System.out.println("stack is empty");
			System.exit(0);
		}
		e = stack.array[stack.top];
		stack.top--; // ջ����һ
		return e;
	}

	// ����ַ��Ƿ��������ַ�Χ
	public boolean isNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
}
