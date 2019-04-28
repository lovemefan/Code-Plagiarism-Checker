import java.util.regex.*;

public class Check {
	public Check(){
		
	}
	
	//去除表达式里的空格
	public String RemoveBlank(String expression){
		String newexpression = "";
			for(int a = 0;a < expression.length();a ++){
				if(expression.charAt(a) == ' '){
					continue;
				}else{
					newexpression = newexpression + expression.charAt(a);
				}
			}
		return newexpression;
	}

	//检查表达式是否有非法字符，非法返回0，合法返回1
	public int IllegalCharacter(String expression){
		int a = 0;
		String regex = "[^(\\d)\\^(\\+)\\^(\\-)\\^(\\*)\\^(\\/)\\^(\\()\\^(\\)]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(expression);
		if(m.find()){
			a = 0;
		}else{
			a = 1;
		}
		return a;
	}
	
	//检查表达式中的括号(左右括号连续出现)
	public int Parenthesis1(String expression){
		expression = RemoveBlank(expression);
		int a = 0;
		if(expression != "" && expression.length() != 1){
			for (int i = 0; i < expression.length() - 1; i++) {
				if (((expression.charAt(i) == '(' && expression.charAt(i+1) == ')') || (expression.charAt(i) == ')' && expression.charAt(i+1) == '('))) {
					a = 0;
				}else{   
					a = 1;
				}
			}
		}
		return a;
	}
	
	//检查表达式中的括号(左右括号不相等)
	public int Parenthesis2(String expression){
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				a = a + 1;
			}else if(expression.charAt(i) == ')'){   
				b = b + 1;
			}
		}
		if(a == b){
			c = 1;
		}else if(a != b){
			c = 0;
		}
		return c;
	}
	
	//检查/后是否为0
	public int Zero(String expression){
		int f = 0;
		String regex = "[\\/][0]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(expression);
		if(m.find()){
			f = 0;
		}else{
			f = 1;
		}
		return f;
	}
	
	//检查表达式格式是否错误
	public int TorF(String expression){
		int g = 0;
		String regex2 = "[\\(][\\*\\/\\+\\-]";
		String regex3 = "[\\)][\\d]";
		String regex4 = "[\\d][\\(]";
		String regex5 = "[\\*\\/\\+\\-]{2}";
		String regex6 = "[\\(][\\)]";
		String regex7 = "[\\+\\*\\/\\-][\\)]";
		String regex8 = "^[\\+\\-\\*\\/)]|[\\+\\-\\*\\/]$";
		Pattern p2 = Pattern.compile(regex2);
		Pattern p3 = Pattern.compile(regex3);
		Pattern p4 = Pattern.compile(regex4);
		Pattern p5 = Pattern.compile(regex5);
		Pattern p6 = Pattern.compile(regex6);
		Pattern p7 = Pattern.compile(regex7);
		Pattern p8 = Pattern.compile(regex8);
		Matcher m2 = p2.matcher(expression);
		Matcher m3 = p3.matcher(expression);
		Matcher m4 = p4.matcher(expression);
		Matcher m5 = p5.matcher(expression);
		Matcher m6 = p6.matcher(expression);
		Matcher m7 = p7.matcher(expression);
		Matcher m8 = p8.matcher(expression);
		if(m2.find() || m3.find() || m4.find() || m5.find() || m6.find() || m7.find()|| m8	.find()){
			g = 0;
		}else{
			g = 1;
		}
		return g;
	}
	//对空行进行判断
	public int NullString(String expression){
		int b = 0;
		int c= 0;
		for(int a = 0;a < expression.length();a ++){
			if(expression.charAt(a) == ' '){
				b = b + 1;
			}
		}
		if(b == expression.length()){
			c = 0;
		}else{
			c = 1;
		}
		return c;
	}
	//对字符串进行判断
	public String Judge(String s) {
		String s1 = "";
		if (IllegalCharacter(s) == 0) {
			s1=s1 + "s1";
			//System.out.println("有非法字符");
		} 
		else if (Parenthesis1(s) == 0) {
			s1=s1 + "s2";
			//System.out.println("左右括号连续出现");
		} 
	    else if (Zero(s) == 0) {
			s1=s1 + "s3";
			//System.out.println("除数不能为0");
		} 
		else if (TorF(s) == 0) {
			s1=s1 + "s4";
			//System.out.println("输入格式错误");
		}else if(Parenthesis2(s) == 0){
			s1 = s1 + "s5";
		}else if(NullString(s) == 0){
			s1 = s1 + "s6";
		}else{
			s1 = s1 + s;//左右括号不相等
		}
		return s1;
	}
}
