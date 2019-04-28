package Project;

public class toPost {
	
	//构造方法
		public  toPost(){
			
		}

	// 转换表达式
	public String toPost(String infix) throws Exception {
		Stack stack = new Stack();// 操作符栈
		String suffix = "";// 存放后缀表达式
		int length = infix.length();// 字符串长度
		for (int i = 0; i < length; i++) {
			char c = infix.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '(':
				stack.push(String.valueOf(c));
				break;
			case '+':
			case '-':
				suffix = addSubOp(stack, suffix, c);// 调用addSubOp()
				suffix += " ";
				break;
			case '*':
			case '/':
				suffix = mulDivOp(stack, suffix, c);// 调用mulDivO()
				suffix += " ";
				break;
			case ')':
				suffix = reightOp(stack, suffix);// 调用reightOp()
				break;
			// 如果是数字，直接送至输出序列
			default:
				suffix += c;
			}
		}
		while (stack.size() != 0) {
			suffix += " " + stack.pop();
		}
		return suffix;
	}
	//遇到* / 的操作
	public String mulDivOp(Stack stack, String intopost,char c){
		while (stack.size() != 0) {
		String temp = stack.pop();
		if (temp.equals("(") || temp.equals("+") ||temp.equals("-") ) {
			stack.push(temp);
			break;
		} else {
			intopost += " " +temp;
		}
	}
	stack.push(String.valueOf(c));
	return intopost;
	}
	//遇到+ - 的操作
	public String addSubOp(Stack stack, String intopost,char c){
		while (stack.size() != 0) {
			String temp = stack.pop();
			if (temp.equals("(")) {
				stack.push("(");
				break;
			}
			intopost+= " " +temp;
		}
		stack.push(String.valueOf(c));
		return intopost;
	}
	//遇到 ) 的操作
	public String reightOp(Stack stack, String intopost){
		while (stack.size() != 0) {
			String temp = stack.pop();
			if (temp.equals("("))
				break;
			else
				intopost += " " + temp;
		}
		return intopost;
	}
}
