package javacalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhengze {

	// 正则表达式
	static boolean validateValue(String value) {

		String regex = "((^\\d+\\s*)|(^\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))(([\\+\\-\\*/]\\s*\\d+)\\s*|([\\+\\-\\*/]\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))+";
		Pattern patern = Pattern.compile(regex);
		Matcher m = patern.matcher(value);
		boolean b = m.matches();
		return b;
	}
}
