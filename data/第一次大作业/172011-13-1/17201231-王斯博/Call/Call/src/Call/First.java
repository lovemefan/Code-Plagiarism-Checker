package Call;

import java.util.Scanner;

public class First {
	public static void main(String[] args) throws Exception {
		CreatFile myfile = new CreatFile();// ����CreateFile()�࣬ʵ���ļ��Ķ�д����
		myfile.WriteFile();// �����ļ�
		Scanner scanner = new Scanner(myfile.file);
		Regular equation = new Regular();// ������ʽ��Regular��������
		int i = 0;
		String[] dej = new String[myfile.readFile(myfile.file)];// �����ʱ����
		String dejReg = null;
		if (scanner.hasNext()) {// �ж��Ƿ��ļ��ɶ�
			do {
				dej[i] = "" + scanner.nextLine();
				// ��֤�������ݵ���ȷ��1
				System.out.println("��" + (i + 1) + "���ñ��ʽΪ��" + dej[i]);
				dej[i] = dej[i].replaceAll(" ", "");// replacAll���ȥ���ַ�����Ŀո�
				dejReg = equation.RegularJudge(dej[i]);
				dejReg = dejReg.replaceAll("null", "");// replacAll���ȥ���ַ�����Ŀո�
				// System.out.println(dejReg);
				if (dejReg.equals("")) {// �жϱ��ʽ����û������
					// ������ʽ��������
					double result = ExperssionEvaluator.evaluate(dej[i]);// ������
					dej[i] = dej[i] + "=" + result;// ����Ⱥźͽ��
					System.out.println("*��" + (i + 1) + "�м�����" + dej[i]);// ���
				} else {
					dej[i] = dej[i] + "\r\nError!" + dejReg;
				}
				i++;
			} while (scanner.hasNextLine());
			scanner.close();// �ر��ļ�
			// �ж������Ƿ����ظ��ļ������У���ɾ������
			dej = myfile.equal(dej);
			myfile.WriteFile(dej);// �½��ļ������ҽ���ʱ���ݵ��뱣�浽�ļ�
		} else
			System.out.println("#�ļ���û�пɶ����ݣ�");
	}
}