import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileExpression {
	public ArrayList<String> Reader() throws IOException {
		// 将文件中的字符串读取出来
		FileReader fr = new FileReader("计算.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> list = new ArrayList<String>();
		// 将读取到的字符串放入数组列表中
		String str;
		while ((str = br.readLine()) != null) {
			list.add(str.replaceAll("\\s*", ""));
		}
		br.close();// 关闭输入流
		// System.out.println(list);//输出数组中的所有元素
		return list;
	}

	// 将计算后的结果写入2.txt
	public void Writer(String[] list) throws IOException {
		FileWriter fw = new FileWriter("结果.txt");
		/* fw.write("你输入的表达式计算结果:\r\n"); */
		for (int i = 0; i < list.length; i++) {
			fw.write(list[i] + "\r\n");
		}
		fw.close();// 关闭输出流

	}

}
