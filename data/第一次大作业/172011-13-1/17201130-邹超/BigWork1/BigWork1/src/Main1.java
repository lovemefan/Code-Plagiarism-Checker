import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) throws Exception {
		java.io.File file = new java.io.File("input.txt");
		Scanner input = new Scanner(file);
		java.io.File file1 = new java.io.File("output.txt");
		PrintWriter output = new PrintWriter(file1);
		Check c = new Check();
		String[] a = { "ERROR" + "\r\n" + "#���������", "ERROR" + "\r\n" + "#�������ұ�������", "ERROR" + "\r\n" + "#���������������",
				"ERROR" + "\r\n" + "#�п�����", "ERROR" + "\r\n" + "#��������ߺ��������", "ERROR" + "\r\n" + "#�������ұ�������� ",
				"ERROR" + "\r\n" + "#�зǷ��ַ�", "ERROR" + "\r\n" + "#����Ϊ0", "ERROR" + "\r\n" + "���ʽ���ַ����������Ż�����",
				"ERROR" + "\r\n" + "���ʽ������������Ż����ֽ�β", "ERROR" + "\r\n" + "�������ұ���������" };
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
