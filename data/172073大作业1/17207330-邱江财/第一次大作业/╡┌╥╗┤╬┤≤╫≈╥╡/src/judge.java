import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class judge {
	public static void isLegal(String s) throws IOException {
		if(s.equals(null)) {
			Write.write("ERROR");
			Write.write("#表达式为空");
		}
		String str = ".*\\(\\).*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#表达式中有空括号");
			return;
		}
		str = ".*[^\\d\\+\\-\\*\\/].*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#表达式包含非法字符");
			return;
		}
		int l =s.length();
		int i,n=0,m=0;
		for(i=0;i<l;i++) {
			char a=s.charAt(i);
			if(a=='(')
				n++;
			else if(a==')')
				m++;
		}
		if(n!=m) {
			Write.write("ERROR");
			Write.write("#括号不匹配");
		}
		str = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#运算符连续");
			return;
		}
		str = ".*\\D[\\+\\-\\*\\/].*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#运算符前无运算数");
			return;
		}
		str = ".*[\\+\\-\\*\\/]\\(*\\D";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#运算符后无运算数");
			return;
		}
		str = ".*\\d\\(.*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#括号非第一个字符且之前无运算符");
			return;
		}
		str = ".*\\(\\d.*";
		if(Pattern.matches(str,s)) {
			Write.write("ERROR");
			Write.write("#小括号后无运算符，括号非最后一个字符");
			return;
		}
		Write.write(caculate.Calculation(s));
		return;
	}
}
