// ��׺ת��׺
class Init {
	String[] stack = new String[1005];
	String post = "";// ����ı��ʽ��ȥ�������еĿո�
	String now = "";// ����ո�֮��ı��ʽ
	String result = "";// �õ��ĺ�׺���ʽ
	int len = 0;// ջ�ĳ���
	int num = 0;// ջ�������ŵ���Ŀ
	int flag = 0; // ���ʽ�����Ƿ����

	Init(String s) {
		this.post = s;
		len = 0;
		this.flag = 0;
	}

	// ����ı��ʽ���ź�����֮�����ո�
	private void handlePost(String post) {
		Integer i = 0;
		for (i = 0; i < post.length() - 1; i++) {

			char temp1 = post.charAt(i);// ��ǰλ��
			char temp2 = post.charAt(i + 1);// ��һλ
			// �жϵ�ǰλ����һλ�Ƿ�������
			if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
				now += temp1;
			}
			// �жϸ���
			else if (i == 0 && temp1 == '-') {
				now += temp1;

			} else if (temp1 == '(' && temp2 == '-') {
				now += temp1 + " " + temp2;
				i++;
			} else
				now += temp1 + " ";
		}
		// System.out.println(now);
		if (post.length() - 1 == i)
			now += post.charAt(post.length() - 1); // �����һ��Ԫ����ӽ�ȥ
	}

	public boolean getTrue() {
		if (this.flag == 1)
			return true;
		else
			return false;
	}

	// ��׺ת��׺
	public String handleNow() {
		handlePost(this.post); // �õ�����ո��ı��ʽnow
		// System.out.println(now);
		String[] nowArr = now.split(" "); // �Կո���Ϊ�ָ������ַ�������
		for (int i = 0; i < nowArr.length; i++) {
			String str = nowArr[i];
			// �ж��ַ���������
			switch (str) {
			// +-*/��ջ���Ƚϲ�С����ջ��Ԫ�ص���ֱ��С��ջ��Ԫ��
			case "+":
			case "-":
				handleSymbol(str);
				break;
			case "*":
			case "/":
				handleSymbol(str);
				break;
			// ��ֱ����ջ
			case "(":
				stack[++len] = str;
				this.num++; // ջ����������Ŀ��һ
				break;
			// ���ջ��Ԫ��ֱ������һ����
			case ")":
				handleBrackets();
				break;
			default:
				result += " " + str;
				break;
			}
		}
		// ջ�ڵ�������δ��ȫ����
		if (this.num != 0)
			this.flag = 1;
		// ��ջ�еķ������
		while (len != 0) {
			result += " " + stack[len--];
			// ���صõ��ĺ�׺���ʽ
		}
		// System.out.println(result);
		return result;
	}

	// �ж�����������ȼ� +-Ϊ1�� */Ϊ2��
	private int check(String s) {
		if (s.equals("+") || s.equals("-"))
			return 1;
		else
			return 2;
	}

	// ��ջ���Ƚϲ�С����ջ��Ԫ�ص���ֱ��С��ջ��Ԫ��
	private void handleSymbol(String s) {
		int a = check(s); // ��Ҫ������������
		while (len != 0) {
			// ջ��Ԫ��
			String temp = stack[len--];
			// �������򽫣����¼���ջ���˳�ѭ��
			if (temp.equals("(")) {
				stack[++len] = temp;
				break;
			}
			// ��ջ��Ԫ�ص���ֱ��С��ջ��Ԫ��
			else {
				int b = check(temp);
				// �ȽϽ�Ҫ������������ջ��Ԫ�ص����ȼ�
				if (b < a) {
					stack[++len] = temp;// ���������¼���ջ��Ԫ�ز��˳�
					break;
				}
				// С����ջ��Ԫ�����
				else
					result += " " + temp;
			}
		}
		// ����Ҫ��������������
		stack[++len] = s;
	}

	// ����
	private void handleBrackets() {
		while (len != 0) {

			// �õ�ջ��Ԫ��
			String temp = stack[len--];
			// ���������˳�ѭ������ջ��Ԫ�����
			if (temp.equals("(")) {
				break;
			} else {
				result += " " + temp;
			}
		}
		this.num--;
		// ���ջ�ڵ������ż�������˵�����Ų�ƥ��
		if (this.num < 0)
			flag = 1;
	}
}
