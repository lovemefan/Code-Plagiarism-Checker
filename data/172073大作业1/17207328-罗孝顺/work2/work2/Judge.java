package work2;
import java.util.regex.*;

//判断不满足计算表达式格式，如果不满足则返回true，反之返回false
public class Judge {

	private String str; // 需要验证的表达式
	private boolean b; // 表达式是否错误
	
	public Judge(String str) {
		this.str = str;
		this.b = true;
	}
	public String getExpression() {
		return str;
	}
	public boolean getb() {
		return b;
	}
	//运算符前无运算数
	public boolean error0() {
		String string = "^[+-/*].*|.*\\([+-/*].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配是否有其他字符
	public boolean error1() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";	
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配是否有空括号
	public boolean error2() {
		String string = ".*\\(\\).*";		
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {		
			b = false;
		}
		return b;
	}

	// 匹配是否有两个连在一起的运算符
	public boolean error3() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式是否以运算符开头
	public boolean error4() {
		String string = "^[\\+\\-\\*\\/\\)]";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中左括号后有运算符
	public boolean error5() {
		String string = ".*\\([\\+\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中右括号前有运算符
	public boolean error6() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中左括号前不是运算符
	public boolean error7() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配表达式中右括号后不是运算符
	public boolean error8() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}
	
	// 匹配表达式以运算符结束
	public boolean error9() {
		String string = "[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// 匹配括号个数，如果对则返回false，反之返回true
	public boolean error10() {
		int num1 = 0; // 记录(的个数
		int num2 = 0; // 记录)的个数
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			b = false;
		}
		return b;
	}		
	
}