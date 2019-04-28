package BigClasswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataIn {
	String fileName;// 传入的文件名
	private String[] expression = new String[50];
	private int i = 0;

	public String[] getExpression() {
		return expression;
	}

	// 得到表达式的个数
	public int getI() {
		return i;
	}

	public DataIn(String fileName) {
		this.fileName = fileName;
	}

	// 将数据重文件中读入
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
