import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileExpression {
	public ArrayList<String> Reader() throws IOException {
		// ���ļ��е��ַ�����ȡ����
		FileReader fr = new FileReader("����.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> list = new ArrayList<String>();
		// ����ȡ�����ַ������������б���
		String str;
		while ((str = br.readLine()) != null) {
			list.add(str.replaceAll("\\s*", ""));
		}
		br.close();// �ر�������
		// System.out.println(list);//��������е�����Ԫ��
		return list;
	}

	// �������Ľ��д��2.txt
	public void Writer(String[] list) throws IOException {
		FileWriter fw = new FileWriter("���.txt");
		/* fw.write("������ı��ʽ������:\r\n"); */
		for (int i = 0; i < list.length; i++) {
			fw.write(list[i] + "\r\n");
		}
		fw.close();// �ر������

	}

}
