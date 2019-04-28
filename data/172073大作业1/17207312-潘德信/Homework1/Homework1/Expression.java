
public class Expression {
	
	private String e = null;
	
	Expression(String e)throws NonstandardException {
		e = e.replaceAll("\\s*", "");								//去除空白符
		setExpression(e);
	}
	
	public void setExpression(String e)throws NonstandardException {						//错误处理
		if(e == null || e.length() == 0)
			throw new NonstandardException("ERROR#表达式为空");
		else if(e.matches("^.*\\(\\).*$"))
			throw new NonstandardException("ERROR#表达式中有空括号");
		else if(!e.matches("^[\\d\\+\\-\\*\\/()]+$"))
			throw new NonstandardException("ERROR#表达式包含非法字符");
		else if(!parenthesisMatching(e))
			throw new NonstandardException("ERROR#括号不匹配");
		else if(e.matches("^(.*)[\\+\\-\\*\\/][\\+\\-\\*\\/](.*)$"))
			throw new NonstandardException("ERROR#运算符连续");
		else if(e.matches("^.*[^\\d)]+[\\+\\-\\*\\/].*$") || e.matches("^[\\+\\-\\*\\/].*"))
			throw new NonstandardException("ERROR#运算符前无运算数");
		else if(e.matches("^.*[\\+\\-\\*\\/][^\\d(]+.*$") || e.matches("^.*[\\+\\-\\*\\/]"))
			throw new NonstandardException("ERROR#运算符后无运算数");
		else if(e.matches("^[^\\d(]+[(].*$"))
			throw new NonstandardException("ERROR#括号非第一个字符且之前无运算数");
		else if(e.matches("^.*[)][^\\d)]+$"))
			throw new NonstandardException("ERROR#小括号后无运算数，括号非最后一个");
		else if(e.matches("^.*[^\\+\\-\\*\\/(][(].*$"))
			throw new NonstandardException("ERROR#缺少运算符，运算数直接接左括号");
		else if(e.matches("^.*[)][^\\+\\-\\*\\/)].*$"))
			throw new NonstandardException("ERROR#缺少运算符，右括号直接接运算数");
		else
			this.e = e + "#";	
	}
	
	String getExpression() {
		return e.replaceAll("#", "");
	}
	
	public boolean parenthesisMatching(String e) {				//括号匹配
		char[] ch = e.toCharArray();
		Stack<Character> stack = new Stack<Character>(ch.length);
		for(int i = 0;i < ch.length;i++) {
			if(ch[i] == '(')
				stack.push(ch[i]);
			else if(ch[i] == ')' && stack.empty())
				return false;
			else if(ch[i] == ')' && !stack.empty())
				stack.pop();
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	public String calculateExpression() {
		Stack<Character> OPTR = new Stack<Character>();
		OPTR.push('#');
		Stack<String> OPND = new Stack<String>();
		char[] ch = e.toCharArray();
		char[][] priority={
			{'>','>','<','<','<','>','>'},
			{'>','>','<','<','<','>','>'},
			{'>','>','>','>','<','>','>'},
			{'>','>','>','>','<','>','>'},
			{'<','<','<','<','<','=','0'},
			{'>','>','>','>','0','>','>'},
			{'<','<','<','<','<','0','='}
		};
		for(int i = 0;i < ch.length;i++) {
			StringBuilder operands = new StringBuilder();
			while(ch[i] >= '0' && ch[i] <= '9') {
				operands.append(ch[i]);
				i++;
			}
			if(operands.length() != 0)				
				OPND.push(operands.toString());
			switch(priority[operator(OPTR.peek())][operator(ch[i])]) {
				case '<':
					OPTR.push(ch[i]); break;
				case '=':
					OPTR.pop(); break;
				case '>':
					float b = Float.parseFloat(OPND.pop()),a = Float.parseFloat(OPND.pop());
					OPND.push(String.valueOf(operate(a,OPTR.pop(),b))); i--; break;
				default:break;
			}
		}
		return OPND.pop();
	}
	
	public int operator(char c) {
		switch(c) {
			case '+':
				return 0;
			case '-':
				return 1;
			case '*':
				return 2;
			case '/':
				return 3;
			case '(':
				return 4;
			case ')':
				return 5;	
			case '#':
				return 6;
			default:
				return -1;		
		}
	}
	
	public float operate(float a,char theta,float b) {
		switch(theta) {
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
			case '/':
				return a/b;
			default:
				return 0;
		}
	}
	
}
