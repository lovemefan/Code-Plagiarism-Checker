import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("express.txt");// ���ļ��ж�ȡ����
		File file1 = new File("result.txt");//��������浽�ļ�
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(file1);
		while (input.hasNext()) {
			String str1 = input.nextLine();
			String str = str1.replace(" ", "");// ���ַ����еĿո�ȥ��
			Check c = new Check();
			String result = c.check(str);// �жϱ��ʽ�Ƿ�Ϸ�
			System.out.println(result);
			output.println(result);// ������д���ļ�
		}
		output.close();// �ر��ļ�
		input.close();// �ر��ļ�
	}

}
		
	

