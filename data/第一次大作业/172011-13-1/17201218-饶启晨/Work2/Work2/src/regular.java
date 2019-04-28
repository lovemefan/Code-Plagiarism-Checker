//校验类
public class regular {
	public regular() {
	
	}
	public static int check(String s) {
		int flag = 0;
		if(s.matches("(.*)[^\\*+-/0123456789()](.*)")){//出现其他非法字符
			flag=1;
			return flag;//System.out.println("ERROR: 出现其他非法字符");
	    }
		if (s.matches("[\\S]*[+\\-/*/][+/*/][\\S]*")) {
			flag=2;
			return flag;//System.out.println("ERROR: 两个运算符连续出现");
		}
		if(s.matches("[\\S]*[+\\-/*/]")){
			flag=3;
			return flag;//System.out.println("ERROR: 表达式中运算符右边没有数字");
			
		}
		if(s.matches("[\\S]*[+\\-/*/(][\\-][(][\\S]*")){
			flag=4;
			return flag;//System.out.println("ERROR: 表达式中(左边是非法字符");
			
		}
		if (s.matches("[\\S]*[)][0-9][\\S]*")) {
			flag=5;
			return flag;//System.out.println("ERROR: 表达式中)右边是非法字符");
			
		}
		if (s.matches("[\\S]*[0-9][(][\\S]*")) {
			flag=6;
			return flag;//System.out.println("ERROR: 表达式中(左边是非法字符");	
		}
		if (s.matches("[\\S]*[(][/*/][\\S]*")) {
			flag=7;
			return flag;//System.out.println("ERROR: 表达式中(右边是非法字符");
		}
		if (s.matches("[\\S]*[+\\-/*/][)][\\S]*")) {
			flag=8;
			return flag;//System.out.println("ERROR: 表达式中)左边是非法字符");
		}
		if (s.matches("[\\S]*[(][)][\\S]*")) {
			flag=9;
			return flag;//System.out.println("ERROR: 表达式中存在空括号");
		}
		return flag;
	}
	
}


