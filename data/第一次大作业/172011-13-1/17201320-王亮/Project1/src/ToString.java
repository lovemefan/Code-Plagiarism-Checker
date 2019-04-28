//����׺���ʽת��Ϊ��׺���ʽ��
public class ToString {
	private SeqStack<String> stack; // ��׺���ʽת��Ϊ��׺���ʽ����Ҫ��ջ
	private String expstr; // �������׺���ʽ
	private String postfix = ""; // ��׺���ʽ

	public ToString(SeqStack<String> stack, String expstr) {// ���캯��
		this.stack = stack;
		this.expstr = expstr;
	}

	private String processExpstr(String expstr) {// ����׺���ʽ�м���ո�������
		String result = "";
		for (int i = 0; i < expstr.length() - 1; i++) {
			char temp1 = expstr.charAt(i);
			char temp2 = expstr.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {// ��������ַ���Ϊ����
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += expstr.charAt(expstr.length() - 1); // �����һ��Ԫ����ӽ�ȥ
		return result;
	}

	private boolean isDigital(char ch) {// �ж��Ƿ�Ϊ����
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

	public String process() {// ǰ׺���ʽת��Ϊ��׺���ʽ
		String[] strArr = processExpstr(expstr).split(" ");// �Կո񻮷�
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
				stack.push(str);
				break;
			case ")":
				getParent();
				break;
			default:
				postfix += str + " ";// ���������������ַ����� ����֮���Կո񻮷�
				break;
			}
		}
		while (!stack.isEmpty()) {// ���ջ��ʣ��ķ���
			postfix += stack.pop();
		}

		return postfix;
	}

	private void getParent() {// ���ַ���Ϊ������ʱ��ջ��Ԫ�س�ջ֪������������
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {// ������Ϊ��
				break;
			} else {
				postfix += top;
			}
		}
	}

	private void getOperation(String str, int priority) {// ��ջ����Ԫ�����ȼ�����ʽ�еĽ��бȽ�
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {// ���ջ��Ϊ���������������ջ
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {// ���ջ��Ԫ�����ȼ������������ջ
					stack.push(top);
					break;
				} else {// �����Ƚ�ջ��Ԫ�س�ջ�����ַ������ٽ��������ջ
					postfix += top;
				}
			}
		}
		stack.push(str);
	}

	private int getPriority(String str) {// ������������ȼ�ת��Ϊ�������Ƚ�
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {// +-���ȼ�Ϊ1
			pri = 1;
		} else {// ����*/���ȼ�Ϊ2
			pri = 2;
		}
		return pri;
	}

}