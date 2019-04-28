package calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	Stack<Character> op = new Stack<>();
	// 正则表达式来处理带小数点的数字
	Pattern p = Pattern.compile("[0-9]+(\\.[0-9]+)?");
	@SuppressWarnings("rawtypes")
	List list = new ArrayList<>();

	@SuppressWarnings({"unchecked" })
	public boolean validate(String s) {
		try {
			op.clear();
			list.clear();
			
			int i = 0;
			while (i < s.length()) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9') {
					String s1 = s.substring(i);
					Matcher m = p.matcher(s1);
					if (m.find()) { // 取匹配到的第一个数字
						s1 = m.group();
						list.add(s1);
					}
					i = i + s1.length();
					// 若数字后直接跟左括号则为格式错误
					if (i < s.length() && s.charAt(i) == '(') {
						list.clear();
						return false;
					}
					continue;
				} else if (c == '(') {
					op.push(c);
				} else if (c == ')') {
					//第一个字符是右括号时验证失败
					if (op.isEmpty()) {
						list.clear();
						return false;
					}
					//右括号之前非数字或右括号时验证失败
					if(s.charAt(i-1)!=')'&&!isNumber(s.charAt(i-1))) {
						list.clear();
						return false;
					}
					char p = op.pop();
					while (p != '(') {
						list.add(p);
						p = op.pop();
					}
					// 若右括号后直接跟数字为格式错误
					if (i + 1 < s.length() && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
						list.clear();
						return false;
					}
				} else if (c == '+' || c == '-') {
					while (!op.isEmpty()
							&& (op.peek() == '+' || op.peek() == '-' || op.peek() == '*' || op.peek() == '/')) {
						list.add(op.pop());
					}
					op.push(c);
				} else if (c == '*' || c == '/') {
					while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
						list.add(op.pop());
					}
					op.push(c);
				}
				i++;
			}

			while (!op.isEmpty()) {
				list.add(op.pop());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean isNumber(char c) {
		return c<='9'&&c>='0';
	}
	
}