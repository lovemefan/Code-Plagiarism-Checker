package greatproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	String s;
	Pattern p;
	Matcher m;

	public Check(String s) {
		this.s = s;
	}

	public String judge() {
		// 判断空字符串
		if (s.equals("")) {
			return "空字符串";
		}
		// 检查是否有空格,一定要放在开头，要不然下面会把空格当成位置字符
		p = Pattern.compile("\\s+");
		m = p.matcher(s);
		if (m.find()) {
			return "空格";
		}

		// 判断第一个字符是否为数字或者左括号
		p = Pattern.compile("[\\d\\(]");// 匹配开头或者结尾时，d后面不用+
		m = p.matcher(s);
		if (m.lookingAt() == false) {
			if (s.matches("\\-\\d+.*") == false) {
				return "以非法字符开头";
			}
		}
		// 判断最后一个字符是否为数字或者右括号
		p = Pattern.compile("[\\d\\)]$");// $表示行结尾 ^表示行开头
		m = p.matcher(s);
		if (m.find() == false) {
			return "以非法字符结尾";
		}
		// 与字符运算符相关的方法
		if (!this.chara().equals("无错误")) {
			return this.chara();
		}

		// 与判断括号相关的方法
		if (!this.paren().equals("无错误")) {
			return this.paren();
		}

		// 判断(后面是运算符
		p = Pattern.compile("\\([\\+\\*\\/]");
		m = p.matcher(s);
		if (m.find()) {
			return "(后面是运算符";
		}
		// 判断负号格式错误
		p = Pattern.compile("\\(\\-\\d++(?!\\))");// \\d+不能代表多个数字,??
		// 为什么需要写两个加号？？？？？？
		m = p.matcher(s);
		if (m.find()) {
			return "负号格式错误";
		}
		return "无错误";
	}

	private String paren() {
		// 判断空括号
		p = Pattern.compile("\\(\\)");
		m = p.matcher(s);
		if (m.find()) {
			return "空括号";
		}
		// 判断(前面不为运算符,)前面是运算符,)后面不能为数字
		p = Pattern.compile("\\d\\(");
		m = p.matcher(s);
		if (m.find()) {
			return "'('前面不是运算符";
		}
		p = Pattern.compile("[\\+\\-\\*\\/]\\)");
		m = p.matcher(s);
		if (m.find()) {
			return "')'前面是运算符";
		}
		p = Pattern.compile("\\)\\d");
		m = p.matcher(s);
		if (m.find()) {
			return "')'后面不能为数字";
		}

		// 括号匹配
		p = Pattern.compile("\\(");
		m = p.matcher(s);
		int l = 0;
		while (m.find()) {
			l++;
		}
		p = Pattern.compile("\\)");
		m = p.matcher(s);
		int r = 0;
		while (m.find()) {
			r++;
		}
		if (l != r) {
			return "括号不匹配";
		}
		return "无错误";
	}

	private String chara() {
		// 匹配是否出现其他字符
		p = Pattern.compile("[^\\+\\-\\*\\/\\(\\)\\d]");// [^abc]
														// 除了a，b，c以外的字符都匹配
		m = p.matcher(s);
		if (m.find()) {
			return "出现其他字符";
		}
		// 判断数字是否书写正确
		p = Pattern.compile("\\d{2,}");
		m = p.matcher(s);
		while (m.find()) {
			if (m.group().matches("0.*")) {
				return "数字格式书写错误";
			}
		}
		// 判断运算符连续
		p = Pattern.compile("[\\+\\-\\*\\/]{2,}");
		m = p.matcher(s);
		if (m.find()) {
			return "运算符连续";
		}
		// 判断分母不能为0
		p = Pattern.compile("\\/0");
		m = p.matcher(s);
		if (m.find()) {
			return "分母不能为0";
		}

		return "无错误";
	}

}
