import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 校验类，检查表达式的合法性
public class Check {
	// 表达式
	private String expression;
	// 错误信息
	private String error;
	// 表达式正确性true正确，false错误
	private boolean legal;
	// 正则表达式
	private String[] regex = { "^$", "\\(\\)", "[\\+\\-\\*\\/]{2,}", "[^0-9\\+\\-\\*\\/\\(\\)]",
			"\\([\\*\\/]", "\\d\\(", "\\)\\d", "[\\+\\-\\*\\/]\\)", "[\\+\\-\\*\\/]$|^[\\*\\/]" };
	//错误信息
	private String[] errorInformation = { "空行","空括号", "运算符连续", "含有非法字符", "左括号后乘除运算符", 
			                              "左括号前数字", "右括号后数字", "右括号前运算符", "首尾符号非法" };
	Pattern pattern;
	
	public Check(){
		
	}

	public Check(String str) {
		expression = str;
		legal = true;
		process();
	}

	// 过滤空白符
	private void filterSpace() {
		expression = expression.replaceAll("\\s", "");
	}

	// 括号个数是否匹配
	private void legalOfBrackets() {
		pattern = Pattern.compile("[\\(\\)]");
		Matcher matcher = pattern.matcher(expression);
		String tmp = "";
		// 括号序列
		while (matcher.find()) {
			tmp += matcher.group();
		}
		// 括号消消乐
		while(tmp.contains("()")){
			tmp = tmp.replaceAll("\\(\\)", "");
		}
		if (tmp.equals("") == false) {
			legal = false;
			error = "括号不匹配";
		}
	}

	// 检查字符串
	public void process() {
		// 过滤空白符
		filterSpace();
		// 括号个数校验
		legalOfBrackets();
		// 检查表达式的正确性
		for (int i = 0; i < regex.length && legal; ++i) {
			pattern = Pattern.compile(regex[i]);
			Matcher matcher = pattern.matcher(expression);
			if (matcher.find()) {
				legal = false;
				error = errorInformation[i];
			}
		}
	}

	// 将负数转为0-正数的形式
	private void transform() {
		expression = expression.replaceAll("\\(\\-", "(0-");
		expression = expression.replaceAll("\\(\\+", "(0+");
		expression = expression.replaceAll("^\\+", "0+");
		expression = expression.replaceAll("^\\-", "0-");
	}

	// 转为中缀
	public ArrayList<String> toInfix() {
		transform();
		ArrayList<String> str = new ArrayList<>();
		pattern = Pattern.compile("[\\+\\-\\*\\/\\(\\)]|\\d+");
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) {
			str.add(matcher.group());
		}
		return str;
	}

	//获取表达式
	public String getExpression() {
		return expression;
	}

	//获取错误信息
	public String getError() {
		return error;
	}

	//获取表达式是否合法
	public boolean getLegal() {
		return legal;
	}

	//设置表达式是否合法
	public void setLegal(boolean legal) {
		this.legal = legal;
	}
	
	//设置错误信息
	public void setError(String error) {
		this.error = error;
	}
}
