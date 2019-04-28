package bighomework;

//Calculate的无参构造方法
public class Calculate {
	public Calculate() {

	}

	// 读取字符串的这一位并进行操作
	public String realCal(Stack stack, char s1) {
		String s2 = "";
		String s6 = "";
		if (s1 >= '0' && s1 <= '9') {
			s2 = s2 + s1;
			stack.pushStack(stack, s2);// 将数字入栈
		} else if (s1 == ' ') {
			s2 = "";
		} else if (s1 == '+' || s1 == '*' || s1 == '-') {
			String s3 = stack.popStack(stack);// 获取栈顶元素
			String s4 = stack.popStack(stack);// 获取栈顶元素
			String s5 = startCal(s3, s4, s1);// 进行运算
			stack.pushStack(stack, s5);// 将计算结果结果入栈
			s6 = s5;
		}
		return s6;
	}

	// 进行字符串的具体计算
	public String Cal(String s) {
		Stack stack = new Stack();
		stack.StackBottom = stack.stackTop;
		int x = s.length();
		String s6 = "";
		// 逐位对字符串进行操作
		for (int i = 0; i < x - 1; i++) {
			String s2 = "";
			char ch = s.charAt(i);
			char ch1 = s.charAt(i + 1);
			if (ch >= '0' && ch <= '9' && ch1 >= '0' && ch1 <= '9') {
				s2 = s2 + ch + ch1;
				stack.pushStack(stack, s2);// 将两位数入栈
				i++;
			} else if (ch == '/') {
				String s3 = stack.popStack(stack);// 获取栈顶元素
				String s4 = stack.popStack(stack); // 获取栈顶元素
				double m = Double.parseDouble(s3);// 将字符串数字转换为数字
				if (m == 0.0) {
					s6 = "s4";
					break;
				} else if (m != 0) {
					String s9 = startCal(s3, s4, ch);// 进行运算
					stack.pushStack(stack, s9);// 将计算结果结果入栈
					s6 = s9;
				}
			} else {
				s6 = realCal(stack, ch);
			}

		}
		// System.out.println(s6);
		return s6;
	}

	// 将字符进行四则运算
	public String startCal(String s1, String s2, char s) {
		double s0 = 0;
		String s3 = "";
		if (s == '+') {
			s0 = Double.parseDouble(s2) + Double.parseDouble(s1);
		} else if (s == '-') {
			s0 = Double.parseDouble(s2) - Double.parseDouble(s1);
		} else if (s == '*') {
			s0 = Double.parseDouble(s2) * Double.parseDouble(s1);
		} else if (s == '/') {
			s0 = Double.parseDouble(s2) / Double.parseDouble(s1);
		}
		s3 = s3 + s0;
		return s3;
	}
}
