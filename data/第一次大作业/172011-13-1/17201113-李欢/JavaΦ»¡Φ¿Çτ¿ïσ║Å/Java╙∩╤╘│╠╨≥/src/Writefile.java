import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Writefile {
	String exp;//�������

	public Writefile() {

	}

	public Writefile(String newExp) {
		exp = newExp;
	}

	public void writeMethod3() {//�����ʽ���߳�����Ϣ�����ļ���
		String fileName = "D:\\fff.txt";

		try {
			Writer ter = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(ter);

			bw.write(exp + "\r\n");

			bw.close();
			ter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
