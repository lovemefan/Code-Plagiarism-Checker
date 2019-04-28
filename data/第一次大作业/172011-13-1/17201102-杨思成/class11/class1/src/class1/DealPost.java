package class1;

import java.util.Deque;

import java.util.LinkedList;

public class DealPost {
	private String post = null;
	private Deque<Double> stack = new LinkedList<Double>();

	public DealPost(String post) {
		this.post = post;
	}

	
	public boolean isDigital(String str) {// 检验是否为数字，但注意infix类里写的是只能判断单个字符是不是数字字符，无法判断多位字符的情况
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

	
	public double Operate(String str) {// 计算的具体操作
		                               // 实际运不是用字符串进行而是用数字进行
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

	
	public void Calculate(String str) {// 利用后缀式进行计算

		double ans = 0;

		String[] arr = str.split(" ");// 用空格区分每个数字和字符

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


	public double getResult() {	// 得到计算结果
		Calculate(post);
		return stack.pop();
	}

}
