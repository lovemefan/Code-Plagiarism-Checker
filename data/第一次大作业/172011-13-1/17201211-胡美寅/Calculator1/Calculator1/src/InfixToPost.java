//��׺���ʽת��Ϊ��׺���ʽ
public class InfixToPost {
	private Stack stack; // ��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
	private String infix; // �������׺���ʽ
	private String post = ""; // �洢�õ��ĺ�׺���ʽ

	// ���췽��
	public InfixToPost(Stack stack, String infix) {
		this.stack = stack;
		this.infix = infix;
	}

	// ���ش���������׺���ʽ����Ҫ�����������׺���ʽ�ӿո� ���磺�������׺���ʽΪ��9+(3-1)*3+10/2
	// �������׺���ʽΪ��9 + ( 3 - 1 ) * 3 + 10 / 2
	private String processInfix(String infix) {
		String result = "";
		for (int i = 0; i < infix.length() - 1; i++) {
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
			if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += infix.charAt(infix.length() - 1); // �����һ��Ԫ����ӽ�ȥ
		return result;
	}

	// ��ǰ׺���ʽת��Ϊ��׺���ʽ�Ĵ������
	public void process() {
		// �Կո���뿪���ʽ
		String[] strArr = processInfix(infix).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				getOperation(str, 1);
				break;
			case "*":
			case "/":
				getOperation(str, 2);
				break;
			case "(":
				stack.pushStack(stack, str);
				break;
			case ")":
				getParent();
				break;
			default:
				post += " " + str;
				break;
			}
		}
		// ����ȫ���������Ҫ���ջ��ʣ��ķ���
		while (!stack.isEmpty(stack)) {
			post += " " + stack.popStack(stack);
		}
	}

	// (3)����������ʱ������ѹ��post��
	// (4) ���������ʱ���Ƚ�����ջ������������ȼ���
	// (4-1) ���stackΪ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
	// (4-2)���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��Stack��ע��ת��Ϊǰ׺���ʽʱ�����ȼ��ϸ߻���ͬ���������򲻰�����ͬ���������
	// (4-3)���򣬽�Stackջ���������������ѹ�뵽post�У��ٴ�ת��(4-1)��Stack���µ�ջ���������Ƚ�
	// (5) ��������ʱ��
	// (5-1) ����������š�(������ֱ��ѹ��stack��
	// (5-2) ����������š�)���������ε���Stackջ�������������ѹ��post��ֱ������������Ϊֹ����ʱ����һ�����Ŷ�����
	// 6) �ظ�����(2)��(5)��ֱ�����ʽ�����ұߣ�
	// (7) ��S1��ʣ�����������ε�����ѹ��S2
	private void getParent() {
		while (!stack.isEmpty(stack)) {
			String top = stack.popStack(stack);
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}

	private void getOperation(String str, int priority) {
		while (!stack.isEmpty(stack)) {
			String top = stack.popStack(stack);
			if (top.equals("(")) {
				stack.pushStack(stack, top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {
					stack.pushStack(stack, top);
					break;
				} else {
					post += " " + top;
				}
			}
		}
		stack.pushStack(stack, str);
	}

	private int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	public String getPost() {
		return post.trim();
	}
}
