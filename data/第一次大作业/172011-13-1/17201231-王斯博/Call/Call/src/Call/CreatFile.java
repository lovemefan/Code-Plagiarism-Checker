package Call;

import java.io.File;
import java.util.Scanner;

public class CreatFile {
	java.io.File file = new java.io.File("calculate.txt");

	// ���ļ��д����������뵽����
	String LookFile() throws Exception {
		Scanner input = new Scanner(this.file);
		String de = null;
		while (input.hasNext()) {
			de = "" + input.nextLine();
		}
		input.close();
		return de;
	}

	// д�����ݵ��ļ�
	void WriteFile() throws Exception {
		if (!file.exists()) {
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			output.close();
		}
	}

	void WriteFile(String[] result) throws Exception {
		if (file.exists()) {
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			for (int i = 0; i < result.length; i++) {
				output.println(result[i]);
			}
			output.close();
		}
	}

	// �ж��ļ��ж�����
	public int readFile(File fis) throws Exception {
		int count = 0;
		Scanner scanner = new Scanner(fis);
		while (scanner.hasNextLine()) {
			scanner.nextLine();
			count++;
		}
		scanner.close();
		System.out.println("*��ʱ�ļ���:" + count + "��");
		return count;
	}

	// ɾ����ͬ��ֵ
	public String[] equal(String[] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i].equals(result[j])) {
					result = delete(j, result);
				}
			}
		}
		System.out.println("#������ͬ�У�ϵͳ��Ϊ���Զ�ɾ����ͬ�У�");
		return result;
	}

	// ɾ��������ĳ���ڵ����ϸ����
	public String[] delete(int index, String array[]) {
		// �����ɾ����ʵ���Ǹ���ǰһλ
		String[] arrNew = new String[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			if (i < index) {
				arrNew[i] = array[i];
			} else {
				arrNew[i] = array[i + 1];
			}
		}
		return arrNew;
	}
}