import java.util.Stack;
import java.util.regex.Pattern;

// 将中缀表达式字符串转换为后缀表达式 
public class StringToArithmetic {

	public StringToArithmetic() {
	}

	// 将中缀表达式字符串计算得到结果
	public static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	// 将中缀表达式转换为后缀表达式
	public static String infixToSuffix(String exp) {
		// 创建操作符堆栈
		Stack<Character> s = new Stack<Character>();
		String suffix = "";
		int length = exp.length(); // 输入的中缀表达式的长度
		for (int i = 0; i < length; i++) {
			char temp;
			// 获取该中缀表达式的每一个字符并进行判断
			char ch = exp.charAt(i);
			switch (ch) {
			// 忽略空格
			case ' ':
				break;
			// 如果是左括号直接压入堆栈
			case '(':
				s.push(ch);
				break;

			// 碰到'+' '-'，将栈中的所有运算符全部弹出去，直至碰到左括号为止，输出到队列中去
			case '+':
			case '-':
				while (s.size() != 0) {
					temp = s.pop();
					if (temp == '(') {
						// 重新将左括号放回堆栈，终止循环
						s.push('(');
						break;
					}
					suffix += " " + temp;
				}
				s.push(ch);
				break;

			// 如果是乘号或者除号，则弹出所有序列，直到碰到加好、减号、左括号为止，最后将该操作符压入堆栈
			case '*':
			case '/':
				while (s.size() != 0) {
					temp = s.pop();
					// 只有比当前优先级高的或者相等的才会弹出到输出队列，遇到加减左括号，直接停止当前循环
					if (temp == '+' || temp == '-' || temp == '(') {
						s.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				s.push(ch);
				break;

			// 如果碰到的是右括号，则距离栈顶的第一个左括号上面的所有运算符弹出栈并抛弃左括号
			case ')':
				while ((temp = s.pop()) != '(') {
					suffix += " " + temp;
				}
				while (!s.isEmpty()) {
					temp = s.pop();
					if (temp == '(') {
						break;
					} else {
						suffix += " " + temp;
					}
				}
				break;
			//如果读取到的是数字，则直接送至输出序列
			default:
				suffix += " " + ch;
				break;
			}

		}
		// 如果堆栈不为空，则把剩余运算符一次弹出，送至输出序列
		while (s.size() != 0) {
			suffix += " " + s.pop();
		}
		return suffix;
	}

	public static double suffixToArithmetic(String exp) {
		// 使用正则表达式匹配数字
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)");
		// 将后缀表达式分割成字符串数组,此处直接使用空白也可以对字符串进行分割
		String[] strings = exp.split(" ");
		Stack<Double> stack = new Stack<Double>();
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].equals(" ")) {
				continue;
			}
			// 如果遇到了数字则直接进栈
			if (pattern.matcher(strings[i]).matches()) {
				stack.push(Double.parseDouble(strings[i]));
			}
			// 如果是运算符，则弹出栈顶的两个数进行计算
			else {
				double y = stack.pop();
				double x = stack.pop();
				// 将运算结果重新压栈
				stack.push(calculate(x, y, strings[i]));
			}
		}
		// 弹出栈顶元素就是最终结果
		return stack.pop();
	}

	private static Double calculate(double x, double y, String string) {
		if (string.trim().equals("+")) {
			return x + y;
		}
		if (string.trim().equals("-")) {
			return x - y;
		}
		if (string.trim().equals("*")) {
			return x * y;
		}
		if (string.trim().equals("/")) {
			return x / y;
		}
		return (double) 0;
	}
}