
public class Calculate {
	// 逆波兰表达式求值
	public static ArrStack rpn(char[] s) {
		ArrStack as = new ArrStack();
		double num = 0;
		// 定义空字符串存入字符
		String arr = "";
		double a = 0;
		double b = 0;
		double result = 0;
		for (int i = 0; i < s.length; i++) {
			// 如果是数字或者.则推入栈中
			if (ArrStack.isNumber(s[i])) {
				arr = arr + s[i];
			} else if (s[i] == ' ' && arr != "") {
				num = Double.valueOf(arr);
				as.stackPush(num);
				// 字符串置空
				arr = "";
			} else {
				// 遇到运算符字符,弹出栈顶前两个数进行运算后再压入栈中
				switch (s[i]) {
				case '+':
					a = as.stackPop();
					b = as.stackPop();
					result = b + a;
					as.stackPush(result);
					break;
				case '-':
					a = as.stackPop();
					b = as.stackPop();
					result = b - a;
					as.stackPush(result);
					break;
				case '*':
					a = as.stackPop();
					b = as.stackPop();
					result = b * a;
					as.stackPush(result);
					break;
				case '/':
					a = as.stackPop();
					b = as.stackPop();
					if (a == 0) {
						System.out.println("除数不能为0!");
						break;
					}
					result = b / a;
					as.stackPush(result);
					break;

				}
			}
		}
		return as;

	}
}
