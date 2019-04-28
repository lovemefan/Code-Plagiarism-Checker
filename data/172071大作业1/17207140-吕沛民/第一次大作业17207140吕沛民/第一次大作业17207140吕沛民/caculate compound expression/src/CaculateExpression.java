
public class CaculateExpression {
	StackOfIntegers stack1 = new StackOfIntegers();
	StackOfIntegers stack2 = new StackOfIntegers();
	private String postExpression = "";
	private String expression;
	
	
	public CaculateExpression() {
		
	}
	public CaculateExpression(String expression) {
		this.expression = expression;
		toPostExpression();
		getResult();
	}
	public String getExpressionResult() {
		
		return stack2.pop();
	}
		
	public String getPostExpression() {   //后辍表达式
		return postExpression;
	}
	private void findLeftParent() {		//栈里的运算符若是“（”则不做处理
		while(!stack1.isEmpty()) 
		{
			String top = stack1.pop();
			if(top.equals("("))
			{
				break;
			}
			else
			{
				postExpression += " "+ top;
			}
		}
	}
	private int getNum(String num) {	//找到栈里运算符的优先级
		int num2 =0;
		if(num.equals("+")||num.equals("-")) {
			 num2=1;
		}
		else
		{
			num2 =2;
		}
		return num2; 
	}
	private void getOperation(String cut,int num){		//用当前的运算符和栈里的运算符比较优先级，优先级高的写入后辍表达式
		while(!stack1.isEmpty())
		{
			String top = stack1.pop();
			if(top.equals("(")) {
				stack1.push(top);
				break;
			}
			else
			{
				int num1 = getNum(top);
				if(num1<num)
				{
					stack1.push(top);
					break;
				}
				else
				{
					postExpression += " "+top;
				}
			}
		}
		stack1.push(cut);
	}
	private void toPostExpression() {		//得到后辍表达式
		String[] cutting = expression.split(" ");
		for(int i =0; i<cutting.length;i++)
		{
			String cut = cutting[i];
			switch(cut) 
			{
				case" ":
					break;
				case"+":
				case"-":
					getOperation(cut,1);
					break;
				case"*":
				case"/":
					getOperation(cut,2);
					break;
				case"(":
					stack1.push(cut);
					break;
				case")":
					findLeftParent();
					break;
				default:
					postExpression += " " + cut;
					break;
			}
		}
		while(!stack1.isEmpty()) 
		{
			postExpression += " " + stack1.pop();
		}
	}
	private void getResult() {		//得到运算结果
		String[] cutt = postExpression.split(" ");
		for(int i =0;i<cutt.length;i++) 
		{
			String cut1 =cutt[i];
			if(isNumber(cut1)== true)
			{
				stack2.push(cut1);
			}
			else
			{
				String result = Caculate(cut1);
				stack2.push(result);
			}
		}
	}
	private String Caculate(String cut1) {   //对运算数中的栈进行运算
		float flo = 0;
		String str = "";
		float flo1 = Float.parseFloat(stack2.pop());
		float flo2 = Float.parseFloat(stack2.pop());
		switch(cut1) 
		{
			case"+":
				flo = flo1 + flo2;
				break;
			case"-":
				flo = flo1 - flo2;
				break;
			case"*":
				flo = flo1 * flo2;
				break;
			case"/":
				flo = flo2 / flo1;
				break;
			default:
				break;
		}
		str = flo +"";
		return str;
	}
	private boolean isNumber(String flag){   //判断字符是否是数字
		boolean n = true;
		for (int i = 0; i < flag.length(); i++) {
			if (!(flag.charAt(i) >= '0' && flag.charAt(i) <= '9')) {
				n= false;
				break;
			}
		}
		return n;
	}
}
