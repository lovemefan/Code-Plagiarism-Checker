import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Check {
	public Check() {

	}

	public String check1(String enterString) {
		/*
		 * 初步判断输入的String 如果为空字符串 返回1 如果有除了数字 括号 运算符与空格之外的其他字符 返回2 如果括号不匹配 返回3
		 */
		String Wrong[] = { "true",
				"空字符串",
				"有除了数字 括号 运算符与空格之外的其他字符", 
				"括号不匹配",
				"纯数字 无运算符"};
		char c[]=enterString.toCharArray();
		int lens = enterString.length();
		int flagi = 0;// 标记左右括号的对象

		if (enterString.equals("")) {// 空字符
			return Wrong[1];// 空字符错误
		}
		
		int nums=0;
		
		for (int i = 0; i < lens; i++) {
			if (c[i]== ' ') {
				continue;
			} else if (c[i] == '(') {
				flagi++;
			} else if (c[i] == ')') {
				flagi--;
			} else if(Character.isDigit(c[i])){
				nums++;
			} else /*if (!Character.isDigit(c[i])) */{
				String regEx1 = "[^\\+\\-\\*\\/]";
				Pattern pattern1 = Pattern.compile(regEx1);
				String s="";
				s+=c[i];
				Matcher matcher1 = pattern1.matcher(s);
				boolean b1 = matcher1.find();
				if (b1) {
					return Wrong[2];
				}
			}
		}
	
		if(nums==lens){
			return Wrong[4];
		}
		if (flagi != 0){
			return Wrong[3];
		}
			
		return Wrong[0];
	}

	public String check2(String enterString) {
		String Wrong[] = { "true", 
				"数字后不能有(", 
				"(后不能跟符号", 
				")后不能跟数字", 
				")前不能有符号", 
				"()为错", 
				"运算符连续", 
				")(括号连续",
				"0不能为除数"};

		String reg1 = "[0-9]\\(";
		String reg2 = "\\([\\+|\\-|\\*|\\/]";
		String reg3 = "\\)[0-9]";
		String reg4 = "[\\+|\\-|\\*|\\/]\\)";
		String reg5 = "\\(\\)";
		String reg6 = "[\\/|\\*|\\-|\\+]{2,}";
		String reg7 = "\\)\\(";
		String reg8 = "\\/0";

		Pattern pat1 = Pattern.compile(reg1);
		Pattern pat2 = Pattern.compile(reg2);
		Pattern pat3 = Pattern.compile(reg3);
		Pattern pat4 = Pattern.compile(reg4);
		Pattern pat5 = Pattern.compile(reg5);
		Pattern pat6 = Pattern.compile(reg6);
		Pattern pat7 = Pattern.compile(reg7);
		Pattern pat8 = Pattern.compile(reg8);
		Matcher matcher1 = pat1.matcher(enterString);
		Matcher matcher2 = pat2.matcher(enterString);
		Matcher matcher3 = pat3.matcher(enterString);
		Matcher matcher4 = pat4.matcher(enterString);
		Matcher matcher5 = pat5.matcher(enterString);
		Matcher matcher6 = pat6.matcher(enterString);
		Matcher matcher7 = pat7.matcher(enterString);
		Matcher matcher8 = pat8.matcher(enterString);

		boolean a1 = matcher1.find();
		boolean a2 = matcher2.find();
		boolean a3 = matcher3.find();
		boolean a4 = matcher4.find();
		boolean a5 = matcher5.find();
		boolean a6 = matcher6.find();
		boolean a7 = matcher7.find();
		boolean a8 = matcher8.find();

		if (a1 == true) {
			return Wrong[1];
		} else if (a2 == true) {
			return Wrong[2];
		} else if (a3 == true) {
			return Wrong[3];
		} else if (a4 == true) {
			return Wrong[4];
		} else if (a5 == true) {
			return Wrong[5];
		} else if (a6 == true) {
			return Wrong[6];
		} else if (a7 == true) {
			return Wrong[7];
		} else if (a8 == true) {
			return Wrong[8];
		}

		return Wrong[0];
		// 如果检测通过返回true 在主函数中调用dealMid
	}
}

