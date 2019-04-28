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
			return "��ĸ����Ϊ0";
		}
		return String.valueOf(stack.pop());// ��double����ת��Ϊint�ͣ�ע��Double
		// ����ֱ��תΪint��Ҫ��ת��Ϊdouble
	}

	private void match(String s) {
		if (Pattern.matches("\\d+", s)) {
			stack.push(Double.valueOf(s));// ��doubleת��Ϊint��ֱ�Ӽ�0.0
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
