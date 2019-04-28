//中缀表达式转换为后缀表达式
public class InfixToPost {
	private Stack stack; // 中缀表达式转换为后缀表达式所需要的栈
	private String infix; // 输入的中缀表达式
	private String post = ""; // 存储得到的后缀表达式

	// 构造方法
	public InfixToPost(Stack stack, String infix) {
		this.stack = stack;
		this.infix = infix;
	}

	// 返回处理过后的中缀表达式，主要是在输入的中缀表达式加空格 例如：输入的中缀表达式为：9+(3-1)*3+10/2
	// 输出的中缀表达式为：9 + ( 3 - 1 ) * 3 + 10 / 2
	private String processInfix(String infix) {
		String result = "";
		for (int i = 0; i < infix.length() - 1; i++) {
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
			if (Character.isDigit(temp1) && Character.isDigit(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";
			}
		}
		result += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
		return result;
	}

	// 将前缀表达式转换为后缀表达式的处理过程
	public void process() {
		// 以空格分离开表达式
		String[] strArr = processInfix(infix).split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			switch (str) {
			case "+":
			case "-":
				getOperation(str, 1);
				break;
			case "*":
			case "/":
				getOperation(str, 2);
				break;
			case "(":
				stack.pushStack(stack, str);
				break;
			case ")":
				getParent();
				break;
			default:
				post += " " + str;
				break;
			}
		}
		// 数字全部输出后，需要输出栈中剩余的符号
		while (!stack.isEmpty(stack)) {
			post += " " + stack.popStack(stack);
		}
	}

	// (3)遇到操作数时，将其压入post；
	// (4) 遇到运算符时，比较其与栈顶运算符的优先级：
	// (4-1) 如果stack为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
	// (4-2)否则，若优先级比栈顶运算符的高，也将运算符压入Stack（注意转换为前缀表达式时是优先级较高或相同，而这里则不包括相同的情况）；
	// (4-3)否则，将Stack栈顶的运算符弹出并压入到post中，再次转到(4-1)与Stack中新的栈顶运算符相比较
	// (5) 遇到括号时：
	// (5-1) 如果是左括号“(”，则直接压入stack；
	// (5-2) 如果是右括号“)”，则依次弹出Stack栈顶的运算符，并压入post，直到遇到左括号为止，此时将这一对括号丢弃；
	// 6) 重复步骤(2)至(5)，直到表达式的最右边；
	// (7) 将S1中剩余的运算符依次弹出并压入S2
	private void getParent() {
		while (!stack.isEmpty(stack)) {
			String top = stack.popStack(stack);
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}

	private void getOperation(String str, int priority) {
		while (!stack.isEmpty(stack)) {
			String top = stack.popStack(stack);
			if (top.equals("(")) {
				stack.pushStack(stack, top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {
					stack.pushStack(stack, top);
					break;
				} else {
					post += " " + top;
				}
			}
		}
		stack.pushStack(stack, str);
	}

	private int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	public String getPost() {
		return post.trim();
	}
}
