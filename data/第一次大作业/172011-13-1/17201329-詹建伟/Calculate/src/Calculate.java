//计算类
public class Calculate {
	// 计算后缀表达式
	// 栈，后缀表达式
	public void calculte(Stack stack, String buf, java.io.PrintWriter output, String expression) {
		String[] s = buf.split(" ");
		for (int i = 0; i < s.length; i++) {
			// 判空
			if (s[i].isEmpty()) {
				continue;
			}
			// 判断数字进栈
			if (s[i].matches("[\\d]{1,}")) {
				stack.pushStack(stack, s[i]);
				continue;
			}
			// 判断计算，并将结果入栈
			switch (s[i]) {
			case "+":
				stack.pushStack(stack, this.add(stack));
				break;
			case "-":
				stack.pushStack(stack, this.reduce(stack));
				break;
			case "*":
				stack.pushStack(stack, this.multi(stack));
				break;
			case "/":
				stack.pushStack(stack, this.division(stack));
				break;
			default:
				break;
			}
		}
		// 输出最终结果
		String temp = stack.outStack(stack);
		if (temp.equals("Infinity")) {
			output.println("ERROR\r\n#除数为0");
		} else {
			double temp2 = Double.parseDouble(temp);
			output.println(expression + "=" + temp2);
		}
		// System.out.println(temp);//控制台上显示结果
	}

	// 实现加法
	public String add(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 + num1) + "";
		return s;
	}

	// 实现减法
	public String reduce(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 - num1) + "";
		return s;
	}

	// 实现乘法
	public String multi(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 * num1) + "";
		return s;
	}

	// 实现除法
	public String division(Stack stack) {
		double num1 = Double.parseDouble(stack.outStack(stack));
		double num2 = Double.parseDouble(stack.outStack(stack));

		String s = (num2 / num1) + "";
		return s;
	}
}
