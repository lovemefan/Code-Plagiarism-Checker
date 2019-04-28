import java.util.ArrayList;

public class Expression {
	public Expression() {

	}

	public static ArrayList<String> Expression(ArrayList<String> ex) {

		int index = 0;

		while (index != ex.size()) {
			String temp = ex.get(index);
			temp = temp.replaceAll(" ", "");
			ex.set(index, temp);
			index++;
		}

		return ex;
	}

	public static ArrayList<String> ExpressionIgnoreTheSame(ArrayList<String> ex) {

		int index = ex.size();

		for (int i = 1; i < index; i++) {
			for (int j = 1; j < (index - i); j++) {
				if (ex.get(j).equals(ex.get(index - i))) {
					ex.set(index - i, "");
					break;
				}
			}
		}

		return ex;
	}

	public static ArrayList<String> ExpressionLegality(ArrayList<String> ex) {
		ArrayList<String> legality = new ArrayList<String>();

		for (int index = 0; index < ex.size(); index++) {
			// 空字符串
			boolean l0 = ex.get(index).matches("");
			// 运算符连续
			boolean l1 = ex.get(index).matches("(.*)[\\*+-/][\\*+-/](.*)");
			// 空括号
			boolean l2 = ex.get(index).matches("(.*)\\(\\)(.*)");
			// (后面是运算符
			boolean l4 = ex.get(index).matches("(.*)\\([\\*+-/](.*)");
			// )前面是运算符
			boolean l5 = ex.get(index).matches("(.*)[\\*+-/]\\)(.*)");
			// (前面不是运算符
			boolean l6 = ex.get(index).matches("(.*)[\\d]\\((.*)");
			// )后面不是运s算符
			boolean l7 = ex.get(index).matches("(.*)\\)[\\d](.*)");
			// 表达式内含非法字符
			boolean l8 = (ex.get(index).matches("(.*)\\@#$%^&￥!~_(.*)"));
			// 除数为零
			boolean l9 = ex.get(index).matches("(.*)\\/0(.*)");
			// 判断是否合法
			if (l0) {
				legality.add("ERROR\n#空字符串");
			} else if (l1) {
				legality.add("ERROR\n#运算符连续");
			} else if (l2) {
				legality.add("ERROR\n#空括号");
			} else if (l4) {
				legality.add("ERROR\n#(后面是运算符");
			} else if (l5) {
				legality.add("ERROR\n#)前面是运算符");
			} else if (l6) {
				legality.add("ERROR\n#(前面不是运算符");
			} else if (l7) {
				legality.add("ERROR\n#)后面不是运算符");
			} else if (l8) {
				legality.add("ERROR\n#表达式内含非法字符");
			} else if (l9) {
				legality.add("ERROR\n#除数为零");
			} else {
				boolean l3 = BracketMismatch(ex, index);
				if (l3) {
					legality.add("ERROR\n#括号不匹配");
				} else {
					legality.add("legal");
				}
			}
		}
		return legality;
	}

	public static boolean BracketMismatch(ArrayList<String> ex, int index) {
		int ofl = 0;
		int ofr = 0;
		char[] of = ex.get(index).toCharArray();
		for (int i = 0; i < of.length; i++) {
			if (of[i] == '(') {
				ofl++;
			} else if (of[i] == ')') {
				ofr++;
			}
		}
		if (ofl != ofr) {
			return true;
		} else {
			return false;
		}
	}
}
