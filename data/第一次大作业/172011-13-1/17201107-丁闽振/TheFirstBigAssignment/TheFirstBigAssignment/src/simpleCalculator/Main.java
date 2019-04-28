package simpleCalculator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {//������
		Scanner input = new Scanner(System.in);
		System.out.println("��л��ʹ�ñ�������!\n�������ļ�����д���ʽ�ĸ��� :\n(ֻ����������,������������С���ļ�����ʽ�ĸ������ᷢ������Խ�����)");
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
		System.out.println("д���ļ��ɹ���");
	}
//����ɾ����ͬ�ı��ʽ
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
//����ȥ�����ʽ�еĿո�
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
