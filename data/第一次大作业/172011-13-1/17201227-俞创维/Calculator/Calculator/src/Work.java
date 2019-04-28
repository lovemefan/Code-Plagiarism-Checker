import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
 
public class Work {
	// ²Ù×÷ÊýÕ»
	private static Stack<Double> Operands;
	// ²Ù×÷·ûÕ»
	private static Stack<Character> Operators;
	// ²Ù×÷·û¼¯ºÏ
	private static final Set<Character> C_OperatorSet = new HashSet<Character>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
 
		{
			add('+');
			add('-');
			add('*');
			add('/');
			add('(');
			add(')');
		}
	};
 
	private static int getOperatorPriority(char ch) {
		if (ch == '+' || ch == '-')
			return 0;
		else if (ch == '*' || ch == '/')
			return 1;
		else
			return -1;
	}
 
	private static String infixToSuffix(String expression) {
		Operators = new Stack<>();
		Operators.clear();
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == ' ')
				continue;
			if (C_OperatorSet.contains(ch)) {
				if (Operators.empty()) {
					if (ch == ')') {
						System.out.println("À¨ºÅ²»Æ¥Åä");
						return sBuilder.toString();
					}
					Operators.push(ch);
				} else if (ch == '(') {
					Operators.push(ch);
				} else if (ch == ')') {
					char top;
					while ((top = Operators.peek()) != '(') {
						if (Operators.empty()) {
							System.out.println("À¨ºÅ²»Æ¥Åä");
							return sBuilder.toString();
						}
						sBuilder.append(top);
						Operators.pop();
					}
					Operators.pop();
				} else {
					char top = Operators.peek();
					if (getOperatorPriority(ch) <= getOperatorPriority(top)) {
						while (!Operators.empty()
								&& getOperatorPriority(ch) <= getOperatorPriority(top = Operators.peek())) {
							sBuilder.append(top);
							Operators.pop();
						}
					}
					Operators.push(ch);
				}
			} else {
				sBuilder.append("[" + ch);
				while (i + 1 < expression.length()
						&& (((ch = expression.charAt(i + 1)) == '.') || (ch >= '0' && ch <= '9'))) {
					sBuilder.append(ch);
					++i;
				}
				sBuilder.append(']');
			}
		}
		while (!Operators.empty()) {
			sBuilder.append(Operators.peek());
			Operators.pop();
		}
		return sBuilder.toString();
	}
 
	public static double evalExp(String expression) {
		Operands = new Stack<>();
		Operands.clear();
		double ret = 0;
		String suffix = infixToSuffix(expression);
		System.out.println("suffix: " + suffix);
		for (int i = 0; i < suffix.length(); i++) {
			if (suffix.charAt(i) == '[') {
				i++;
				int beginIndex = i, endIndex = i;
				while (']' != suffix.charAt(i)) {
					i++;
					endIndex++;
				}
				Operands.push(Double.valueOf(suffix.substring(beginIndex, endIndex)));
			} else {
				double left, right, res = 0;
				right = Operands.peek();
				Operands.pop();
				left = Operands.peek();
				Operands.pop();
				switch (suffix.charAt(i)) {
				case '+':
					res = left + right;
					break;
				case '-':
					res = left - right;
					break;
				case '*':
					res = left * right;
					break;
				case '/':
					res = left / right;
					break;
				case '^':
					res = Math.pow(left, right);
					break;
				}
				Operands.push(res);
			}
		}
		ret = Operands.peek();
		Operands.pop();
		return ret;
	}
 
}