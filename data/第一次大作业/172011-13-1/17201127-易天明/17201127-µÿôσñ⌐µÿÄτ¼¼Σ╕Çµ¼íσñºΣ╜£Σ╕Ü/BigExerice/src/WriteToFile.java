import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {	
	public static void writeToFile(String string) throws IOException {
//		File file = new File("D:" + File.separator + "output.txt");
		File file = new File("output.txt");
		if (!file.exists()) {
			try {
				// ����ļ��Ҳ�������newһ��
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream out = new FileOutputStream(file, true);
		byte[] bs = (string + "\r\n").getBytes();
		try {
			//д���ļ�
			out.write(bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}
	
	//ɾ��ԭ�ļ�����ɾ���Ѵ��ڵ�����
	public static void fileDel() throws IOException {
//		File file = new File("D:" + File.separator + "output.txt");
		File file = new File("output.txt");
		if (file.exists()) {
			file.delete();
		}
	}
}
