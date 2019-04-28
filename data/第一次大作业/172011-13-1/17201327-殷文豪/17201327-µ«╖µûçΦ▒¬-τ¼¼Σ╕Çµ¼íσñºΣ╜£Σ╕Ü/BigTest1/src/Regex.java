
//正则校验类
public class Regex {
	private String infix;//中缀表达式
	private String error = "ERROR\r\n#";
	
	//构造方法
	public Regex() {
		
	}
	
	//重载构造方法
	//infix 中缀表达式
	public Regex(String infix) {
		this.infix = infix;
	}
	
	//设置infix
	public void setInfix(String infix) {
		this.infix = infix;
	}
	
	//获取infix
	public String getInfix() {
		return infix;
	}
	
	//获取error
	public String getError() {
		return error;
	}
	
	//判断infix是否是合法的中缀表达式
	public boolean isCorrect() {
		if (error.equals("ERROR\r\n#")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//检验方法
	public void check() {
		//将表达式中的空格消除
		infix = infix.replaceAll(" ", "");
		//进行校验
		check1();
		check2();
		check3();
		check4();
		check5();
		check6();
		check7();
		check8();
		check9();
		check10();
		check11();
		check12();
		check13();
	}
	
	//检验空字符串
	public void check1() {
		if (infix.equals("")) {
			error += "空字符串" + " ";
		}
	}
	
	//检验运算符连续
	public void check2() {
		if (infix.matches(".*[\\+\\-\\*/][\\+\\-\\*/].*")) {
			error += "运算符连续" + " ";
		}
	}
	
	//检验空括号
	public void check3() {
		if (infix.matches(".*\\(\\).*")) {
			error += "空括号" + " ";
		}
	}
	
	//检验括号不配对
	public void check4() {
		int temp1 = 0;//记录(的数量
		int temp2 = 0;//记录)的数量
		//遍历字符串
		for (int i = 0;i < infix.length();i ++) {
			if (infix.charAt(i) == '(') {
				temp1 ++;
			}
			if (infix.charAt(i) == ')') {
				temp2 ++;
			}
		}
		//字符串以(结尾或者以)开头
		if (infix.matches("\\).*") || infix.matches(".*\\(")) {
			error += "括号不配对" + " ";
		}
		else if (temp1 != temp2) {
			error += "括号不配对" + " ";
		}
	}
	
	//检验(后是运算符
	public void check5() {
		if (infix.matches(".*\\([\\+\\*/].*")) {
			error += "(后是运算符" + " ";
		}
		else if (infix.matches(".*(\\(\\-)+[\\+\\*\\-/].*")) {
			error += "(后是运算符" + " ";
		}
	}
	
	//检验)前面是运算符
	public void check6() {
		if (infix.matches(".*[\\+\\-\\*/]\\).*")) {
			error += ")前面是运算符" + " ";
		}
	}
	
	//检验(前面不是运算符
	public void check7() {
		if (infix.matches(".*[^\\(\\+\\-\\*/]\\(.*")) {
			error += "(前面不是运算符" + " ";
		}
	}
	
	//检验)后面不是运算符
	public void check8() {
		if (infix.matches(".*\\)[^\\)\\+\\-\\*/].*")) {
			error += ")后面不是运算符" + " ";
		}
	}
	
	//检验表达式内含非法字符
	public void check9() {
		if (infix.matches(".*[^\\+\\-\\*/\\(\\)\\d].*")) {
			error += "表达式内含非法字符" + " ";
		}
	}
	
	//检验数字以0开头
	public void check10() {
		if (infix.matches(".*[\\+\\-\\*/\\(\\)]0[\\d]+.*") || infix.matches("0[\\d]+.*")) {
			error += "数字以0开头" + " ";
		}
	}
	
	//检验以运算符开头
	public void check11() {
		if (infix.matches("[\\+\\*/].*") || infix.matches("\\-[\\)\\+\\-\\*/].*")) {
			error += "以运算符开头" + " ";
		}
	}
	
	//检验以运算符结尾
	public void check12() {
		if (infix.matches(".*[\\+\\*\\-/]")) {
			error += "以运算符结尾" + " ";
		}
	}
	
	//简单的判断除数为0
	public void check13() {
		if (infix.matches(".*/0") || infix.matches(".*/\\(0\\)")) {
			error += "除数为0" + " ";
		}
	}

}
