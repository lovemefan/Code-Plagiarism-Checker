import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {
	// ���ļ��ж�ȡ��������
	private ArrayList<String> strings = new ArrayList<>();
	
	public ArrayList<String> getStrings() {
		return strings;
	}
	
	public void setStrings(ArrayList<String> strings) {
		this.strings = strings;
	}
	
	// ���ļ��ж�ȡ���ݵķ���
	ReadFromFile() throws IOException {
//		File file1 = new File("D:" + File.separator + "input.txt");
		File file1 = new File("input.txt");
		if (!file1.exists()) {
			try {
				file1.createNewFile();
				System.out.println("û��ԭ�ļ����Ѵ���");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		BufferedReader file = new BufferedReader(new FileReader("D:" + File.separator + "input.txt"));
		BufferedReader file = new BufferedReader(new FileReader("input.txt"));
		// �����ַ������ȡ����ÿ�е�����
		String str = null;

		while ((str = file.readLine()) != null) {
			strings.add(str);
		}
		file.close();
	}
}
