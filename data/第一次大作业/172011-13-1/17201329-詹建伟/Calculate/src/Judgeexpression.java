
import java.io.IOException;
import java.util.Scanner;

public class Judgeexpression {

	// 构造方法
	public Judgeexpression() {

	}

	// 校验是否输入规范
	public boolean Judge(String expression, java.io.PrintWriter output) {
		int flag = this.Judge1(expression, output) + this.Judge2(expression, output) + this.Judge3(expression, output)
				+ this.Judge4(expression, output) + this.Judge5(expression, output) + this.Judge6(expression, output)
				+ this.Judge8(expression, output) + this.Judge9(expression, output)
				+ this.Judge10(expression, output) + this.Judge11(expression, output) + this.Judge12(expression, output);
		if (flag == 11) {
			return true;
		}
		return false;

	}

	// 判断是不是空表达式
	public int Judge1(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.equals("")) {
			output.println("ERROR\r\n#空表达式");
			return 0;
		}
		return 1;
	}

	// 判断是不是存在非法字符
	public int Judge2(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[[^\\d]&&[^\\+]&&[^\\-]&&[^\\*]&&[^/]&&[^(]&&[^)]]+.*")) {
			return 1;
		}
		output.println("ERROR\r\n#存在非法字符");
		return 0;
	}

	// 判断括号是不是匹配
	public int Judge3(String s, java.io.PrintWriter output) {
		char[] buf = s.toCharArray();
		int flag1 = 0;
		int flag2 = 0;
		for (int i = 0; i < buf.length; i++) {
			if (buf[i] == '(') {
				flag1++;
			}
			if (buf[i] == ')') {
				flag2++;
			}
		}
		if (flag1 == flag2) {
			return 1;
		} else {
			output.println("ERROR\r\n#括号不匹配");
			return 0;
		}
	}

	// 运算符连续
	public int Judge4(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\-|\\+|\\*|/][\\-|\\+|\\*|/].*")) {
			return 1;
		}
		output.println("ERROR\r\n#运算符连续");
		return 0;
	}

	// 空括号
	public int Judge5(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\(\\).*")) {
			return 1;
		}
		output.println("ERROR\r\n#空括号");
		return 0;
	}

	// (后面是运算符
	public int Judge6(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\([\\+\\*/].*")) {
			return 1;
		}
		output.println("ERROR\r\n#(后面是运算符");
		return 0;
	}

//-6 +  (-(6)+((-(-5))))

	// )前面是运算符
	public int Judge8(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\+|\\-|\\*|/]\\).*")) {
			return 1;
		}
		output.println("ERROR\r\n#)前面是运算符");
		return 0;
	}

	// (前面不是运算符
	public int Judge9(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\d|\\)]\\(.*")) {
			return 1;
		}
		output.println("ERROR\r\n#(前面不是运算符");
		return 0;
	}

	// )后面不是运算符
	public int Judge10(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\)[\\d|\\(].*")) {
			return 1;
		}
		output.println("ERROR\r\n#)后面不是运算符");
		return 0;
	}

	// 以运算符结尾
	public int Judge11(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.matches(".*[\\+|\\-|\\*|/]")) {
			output.println("ERROR\r\n#以运算符结尾");
			return 0;
		}
		return 1;
	}
	
	//以运算符开头
	public int Judge12(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.matches("[\\+|\\*|/].*")) {
			output.println("ERROR\r\n#以运算符开头");
			return 0;
		}
		return 1;
	}
	
	// 消除相同的表达式
	public boolean isSame(java.io.File file, String expression, int num) throws IOException {
		Scanner input = new Scanner(file);
		String[] s = new String[(int) file.length()];
		int flag = 0;
		while (flag < num) {
			s[flag++] = input.nextLine();
		}
		input.close();
		int flag2 = 0;
		for (int i = 0; i < flag; i++) {
			s[i] = s[i].replaceAll(" ", "");
			if (expression.equals(s[i])) {
				flag2++;
			}
		}
		if (flag2 >= 2) {
			return true;
		}
		return false;
	}

}
