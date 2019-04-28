
public class Calculate {
	private String post; // 中缀表达式转换得到的后缀表达式
	private StackInt stack; // 用于得到计算结果的栈

	//构造方法
	public Calculate(String post, StackInt stack) {
		this.post = post;
		this.stack = stack;
	}

	// 由后缀表达式得到四则运算结果的实现过程
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

	// 计算栈出来的两个数
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
				throw new ArithmeticException("ERROR\n#0不能作为除数!");
			}
			re = n / m;
			break;
		default:
			break;
		}
		return re;
	}

	//判断是否为数字
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

	//获取结果
	public int getResult() {
		return stack.pop();
	}
}
