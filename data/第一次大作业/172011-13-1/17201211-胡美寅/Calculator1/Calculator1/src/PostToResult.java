
public class PostToResult {
	private String post; // 中缀表达式转换得到的后缀表达式
	private Stack stack; // 用于得到计算结果的栈
	// 注意此处的栈为结果栈

	public PostToResult(String post, Stack stack) {
		this.post = post;
		this.stack = stack;
	}

	// 由后缀表达式得到四则运算结果的实现过程
	public void operate() {
		String[] strArr = post.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String temp = strArr[i];
			if (isDigital(temp)) {
				stack.pushStack(stack, temp);
			} else {
				int result = compute(temp);
				stack.pushStack(stack, String.valueOf(result));
			}
		}
	}

	private int compute(String str) {
		int re = 0;
		int m = Integer.parseInt(stack.popStack(stack));
		int n = Integer.parseInt(stack.popStack(stack));
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
			re = n / m;
			break;
		default:
			break;
		}
		return re;
	}

	private boolean isDigital(String str) {
		char[] chArr = str.toCharArray(); // 将字符串转换为字符数组
		int len = chArr.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (chArr[i] >= '0' && chArr[i] <= '9')
				count++;
		}
		return count == len;
	}

	public String getResult() {
		return (stack.popStack(stack));
	}
}
