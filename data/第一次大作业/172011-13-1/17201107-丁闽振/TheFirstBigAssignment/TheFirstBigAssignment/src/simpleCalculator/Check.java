package simpleCalculator;

import java.util.regex.*;

public class Check {
	private String string;//用来存储错误的表达式

	Check() {

	}
//利用正则表达式来判断表达式是否输入正确
	public boolean check(String string) {
		Pattern p = Pattern.compile("\\(\\)");
		Matcher m = p.matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#空括号！！！";
			return false;
		}
		m = Pattern.compile("[\\+-/\\*]{2,}").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#含有连续的运算符！！！";
			return false;
		}
		m = Pattern.compile("\\d\\(").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\"(\"左边直接与数字相连,它们之间缺少操作符！！！";
			return false;
		}
		m = Pattern.compile("\\)\\d").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\")\"右边直接与数字相连,它们之间缺少操作符！！！";
			return false;
		}
		m = Pattern.compile("[-\\+/\\*]\\)|\\([-\\+/\\*]").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#\"(\"右边不能直接与操作符相连,\")\"左边不能直接与操作符相连！！！";
			return false;
		}
		m = Pattern.compile("[^\\d\\+\\-\\*\\/\\(\\)]").matcher(string);
		if (m.find()) {
			this.string = string + "\nERROR\n#表达式中含有非法字符！！！";
			return false;
		}
		this.string = string;
		return true;
	}
//返回错误表达式
	public String getExpression() {
		return string;
	}

}
