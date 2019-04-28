import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 筛选类,检查表达式的正确性
public class Filter {
	private String errorString;// 错误信息

	private String finalString;// 需要检查的字符串

	private String regularString;// 规范的表达式

	private boolean isLegal;// 表达式是否合法

	public boolean getIsLegal() {// 访问器isLegal
		return isLegal;
	}

	public String getFinalString() {// 访问器FinalString
		return finalString;
	}

	public Filter() {// 无参构造
		finalString = "";
		setRegularString("");
		isLegal = true;
		errorString = "";
	}

	public Filter(String str) {// 参数为要检查的字符串序列的构造方法
		finalString = str;
		setRegularString("");
		isLegal = true;
	}

	private void checkIlegalCharacter() {// 检查是否有无关字符
		if (isLegal == false) {// 检查是否合法
			return;
		}
		if (finalString.length() == 0) {// 序列为空串
			errorString = "ERROR\n#The expression is empty";
			isLegal = false;
			return;
		}

		// 正则表达式匹配空白符（包括制表符，空格，翻页符等）、数字、加、减、乘、除以外的字符
		String regexError = "[^0-9\\(\\)\\+\\-\\*\\/\\s]";
		Pattern pattern = Pattern.compile(regexError);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// 含有无关字符
			errorString = "ERROR\n#The expression contains illegal characters";
			isLegal = false;
			return;
		}
	}

	private void filterSpace() {// 过滤空白符
		if (isLegal == false) {// 检查是否合法
			return;
		}
		String s = "";// 初始化字符串，该字符串用来保存过滤后的字符串

		// 正则表达式匹配空白符
		String regexSpace = "[^\\s]";
		Pattern pattern = Pattern.compile(regexSpace);
		Matcher matcher = pattern.matcher(finalString);

		while (matcher.find()) {// 查找下一个匹配的子序列
			s += matcher.group();
		}
		finalString = s;// 返回处理后的字符串
	}

	private void checkBracket() {// 检查括号是否匹配
		if (isLegal == false) {// 检查是否合法
			return;
		}
		int bracketCnt = 0;// 记录需匹配左括号个数
		for (int i = 0; i < finalString.length(); ++i) {// 查找每个括号
			if (finalString.charAt(i) == '(') {// 左括号个数加1
				++bracketCnt;
			}
			if (finalString.charAt(i) == ')') {// 右括号个数减1
				--bracketCnt;
			}
			if (bracketCnt < 0) {// 右括比左括号多，不合法
				isLegal = false;
				errorString = "ERROR\n#Bracket mismatch";
				return;
			}
		}
		if (bracketCnt != 0) {// 左括号比右括号多，不合法
			isLegal = false;
			errorString = "ERROR\n#Bracket mismatch";
		}
	}

	private void checkEmptyBracket() {// 检查是否有空括号
		if (isLegal == false) {// 检查是否合法
			return;
		}
		// 正则表达式匹配一对空括号
		String regexEmptySpace = "(\\(\\))";
		Pattern pattern = Pattern.compile(regexEmptySpace);
		Matcher matcher = pattern.matcher(finalString);
		if (matcher.find()) {// 查找序列
			isLegal = false;
			errorString = "ERROR\n#The expression contains a pair of empty bracket";
		}
	}

	private void checksSigns() {// 检查符号连续
		if (isLegal == false) {// 检查是否合法
			return;
		}

		// 匹配乘号或除号是否合法
		String regex = "[\\+\\-\\*\\/]{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// 查找子序列
			errorString = "ERROR\n#The expression contains a continuous operational symbol";
			isLegal = false;
		}
	}

	private void checkLine() {// 检查行首行尾是否有运算符
		if (isLegal == false) {// 检查是否合法
			return;
		}

		// 匹配行首和行尾
		String regex = "^[\\*\\/]|[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// 查找序列
			errorString = "ERROR\n#The first or last character of the expression is illegal";
			isLegal = false;
		}
	}

	private void checkTwoSides() {// 检查运算符两侧是否合法
		if (isLegal == false) {// 检查是否合法
			return;
		}

		// 匹配运算符两侧
		String regex = "\\([\\*\\/]|[\\*\\/\\+\\-]\\)|\\d\\(|\\)\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(finalString);

		if (matcher.find()) {// 查找序列
			errorString = "ERROR\n#The operator is illegal";
			isLegal = false;
		}
	}

	private void completeNum() {// 正数或负数补一个0在前面，让表达式符合运算规则
		if (isLegal == false)// 检查是否合法
			return;
		String regex = "^[\\+\\-][\\d|\\(]";// 匹配行首正负数
		Pattern pattern = Pattern.compile(regex);// 创建Pattern 对象
		Matcher matcher = pattern.matcher(finalString);// 创建Matcher 对象
		int i = 0;// 记录字符串的位置
		if (matcher.find()) {// 如果第一个数是正数或负数且不带括号就在前面补一个0
			for (; i < matcher.start(); ++i) {
				setRegularString(getRegularString() + finalString.charAt(i));
			}
			setRegularString(getRegularString() + "0");
		}
		regex = "\\([\\+\\-]";// 匹配左括号之后的正负数
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(finalString);
		while (matcher.find()) {// 不断查找子序列
			for (; i < matcher.start() + 1; ++i) {// 将正负数之前的字符拷贝进新字符串
				setRegularString(getRegularString() + finalString.charAt(i));
			}
			setRegularString(getRegularString() + "0");// 正负数前填上一个0
		}
		for (; i < finalString.length(); ++i) {// 将剩余字符拷贝进新字符串
			setRegularString(getRegularString() + finalString.charAt(i));
		}
	}

	/*
	 * private void checkZeros() {// 检查多个0开头，如012，00 if (isLegal == false)//
	 * 检查是否合法 return; String regex = "0\\d+";// 匹配多个零情况 Pattern pattern =
	 * Pattern.compile(regex);// 创建Pattern 对象 Matcher matcher =
	 * pattern.matcher(finalString);// 创建Matcher 对象 if (matcher.find()) {// 查找序列
	 * isLegal = false; errorString = "ERROR#\nInvalid token"; } }
	 */

	private void checkString() {// 检查字符序列，将所有子操作合并为整个操作
		filterSpace();// 过滤空白符

		checkIlegalCharacter();// 检查是否有无关字符

		checkBracket();// 检查括号是否匹配

		checkEmptyBracket();// 检查是否有空括号

		checkLine();// 检表达式首行尾是否合法

		checksSigns();// 检查运算符是否连续

		checkTwoSides();// 检查"("左有数字和")"有数字，")"左有运算符

		completeNum();// 规范表达式
	}

	public LinkStack linkedExp() {// 如果合法返回一个中缀表达式，否则为空
		checkString();// 先检查序列是否合法
		LinkStack exp = new LinkStack();// 创建一个链表用来存储标准的中缀表达式
		if (isLegal == false)// 如果表达式不符合要求则返回空
			return exp;

		// 将表达式中的数字和字符拆分出来
		String regex = "[\\+\\-\\*\\/\\(\\)]|\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(regularString);
		while (matcher.find()) {// 不断查找序列
			exp.addNode(new Node(matcher.group()));
		}

		return exp;// 返回中缀表达式
	}

	public String getRegularString() {
		return regularString;
	}

	public void setRegularString(String regularString) {
		this.regularString = regularString;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
}