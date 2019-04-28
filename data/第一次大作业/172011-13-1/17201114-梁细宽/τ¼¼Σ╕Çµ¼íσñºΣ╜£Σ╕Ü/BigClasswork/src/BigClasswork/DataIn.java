package BigClasswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataIn {
	String fileName;// ������ļ���
	private String[] expression = new String[50];
	private int i = 0;

	public String[] getExpression() {
		return expression;
	}

	// �õ����ʽ�ĸ���
	public int getI() {
		return i;
	}

	public DataIn(String fileName) {
		this.fileName = fileName;
	}

	// ���������ļ��ж���
	public void dataIn() {
		try {
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String string = null;

			while ((string = bufferedReader.readLine()) != null) {

				expression[i] = string;
				i++;
				// System.out.println(string);
			}
			bufferedReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
