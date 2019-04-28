import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] array = new String[1000];
		String str;
		int i = 0;
		InputStream inputStream = System.in;
		PrintStream outputStream = System.out;
		try {
			inputStream = new FileInputStream("input.txt");
			outputStream = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
		Scanner input = new Scanner(inputStream);
		while ((input.hasNextLine())) {
			str = input.nextLine();
			array[i] = str;
			str = str.replaceAll(" ","");//ɾ���ո�					
			if (!str.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// �Ƿ��ַ�
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) { //��������
				outputStream.println("ERROR\r\n"+"#" +str); // ---.
				continue;
			}

			if (str.matches(".*(\\)\\d|\\d\\().*")) { // ���ұ������ֵ���� �� (��������ֵ����
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\(\\)).*")) { // ƥ�������
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // ��������ߺ��������
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\(\\+|\\(/|\\(\\*).*")) { // �������ұ��������
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches("[\\+\\*\\/].*")) {// �ж��Է��ſ�ͷ
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}
			if (str.matches(".*\\/0.")) { // /0
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}
			if (str.matches(".*[\\+\\-\\*\\/]")) {// ���һ���ַ�Ϊ�����
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			} 
	else {
				outputStream.println(str+"="+StringToArithmetic.stringToArithmetic(str));
			
			i++;
			}
		}

	}
}