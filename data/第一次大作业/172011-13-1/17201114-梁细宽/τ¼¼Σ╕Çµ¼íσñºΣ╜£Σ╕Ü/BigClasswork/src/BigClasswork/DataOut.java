package BigClasswork;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataOut {
	private String str;
	private String fileName;// ������ļ���

	public DataOut() {

	}

	public DataOut(String str, String fileName) {
		this.str = str;
		this.fileName = fileName;
	}

	// ����������ļ�
	public void dataOut() {
		try {
			Writer writer = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(writer);

			bw.write(str + "\r\n");

			bw.close();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
