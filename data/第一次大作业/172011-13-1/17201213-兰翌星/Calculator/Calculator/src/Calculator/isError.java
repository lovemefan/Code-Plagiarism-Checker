package Calculator;

import java.util.Stack;

public class isError {
	private String Exception = null;
	StringBuffer ERRORBuffer = new StringBuffer();
	Stack<Character> stack = new Stack<Character>();
	
	/**
	 * 无参构造方法
	 */
	public isError() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 有参构造方法，初始化表达式
	 * @param Exception
	 */
	public isError(String Exception) {
		this.Exception = Exception;
	}
	
	/**
	 * 返回表达式的错误信息
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ERRORBuffer.toString();
	}
	
	/**
	 * 判断表达式括号是否存在错误，匹配返回true,不匹配返回false并记录错误信息
	 * @return
	 */
	public boolean BracketsError(){
		boolean error = true;
		error = getEr();
		if(this.Exception.matches("(.*)[0-9]\\((.*)")){
			ERRORBuffer.append("缺少操作符:左括号左边缺少操作符;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\)[0-9](.*)")){
			ERRORBuffer.append("缺少操作符:右括号右边缺少操作符;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\([\\*+-/](.*)")){
			ERRORBuffer.append("缺少操作数:左括号右边缺少操作数;");
			error = false;
		}
		if(this.Exception.matches("(.*)[\\*+-/]\\)(.*)")){
			ERRORBuffer.append("缺少操作数:右括号左边缺少操作数;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\(\\)(.*)")){
			ERRORBuffer.append("空括号:括号内无表达式;");
			error = false;
		}
		return error;
	}
	
	private boolean getEr(){
		boolean error = true;
		for(int i = 0 ; i < Exception.length() ; i ++){
			if(Exception.charAt(i) == '('){
				stack.push(Exception.charAt(i));
			}
			if(Exception.charAt(i) == ')'){
				if(stack.isEmpty()){
					ERRORBuffer.append("括号不匹配:缺少左括号;");
					error = false;
				}else{
					stack.pop();
				}
			}
		}
		if( ! stack.isEmpty()){
			ERRORBuffer.append("括号不匹配:缺少右括号;");
			error = false;
		}
		return error;
	}
	
	/**
	 * 判断操作符错误，有则返回false并记录错误信息
	 */
	public boolean OperatorError(){
		boolean error = true;
		if(this.Exception.matches("(.*)[\\*+-/][\\*+-/](.*)")){
			ERRORBuffer.append("运算符缺少操作数;");
			error = false;
		}
//		if( ! this.Exception.matches("(.*)[\\*+-/](.?)")){
//			ERRORBuffer.append("缺少运算符符:缺少+ - * /;");
//			error = false;
//		}
		return error;
	}

	/**
	 * 判断非法字符
	 * @return
	 */
	public boolean ErrorChar(){
		if(this.Exception.matches("(.*)[^\\*+-/0123456789\\(\\)](.*)")){
			ERRORBuffer.append("含有非法字符;");
			return false;
		}
		return true;
	}
}
