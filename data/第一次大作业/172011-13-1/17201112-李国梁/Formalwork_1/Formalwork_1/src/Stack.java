
public class Stack {// ����ʵ��ջ
	private String[] str;// ����һ��ջ
	private int up;// ջ��

	public Stack(int num) {// �в�������ջ
		str = new String[num];
		up = 0;
	}

	public Stack() {// �޲�

	}

	public void in(String c) {// ��ջ
		str[up] = c;
		up++;
	}

	public String out() {// ��ջ
		up--;
		return str[up];
	}

	public boolean empty() {// ջ�Ƿ��
		return up == 0;
	}
}