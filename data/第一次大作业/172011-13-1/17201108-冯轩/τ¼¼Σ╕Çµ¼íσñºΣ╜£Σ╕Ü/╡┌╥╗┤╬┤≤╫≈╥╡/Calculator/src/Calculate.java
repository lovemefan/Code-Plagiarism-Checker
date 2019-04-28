
public class Calculate {
	private String post; // ��׺���ʽת���õ��ĺ�׺���ʽ
	private StackInt stack; // ���ڵõ���������ջ

	//���췽��
	public Calculate(String post, StackInt stack) {
		this.post = post;
		this.stack = stack;
	}

	// �ɺ�׺���ʽ�õ�������������ʵ�ֹ���
	public void operate() {
		String[] strArr = post.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.push(Integer.valueOf(temp));
			} else {
				int result = calculate(temp);
				stack.push(result);
			}
		}
	}

	// ����ջ������������
	private int calculate(String str) {
		int re = 0;
		int m = stack.pop();
		int n = stack.pop();
		switch (str) {
		case "+":
			re = n + m;
			break;
		case "-":
			re = n - m;
			break;
		case "*":
			re = n * m;
			break;
		case "/":
			if (m == 0) {
				throw new ArithmeticException("ERROR\n#0������Ϊ����!");
			}
			re = n / m;
			break;
		default:
			break;
		}
		return re;
	}

	//�ж��Ƿ�Ϊ����
	private boolean isDigital(String str) {
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (chArr[i] >= '0' && chArr[i] <= '9')
				count++;
		}
		return count == len;
	}

	//��ȡ���
	public int getResult() {
		return stack.pop();
	}
}
