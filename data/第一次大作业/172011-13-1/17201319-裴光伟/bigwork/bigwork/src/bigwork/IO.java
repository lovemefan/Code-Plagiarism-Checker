package bigwork;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	// 从文件中读取数据
	public static String[] scan() throws Exception {
		File arithFile = new File("arith.txt");
		String[] exp = new String[1000];// 从文件中读取请求的数量
		if (!arithFile.exists()) {
			System.out.println("无输入文件,请确认输入文件存在");
			System.exit(1);
		}
		try (Scanner input = new Scanner(arithFile)) {
			int i = 0;
			while (input.hasNextLine()) {
				String a = input.nextLine();
				if(RegularExpression.blankPan(a))
					exp[i] = "\r\nERROR\r\n#表达式为空";
				else {
					exp[i] = a;
				}
				i++;
			}
		}
		return exp;
	}

	// 向文件中输入数据
	public static void prin(String[] exp, int s) throws Exception {
		File arithFile = new File("arithresult.txt");
		try (PrintWriter output = new PrintWriter(arithFile)) {
			for (int i = 0; i < s; i++)
				output.println(exp[i]);
		}
	}

	// 计算数组的有效数
	public static int shu(String[] exp) {
		int s = 0;
		while (exp[s] != null)
			s++;
		return s;
	}
}
