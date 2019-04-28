package greatproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translate {
	private String oldStr = "";
	private String newStr = "";
	private Stack<String> stack = new Stack<String>();

	public Translate(String oldStr) {
		this.oldStr = oldStr;
	}

	public String tran() {
		this.addZo();
		Pattern p = Pattern.compile("\\d+|\\+|\\-|\\*|\\/|\\)|\\(");
		Matcher m = p.matcher(oldStr);
		while (m.find()) {
			this.match(m.group());
		}
		while (!stack.isEmpty()) {
			newStr += stack.pop() + " ";
		}

		return newStr;
	}

	private void match(String s) {
		if (Pattern.matches("\\d+", s)) {
			newStr += s + " ";
		} else if (Pattern.matches("[\\+\\-]", s)) {
			this.stac(1, s);
		} else if (Pattern.matches("[\\*\\/]", s)) {
			this.stac(2, s);
		} else if (Pattern.matches("\\(", s)) {
			this.stac(0, s);
		} else if (Pattern.matches("\\)", s)) {
			this.stac(3, s);
		}

	}

	private void stac(int i, String s) {
		if (i == 0) {// ¿¼ÂÇ×óÀ¨ºÅ
			stack.push(s);
			return;
		}
		if (i == 3) {// ÓÒÀ¨ºÅ
			while (!stack.isEmpty()) {
				String top = stack.pop();
				if (top.equals("(")) {
					break;
				} else {
					newStr += top + " ";
				}
			}
			return;
		} // ¼Ó¼õ³Ë³ý
		while (!stack.isEmpty()) {
			String top = stack.pop();
			int itop = getI(top);
			if (itop < i) {
				stack.push(top);
				break;
			} else {
				newStr += top + " ";
			}
		}
		stack.push(s);
	}

	private int getI(String s) {
		if (Pattern.matches("[\\+\\-]", s)) {
			return 1;
		} else if (Pattern.matches("[\\*\\/]", s)) {
			return 2;
		}
		return 0;
	}

	public void addZo() {// ¸ø¸ººÅ¼Ó0
		Pattern p = Pattern.compile("\\-");
		Matcher m = p.matcher(oldStr);
		if (m.lookingAt()) {
			oldStr = oldStr.replaceFirst("\\-", "0\\-");
		}
		p = Pattern.compile("\\(\\-");
		m = p.matcher(oldStr);
		while (m.find()) {
			oldStr = oldStr.replaceAll("\\(\\-", "(0-");
		}
	}

}
