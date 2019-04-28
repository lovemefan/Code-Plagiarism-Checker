package BigClasswork;

public class Calculate {
	private String post; // 中缀表达式转换得到的后缀表达式
	private Stack stack; // 用于得到计算结果的栈

	// 构造方法
	public Calculate(String post, Stack stack) {
		this.post = post;
		this.stack = stack;
	}

	// 结果的访问器
	public String getResult() {
		return stack.PopStack();
	}

	// 由后缀表达式得到四则运算结果的实现过程
	public void operate() {
		String[] strArr = post.split(" ");// 以空格为折点将字符串分为字符串数组
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.PushStack(String.valueOf(temp));// 将字符串转换为数字
			} else {
				int result = compute(temp);
				stack.PushStack(String.valueOf(result));
			}
		}
	}

	// 计算过程
	public int compute(String str) {
		int re = 0;
		int m = Integer.parseInt(stack.PopStack());
		int n = Integer.parseInt(stack.PopStack());
		switch (str) {// 判断运算符并计算结果
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

	// 验证字符串中是否全为数字
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
