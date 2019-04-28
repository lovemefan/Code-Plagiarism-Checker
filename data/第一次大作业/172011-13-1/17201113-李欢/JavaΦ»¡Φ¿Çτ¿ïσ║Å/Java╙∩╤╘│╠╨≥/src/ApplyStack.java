
public class ApplyStack {
	private Stack stack; // 中缀表达式转换为后缀表达式所需要的栈
	private String fox; // 输入的中缀表达式
	private String add = ""; // 存储得到的后缀表达式

	public ApplyStack(Stack stack, String fox) {
		this.stack = stack;
		this.fox = fox;
	}

	private String processInfix(String fox) {
		String result = "";
		for (int i = 0; i < fox.length() - 1; i++) {
			char temp1 = fox.charAt(i);
			char temp2 = fox.charAt(i + 1);
			if (isDigital(temp1) && isDigital(temp2)) {
				result += temp1;
			} else {
				result += temp1 + " ";// 将表达式中的字符进行加空格处理
			}
		}
		result += fox.charAt(fox.length() - 1); // 将最后一个元素添加进去
		return result;
	}

	private boolean isDigital(char ch) {// 判断字符是否是数字
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

	

	private void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else {
				add += " " + top;
			}
		}
	}

	private void getOperation(String str, int priority) {// 运算符优先级处理
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
					add += " " + top;
				}
			}
		}
		stack.push(str);
	}

	private int getPriority(String str) {// 将优先级作为1,2进行赋值
		int tx = 0;
		if (str.equals("+") || str.equals("-")) {
			tx = 1;
		} else {
			tx = 2;
		}
		return tx;
	}

	public String getPost() {
		return add.trim();

	}
	// 将中缀表达式转换为后缀表达式的处理过程
		public void process() {
			String[] strArr = processInfix(fox).split(" ");
			for (int i = 0; i < strArr.length; i++) {
				String ig = strArr[i];
				if(ig.equals("+")||ig.endsWith("-")){
					getOperation(ig, 1);
				}
				else if(ig.equals("*")||ig.endsWith("/")){
					getOperation(ig, 2);
				}
				else if(ig.equals("(")){
					stack.push(ig);
				}
				else if(ig.equals(")")){
					getParent();
				}
				else{
					add += " " + ig;
				}
			}
			// 数字全部输出后，需要输出栈中剩余的符号
			while (!stack.isEmpty()) {
				add += " " + stack.pop();

			}
		}
}


