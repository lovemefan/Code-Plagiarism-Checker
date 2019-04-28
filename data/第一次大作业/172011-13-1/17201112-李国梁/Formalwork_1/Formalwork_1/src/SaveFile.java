import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
	String fileName;
	String str;

	public SaveFile(String fileName, String str) {//�вι���
		this.fileName = fileName;
		this.str = str;
	}

	public void save() {//�洢��ָ���ļ�
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(str);
			out.newLine();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}