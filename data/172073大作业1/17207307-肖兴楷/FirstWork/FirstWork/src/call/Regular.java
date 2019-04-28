package call;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//该类利用正则表达时判断表达式是否合法
public class Regular {
	Regular() {

	}

	String RegularJudge(String s) {
		String i = null;
		// 以下为检测具体算式是否有误
		i = i + regularJudge1(s);// 判断是否输出error
		i = i + regularJudge2(s);// 判断是否有特殊字符，格式错误
		i = i + regularJudge3(s);// 判断是否是整型
		i = i + regularJudge4(s);// 判断表达式中是否含有中文括号
		i = i + regularJudge5(s);// 判断表达式开头或者结尾是否存在运算符号
		i = i + regularJudge6(s);// 判断表达式(后有运算符或者)前有运算符
		i = i + regularJudge7(s);// 出现了多次运算符，如：1--1，8*-4等
		i = i + regularJudge8(s);// 判断表达式(前是否有运算符或者)后是否有运算符
		i = i + regularJudge9(s);// 判断表达式括号数量是否匹配
		return i;
	}

	// 判断是否输出error
	String regularJudge1(String s) {
		boolean judge = false;
		if (!s.contains("(") || !s.contains(")")) {// 有括号和无括号为两种判别方法
			Pattern p = Pattern.compile("(\\d+)((\\+|\\-|\\*|\\/)(\\d+))*");
			Matcher m = p.matcher(s);
			judge = m.matches();
		} else {
			Pattern p = Pattern.compile(
					"((\\d*(\\+|\\-|\\*|\\/))*(\\(\\d+((\\+|\\-|\\/|\\*)(\\d+))*\\))*((\\+|\\-|\\*|\\/)\\d*)*)*");
			Matcher m = p.matcher(s);
			judge = m.matches();
		}
		String i = null;
		if (judge == false) {
			i = "\r\n#表达式不符合规范！";
			System.out.println("#表达式不符合规范！");
		}
		return i;
	}

	// 判断表达式中是否含有中文括号
	String regularJudge4(String s) {
		Pattern p = Pattern.compile("[\\uff08\\\uff09]+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#表达式中含有中文括号";
			System.out.println("#表达式中含有中文括号");
		}
		return i;
	}

	// 判断表达式括号数量是否匹配
	String regularJudge9(String s) {
		int bracketNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				bracketNum += 1;
			if (s.charAt(i) == ')')
				bracketNum += -1;
		}
		String add = null;
		if (bracketNum != 0) { // 左右括号数量不等
			add = "\r\n#表达式中括号运用错误";
			System.out.println("#表达式中括号运用错误");
		}
		return add;
	}

	// 判断表达式(前是否有运算符或者)后是否有运算符
	String regularJudge8(String s) {
		Pattern p = Pattern.compile(".*\\d+\\(.*|.*\\)\\d+.*");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			System.out.println("#表达式(前没有运算符或者)后没有运算符");
			i = "\r\n#表达式(前没有运算符或者)后没有运算符";
		}
		return i;
	}

	// 出现了多次运算符，如：1--1，8*-4等
	String regularJudge7(String s) {
		Pattern p = Pattern.compile("(\\+|\\-|\\/|\\*){2,}");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			System.out.println("#运算符连续");
			i = "\r\n#运算符连续";
		}
		return i;
	}

	// 判断表达式(后有运算符或者)前有运算符
	String regularJudge6(String s) {
		Pattern p = Pattern.compile("\\((\\+|\\-|\\/|\\*).+|.+(\\+|\\-|\\/|\\*)\\)");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#表达式(后有运算符或者)前有运算符";
			System.out.println("#表达式(后有运算符或者)前有运算符");
		}
		return i;
	}

	String regularJudge3(String s) {
		Pattern p = Pattern.compile("\\d+\\.\\d+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#表达式中出现了小数点，应输入整型";
			System.out.println("#表达式中出现了小数点，应输入整型");
		}
		return i;
	}

	// 判断表达式开头或者结尾是否存在运算符号
	String regularJudge5(String s) {
		Pattern p = Pattern.compile("^(\\+|\\-|\\/|\\*).+|.+(\\+|\\-|\\/|\\*)$");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.matches()) {
			i = "\r\n#表达式开头或者结尾存在运算符号";
			System.out.println("#表达式开头或者结尾存在运算符号");
		}
		return i;
	}

	// 判断是否有特殊字符，格式错误
	String regularJudge2(String s) {
		Pattern p = Pattern.compile("[^\\d\\(\\)\\-\\+\\*\\/]+");
		Matcher m = p.matcher(s);
		String i = null;
		if (m.find()) {
			i = "\r\n#表达式包含非法字符";
			System.out.println("#表达式包含非法字符");
		}
		return i;
	}
}