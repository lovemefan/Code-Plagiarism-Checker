//由后缀表达式计算结果的类
public class ToValue {
	private String postfix; // 中缀表达式转换得到的后缀表达式
	private LinkedStack<Double> stack; // 用于得到计算结果的栈

	public ToValue(String postfix, LinkedStack<Double> stack) {// 构造函数
		this.postfix = postfix;
		this.stack = stack;
	}

	public double process() {// 计算操作
		int i = 0;
		double result = 0;
		while (i < postfix.length()) {
			char ch = postfix.charAt(i);
			if (ch >= '0' && ch <= '9') {// 如果ch是数字
				result = 0;
				while (ch != ' ') {// 遇到空格即读完一个数则 结束
					result = result * 10 + Double.parseDouble(ch + "");// 将字符转化为数字
					i++;
					ch = postfix.charAt(i);
				}
				i++;
				stack.push(new Double(result));// 将数字入栈
			} else {
				double y = stack.pop().doubleValue();// 取栈顶元素
				if (stack.get() == null) {// 考虑到表达式若含有"(-1)"则最后栈中会多出一个运算符
					result = y;
					return result;
				}
				double x = stack.pop().doubleValue();// 取栈顶元素
				switch (ch) {
				case '+':
					result = x + y;// 如果是+则相加
					break;
				case '-':
					result = x - y;// 如果是-则相减
					break;
				case '*':
					result = x * y;// 如果是*则相乘
					break;
				case '/':
					result = x / y;// 如果是/则相除
					break;
				}
				stack.push(new Double(result));// 将结果入栈
				i++;
			}

		}
		result = stack.pop().doubleValue();// 将最后的结果出栈
		return result;
	}
}
