import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Check {

	ArrayList<String> s1;
	FileRead f = new FileRead(); // ����FileRead�Ķ���f

	public Check() { // s1�õ���������
		s1 = f.getStr();
	}

	// �ж����������Ƿ���Ϲ淶
	public void pan() {
		int i = 0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;
		for (i = 0; i < s1.size(); i++) {
			for (j = i + 1; j < s1.size(); j++) {
				if (s1.get(i).compareTo(s1.get(j)) == 0) {
					System.out.println(s1.get(j) + "\nERROR\n" + "#���������ظ�������");
					s1.remove(j);
				}
			}
		}
		System.out.println("�����ظ������s1�Ĵ�СΪ:" + s1.size());
		System.out.println("��������ظ������s1������Ϊ��" + s1);
		for (i = 0; i < s1.size(); i++) {
			// �ж����������Ƿ�Ϊ���ַ���
			if (s1.get(i).compareTo("") == 0) {
				System.out.println(s1.get(i) + "\nERROR\n" + "#����Ϊ���ַ�����Ϊ��Ч��������");
				s1.remove(i);
			}

			// �����ַָ�s1�����з���
			String[] t = s1.get(i).split("\\d");
			for (j = 0; j < t.length; j++) {
				// �ж�������������Ƿ��зǷ��ַ�
				if (t[j].matches("[^\\+\\-\\*\\/\\(\\)]")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#����Ƿ��ַ�");
					s1.remove(s1.get(i));
					break;
				}
				// �ж������������Ƿ��������������
				if (t[j].matches("[\\+\\-\\*\\/]{2,}")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#�������������");
					s1.remove(s1.get(i));
					break;
				}
				// �ж������������Ƿ��п�����
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#���������");
					s1.remove(s1.get(i));
					break;
				}
				// �ж���������������Ƿ�ƥ��
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\([\\+\\-\\*\\/]{0,}")
						|| t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					sum1 = sum1 + 1;
				}
				if (t[j].matches("\\(\\(")) {
					sum1 = sum1 + 2;
				}
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\)[\\+\\-\\*\\/]{0,}")
						|| t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					sum2 = sum2 + 1;
				}
				if (t[j].matches("\\)\\)")) {
					sum2 = sum2 + 2;
				}
			} // forj
			if (sum1 != sum2) {
				System.out.println(s1.get(i) + "\nERROR\n" + "#�������Ų�ƥ��");
				s1.remove(s1.get(i));
			}
			sum1 = 0;
			sum2 = 0;
		} // fori
		System.out.println("���������Ч����Ϊ:" + s1);

	}// pan

	// �����Ϲ淶�����󱣴浽output.txt�ļ�
	public void WriterData() {
		File file = new File("output.txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		for (i = 0; i < s1.size(); i++) {
			output.println(s1.get(i));
		}
		output.close();
	}// writer

}
