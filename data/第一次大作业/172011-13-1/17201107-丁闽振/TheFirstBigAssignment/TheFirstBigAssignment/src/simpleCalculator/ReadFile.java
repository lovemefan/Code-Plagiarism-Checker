package simpleCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFile {
	private String[] string;//用来存储读取的信息
//构造函数
	ReadFile(int i) {
		string = new String[i];
	}
//读取文件
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
		System.out.println("读取文件成功！");
		return string;
	}

}
