
import java.util.regex.*;

//判断不满足计算表达式格式，如果不满足则返回true，反之返回false
public class Regex {

	private String expression; // 需要验证的表达式
	private boolean isTrue; // 表达式是否错误
	private String eM; // 表达式错误信息

	// 空构造方法
	public Regex() {

	}

	// 带参构造方法,参数是表达式
	public Regex(String expression) {
		this.expression = expression;
		isTrue = true;
		eM = "";
	}

	// 表达式访问器
	public String getExpression() {
		return expression;
	}

	// isTrue的访问器
	public boolean getIsTrue() {
		return isTrue;
	}

	// 错误信息访问器
	public String getErrorMessage() {
		eM += judgeOtherChar();
		eM += judgeEmpty();
		eM += judgeTwoSymbol();
		eM += judgeStartSymbol();
		eM += judgeSymbolAfterLeft();
		eM += judgeSymbolBeforeRight();
		eM += judgeSymbolNotBeforeLeft();
		eM += judgeSymbolNotAfterRight();
		eM += judgeEndOfSymbol();
		eM += judgeParentheses();
		return eM;
	}

	// 消去空格符
	public String cancelSpace() {
		String string = "[^\\s]";
		// s1用于记住去除空格后的表达式
		String s1 = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			s1 += matcher.group();
		}
		expression = s1;
		return expression;
	}

	// 匹配是否有其他除+,-,*,/,(,)外的字符
	public String judgeOtherChar() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中含有不合法字符\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配空括号
	public String judgeEmpty() {
		String string = ".*\\(\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中含有空括号\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配两个运算符号连在一起
	public String judgeTwoSymbol() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中有两个运算符号连在一起\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式以运算符开头，+,-除外 边界匹配器^:一行的开头
	public String judgeStartSymbol() {
		String string = "^[\\*\\/\\)]";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式以+，*，/运算符开头\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式中左括号后有运算符
	public String judgeSymbolAfterLeft() {
		String string = ".*\\([\\+\\*\\/].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中左括号后有运算符\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式中右括号前有运算符
	public String judgeSymbolBeforeRight() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中右括号前有运算符\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式中左括号前不是运算符
	public String judgeSymbolNotBeforeLeft() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中左括号前不是运算符\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式中右括号后不是运算符
	public String judgeSymbolNotAfterRight() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式中右括号后不是运算符\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配表达式以运算符结束
	public String judgeEndOfSymbol() {
		String string = "[\\+\\-\\*\\/]$";
		String errorMessage = "";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(expression);
		if (matcher.find()) {
			errorMessage = "#表达式以运算符结束\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 匹配括号个数，如果对则返回false，反之返回true
	public String judgeParentheses() {
		String errorMessage = "";
		int num1 = 0; // 记录(的个数
		int num2 = 0; // 记录)的个数
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			errorMessage = "#表达式括号对不匹配\r\n";
			isTrue = false;
		}
		return errorMessage;
	}

	// 所有判断操作集合
	public boolean judgeAll() {
		cancelSpace();
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
		return isTrue;
	}
}
