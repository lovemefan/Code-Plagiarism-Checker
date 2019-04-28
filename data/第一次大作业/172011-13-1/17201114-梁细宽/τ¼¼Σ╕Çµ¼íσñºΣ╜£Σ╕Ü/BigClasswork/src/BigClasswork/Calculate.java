package BigClasswork;

public class Calculate {
	private String post; // ��׺���ʽת���õ��ĺ�׺���ʽ
	private Stack stack; // ���ڵõ���������ջ

	// ���췽��
	public Calculate(String post, Stack stack) {
		this.post = post;
		this.stack = stack;
	}

	// ����ķ�����
	public String getResult() {
		return stack.PopStack();
	}

	// �ɺ�׺���ʽ�õ�������������ʵ�ֹ���
	public void operate() {
		String[] strArr = post.split(" ");// �Կո�Ϊ�۵㽫�ַ�����Ϊ�ַ�������
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.PushStack(String.valueOf(temp));// ���ַ���ת��Ϊ����
			} else {
				int result = compute(temp);
				stack.PushStack(String.valueOf(result));
			}
		}
	}

	// �������
	public int compute(String str) {
		int re = 0;
		int m = Integer.parseInt(stack.PopStack());
		int n = Integer.parseInt(stack.PopStack());
		switch (str) {// �ж��������������
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
			re = n / m;
			break;
		default:
			break;
		}
		return re;
	}

	// ��֤�ַ������Ƿ�ȫΪ����
	public boolean isDigital(String str) {
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (chArr[i] >= '0' && chArr[i] <= '9')
				count++;
		}
		return count == len;
	}

}
