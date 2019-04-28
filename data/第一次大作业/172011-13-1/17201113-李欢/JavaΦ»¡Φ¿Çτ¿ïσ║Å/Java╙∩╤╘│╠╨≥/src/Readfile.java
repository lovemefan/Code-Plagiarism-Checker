import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Readfile {

	String filename;// 类的属性，文件名称

	String[] xep = new String[50];

	public Readfile() {

	}

	public Readfile(String filename) {
		this.filename = filename;
	}

	public void readMethod2()// 将文件的内容读取出来
	{
		String fileName = "D:/sss.txt";
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			line = in.readLine();
			int i = 0;
			while (line != null) {

				xep[i] = line;
				line = in.readLine();
				i++;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String[] getXep() {// 返回读取到的字符串数组，即表达式数组

		return xep;
	}
}
