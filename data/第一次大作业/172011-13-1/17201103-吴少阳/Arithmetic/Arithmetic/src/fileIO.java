import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fileIO {
	ArrayList<String> str = new ArrayList<String>(); // 定义一个字符串集合

	public void fileInput() throws IOException {// 用来读取表达式
		File file = new File("d:\\1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		for (int i = 0;; i++) {
			str.add(bufferedReader.readLine());// 按行来读取
			if (str.get(i) == null)
				break;
		}
		bufferedReader.close();
	}

	// 将数据写入文件中
	public void fileOutput(String t) throws IOException {
		PrintWriter output = new PrintWriter("d:\\2.txt");
		output.println(t);
		output.close();
	}

	// 用来传出每一个表达式
	public String setexpression(int t) {
		return str.get(t);
	}
}