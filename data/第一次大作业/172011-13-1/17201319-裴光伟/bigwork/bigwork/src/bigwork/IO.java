package bigwork;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	// ���ļ��ж�ȡ����
	public static String[] scan() throws Exception {
		File arithFile = new File("arith.txt");
		String[] exp = new String[1000];// ���ļ��ж�ȡ���������
		if (!arithFile.exists()) {
			System.out.println("�������ļ�,��ȷ�������ļ�����");
			System.exit(1);
		}
		try (Scanner input = new Scanner(arithFile)) {
			int i = 0;
			while (input.hasNextLine()) {
				String a = input.nextLine();
				if(RegularExpression.blankPan(a))
					exp[i] = "\r\nERROR\r\n#���ʽΪ��";
				else {
					exp[i] = a;
				}
				i++;
			}
		}
		return exp;
	}

	// ���ļ�����������
	public static void prin(String[] exp, int s) throws Exception {
		File arithFile = new File("arithresult.txt");
		try (PrintWriter output = new PrintWriter(arithFile)) {
			for (int i = 0; i < s; i++)
				output.println(exp[i]);
		}
	}

	// �����������Ч��
	public static int shu(String[] exp) {
		int s = 0;
		while (exp[s] != null)
			s++;
		return s;
	}
}
