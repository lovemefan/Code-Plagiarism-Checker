package shangKe;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writeMethod1 {
	String uzi;//�������

	public writeMethod1() {

	}

	public writeMethod1(String uzi) {
		this.uzi=uzi;
	}

	public void save() {//�����ʽ���߳�����Ϣ�����ļ���
		String fileName = "D:\\kkk.txt";

		try {
			Writer iii = new FileWriter(fileName, true);
			BufferedWriter ll = new BufferedWriter(iii);

			iii.write(uzi + "\r\n");

			ll.close();
			iii.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}