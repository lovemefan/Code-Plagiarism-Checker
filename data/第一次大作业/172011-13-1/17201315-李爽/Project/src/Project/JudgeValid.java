package Project;

import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.*;

public class JudgeValid {
	// 构造方法
	public JudgeValid() {

	}

	// 判断
	public int judge(String infix) {
		int flag = 0;
		if (judge1(infix)) {
			flag = 1;
		} else if (!judge2(infix)) {
			flag = 2;
		} else if (judge3(infix)) {
			flag = 3;
		} else if (judge4(infix)) {
			flag = 4;
		} else if (judge5(infix)) {
		flag = 5;
		}else if (judge6(infix)) {
			flag = 6;
		}else if (judge7(infix)) {
			flag = 7;
		}else if (judge8(infix)) {
			flag = 8;
		}
		return flag;
	}

	// 判断()中是否有其他字符
	public static boolean judge1(String s) {
		boolean f = false;
		String sub1 = "[^0-9\\*\\+\\-\\//\\(\\)\\.]";
		Pattern p1 = Pattern.compile(sub1);
		Matcher m1 = p1.matcher(s);// 创建matcher类的对象 m

		if (m1.find())
			f = true;
		return f;
	}

	// 判断是否括号不匹配
	public static boolean judge2(String s) {
		int top = 0;// 计数，左括号 1，右括号 -1，最后总和0则匹配
		boolean end = true;// true 表示匹配

		char[] biao = s.toCharArray();// 将字符串转化成字符数组
		for (int i = 0; i < biao.length; i++) {
			// 如果是(则加1，进栈
			if (biao[i] == '(') {
				top++;
			} else if (biao[i] == ')') {// 如果是)
				top--;
			}
			if (top < 0){
				end = false;
				break;
			}
		}
		if (top != 0)
			end = false;
		return end;
	}

	// 判断空括号
	public static boolean judge3(String s) {
		boolean f = false;
		String sub = "[\\(][\\)]";
		// 创建Pattern类的对象
		Pattern pat = Pattern.compile(sub);
		// 创建matcher类的对象
		Matcher mat = pat.matcher(s);
		if ( mat.find()) {
			f = true;
		}
		return f;
	}
	
	// 判断是否表达式首尾有没有运算符
	public static boolean judge4(String s) {
		boolean f = false;
		String sub = "^[\\+\\*\\/]|[\\+\\-\\*\\/]$";
		// 创建Pattern类的对象
		Pattern pat = Pattern.compile(sub);
		// 创建matcher类的对象
		Matcher mat = pat.matcher(s);
		if (mat.find()) {
			f = true;
		}
		return f;
	}
	
	// 判断是否表达式存在括号接数字
	public static boolean judge5(String s) {
		boolean f = false;
		String sub = "[\\d]{1,10}[\\(]|[\\)][\\d]{1,10}";
		// 创建Pattern类的对象
		Pattern pat = Pattern.compile(sub);
		// 创建matcher类的对象
		Matcher mat = pat.matcher(s);
		if ( mat.find() ) {
			f = true;
		}
		return f;
	}
	
	// 判断是否表达式存在括号接运算符或)(之间没有运算符
		public static boolean judge6(String s) {
			boolean f = false;
			String sub = "[\\(][\\+\\*\\/]|[\\+\\-\\*\\/][\\)]|[\\)\\(]";
			// 创建Pattern类的对象
			Pattern pat = Pattern.compile(sub);
			// 创建matcher类的对象
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
		
		// 判断是否表达式存在运算符连续
		public static boolean judge7(String s) {
			boolean f = false;
			String sub = "[\\+\\-\\*\\/]{2}";
			// 创建Pattern类的对象
			Pattern pat = Pattern.compile(sub);
			// 创建matcher类的对象
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
		
		// 判断负数表达 规范
		public static boolean judge8(String s) {
			boolean f = false;
			String sub = "[\\(][\\-][\\d]{1,10}[\\+\\-\\*\\/]|[\\-][\\(][\\d]{1,10}[\\)]";
			// 创建Pattern类的对象
			Pattern pat = Pattern.compile(sub);
		// 创建matcher类的对象
			Matcher mat = pat.matcher(s);
			if ( mat.find() ) {
				f = true;
			}
			return f;
		}
}

