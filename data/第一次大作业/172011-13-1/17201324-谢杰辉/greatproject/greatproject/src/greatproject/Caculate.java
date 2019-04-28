package greatproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculate {
	private String s;
	Stack<Double> stack = new Stack<Double>();
	private int flag;

	public Caculate(String s) {
		this.s = s;
	}

	public String getResult() {
		Pattern p = Pattern.compile("\\d+|\\+|\\-|\\*|\\/|\\)|\\(");
		Matcher m = p.matcher(s);
		while (m.find()) {
			match(m.group());
		}
		if (flag == 1) {
			return "分母不能为0";
		}
		return String.valueOf(stack.pop());// 把double类型转换为int型，注意Double
		// 不能直接转为int，要先转换为double
	}

	private void match(String s) {
		if (Pattern.matches("\\d+", s)) {
			stack.push(Double.valueOf(s));// 把double转换为int，直接加0.0
		} else {
			stack.push(compute(s));
		}
	}

	private double compute(String s) {
		double re = 0;
		double m = stack.pop();
		double n = stack.pop();
		switch (s) {
		case "+":
			re = n + m;
			break;
		case "-":
			re = n - m;
			break;
		case "*":
			re = n * m;
			break;
		case "/":
			if (m == 0) {
				flag = 1;
			}
			re = n / m;
			break;
		default:
			break;
		}
		return re;
	}

}
