package allpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resolve {
	/*
	 * 一次性输入所有指令
	 * 自动过滤空格
	 *能忽略相同的请求
	*/
	String[] ex = {
			".*\\(\\).*",					//有空括号
			".*[^\\d+-/*\\(\\)].*",			//表达式包含非法字符"
			".*[+-/*][+-/*].*",				//运算符连续
			"^[+-/*].*|.*\\([+-/*].*",		//运算符前无运算数
			".*[+-/*]$|.*[+-/*]\\).*",		//运算符后无运算数
			".*\\d\\(.*",					//括号非第一个字符且之前无运算数
			".*\\)\\d.*"					//小括号后无运算数，括号非最后一个字符
											//括号不匹配
											//表达式为空 
	};
	int isLegal(String a) {
		int anum = 0,bnum = 0;
		for(int i = 0;i < a.length();i++) {
			if(a.charAt(i) == '(')
				anum++;
			if(a.charAt(i) == ')')
				bnum++;
		}
		if(anum != bnum)
			return 8;
		for(int i= 0;i < 7;i++) {
			Pattern pattern = Pattern.compile(ex[i]);
			Matcher matcher = pattern.matcher(a);
			if (matcher.find()) {;
				return i+1;
			}
		}
		return 0;
	}
}
