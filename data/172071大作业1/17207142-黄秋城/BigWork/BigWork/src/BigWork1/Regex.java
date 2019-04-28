package BigWork1;

public class Regex//正则表达式匹配类
{
	boolean legal=true;
	String error;
	public Regex() {
		
	}
	
	public void Islegal(String s) {
		
		String a1=".*[^0-9|^\\(|^\\)|^\\+|^\\-|^\\*|^\\/].*";//将字符串中字符锁死在+-*/,0-9,()
		String a2=".*[\\+|\\-|\\*|\\/][\\+|\\-|\\*|\\/].*";//连续运算符
		String a3=".*[\\(][\\+\\*\\/].*";//左括号后+*/
		String a4=".*[\\(][\\-][\\d][\\+\\-\\*\\/].*";//(-5+6)
		String a5=".*[\\+\\-\\*\\/][\\)].*";//右括号前+-*/
		String a6=".*[\\(][\\)].*";//空括号
		String a7="[\\+\\*\\/][\\d].*";//开头是运算符
		String a8=".*[\\+\\*\\/\\-]";//结尾是运算符
		String a10=".*[\\(][0-9]+[\\)].*";//括号里只有数字
		
		if(s.matches(a1)||s.matches(a2)||s.matches(a3)||s.matches(a4)||s.matches(a5)||
				s.matches(a6)||s.matches(a7)||s.matches(a8)||s.matches(a10)) {
			
			legal=false;
		}
	
	
	}
	public void SetError(String s) {
		
		String a1=".*[^0-9|^\\(|^\\)|^\\+|^\\-|^\\*|^\\/].*";//将字符串中字符锁死在+-*/,0-9,()
		String a2=".*[\\+|\\-|\\*|\\/][\\+|\\-|\\*|\\/].*";//连续运算符
		String a3=".*[\\(][\\+\\*\\/].*";//左括号后+*/
		String a4=".*[\\(][\\-][\\d][\\+\\-\\*\\/].*";//(-5+6)
		String a5=".*[\\+\\-\\*\\/][\\)].*";//右括号前+-*/
		String a6=".*[\\(][\\)].*";//空括号
		String a7="[\\+\\*\\/][\\d].*";//开头是运算符
		String a8=".*[\\+\\*\\/\\-]";//结尾是运算符
		String a10=".*[\\(][0-9]+[\\)].*";//括号里只有数字
		
		if(s.matches(a1)) {
			error="#非法字符";
		}
		if(s.matches(a2)) {
			error="#出现连续的运算符";
		}
		if(s.matches(a3)) {
			error="#左括号后紧跟运算符";
		}
		if(s.matches(a4)) {
			error="#非开头负数未加括号";
		}
		if(s.matches(a5)) {
			error="#右括号前紧跟运算符";
		}
		if(s.matches(a6)) {
			error="#空括号";
		}
		if(s.matches(a7)) {
			error="#运算式开头为运算符";
		}
		if(s.matches(a8)) {
			error="#运算式结尾为运算符";
		}
		if(s.matches(a10)) {
			error="#运算时全为数字";
		}
	}
	
}
