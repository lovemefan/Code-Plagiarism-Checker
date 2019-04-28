import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
	String fileName;
	String str;

	public SaveFile(String fileName, String str) {//有参构造
		this.fileName = fileName;
		this.str = str;
	}

	public void save() {//存储到指定文件
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