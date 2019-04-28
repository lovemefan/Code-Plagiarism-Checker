
public class Check {
	public int check(String exp) {

		if (exp.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) {
			return 0;
		}
		if (exp.matches(".*(\\)\\d).*")) { // ）右边是数字的情况 
			return 1;
		}
		if (exp.matches(".*(\\d\\().*")) { // (左边是数字的情况
			return 2;
		}

		if (exp.matches(".*(\\(\\)).*")) { // 匹配空括号
			return 3;
		}

		if (exp.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // 右括号左边含有运算符
			return 4;
		}

		if (exp.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")) {// 左括号右边有运算符
			return 5;
		}
		if (!exp.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) { // 有非法字符
			return 6;
		}
		if (exp.matches(".*(/0).*")) {  //除数为0
			return 7;
		}
		if (exp.matches(("(\\)|\\*|\\+|\\-|\\/).*"))) {  //首字符不是左括号或数字
			return 8;
		}
		if (exp.matches((".*(\\(|\\+|\\-|\\*|\\/)"))) {  //表达式最后不是以右括号或数字结尾
			return 9;
		}
		if (exp.matches("[\\S]*[)][(][\\S]*")) {   //右括号右边是左括号
			return 10;
		}

		return -1; 

	}
}
