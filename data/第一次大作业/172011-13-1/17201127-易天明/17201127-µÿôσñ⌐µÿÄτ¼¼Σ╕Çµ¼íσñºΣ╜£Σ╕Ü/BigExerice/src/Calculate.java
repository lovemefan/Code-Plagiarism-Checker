import java.util.Stack;

public class Calculate {
	public Calculate() {
		
	}
	
	public static double calculate(String s) {
		// 将字符串分割空格并转化为字符串数组
		String strings[] = s.split(" ");

		for (int i = 0; i < strings.length; i++) {
			// 去掉字符串首尾的空格
			strings[i].trim();
		}
		// 定义栈用来计算
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < strings.length; i++) {
			// 如果是数字，则进栈
			if (!isOperateationalCharacter(strings[i])) {
				stack.push(Double.parseDouble(strings[i]));
			}
			// 如果是运算符，弹出运算数，计算结果。
			else {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(cal(x, y, strings[i])); // 将运算结果重新压入栈。
			}
		}
		return stack.pop(); // 弹出栈顶元素就是运算最终结果。
	}

	public static double cal(double num1, double num2, String operationalCharacter) {
		switch (operationalCharacter) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return 0;
		}
	}

	public static boolean isOperateationalCharacter(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
			return true;
		return false;
	}
}
