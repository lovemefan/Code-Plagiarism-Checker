import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//读取文件类
public class ReadFile {
	private int lines;// 表达式的个数
	private String[] s;// 表达式

	ReadFile() {// 构造函数
	}

	private int readLines() throws IOException {// 读取文件行数即表达式的个数
		lines = 0;
		File file = new File("C:\\Users\\王小亮\\Desktop\\dates.txt");
		if (!file.exists()) {// 如果文件不存在
			System.out.println("no file");
			System.exit(0);
		}
		Scanner readfile = new Scanner(file);
		while (readfile.hasNext()) {// 当还有内容时
			readfile.nextLine();
			lines++;
		}
		readfile.close();
		return lines;
	}

	public String[] read() throws IOException {// 读取表达式存入数组
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\王小亮\\Desktop\\dates.txt"));
		s = new String[readLines()];
		for (int i = 0; i < s.length; i++) {
			s[i] = reader.readLine();
		}
		reader.close();
		return s;
	}

}
