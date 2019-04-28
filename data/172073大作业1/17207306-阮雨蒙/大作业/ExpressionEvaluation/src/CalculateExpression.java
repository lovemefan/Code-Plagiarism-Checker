//计算表达式类
public class CalculateExpression {
	private String expression;  //待处理数学表达式
	
	//无参构造方法
	public CalculateExpression(){
		
	}
	
	//有参构造方法
	public CalculateExpression(String expression){
		this.expression = expression;
	}
	
	// 计算表达式的值
	public float evaluate() {
		char[] tokens = expression.toCharArray(); // 转成字符数组

		// 定义数值栈
		SqStack stackOfNum = new SqStack(1024);
		// 定义符号栈
		SqStack stackOfOps = new SqStack(1024);

		try {

			for (int i = 0; i < tokens.length; i++) {  //从左到右扫描表达式字符串

				if (tokens[i] >= '0' && tokens[i] <= '9') {
					StringBuffer sbuf = new StringBuffer();//用来存储数值对应的字符串

					//解决连续多个数字表示一个整型数的情况，例如345+4
					while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
						sbuf.append(tokens[i++]);
					}
					i--; // 回退一位，因为i的值向后++了一次
					//将数值入数值栈
					stackOfNum.push(Float.parseFloat(sbuf.toString()));
				}
				//左括号直接入符号栈
				else if (tokens[i] == '(')
					stackOfOps.push(tokens[i]);
				//右括号则将符号栈与数值栈出栈，直到符号栈中的左括号为止，并进行计算，然后将运算结果入数值栈
				else if (tokens[i] == ')') {
					while (!stackOfOps.peek().toString().equals("("))
						stackOfNum.push(
								caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
					stackOfOps.pop();//左括号出栈
				}
				//如果是加减乘除运算符
				else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
					//需要将当前运算符与符号栈中栈顶运算符的优先级进行比较，
					//如果当前运算符优先级大于符号栈栈顶运算符的优先级
					//则将符号栈与数值栈出栈，直到符号栈中的左括号为止，并进行计算，然后将运算结果入数值栈
					while (!stackOfOps.isEmpty() && hasPriority(tokens[i], (char) stackOfOps.peek()))
						stackOfNum.push(
								caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
					stackOfOps.push(tokens[i]);//当前运算符进符号栈
				}
			}
			//栈不为空，则符号栈与数值栈依次出栈并运算
			while (!stackOfOps.isEmpty())
				stackOfNum.push(caculate((char) stackOfOps.pop(), (float) stackOfNum.pop(), (float) stackOfNum.pop()));
			//最后的运算结果
			return (float) stackOfNum.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	// 判断两个运算符是否有优先级差异，当op1优先级<op2优先级时返回true，否则返回false
	// 小括号不进行优先级比较
	public boolean hasPriority(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// 计算表达式的值，op为运算符，a与b为运算数
	public float caculate(char op, float b, float a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) { // 除0的情况
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}
}