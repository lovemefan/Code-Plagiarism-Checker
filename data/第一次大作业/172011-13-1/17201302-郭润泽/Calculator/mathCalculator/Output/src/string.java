import java.util.regex.*;
 
public class string{
	public static void main(String[] args) {
		String str = "(3+5*6)/0";
		String regEx = "[\\*\\/\\+\\-][\\*\\/\\+\\-]";
		String regEx1 = "\\(\\)";
		String regEx2 = "[^\\*\\/\\+\\-]\\(";
		String regEx3 = "[\\*\\/\\+\\-]\\)";
		String regEx4 = "\\([\\*\\/\\+\\-]";
		String regEx5 = "\\)[^\\*\\/\\+\\-]";
		String regEx6 = "\\/0";
		String regEx7 = "\\/0";
		boolean result=Pattern.compile(regEx6).matcher(str).find();
		System.out.println(result);
	}
}//ture