import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 表达式合法性校验类
public class CheckExpression {
	private String errorMessage;// 返回的错误信息
	private String expression;// 需要检查的字符串

	// 访问器expression
	public String getExpression() {
		return expression;
	}

	// 无参构造方法
	public CheckExpression() {
		expression = "";
		errorMessage = "";
	}

	// 有参构造方法
	public CheckExpression(String str) {// 参数为要检查的字符串序列的构造方法
		expression = str;
	}

	// 检查是否有无关字符
	private void checkIlegalChar() {
		if (expression.length() == 0) {// 表达式为空串
			errorMessage = "ERROR"  + "\r\n" + "#表达式为空!";
			return;
		}

		// 正则表达式匹配空白符\\s、数字、加、减、乘、除以外的字符
		String regexError = "[^0-9\\(\\)\\+\\-\\*\\/\\s]";
		Pattern pattern = Pattern.compile(regexError);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {// 含有无关字符
			errorMessage = "ERROR"  + "\r\n" + "#表达式包含非法字符!";
			return;
		}
	}

	// 过滤空白符
	public String trimSpace() {
		String str = null;
		str = expression.replaceAll("\\s", "");
		return str;
	}

	// 求子串（son）在字符串（father）中出现的次数
	private static int extractCount(String father, String son) {
		int count = 0;
		Pattern p = Pattern.compile(son, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(father);

		while (m.find()) {
			count++;
		}
		return count;
	}

	// 检查括号数量是否匹配
	private void checkBracketMatch() {
		if (extractCount(expression, "\\(") != extractCount(expression, "\\)"))
			errorMessage = "ERROR"  + "\r\n" + "#括号不匹配!";
		return;

	}

	// 检查是否有空括号
	private void checkEmptyBracket() {
		if (extractCount(expression, "\\(\\)") > 0) {
			errorMessage = "ERROR"  + "\r\n" + "#表达式中有空括号!";
		}
	}

	// 检查运算符连续
	private void checkSymbolDuplicate() {
		String regex = "[\\+\\-\\*\\/]{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#运算符连续！";
		}
	}

	// 检查行首行尾是否有运算符
	private void checkHeadAndTail() {
		String regex = "^[\\*\\/\\+]|[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#The head and the tail of the expression is illegal!";
		}
	}

	// 检查操作数是否合法
	private void checkOperand() {
		String regex = "\\([\\*\\/]|[\\*\\/\\+\\-]\\)|\\d\\(|\\)\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(expression);

		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#运算符无效!";
		}
	}

	// 检查多个0开头的运算数，如0005，00000
	private void checkZerosStart() {
		String regex = "0\\d+";// 匹配多个零情况
		Pattern pattern = Pattern.compile(regex);// 创建Pattern 对象
		Matcher matcher = pattern.matcher(expression);// 创建Matcher 对象
		if (matcher.find()) {
			errorMessage = "ERROR"  + "\r\n" + "#Invalid Operand！";
		}
	}

	// 检查表达式字符串，将所有子操作合并为一个操作
	public void checkExpression() {
		trimSpace();			//去除所有空格
		checkIlegalChar();		//无效字符检测
		checkBracketMatch();	//括号数量匹配检测
		checkEmptyBracket();	//空括号检测
		checkSymbolDuplicate();	//连续运算符检测
		checkHeadAndTail();		//表达式头尾错误检测
		checkOperand();			//运算数错误检测
		checkZerosStart();		//0开头的数值检测
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}