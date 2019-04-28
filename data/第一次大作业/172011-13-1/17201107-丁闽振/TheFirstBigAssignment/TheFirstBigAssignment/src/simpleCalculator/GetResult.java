package simpleCalculator;

public class GetResult {
	private String temp; // 中缀表达式转换得到的后缀表达式
	private StackInt stack; // 用于得到计算结果的栈

	public GetResult() {

	}
	//构造函数
	public GetResult(String post, StackInt stack) {
		this.temp = post;
		this.stack = stack;
	}

	public void operation() {
		String[] str = temp.split(" ");
		for (int i = 0; i < str.length; i++) {
			String temp1 = str[i];
			if (isDigital(temp1)) {
				stack.push(Integer.valueOf(temp1));
			} else {
				int result = compute(temp1);
				stack.push(result);
			}
		}
	}
	//计算表达式的结果
	private int compute(String str) {
		int result = 0;
		int p = stack.pop();
		int q = stack.pop();
		switch (str) {
		case "+":
			result = q + p;
			break;
		case "-":
			result = q - p;
			break;
		case "*":
			result = q * p;
			break;
		case "/":
			result = q / p;
			break;
		default:
			break;
		}
		return result;
	}
	//判断是不是数字
	private boolean isDigital(String str) {
		char[] ch = str.toCharArray();
		int sum = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9')
				sum++;
		}
		return sum == ch.length;
	}

	public int getResult() {
		return stack.pop();
	}

}
