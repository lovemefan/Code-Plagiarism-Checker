import java.util.Stack;

public class Solution {
	// 利用栈
	private static Stack<String> stack = new Stack<String>();
	// 用于记录输出后缀表达式
	private static StringBuffer suffixExpression = new StringBuffer();
	
	public Solution() {
		
	}

	// 判断是否为操作符
	public static boolean isOperateationalCharacter(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("(")
				|| str.equals(")"))
			return true;
		return false;
	}

	// 计算操作符的优先级
	public static int priority(String str) {
		switch (str) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "(":
			return 3;
		case ")":
			return 3;
		default:
			return 0;
		}
	}

	// 转换为后缀表达式
	/*
	 * 思路: 1.遇到操作数，直接输出 2.栈为空时，遇到运算符，入栈； 3.遇到左括号，将其入栈
	 * 4.遇到右括号，执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出
	 * 5.遇到其他运算符"+"、"-"、"*"、"/"时，弹出所有优先级大于或等于该运算符的栈顶元素，然后将该运算符入栈
	 * 6.最终将栈中的元素依次出栈，输出。 经过上面的步骤，得到的输出既是转换得到的后缀表达式 举例：a+b*c+(d*e+f)g ———> a b c
	 * + d e * f + g * +
	 */
	public static StringBuffer transformToSuffixExpression(String s) {
		suffixExpression.delete(0, suffixExpression.length());
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			transexpression(arr[i]);
		}
		
		// 如果栈不为空，把剩余的运算符依次弹出，送至输出序列。
		while (stack.size() != 0) {
			suffixExpression.append(" " + stack.pop());
		}
		return suffixExpression;
	}

	public static void transexpression(String c) {
		switch (c) {
		// 忽略空格
        case " ":
            break;
		// 左括号直接进栈
		case "(":
			stack.push(c);
			break;
		// 碰到"+""-"，将栈中所有运算符弹出，送到输出
		case "+":
		case "-":
			encounterAdditionOrSubtraction(c);
			break;
		// 碰到'*''/'，将栈中所有乘除运算符弹出，送到输出
        case "*":
        case "/":
        	encounterMultiplicationOrDivision(c);
        	break;
        // 碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
        case ")":
        	encounterClosingParentheses();
        	break;
        default :
        	suffixExpression.append(c);
		}
	}

	private static void encounterClosingParentheses() {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("("))
                break;
            else
            	suffixExpression.append(" " + temp);
        }
	}

	private static void encounterMultiplicationOrDivision(String c) {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("(") || temp.equals("+") || temp.equals("-")) {
            	stack.push(temp);
                break;
            } else {
            	suffixExpression.append(" " + temp);
            }
        }
        stack.push(c);
        suffixExpression.append(" ");
	}

	private static void encounterAdditionOrSubtraction(String c) {
		String temp;
		while (stack.size() != 0) {
            temp = stack.pop();
            if (temp.equals("(")) {
                stack.push("(");
                break;
            }
            suffixExpression.append(" " + temp);
        }
        stack.push(c);
        suffixExpression.append(" ");
	}
}
