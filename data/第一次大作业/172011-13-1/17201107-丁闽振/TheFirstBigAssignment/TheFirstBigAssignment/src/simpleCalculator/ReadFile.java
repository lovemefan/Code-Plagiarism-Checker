package simpleCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFile {
	private String[] string;//�����洢��ȡ����Ϣ
//���캯��
	ReadFile(int i) {
		string = new String[i];
	}
//��ȡ�ļ�
	public String[] readOperation() throws IOException {
		StringBuffer sb = new StringBuffer("");
		Reader reader = new FileReader("./readFile.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String str = new String();
		int i = 0;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str + "\n");
			string[i] = str;
			i++;
		}
		bufferedReader.close();
		reader.close();
		System.out.println("��ȡ�ļ��ɹ���");
		return string;
	}

}
