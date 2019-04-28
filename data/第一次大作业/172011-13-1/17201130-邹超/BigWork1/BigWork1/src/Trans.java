
public class Trans {
	private Stack sta; 
	private String inexp; 
	private String Exp = ""; 

	public Trans(Stack stack, String inexp) {
		this.sta = stack;
		this.inexp = inexp;
	}

	private String proExp(String inexp) {
		String result = "";
		for (int i = 0; i < inexp.length() - 1; i++) {
			char num1 = inexp.charAt(i);
			char num2 = inexp.charAt(i + 1);
			if (pan(num1) || pan(num2)) {
				result += num1 + " ";
			} else {
				result += num1;
			}
		}
		result += inexp.charAt(inexp.length() - 1); // 将最后一个元素添加进去
		return result;
	}

	private boolean pan(char ch) {
		if (ch >= '0' && ch <= '9')
			return false;
		else
			return true;
	}

	public void process() {
		String[] a = proExp(inexp).split(" ");
		for (int i = 0; i < a.length; i++) {
			String b = a[i];
			switch (b) {
			case "+":
			case "-":
				compare(b, 1);
				break;
			case "*":
			case "/":
				compare(b, 2);
				break;
			case "(":
				sta.push(b);
				break;
			case ")":
				getPan();
				break;
			default:
				Exp += " " + b;
				break;
			}
		}
		// 数字全部输出后，需要输出栈中剩余的符号
		while (!sta.isEmpty()) {
			Exp += " " + sta.pop();
		}
	}

	private void getPan() {
		while (!sta.isEmpty()) {
			String t = sta.pop();
			if (t.equals("(")) {
				break;
			} else {
				Exp += " " + t;
			}
		}
	}

	private void compare(String str, int num) {
		while (!sta.isEmpty()) {
			String top2 = sta.pop();
			if (top2.equals("(")) {
				sta.push(top2);
				break;
			} else {
				int top1 = getPri(top2);
				if (top1 < num) {
					sta.push(top2);
					break;
				} else {
					Exp += " " + top2;
				}
			}
		}
		sta.push(str);
	}

	private int getPri(String rng) {
		int num = 1;
		if (rng.equals("/") || rng.equals("*")) {
			num = 2;
		} else {
			num = 1;
		}
		return num;
	}

	public String getPost() {
		return Exp;
	}

}
