import java.util.Scanner;

public class File_IO {
	String[] expression = new String[10000];

	// File_IO�Ĺ��췽��
	public File_IO() {

	}

	// ���ļ����ݶ���
	public String[] FileI() throws Exception {
		java.io.File file = new java.io.File("Expression.txt");
		Scanner input = new Scanner(file);
		for (int i = 0; input.hasNextLine() == true; i++) {
			expression[i] = input.nextLine();
		}
		input.close();
		return expression;
	}

	// �����д���ļ���
	public void FileO(String[] str) throws Exception {
		java.io.File file = new java.io.File("output.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int i = 0; str[i] != null; i++) {
			output.println(str[i]);
		}
		output.close();
	}
}
