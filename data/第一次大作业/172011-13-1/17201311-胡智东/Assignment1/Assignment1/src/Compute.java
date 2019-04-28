
public class Compute {
	String post; // 中缀表达式转换得到的后缀表达式
	Stack stack = new Stack();// 用于得到计算结果的栈
	// 构造方法

	public Compute(String post) {
		this.post = post;
	}

	// 将后缀表达式进行四则运算的操作
	public void operate() {
		String[] strArr = post.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.push((temp));
			} else {
				double result = compute(temp);
				stack.push(String.valueOf(result));
			}
		}
	}

	// 加减乘除的实现
	public Double compute(String str) {
		double result = 0;
		Double m = Double.valueOf(stack.pop());
		Double n = Double.valueOf(stack.pop());
		switch (str) {
		case "+":
			result = n + m;
			break;
		case "-":
			result = n - m;
			break;
		case "*":
			result = n * m;
			break;
		case "/":
			result = n / m;
			break;
		default:
			break;
		}
		return result;
	}

	// 判断是否为数字
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

	// 结果的调取
	public double getResult() {
		double res = Double.valueOf(stack.pop());
		return res;
	}

}
