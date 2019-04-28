import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Writer {
	Calculate[] cal = new Calculate[10000];// ���ʽ����
	int size = 0;// ��С

	public Writer() throws FileNotFoundException {// �����ʽ������ʽ������
		File file = new File("Informations.txt");// Create a File instance
		if (file.exists() == false) {// ����ļ���������ֹͣ����
			System.out.println("�ļ�������");
			System.exit(0);
		}
		Scanner input = new Scanner(file);// Creat a Scanner for the file
		while (input.hasNextLine()) {// ��¼���ʽ,������
			cal[size++] = new Calculate(input.nextLine());
		}
		input.close();
	}

	public void writeToFile() throws IOException {// ���ļ��ж�ȡ���ʽ
		File outputFile = new File("expression.txt");// �����ļ�����
		PrintWriter output = new PrintWriter(outputFile);// ����һ���������
		for (int i = 0; i < size; ++i) {
			if (!isExist(cal, i)) {// ���������ͬ����Ը����󣬲���ͬ�����
				printTofile(cal[i], output);
			}
		}
		output.close();
		System.out.println("д�����");
	}

	private boolean isExist(Calculate[] s, int pos) {// �Ƿ���ڸ�����
		for (int i = 0; i < pos; ++i) {
			if (s[pos].filter.getFinalString().equals(s[i].filter.getFinalString())) {
				return true;
			}
		}
		return false;
	}

	private void printTofile(Calculate cal, PrintWriter output) throws IOException {// �����д���ļ�
		if (cal.filter.getIsLegal() == true) {// ������ʽ�Ϸ�
			output.println(cal.printExp());// д����ʽ������ļ���
		} else {// ���ʽ����
			output.println(cal.filter.getErrorString());// д�������Ϣ
		}
	}
}
