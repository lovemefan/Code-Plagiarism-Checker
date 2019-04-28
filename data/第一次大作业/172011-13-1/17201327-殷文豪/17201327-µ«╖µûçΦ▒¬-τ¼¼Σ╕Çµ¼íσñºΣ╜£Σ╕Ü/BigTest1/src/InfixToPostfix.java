
//中缀转后缀类
public class InfixToPostfix {
	private String infix;//中缀表达式
	private String postfix = "";//后缀表达式
	
	//构造方法
	public InfixToPostfix() {
		
	}
	
	//重载构造方法
	//String 中缀表达式
	public InfixToPostfix(String infix) {
		this.infix = infix;
	}
	
	//设置infix
	public void setInfix(String infix) {
		this.infix = infix;
	}
	
	//判断字符是否是数字
	//ch 字符
	public boolean isnumber(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//将负数变为0-它的绝对值,取消负数的影响,返回一个无负数的新字符串
	public String infixProcess() {
		String infix = "";
		//以负号开头
		if (this.infix.matches("\\-.*")) {
			infix = this.infix.replaceFirst("\\-", "0-");
		}
		if (this.infix.matches(".*(\\(\\-)+.*")) {
			//infix没变就直接添0，变了就对其本身操作添0
			if (infix.equals("")) {
				infix = this.infix.replaceAll("\\(\\-", "(0-");
			}
			else {
				infix = infix.replaceAll("\\(\\-", "(0-");
			}
		}
		//infix本身没负号就返回本身
		if (infix.equals("")) {
			infix += this.infix;
		}
		return infix;
	}
	
	//将中缀表达式用空格隔开（9*3变成9 * 3 ）
	public String getNewInfix() {
		String result = "";
		//消除负号影响
		String infix = infixProcess();
		//消除空格符
		infix = infix.replaceAll(" ", "");
		for (int i = 0;i < infix.length() - 1;i ++) {
			//判断是数字还是符号
			if (isnumber(infix.charAt(i)) && isnumber(infix.charAt(i + 1))) {
				result += infix.charAt(i);
			}
			else {
				result += infix.charAt(i) + " ";
			}
		}
		//空格隔开并以空格结尾的中缀表达式
		result += infix.charAt(infix.length() - 1) + " ";
		return result;
	}
	
	//中缀转后缀,获取后缀
	public String getPostfix() {
		String infix = getNewInfix();//获得带间隔的中缀表达式
		Stack stack = new Stack();//创建新栈
		for (int i = 0;i < infix.length();i ++) {
			switch (infix.charAt(i)) {
				case '(':
					Node newNode = new Node(infix.charAt(i),stack.getFirst());
					stack.setFirst(newNode);
					i ++;//跳过运算符后面的空格
					break;
				case ')':
					stack = postfix1(stack,i,infix);
					i ++;//跳过运算符后面的空格
					break;
				case '+':
				case '-':
					stack = postfix2(stack,i,infix);
					i ++;//跳过运算符后面的空格
					break;
				case '*':
				case '/':
					stack = postfix3(stack,i,infix);
					i ++;//跳过运算符后面的空格
					break;
				default :
					postfix += infix.charAt(i);
					break;
			}
		}
		//把栈中剩余的符号输出
		while (stack.getFirst() != null) {
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//出栈
		}
		return postfix;
	}
	
	//getPostfix的代码，简化代码量
	//stack 栈,i 循环的下标值,infix 带空格的中缀表达式
	public Stack postfix1(Stack stack,int i,String infix) {
		while (stack.getFirst().getChar() != '(') {
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//出栈
		}
		stack.setFirst(stack.getFirst().next);//出栈
		return stack;
	}
	
	//getPostfix的代码，简化代码量
	//stack 栈,i 循环的下标值,infix 带空格的中缀表达式
	public Stack postfix2(Stack stack,int i,String infix) {
		//栈顶不为空进入循环
		while (stack.getFirst() != null) {
			//判断运算符优先级决定出栈进栈
			if (stack.getFirst().getChar() == '(') {
				Node newNode = new Node(infix.charAt(i),stack.getFirst());
				stack.setFirst(newNode);//入栈
				break;
			}
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//出栈
		}
		//判断栈顶为空,符号直接入栈
		if (stack.getFirst() == null) {
			Node newNode = new Node(infix.charAt(i),stack.getFirst());
			stack.setFirst(newNode);//入栈
		}
		return stack;
	}
	
	//getPostfix的代码，简化代码量
	//stack 栈,i 循环的下标值,infix 带空格的中缀表达式
	public Stack postfix3(Stack stack,int i,String infix) {
		//栈顶不为空进入循环
		while (stack.getFirst() != null) {
			//判断运算符优先级决定出栈进栈
			if (stack.getFirst().getChar() == '(' || 
					stack.getFirst().getChar() == '+' || stack.getFirst().getChar() == '-') {
				Node newNode = new Node(infix.charAt(i),stack.getFirst());
				stack.setFirst(newNode);//入栈
				break;
			}
			postfix += stack.getFirst().getChar();
			stack.setFirst(stack.getFirst().next);//出栈
		}
		//判断栈顶为空,符号直接入栈
		if (stack.getFirst() == null) {
			Node newNode = new Node(infix.charAt(i),stack.getFirst());
			stack.setFirst(newNode);//入栈
		}
		return stack;
	}
	
}
