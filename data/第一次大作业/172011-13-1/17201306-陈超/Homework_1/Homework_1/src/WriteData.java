import java.io.File;
import java.io.PrintWriter;

//���ļ�д������
public class WriteData {

	// �չ��췽��
	public WriteData() {

	}

	// ���ι��췽��,���������ս��
	public void writeData(String allResult) throws Exception {
		File file = new File("result.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		// �Զ��ر���Դ
		try (PrintWriter output = new PrintWriter(file);) {
			output.println(allResult);
			output.close();
		}
	}
}
