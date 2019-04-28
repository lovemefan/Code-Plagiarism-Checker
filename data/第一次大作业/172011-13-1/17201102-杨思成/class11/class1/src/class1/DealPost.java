package class1;

import java.util.Deque;

import java.util.LinkedList;

public class DealPost {
	private String post = null;
	private Deque<Double> stack = new LinkedList<Double>();

	public DealPost(String post) {
		this.post = post;
	}

	
	public boolean isDigital(String str) {// �����Ƿ�Ϊ���֣���ע��infix����д����ֻ���жϵ����ַ��ǲ��������ַ����޷��ж϶�λ�ַ������
		char[] my = str.toCharArray();
		int len = my.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (my[i] >= '0' && my[i] <= '9') {
				count++;
			}
		}
		if (count == len)
			return true;
		else
			return false;
	}

	
	public double Operate(String str) {// ����ľ������
		                               // ʵ���˲������ַ������ж��������ֽ���
		double last = stack.pop();
		double first = stack.pop();
		double ans = 0;

		switch (str) {
		case "+":

			ans = first + last;
			break;

		case "-":

			ans = first - last;
			break;
		case "*":

			ans = first * last;
			break;
		case "/":

			ans = first / last;
			break;
		}
		return ans;
	}

	
	public void Calculate(String str) {// ���ú�׺ʽ���м���

		double ans = 0;

		String[] arr = str.split(" ");// �ÿո�����ÿ�����ֺ��ַ�

		for (int i = 0; i < arr.length; i++) {
			if (isDigital(arr[i])) {
				// stack.push((arr[i]));
				stack.push(Double.valueOf(arr[i]));
			} else {
				ans = Operate(arr[i]);
				stack.push(ans);
			}
		}
	}


	public double getResult() {	// �õ�������
		Calculate(post);
		return stack.pop();
	}

}
