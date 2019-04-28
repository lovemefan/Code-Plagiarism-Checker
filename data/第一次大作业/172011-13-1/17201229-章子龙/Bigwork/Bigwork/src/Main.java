import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		File file1 = new File("input.txt");
		
		Scanner input = new Scanner(file1);

		File file2 = new File("ouput.txt");
		
		PrintWriter output = new PrintWriter(file2);

		Convert con = new Convert();

				   
		ArrayList<String> s1 = new ArrayList<String>();   //���ļ��ļ���ʽ�����ַ�������
		 
		ArrayList<String> s2 = new ArrayList<String>();    //��s1�е��ַ���ȥ�ո�����

		// ���ļ���ı��ʽ�����ַ�������
		while (input.hasNextLine()) {
			
			s1.add(input.nextLine());
			
		}

		// ������ʽ
		// ȥ���ַ����еĿո�
		for (int i = 0; i < s1.size(); i++) {
			s2.add(s1.get(i).replaceAll(" ", ""));   //��s1�е��ַ���ȥ�ո�����s2

		}


		// ȥ����ͬ���ַ���
		for (int i = 0; i < s2.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (s2.get(j).equals(s2.get(i))) {
					s2.remove(i);
				}
			}

		}

		Check c = new Check();
		float key;  //��¼����ʽ�Ľ��

		//�жϼ���ʽ�Ƿ�Ϸ�
		for (int i = 0; i < s2.size() ; i++) {
			if (!s2.get(i).matches(".*[\\(-\\+|\\-|\\/|\\d].*")) {
				output.println(s2.get(i));
				output.println("                   #error,���Ƿ��ַ�");
			}

			else if (s2.get(i).matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
				output.println(s2.get(i));
				output.println("                   #error,���������");
			}

			else if (s2.get(i).matches(".*[\\(][\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,������");
			}

			else if (c.check(s2.get(i)) == 0) {
				output.println(s2.get(i));
				output.println("                   #error,���Ų�ƥ��");
			}

			else if (c.check2(s2.get(i),1) == 0){
				output.println(s2.get(i));
				output.println("                   #error,��ͷ����Ϊ'('����������");
			}
			
			else if(c.check2(s2.get(i), s2.get(i).length()) == 0){
				output.println(s2.get(i));
				output.println("                   #error,��β����Ϊ')'����������");
			}
			
			else if (s2.get(i).matches(".*[\\(][\\+\\*\\/].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'���������");
			}

			else if (s2.get(i).matches(".*[\\+\\-\\*\\/][\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'ǰ�������");
			}

			else if (s2.get(i).matches(".*[\\d|\\(|\\)][\\(].*")) {
				output.println(s2.get(i));
				output.println("                   #error,'('ǰ���������");
			}

			else if (s2.get(i).matches(".*[\\)][\\d|\\(|\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'���������");
			}

			else {

				key = con.Convert(s2.get(i));
				output.println(s2.get(i));
				output.println("                                = " + key);
			}
		}
		output.close();
		System.out.println("�������");
	}
}
