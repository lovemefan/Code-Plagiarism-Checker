package Calculator01;
import java.util.regex.*;
public class Regular {

	private String exp; // 需要验证的表达式
	private boolean sfTrue; // 表达式是否错误
	private String eMe; // 表达式错误信息

	public  Regular(String exp) 
	{// 带参构造方法,参数是表达式
		this.exp=exp;
		sfTrue=true;
		eMe= "";
	}

	
	public String getExpression() 
	{// 表达式访问
		return exp;
	}

	
	public boolean getIsTrue() 
	{// 是否正确
		return sfTrue;
	}

	
	public String getErrorMessage() {
		// 错误信息访问
		eMe+= judgeEmptyexp();
		eMe+= judgeOtherChar();
		eMe+= judgeEmpty();
		eMe+= judgeTwoSymbol();
		eMe+= judgeStartSymbol();
		eMe+= judgeSymbolAfterLeft();
		eMe+= judgeSymbolBeforeRight();
		eMe+= judgeSymbolNotBeforeLeft();
		eMe+= judgeSymbolNotAfterRight();
		eMe+= judgeEndOfSymbol();
		eMe+= judgeParentheses();
		return eMe;
	}

	
	public String cancelSpace() {// 消去空格符
		String string = "[^\\s]";
		// s1用于记住去除空格后的表达式
		String s1 = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		while (matcher.find()) {
			s1 += matcher.group();
		}
		exp=s1;
		return exp;
	}
	public String judgeEmptyexp() {//判断是否为空的表达式
		/*String string ="\\s*|\t|\r|\n";
		String errorMessage="";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage="#表达式为空\r\n";
			sfTrue = false;
		}*/
		String errorMessage="";
		if(exp.length()==0)
		{
			errorMessage="#表达式为空\r\n";
			sfTrue = false;
		}
		return errorMessage;
		
		

	}
	
	
	public String judgeOtherChar() {// 匹配是否有其他除+,-,*,/,(,)外的字符
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";
		String errorMessage="";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage="#表达式中含有非法字符\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeEmpty() {// 匹配空括号
		String string = ".*\\(\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#表达式中含有空括号\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}


	public String judgeTwoSymbol() {	// 匹配两个运算符号连在一起
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#运算符连续\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeStartSymbol() {// 匹配表达式以运算符开头-除外 
		String string = "^[\\*\\/\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#运算符前无运算数\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolAfterLeft() {// 匹配表达式中左括号后有运算符-除外
		String string = ".*\\([\\+\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#运算符前无运算数\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolBeforeRight() {// 匹配表达式中右括号前有运算符
		String string = ".*[\\+\\-\\*\\/]\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#运算符后无运算数\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolNotBeforeLeft() {// 匹配表达式中左括号前不是运算符
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#括号非第一个字符且之前无运算数 \r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeSymbolNotAfterRight() {// 匹配表达式中右括号后不是运算符
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#小括号后无运算数，括号非最后一个字符\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeEndOfSymbol() {// 匹配表达式以运算符结束
		String string = "[\\+\\-\\*\\/]$";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(exp);
		if (matcher.find()) {
			errorMessage = "#运算符后无运算数\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	
	public String judgeParentheses() {// 匹配括号个数，如果对则返回false，反之返回true
		String errorMessage = "";
		int num1 = 0; // 记录(的个数
		int num2 = 0; // 记录)的个数
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			errorMessage = "#括号不匹配\r\n";
			sfTrue = false;
		}
		return errorMessage;
	}

	// 所有判断操作集合
	public boolean judgeAll() {
		cancelSpace();
		judgeEmptyexp();
		judgeOtherChar();
		judgeEmpty();
		judgeTwoSymbol();
		judgeStartSymbol();
		judgeSymbolAfterLeft();
		judgeSymbolBeforeRight();
		judgeSymbolNotBeforeLeft();
		judgeSymbolNotAfterRight();
		judgeEndOfSymbol();
		judgeParentheses();
		return sfTrue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
