import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// ����IO��
public class FileToFile {
	// ���ݴ洢
	ArrayList<String> data = new ArrayList<>();

	public FileToFile() {

	}

	// ���ļ�д�ļ�
	public void inputFile() throws IOException {
		File file = new File("input.txt");
		File outputFile = new File("output.txt");
		//�ж��ļ��Ƿ����
		if (!file.exists()) {
			System.out.println("�ļ�������");
			System.exit(0);
		}
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(outputFile);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			Check check = new Check(str);
			str = check.getExpression();
			// ���ݲ���
			if (!data.contains(str)) {
				outputFile(check, output);
				data.add(str);
			}
		}
		output.close();
		System.out.println("�ɹ�");
		input.close();
	}

	// ������ļ�
	private void outputFile(Check check, PrintWriter output) {
		String str = check.getExpression();
		if (check.getLegal()) {
			Calculate c = new Calculate(check);
			// �ڼ���֮��֪������Ϊ0�����
			c.compute();
			if (check.getLegal()) {
				output.println(str + "=" + c.getNum());   //��������д���ļ�
			} else {
				output.println("ERROR\n#" + check.getError());  //��������Ϣд���ļ�
			}
		} else {
			output.println("ERROR\n#" + check.getError());  //��������Ϣд���ļ�
		}
	}
}
