
import java.io.IOException;
import java.util.Scanner;

public class Judgeexpression {

	// ���췽��
	public Judgeexpression() {

	}

	// У���Ƿ�����淶
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

	// �ж��ǲ��ǿձ��ʽ
	public int Judge1(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.equals("")) {
			output.println("ERROR\r\n#�ձ��ʽ");
			return 0;
		}
		return 1;
	}

	// �ж��ǲ��Ǵ��ڷǷ��ַ�
	public int Judge2(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[[^\\d]&&[^\\+]&&[^\\-]&&[^\\*]&&[^/]&&[^(]&&[^)]]+.*")) {
			return 1;
		}
		output.println("ERROR\r\n#���ڷǷ��ַ�");
		return 0;
	}

	// �ж������ǲ���ƥ��
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
			output.println("ERROR\r\n#���Ų�ƥ��");
			return 0;
		}
	}

	// ���������
	public int Judge4(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\-|\\+|\\*|/][\\-|\\+|\\*|/].*")) {
			return 1;
		}
		output.println("ERROR\r\n#���������");
		return 0;
	}

	// ������
	public int Judge5(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\(\\).*")) {
			return 1;
		}
		output.println("ERROR\r\n#������");
		return 0;
	}

	// (�����������
	public int Judge6(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\([\\+\\*/].*")) {
			return 1;
		}
		output.println("ERROR\r\n#(�����������");
		return 0;
	}

//-6 +  (-(6)+((-(-5))))

	// )ǰ���������
	public int Judge8(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\+|\\-|\\*|/]\\).*")) {
			return 1;
		}
		output.println("ERROR\r\n#)ǰ���������");
		return 0;
	}

	// (ǰ�治�������
	public int Judge9(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*[\\d|\\)]\\(.*")) {
			return 1;
		}
		output.println("ERROR\r\n#(ǰ�治�������");
		return 0;
	}

	// )���治�������
	public int Judge10(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (!s.matches(".*\\)[\\d|\\(].*")) {
			return 1;
		}
		output.println("ERROR\r\n#)���治�������");
		return 0;
	}

	// ���������β
	public int Judge11(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.matches(".*[\\+|\\-|\\*|/]")) {
			output.println("ERROR\r\n#���������β");
			return 0;
		}
		return 1;
	}
	
	//���������ͷ
	public int Judge12(String s, java.io.PrintWriter output) {
		s = s.replace(" ", "");
		if (s.matches("[\\+|\\*|/].*")) {
			output.println("ERROR\r\n#���������ͷ");
			return 0;
		}
		return 1;
	}
	
	// ������ͬ�ı��ʽ
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
