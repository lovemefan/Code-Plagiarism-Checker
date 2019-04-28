package 大作业;

public class Regexp {

	private String expression;//表达式

	//创建表达式构造方法
	public Regexp(String expression) {
		this.expression = expression;

	}

	// 检测格式是否正确
	public boolean isTure(String expression) {
		boolean a1 = expression.matches(".*[\\+\\-\\*\\/]{2,}.*");// 1.运算符连续
		boolean a2 = expression.matches(".*[\\+\\-\\*\\/][\\)]|[\\(][\\*\\/\\+\\-].*");// 2.运算符后右括号或左括号后是运算符
        boolean a3 = expression.matches("[\\+\\*\\/][\\d].*");// 5.开头为运算符
		boolean a4 = expression.matches(".*[\\(][\\)].*");// 6.空括号
        boolean a5 = expression.matches("[^\\d]{1,}|[^\\+\\-\\*\\/]{1,}");// 8.没有数字或没有运算符
        boolean a6 = expression.matches(".*[\\)][\\d]|[\\d][\\(].*");// 10.右括号后是数字或数字后是左括号
        boolean a7 = expression.matches(".*[^\\d\\+\\-\\*\\/\\(\\)].*");// 12.出现字符或非法符号

		if (!a1 && !a2 && !a3 && !a4 && !a5 && !a6 && !a7)
			return true;
		else
			return false;

	}
	
   //得到错误原因
	  public String export(String expression) {
		boolean a1 = expression.matches(".*[\\+\\-\\*\\/]{2,}.*");// 1.运算符连续
		boolean a2 = expression.matches(".*[\\+\\-\\*\\/][\\)]|[\\(][\\*\\/\\+\\-].*");// 2.运算符后右括号或左括号后是运算符
        boolean a3 = expression.matches("[\\+\\*\\/][\\d].*");// 5.开头为运算符
		boolean a4 = expression.matches(".*[\\(][\\)].*");// 6.空括号
        boolean a5 = expression.matches("[^\\d]{1,}|[^\\+\\-\\*\\/]{1,}");// 8.没有数字或没有运算符
        boolean a6 = expression.matches(".*[\\)][\\d]|[\\d][\\(].*");// 10.右括号后是数字或数字后是左括号
        boolean a7 = expression.matches(".*[^\\d|^\\+|^\\-|^\\*|^\\/|^\\(|^\\)].*");// 12.出现字符或非法符号

		String isError = "";

		if (a1) {
			isError += "#运算符连续";
		}

		if (a2) {
			isError += "#运算符后右括号或左括号后是运算符";

		}

		if (a3) {
			isError += "#开头为运算符";

		}
		if (a4) {
			isError += "#空括号";

		}

		if (a5) {
			isError += "#没有数字或没有运算符";

		}

		if (a6) {
			isError += "#右括号后是数字或数字后是左括号";
		}

		if (a7) {
			isError += "#出现字符或非法符号";

		}

		return isError;

	}

}
