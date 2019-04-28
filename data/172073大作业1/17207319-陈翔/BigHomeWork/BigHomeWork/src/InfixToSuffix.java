
import java.util.Stack;
public class InfixToSuffix {
	public static String suffixCalc(String input) {
		
		Stack<Double> numbersStack = new Stack<Double>();
		Stack<Character> operatorsStack = new Stack<Character>();
		Stack<Object> suffixExpr = new Stack<Object>();
		int len = input.length();
		char c, temp;
		double number;
		for (int i = 0; i < len; i++) {
			c = input.charAt(i);
			if (Character.isDigit(c)) {
				int endDigitPos = getEndPosOfDigit(input, i);
				number = Double.parseDouble(input.substring(i, endDigitPos));
				i = endDigitPos - 1;
				numbersStack.push(number);
				if ((int)number == number) {
					suffixExpr.push((int)number);
				} else {
					suffixExpr.push(number);
				}
			} else if (isOperator(c)) {
				// 操作符栈非空，且栈顶不是'('，且当前操作符优先级低于栈顶操作符
				while (!operatorsStack.isEmpty() 
						&& operatorsStack.peek() != '(' 
						&& priorityCompare(c, operatorsStack.peek()) <= 0) {
					suffixExpr.push(operatorsStack.peek());
					numbersStack.push(calc(numbersStack, operatorsStack.pop()));
				}
				operatorsStack.push(c);
			} else if (c == '(') {
				operatorsStack.push(c);
			} else if (c == ')') {
				while ((temp = operatorsStack.pop()) != '(') {
					numbersStack.push(calc(numbersStack, temp));
					suffixExpr.push(temp);
				}
			} else if (c == ' ') {
				
			} else {
				throw new IllegalArgumentException("wrong character '" + c + "'");
			}
		}
		
		while (!operatorsStack.isEmpty()) {
			temp = operatorsStack.pop();
			suffixExpr.push(temp);
			numbersStack.push(calc(numbersStack, temp));
		}
		
		printStack(suffixExpr);
		return  String.valueOf(numbersStack.pop());
	}
	
	private static void printStack(Stack<?> stack) {
		String s = "";
		while (!stack.isEmpty()) {
			s += stack.pop();
		}
		for (int i = s.length()-1; i >= 0; i--) {
			
		}
	}
 
	private static int getEndPosOfDigit(String input, int start) {
		char c;
		int end = start + 1;
		for (int i = start + 1; i < input.length(); i++) {
			c = input.charAt(i);
			if (Character.isDigit(c) || c == '.') {
				continue;
			} else {
				end = i;
				break;
			}
		}
		return end;
	}
 
	private static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}
 
	// op1优先级高于op2 return 1
	private static int priorityCompare(char op1, char op2) {
		switch (op1) {
		case '+':
		case '-':
			return (op2 == '*' || op2 == '/' ? -1 : 0);
		case '*':
		case '/':
			return (op2 == '+' || op2 == '-' ? 1 : 0);
		}
		return 1;
	}
 
	private static double calc(Stack<Double> numbersStack, char op) {
		double num1 = numbersStack.pop();
		double num2 = numbersStack.pop();
		return calc(num2, num1, op);
	} 
	private static double calc(double num1, double num2, char op) throws IllegalArgumentException {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			if (num2 == 0)
				throw new IllegalArgumentException("divisor can't be 0.");
			return num1 / num2;
		default:
			return 0;
		}
	}

}