import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fileIO {
	ArrayList<String> str = new ArrayList<String>(); // ����һ���ַ�������

	public void fileInput() throws IOException {// ������ȡ���ʽ
		File file = new File("d:\\1.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		for (int i = 0;; i++) {
			str.add(bufferedReader.readLine());// ��������ȡ
			if (str.get(i) == null)
				break;
		}
		bufferedReader.close();
	}

	// ������д���ļ���
	public void fileOutput(String t) throws IOException {
		PrintWriter output = new PrintWriter("d:\\2.txt");
		output.println(t);
		output.close();
	}

	// ��������ÿһ�����ʽ
	public String setexpression(int t) {
		return str.get(t);
	}
}