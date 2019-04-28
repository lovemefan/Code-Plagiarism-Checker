
public class Suffix {
	Stack stack = new Stack();// ��������ת����׺��ջ
	String post = "";// ��׺���ʽ�ı���
	String expression;// ���ļ��ж�ȡ�ı��ʽ

	// Suffix���췽��
	public Suffix(String expression) {
		this.expression = expression;
	}

	// ��׺�Ĵ���:��ԭ�ո�ȫ��ɾȥ�������������֮��ͳһ����ո�
	public String Deal(String expression) {
		String dealExpression;
		String Deal1 = "";
		dealExpression = expression.replace(" ", "");
		for (int i = 0; i < dealExpression.length() - 1; i++) {
			if (dealExpression.charAt(i) <= '9' && dealExpression.charAt(i) >= '0') {
				if (dealExpression.charAt(i + 1) <= '9' && dealExpression.charAt(i + 1) >= '0') {
					Deal1 += dealExpression.charAt(i);
				}

				else
					Deal1 += dealExpression.charAt(i) + " ";
			} else
				Deal1 += dealExpression.charAt(i) + " ";

		}
		Deal1 += dealExpression.charAt(dealExpression.length() - 1);
		return Deal1;
	}

	// �ж�����������ȼ�
	public int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	// ����׺ת���ɺ�׺���ʽ
	public void process() {
		String[] strArr = Deal(expression).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				symbolEnter(str, 1);
				break;
			case "*":
			case "/":
				symbolEnter(str, 2);
				break;
			case "(":
				stack.push(str);
				break;
			case ")":
				rightOutput();
				break;
			default:
				post += str + " ";
				break;
			}
		}
		// ����ȫ���������Ҫ���ջ��ʣ�����еķ���
		while (!stack.isEmpty()) {
			post += stack.pop() + " ";
		}
	}

	// ����������ʹ��ջ�����нڵ㶼��ջ
	public void rightOutput() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += top + " ";
			}
		}
	}

	// ������ ����������ŵ���ջ����
	public void symbolEnter(String str, int priority) {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);// ��ȡ���ȼ����ж�
				if (priTop < priority) {
					stack.push(top);
					break;
				} else {
					post += top + " ";
				}
			}
		}
		stack.push(str);
	}
}
