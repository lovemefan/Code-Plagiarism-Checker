
//�ļ��������
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class IO {
	InputStream inputStream = System.in;
	PrintStream outputStream = System.out;
	Scanner input;

	IO() {
		try {
			inputStream = new FileInputStream("input.txt");
			outputStream = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
		input = new Scanner(inputStream);
	}

	public Boolean getHasNextLine() {
		return input.hasNextLine();// �ж��ļ��Ƿ�����һ��
	}

	public String getNextLine() {
		return input.nextLine(); // �����ļ���������Ϣ
	}

	public void getAns(String ans) {
		outputStream.println(ans); // ���õ�����Ϣ������ļ���
	}
}
