import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	public static boolean check(String line) {
		int brackets = 0;//标记括号是否匹配的记号
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '(') {
				brackets++;
				continue;
			}
			if (line.charAt(i) == ')') {
				brackets--;
				if (brackets < 0)
					return false;
				continue;
			}
			if (line.charAt(i) <= '9' || line.charAt(i) >= '0')//判断数字为0-9
				continue;
			if (line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/')//判断符号只能为四则符号
				continue;
			return false;
		}
		String pattern = ".*[(][)].*";
		if (Pattern.matches(pattern, line))
			return false;
		//根据所有的错误情况用正则表达式判断该式是否正确
		pattern = ".*[)][(].*";
		if (Pattern.matches(pattern, line))
			return false;

		pattern = ".*[-|+|*|/][-|+|*|/].*";
		if (Pattern.matches(pattern, line))
			return false;

		pattern = ".*[(][-|+|*|/].*";
		if (Pattern.matches(pattern, line))
			return false;

		pattern = ".*[-|+|*|/][)].*";
		if (Pattern.matches(pattern, line))
			return false;

		pattern = ".*^[-|+|*|/|)].*";
		if (Pattern.matches(pattern, line))
			return false;

		pattern = ".*[-|+|*|/|(]$.*";
		if (Pattern.matches(pattern, line))
			return false;
		return true;
	}
}
