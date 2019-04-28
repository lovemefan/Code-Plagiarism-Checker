import java.util.Scanner;

public class File_IO {
	String[] expression = new String[10000];

	// File_IO的构造方法
	public File_IO() {

	}

	// 将文件内容读入
	public String[] FileI() throws Exception {
		java.io.File file = new java.io.File("Expression.txt");
		Scanner input = new Scanner(file);
		for (int i = 0; input.hasNextLine() == true; i++) {
			expression[i] = input.nextLine();
		}
		input.close();
		return expression;
	}

	// 将结果写入文件中
	public void FileO(String[] str) throws Exception {
		java.io.File file = new java.io.File("output.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int i = 0; str[i] != null; i++) {
			output.println(str[i]);
		}
		output.close();
	}
}
