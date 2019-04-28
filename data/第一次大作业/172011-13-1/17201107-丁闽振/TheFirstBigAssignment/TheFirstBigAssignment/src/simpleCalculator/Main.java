package simpleCalculator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {//主函数
		Scanner input = new Scanner(System.in);
		System.out.println("感谢您使用本计算器!\n请输入文件中所写表达式的个数 :\n(只能输入整数,如果输入的整数小于文件里表达式的个数，会发生数组越界错误)");
		int n = input.nextInt();
		String[] str = new String[n];
		Stack stack = new Stack();
		StackInt stack_result = new StackInt();
		ReadFile readFile = new ReadFile(str.length);
		WriterFile writerFile = new WriterFile();
		Check check = new Check();
		str = readFile.readOperation();
		str = delete(str);
		str = deleteBlank(str);
		for (int i = 0; i < str.length; i++) {
			if (!check.check(str[i])) {
				writerFile.StringBufferDemo(check.getExpression());
			} else {
				Transform infix = new Transform(stack, str[i]);
				infix.process();
				String post = infix.getPost();
				GetResult ptr = new GetResult(post, stack_result);
				ptr.operation();
				writerFile.StringBufferDemo(str[i] += "=" + ptr.getResult());
			}
		}
		System.out.println("写入文件成功！");
	}
//用来删除相同的表达式
	public static String[] delete(String[] str) {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < str.length; i++) {
			if (!list.contains(str[i])) {
				list.add(str[i]);
			}
		}
		String[] rowsTemp = list.toArray(new String[list.size()]);
		return rowsTemp;
	}
//用来去除表达式中的空格
	public static String[] deleteBlank(String[] str) {
		String[] str1 = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			StringBuffer sb = new StringBuffer("");
			String[] string = str[i].split(" ");
			for (int j = 0; j < string.length; j++) {
				sb.append(string[j]);
			}
			str1[i] = sb.toString();
		}
		return str1;
	}
}
