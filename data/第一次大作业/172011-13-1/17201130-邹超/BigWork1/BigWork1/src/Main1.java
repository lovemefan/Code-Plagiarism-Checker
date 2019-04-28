import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) throws Exception {
		java.io.File file = new java.io.File("input.txt");
		Scanner input = new Scanner(file);
		java.io.File file1 = new java.io.File("output.txt");
		PrintWriter output = new PrintWriter(file1);
		Check c = new Check();
		String[] a = { "ERROR" + "\r\n" + "#运算符连续", "ERROR" + "\r\n" + "#右括号右边是数字", "ERROR" + "\r\n" + "#左括号左边是数字",
				"ERROR" + "\r\n" + "#有空括号", "ERROR" + "\r\n" + "#右括号左边含有运算符", "ERROR" + "\r\n" + "#左括号右边有运算符 ",
				"ERROR" + "\r\n" + "#有非法字符", "ERROR" + "\r\n" + "#除数为0", "ERROR" + "\r\n" + "表达式首字符不是左括号或数字",
				"ERROR" + "\r\n" + "表达式最后不是以右括号或数字结尾", "ERROR" + "\r\n" + "右括号右边是左括号" };
		int k = 0;
		String in[] = new String[50];
		while (input.hasNextLine()) {

			in[k] = input.nextLine();

			in[k].replace(" ", "");

			if (c.check(in[k]) == -1) {

				int temp1 = 0;
				for (int j = 0; j < k; j++) {
					if (in[k].equals(in[j])) {
						temp1 = 1;

					}

				}

				if (temp1 == 1) {

				}

				else {
					Stack stack = new Stack(in[k].length());
					Trans exp = new Trans(stack, in[k]);
					exp.process();

					String Exp = exp.getPost().trim();
					Stack result = new Stack(Exp.length());
					GetTheResult g = new GetTheResult(Exp, result);
					g.operate();
					String temp = g.getResult();
					output.println(in[k] + "=" + temp);
				}
			}

			else {

				for (int i = 0; i < a.length; i++) {
					if (c.check(in[k]) == i) {
						output.println(a[i]);
						break;
					}
				}
			}

			k++;
		}

		input.close();
		output.close();

	}
}
