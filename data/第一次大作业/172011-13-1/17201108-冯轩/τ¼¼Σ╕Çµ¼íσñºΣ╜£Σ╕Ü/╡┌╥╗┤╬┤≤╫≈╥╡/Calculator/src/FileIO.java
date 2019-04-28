import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileIO {

	// ���ļ�����������뵽�ַ�����
		public static String fileInput(String path) throws IOException{
			File file = new File(path);
			if (!file.exists() || file.isDirectory()) { // �ж��ļ��Ƿ����
				System.out.println("�ļ������ڻ��·��ΪĿ¼��");
				System.exit(-1);
			}
			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[1];
			StringBuffer sb = new StringBuffer();
			while ((fis.read(buf)) != -1) {
				sb.append(new String(buf));
				buf = new byte[1];// �������ɣ�������ϴζ�ȡ�������ظ�
			}
			fis.close();
			return sb.toString();
		}

		// ���ַ���������ļ�
		public static void fileOutput(String path, String content) throws IOException{
			File file = new File(path);
			if (!file.exists() || file.isDirectory()) {
				System.out.println("�ļ������ڻ��·��ΪĿ¼��");
				System.exit(-1);
			}
			FileOutputStream fis = new FileOutputStream(file, true);
			PrintStream p = new PrintStream(fis);
			p.println(content);
			p.close();
			System.out.println("DONE!");
		}
}
