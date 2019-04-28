
//后缀计算类
public class PostfixCompute {
	private InfixToPostfix deal = new InfixToPostfix();
	private Stack stack = new Stack();//计算所需的栈

	//构造方法
	public PostfixCompute() {
		
	}
	
	//重载构造方法
	//String 中缀表达式
	public PostfixCompute(String infix) {
		this.deal.setInfix(infix);
	}
	
	//获取deal
	public InfixToPostfix getDeal() {
		return deal;
	}
	
	//获得计算结果
	public double getResult() {
		return compute();
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
	
	//返回计算结果
	public double compute() {
		String postfix = deal.getPostfix();
		for (int i = 0;i < postfix.length();i ++) {
			String numbers = "";//要进栈的数字字符串
			while (isnumber(postfix.charAt(i))) {
				numbers += postfix.charAt(i);
				i ++;
			}
			//要进栈的字符串不为为空
			if (!numbers.equals("")){
				Node newNode = new Node(numbers,stack.getFirst());
				stack.setFirst(newNode);
			}
			if (!isnumber(postfix.charAt(i)) && postfix.charAt(i) != ' ') {
				compute1(i,postfix);
			}
		}
		//将栈中最后的结果出栈
		double result = Double.parseDouble(stack.getFirst().getStr());
		stack.setFirst(stack.getFirst().next);
		return result;
	}
	
	//计算的一部分代码
	//i 循环的下标,postfix 后缀表达式
	public void compute1(int i,String postfix) {
		//栈的前两个节点出栈,转换为double型做算术运算
		double r1 = Double.parseDouble(stack.getFirst().getStr());
		stack.setFirst(stack.getFirst().next);
		double r2 = Double.parseDouble(stack.getFirst().getStr());
		double r3 = 0;//用来存储运算结果
		switch (postfix.charAt(i)) {
		case '+' :
			r3 = r2 + r1;
			break;
		case '-' :
			r3 = r2 - r1;
			break;
		case '*' :
			r3 = r2 * r1;
			break;
		case '/' :
			r3 = r2 / r1;
			break;
		
		}
		//重置栈顶元素为运算后的值
		stack.getFirst().setStr("" + r3);;
	}
}
