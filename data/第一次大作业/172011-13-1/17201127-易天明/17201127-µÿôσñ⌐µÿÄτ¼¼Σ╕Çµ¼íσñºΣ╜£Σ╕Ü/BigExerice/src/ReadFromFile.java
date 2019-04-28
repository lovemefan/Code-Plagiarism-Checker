import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {
	// 从文件中读取出的数据
	private ArrayList<String> strings = new ArrayList<>();
	
	public ArrayList<String> getStrings() {
		return strings;
	}
	
	public void setStrings(ArrayList<String> strings) {
		this.strings = strings;
	}
	
	// 从文件中读取数据的方法
	ReadFromFile() throws IOException {
//		File file1 = new File("D:" + File.separator + "input.txt");
		File file1 = new File("input.txt");
		if (!file1.exists()) {
			try {
				file1.createNewFile();
				System.out.println("没有原文件，已创建");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		BufferedReader file = new BufferedReader(new FileReader("D:" + File.separator + "input.txt"));
		BufferedReader file = new BufferedReader(new FileReader("input.txt"));
		// 创建字符串存读取出的每行的数据
		String str = null;

		while ((str = file.readLine()) != null) {
			strings.add(str);
		}
		file.close();
	}
}
