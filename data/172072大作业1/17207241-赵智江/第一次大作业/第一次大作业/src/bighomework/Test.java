package bighomework;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		outPut();
	}

	public static void outPut() throws FileNotFoundException {
		File file1 = new File();
		Calculate cal1 = new Calculate();
		String[] Except = new String[1000];
		Except = file1.OutputFile();// ���ļ��л�ȡ�ı��ʽ
		System.out.println("�ļ���ȡ���");
		Check check1 = new Check();
		String[] Except1 = new String[1000];// ��ȥ�ո����ַ���
		String[] Except3 = new String[1000];// ���ó�������ַ���

		int a = 0;
		for (int i = 0; Except[i] != null; i++) {
			Except1[i] = check1.cleanBlank(Except[i]);// ��ȥ�ַ����еĿո�
			int y = Except1[i].length();
//			System.out.println(Except1[i]);
//			System.out.println(y);
			String Except2 = check1.addBlank(Except1[i]);// �ÿո����ֺ�������ֿ�
			String Except4 = check1.Judge(Except2);// У���ַ���
			int x = Cheat(Except1[i], i, Except1);//�ж��ַ����Ƿ��ظ�
			if(y==0){
				Except3[i] = "s0";//���ַ�
		        a++;
			}
			else if (Except4.equals("s1")) {
				Except3[i] = "s1";//����
				a++;
			} else if (Except4.equals("s2")) {
				Except3[i] = "s2";//0
				a++;
			} else if (x == 1) {
				Except3[i] = "s5";//#���ʽ�ظ�����";
				a++;
			} 
			else if(Except4.equals("s4")){
				Except3[i] = "s4";//�Ƿ��ַ�
				a++;
			}	
			else if(Except4.equals("s3")){
				Except3[i] = "s3";//��ʽ
				a++;
			}	
			else {
			
				Except3[i] = cal1.Cal(Except4);// ���㷵�ؽ��
				a++;
			}
		}
		file1.InputFile1(Except1, Except3, a);// ��ԭ���ʽ����������ʽ�ĸ������뺯��
		System.out.println("�ļ�д����ɣ������ļ��в鿴");
	}

	public static int Cheat(String s, int x, String[] s1) {
		int m = 0;
		for (int i = 0; i < x; i++) {
			if (s.equals(s1[i])) {
				m = 1;
			} else {
				continue;
			}

		}
		return m;

	}
}
