package 大作业;
/**
 * 用正则表达式判断中缀表达式返回Boolean型
 * @author 刘润石
 *
 */
public class Examine {
	String infix;//用来检查的式子
	int i;//错误的下标
	String [] say = {//出错时调用的字符串
		"ERROR\r\n#表达式为空字符串",
		"ERROR\r\n#表达式中多个运算符连续",
		"ERROR\r\n#表达式中空括号",
		"ERROR\r\n#表达式中\")\"右边是数字",
		"ERROR\r\n#表达式中\"(\"左边是数字",
		"ERROR\r\n#表达式中\"(\"右边是运算符",
		"ERROR\r\n#表达式中\")\"左边是运算符",
		"ERROR\r\n#表达式中\")\"的右边是\"(\" ",
		"ERROR\r\n#表达式中首或末位为运算符 ",
		"ERROR\r\n#表达式存在非法字符",
		"ERROR\r\n#表达式括号不匹配"
	};
	boolean flag = true;//开关
	
	public Examine(){
		
	}
	
	public Examine(String infix) {
		this.infix = infix;
	}
	void examine(String infix){
		String [] temp = new String[10];//错误式子类型的正则表达式
		temp[0] = "\\s";
		temp[1] = "[\\S]*[+-/*/][+-/*/]+[\\S]*";
		temp[2] = "[\\S]*[(][)][\\S]*";
		temp[3] = "[\\S]*[)][0-9][\\S]*";
		temp[4] = "[\\S]*[0-9][(][\\S]*";
		temp[5] = "[\\S]*[(][+-/*/][\\S]*";
		temp[6] = "[\\S]*[+-/*/][)][\\S]*";
		temp[7] = "[\\S]*[)][(][\\S]*";
		temp[8] = "([+-/*/]+.[\\S]*|[\\S]*.[+-/*/]+)";
		temp[9] = "[\\S]*[a-zA-Z_=!@#$%^&~][\\S]*";
		if(infix.matches(temp[0])){//进行依次判断
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式为空字符串");
			i = 0;
		}else if(infix.matches(temp[1])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中多个运算符连续");
			i = 1;
		}else if(infix.matches(temp[2])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中空括号");
			i = 2;
		}else if(infix.matches(temp[3])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中\")\"右边是数字 ");
			i = 3;
		}else if(infix.matches(temp[4])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中\"(\"左边是数字 ");
			i = 4;
		}else if(infix.matches(temp[5])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中\"(\"右边是运算符 ");
			i = 5;
		}else if(infix.matches(temp[6])){
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中\")\"左边是运算符 ");
			i = 6;
		}else if (infix.matches(temp[7])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中\")\"的右边是\"(\"  ");
			i = 7;
		}else if (infix.matches(temp[8])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中首或末位为运算符");
			i = 8;
		}else if (infix.matches(temp[9])) {
			flag = false;
			System.out.println("ERROR");
			System.out.println("#表达式中存在非法字符");
			i = 9;
		}
	}
}

