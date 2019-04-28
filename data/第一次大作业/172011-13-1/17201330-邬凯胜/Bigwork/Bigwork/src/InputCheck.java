
import java.util.regex.*;

public class InputCheck {
	private String str = ""; // 需要验证的字符串
	private boolean isTrue = true;
	private String error;

	// 传参构造方法，传入要验证的字符串
	public InputCheck(String newString) {
		str = newString;
		isTrue = true;
		error = "";
	}

	// 获得字符串str
	public String getStr() {
		return str;
	}

	// 获得isTrue的值
	public boolean getIsTrue() {
		return isTrue;
	}

	// 消去空格符
	public void cancelSpace() {
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			s1 += matcher.group();
		}
		str = s1;
	}

	// 判断是否有其他字符（除+，-，*，/，（，）外）
	public String judgeOtherChar() {
		String s = "[^0-9\\+\\-\\*\\/\\(\\)]";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			error = "ERROR\n表达式中含有不合法字符";
			isTrue = false;
		}
		return error;
	}

	// 判断运算符是否连续，运算符和括号两边是否正确
	public String judgeSymbol() {
		String[] s = { "[\\+\\-\\*\\/][\\+\\-\\*\\/]", "[^0-9\\)][\\+\\-\\*\\/]", "[\\+\\-\\*\\/][^0-9\\(]",
				"[0-9][\\(]", "[\\)][0-9]", "[\\(][\\)]" };
		for (int i = 0; i < s.length; i++) {
			Pattern pattern = Pattern.compile(s[i]);
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				error = "ERROR\n表达式中运算符或括号使用错误";
				isTrue = false;
			}
		}
		return error;
	}

	// 判断括号是否匹配
	public String judgeBracketNumber() {
		int bracketNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				bracketNum += 1;
			if (str.charAt(i) == ')')
				bracketNum += -1;
			if (bracketNum < 0) { // 右括号比左括号先出现
				error = "ERROR\n表达式中括号运用错误";
				isTrue = false;
			}
		}
		if (bracketNum != 0) { // 左右括号数量不等
			error = "ERROR\n表达式中括号运用错误";
			isTrue = false;
		}
		return error;
	}

	// 判断表达式首尾出现运算符并调整
	public String judgeStartAndEnd() {
		if (str.charAt(0) == '-' || str.charAt(0) == '+')
			str = "0" + str;
		else if (str.charAt(0) == '*' || str.charAt(0) == '/') {
			error = "ERROR\n表达式首运算符使用错误";
			isTrue = false;
		}
		if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-'
				|| str.charAt(str.length() - 1) == '*' || str.charAt(str.length() - 1) == '/') {
			error = "ERROR\n表达式尾运算符使用错误";
			isTrue = false;
		}
		return error;
	}

	// 所以判断操作集合
	public boolean judgeAll() {
		cancelSpace(); // 消去空格符
		judgeOtherChar(); // 判断是否有其他字符
		judgeSymbol(); // 判断运算符和括号的运用是否出错
		judgeStartAndEnd(); // 判断表达式首尾出现运算符并调整
		judgeBracketNumber(); // 判断括号的数量是否正确
		return isTrue;
	}
	
	public String getErrorMessage() {
		judgeOtherChar(); // 判断是否有其他字符
		judgeSymbol(); // 判断运算符和括号的运用是否出错
		judgeStartAndEnd(); // 判断表达式首尾出现运算符并调整
		judgeBracketNumber(); // 判断括号的数量是否正确
		return error;
	}
}
