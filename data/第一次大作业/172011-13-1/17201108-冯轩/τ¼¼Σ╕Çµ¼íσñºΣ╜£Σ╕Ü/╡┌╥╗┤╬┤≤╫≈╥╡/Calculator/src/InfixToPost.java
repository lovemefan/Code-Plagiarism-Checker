
public class InfixToPost {
	private Stack stack; // 中缀表达式转换为后缀表达式所需要的栈
	private String infix; // 输入的中缀表达式
	private String post = ""; // 存储得到的后缀表达式

	//初始化构造器
    public InfixToPost (Stack stack, String infix) {
        this.stack = stack;
        this.infix = infix.replaceAll("\\s+","");//去除字符串中的空格;
    }
    
	private void getOperation(String str, int priority) {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				stack.push(top);
				break;
			} else {
				int priTop = getPriority(top);
				if (priTop < priority) {
					stack.push(top);
					break;
				} else {
					post += " " + top;
				}
			}
		}
		stack.push(str);
	}

	//获取运算符优先级
	private int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")) {
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}

	//获取括号
	private void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				post += " " + top;
			}
		}
	}

	//为表达式处理加上空格
	private String processInfix(String infix) {
        String result = "";
        for (int i = 0; i < infix.length() - 1; i++) {
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (isDigital(temp1) && isDigital(temp2)) {
                result += temp1;
            } else {
                result += temp1 + " ";
            }
        }
        result += infix.charAt(infix.length() - 1); // 将最后一个元素添加进去
        return result;
    }

	//判断是否是数字
	private boolean isDigital(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

	//中缀表达式转后缀表达式
	public void process() {
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
				stack.push(str);
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
		while (!stack.isEmpty()) {
			post += " " + stack.pop();
		}
	}

	//得到结果
	public String getPost() {
		return post.trim();
	}
}
