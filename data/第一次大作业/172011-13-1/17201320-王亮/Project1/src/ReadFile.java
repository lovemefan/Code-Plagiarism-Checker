import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//��ȡ�ļ���
public class ReadFile {
	private int lines;// ���ʽ�ĸ���
	private String[] s;// ���ʽ

	ReadFile() {// ���캯��
	}

	private int readLines() throws IOException {// ��ȡ�ļ����������ʽ�ĸ���
		lines = 0;
		File file = new File("C:\\Users\\��С��\\Desktop\\dates.txt");
		if (!file.exists()) {// ����ļ�������
			System.out.println("no file");
			System.exit(0);
		}
		Scanner readfile = new Scanner(file);
		while (readfile.hasNext()) {// ����������ʱ
			readfile.nextLine();
			lines++;
		}
		readfile.close();
		return lines;
	}

	public String[] read() throws IOException {// ��ȡ���ʽ��������
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\��С��\\Desktop\\dates.txt"));
		s = new String[readLines()];
		for (int i = 0; i < s.length; i++) {
			s[i] = reader.readLine();
		}
		reader.close();
		return s;
	}

}
