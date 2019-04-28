import java.util.regex.Matcher;
import java.util.regex.Pattern;

//输入校验类
public class Check {
	private String s;// 表达式
	private String[] str;// 表达式数组
	private String s1;
	
	public Check() {// 构造函数

	}

	public Check(String[] str) {// 构造函数
		this.str = str;
	}

	public String get(){//返回错误信息
		return s1;
	}
	
	public Check(String s) {// 构造函数
		this.s = s;
	}

	private boolean test1() {// 如果表达式为“()”
		Pattern p = Pattern.compile("\\(\\)");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "空括号";
			return false;
		}
		return true;
	}

	private boolean test0() {// 如果表达式为空
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "空字符串";
			return false;
		}
		return true;
	}
	
	private boolean test2() {// 如果表达式中运算符连续
		Pattern p = Pattern.compile("[\\+\\-\\*\\/]+[\\+\\-\\*\\/]+");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "运算符连续";
			return false;
		}
		return true;
	}
    
	private boolean test3() {// 如果表达式中左括号后面是运算符且不是"(-1)"
		Pattern p = Pattern.compile("\\([\\-]\\d+[^\\)]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "左括号后是运算符";
			return false;
		}
		return true;
	}
    
	private boolean test4() {// 如果表达式中运算符后面是右括号
		Pattern p = Pattern.compile("[\\+\\-\\*\\/]\\)");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "运算符后面是右括号";
			return false;
		}
		return true;
	}
    
	private boolean test5() {// 如果表达式中运算符前面左括号
		Pattern p = Pattern.compile("\\([\\+\\*\\/]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "左括号后是运算符";
			return false;
		}
		return true;
	}
	
	private boolean test6() {// 如果表达式以运算符或右括号开始
		Pattern p = Pattern.compile("^[\\+\\-\\*\\/\\)]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "开头符号错误";
			return false;
		}
		return true;
	}
    
	private boolean test7() {// 以运算符或左括号结束
		Pattern p = Pattern.compile("[\\+\\-\\*\\/\\(]$");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "结尾符号错误";
			return false;
		}
		return true;
	}
	private boolean test8() {// 如果表达式括号不匹配
		int count1 = 0;
		int count2 = 0;
		Pattern p = Pattern.compile("\\(", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(s);
		while (m.find()) {
			count1++;
		}
		Pattern p1 = Pattern.compile("\\)", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(s);
		while (m1.find()) {
			count2++;
		}
		if (count1 != count2) {
			s1 = "括号不匹配";
			return false;
		}
			return true;
	}
    
	private boolean test9() {// 如果表达式含大小写字母
		Pattern p = Pattern.compile("[A-Za-z]");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "表达式含非法字符";
			return false;
		}
		return true;
	}
    
	private boolean test10() {// 如果表达式除数是0
		Pattern p = Pattern.compile("[\\/]0");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "除号后面不能为零";
			return false;
		}
		return true;
	}
	
	private boolean test11() {// 如果表达式数字后面是左括号
		Pattern p = Pattern.compile("\\d+\\(");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "数字后面是左括号";
			return false;
		}
		return true;
	}
	
	private boolean test12() {// 如果表达式右括号后面是数字
		Pattern p = Pattern.compile("\\)\\d+");
		Matcher m = p.matcher(s);
		if(m.find()) {
			s1 = "右括号后是数字";
			return false;
		}
		return true;
	}

	public boolean testa() {// 判断表达式是否合法
		if (!test0() || !test1() || !test2() || !test3() || !test4() || !test5()) {
			return false;
		}
		return true;
	}

	public boolean testb() {// 判断表达式是否合法
		if (!test6() || !test7() || !test8() || !test9() || !test10() || !test11() || !test12()) {
			return false;
		}
		return true;
	}
	
	public boolean test() {// 判断表达式是否合法
		if(testa() && testb()){
			return true;
		}
		return false;
	}
	
	public String[] test00() {// 删除重复的表达式
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equals(str[j])) {
					str = delete(str, j);
					j--;
				}
			}
		}
		return str;
	}

	private String[] delete(String[] s, int x) {// 实现删除数组元素
		String[] arrNew = new String[s.length - 1];
		for (int i = x; i < s.length - 1; i++) {
			arrNew[i] = s[i + 1];
		}
		for (int i = 0; i < x; i++) {
			arrNew[i] = s[i];
		}
		return arrNew;
	}
}
