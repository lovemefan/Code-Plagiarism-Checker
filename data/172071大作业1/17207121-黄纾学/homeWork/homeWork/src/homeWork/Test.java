package homeWork;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Test {

	// 构造方法

	public Test() {

	}

	// 检验算式是否合法

	// 字符串类型变量 存储着文件内容

	public int Test(String src) throws Exception {

		int effective = 0;

		if (src.length() <= 0) {// 判定字符串是否为空

			effective = 1;

			return effective;

		}

		else if (judge(src) != 0) {

			effective = judge(src);

			return effective;

		}

		else if (judge2(src) != 0) {

			effective = judge2(src);

			return effective;

		}

		return effective;

	}

	// 用正则表达式检验算式是否合法

	// 字符串类型变量 存储着文件内容

	public int judge(String src) {

		int effective;

		Pattern pattern = Pattern.compile("[\\+\\-\\*\\/]{2}");// 是否存在双运算符

		Matcher matcher = pattern.matcher(src);

		if (matcher.find()) {

			

			effective = 2;

			return effective;

		}

		pattern = Pattern.compile("[^0-9\\+\\.\\-\\*\\/\\(\\)]");// 是否存在除四则运算符、"."与数字之外的字符

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 3;

			return effective;

		}

		pattern = Pattern.compile("[\\+\\-\\*\\/]\\)");// 是否存在运算符与右括号相连

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 4;

			return effective;

		}

		pattern = Pattern.compile("\\([\\+\\*\\/]");// 是否存在除"-"以外的运算符与左括号相连

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 5;

			return effective;

		}

		pattern = Pattern.compile("\\(\\)");// 是否存在左右括号直接相连

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 6;

			return effective;

		}

		pattern = Pattern.compile("(^[\\-\\+\\*\\/])|([\\-\\+\\*\\/]$)");// 首部第一位或尾部最后一位为运算符

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 7;

			return effective;

		}
		
		pattern = Pattern.compile("(\\d\\()|(\\)\\d)");// 左括号前有数字或右括号后有数字

		matcher = pattern.matcher(src);

		if (matcher.find()) {

			effective = 6;

			return effective;

		}
		effective = 0;

		return effective;

	}

	// 检验算式是否合法

	// 字符串类型变量 存储着文件内容

	public int judge2(String src) {

		int effective = 0;

		int flag = 0;

		for (int j = 0; j < src.length(); j++) {// 检验左右括号是否合法

			char ch = src.charAt(j);

			if (ch == '(')

				flag++;

			if (ch == ')')

				flag--;

			if (flag < 0)

				break;

		}

		if (flag != 0) {

			effective = 6;

			return effective;

		}

		effective = 0;

		return effective;

	}

	// 替换错误算式

	// 字符串类型变量 存储着文件内容 int型变量 存储算式的错误类型

	public String replace(String src, int flag) {

		if (flag == 1) {

			src = "#为空字符";

		}

		else if (flag == 2) {

			src = "#存在双运算符";

		}

		else if (flag == 3) {

			src = "#存在非法字符";

		}

		else if (flag == 4) {

			src = "#存在运算符与右括号相连";

		}

		else if (flag == 5) {

			src = "#存在除'-'以外的运算符与左括号相连";

		}

		else if (flag == 6) {

			src = "#括号不合法";

		}

		else if (flag == 7) {

			src = "#首位或尾位存在运算符";

		}

		else if (flag == 8) {

			src = "#出现除数为0";

		}
		return src;

	}

}

