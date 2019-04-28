import java.util.ArrayList;

public class Check {
	static String check(String str) {
		Calcalute c1 = new Calcalute();
		boolean m1 = str.matches("[0-9\\+\\-\\*\\/\\(\\)]*");// 含有非法字符
		boolean m2 = str.matches("(.*)[0-9]\\((.*)");// 缺少操作符：左括号左边缺少操作符
		boolean m3 = str.matches("(.*)\\)[0-9](.*)");// 缺少操作符：右括号右边缺少操作符
		boolean m4 = str.matches("(.*)\\([\\*+-/](.*)");// 缺少操作数：左括号右边缺少操作数
		boolean m5 = str.matches("(.*)[\\*+-/]\\)(.*)");// 缺少操作数：右括号左边缺少操作数
		boolean m6 = str.matches("(.*)\\(\\)(.*)");// 空括号：括号内无表达式
		boolean m7 = str.matches("(.*)[\\*+-/][\\*+-/](.*)");// 运算符缺少操作数
		boolean m8 = str.matches("[\\+\\-\\*\\/](.*)");// 字符串首字符为操作符
		boolean m9 = str.matches("(.*)[\\+\\-\\*\\/]");// 字符串尾字符为操作符
		boolean m10=judge(str);
		if (m1 == false) {
			return str + "  #ERROR 含有非法字符";
		} else if (m2 == true) {
			return str + "  #ERROR 左括号左边缺少操作符";
		} else if (m3 == true) {
			return str + "  #ERROR 右括号右边缺少操作符";
		} else if (m4 == true) {
			return str + "  #ERROR 左括号右边缺少操作数";
		} else if (m5 == true) {
			return str + "  #ERROR 右括号左边缺少操作数";
		} else if (m6 == true) {
			return str + "  #ERROR 括号里没有表达式";
		} else if (m7 == true) {
			return str + "  #ERROR 运算符缺少操作数";
		} else if (m8 == true) {
			return str + "  #ERROR 字符串首字符为操作符";
		} else if (m9 == true) {
			return str + "  #ERROR 字符串尾字符为操作符";
		} else if(m10==false){
			return str + "  #ERROR 括号不匹配";
		}
		else {
			ArrayList result = c1.getStringList(str);
			ArrayList result1 = c1.getPostOrder(result);
			int sum = c1.calculate(result1);
			return str + "=" + sum;

		}
	}

	private static boolean judge(String str) {
		Calcalute c1 = new Calcalute();
		int sum=0;
		boolean end=true;
		ArrayList result = c1.getStringList(str);
		for(int i=0;i<result.size();i++){
			if(result.get(i).equals("(")){
				sum=sum+1;
			}else if(result.get(i).equals(")")){
				sum=sum-1;
			}
		}
		if(sum==0){
			return true; 
		}else{
		return false;
		}
	}

}
