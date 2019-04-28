package ooExperiment2;


import java.util.Stack;

public class Main {
	public static void main(String[] ages) {

		deals(); //����deal()����

	}

	public static void deals()  {

		Io io = new Io();   //����Io�����io
		Check check = new Check();   //����Check�����check
        
		//��ȡ�ļ��е���ѧ���ʽ
		while (io.getHasNextLine()) {
			String express = io.getNextLine();
			String exp = deal(express);   //����deal()�������б��ʽԤ����
			String b = check.match(exp);  //����Check����match()�������б��ʽ����֤
			if (b.equals("true")) {
				Stack<String> stack = new Stack<String>(); // ����ջ��ջ�ڴ��ַ���
				String post = "";

				InfixToPost inf = new InfixToPost(stack, post);   //����InfixToPost�� ����inf
				inf.process(exp);                                 //����InfixToPost���е�process()����������׺���ʽת��Ϊ��׺ ���ʽ

				Stack<Integer> stack_result = new Stack<>();      //����ջ����ź�׺���ʽ
				PostToResult pos = new PostToResult(stack_result);//����PostToResult�����pos
				pos.operate(inf);                                 //����PostToResult���е�operate()�������ú�׺���ʽ������ʽ

				io.getAns(exp + " = " + String.valueOf(pos.getResult())+"\n");  //�����ʽ�����������ļ���
			}else{
				io.getAns(b+"\n");                                           //������ı�ʾʽ����������ļ���
			}

		}

	}

	// Ԥ�������������������
	public static String deal(String express) {
		String exp = "";

		for (int i = 0; i < express.length() - 1; i++) { // ֻ�ܵ������ڶ���
			char temp1 = express.charAt(i);// ���ַ����е��ַ��������

			char temp2 = express.charAt(i + 1);

			if (isDigital(temp1) && isDigital(temp2)) { // �ж��Ƿ��Ƕ�λ��
				exp += temp1;
			} else {
				exp += temp1 + " ";
			}
		}
		exp += express.charAt(express.length() - 1);// ���һ���ַ�����
		return exp;
	}

	// �ж��Ƿ�������
	public static boolean isDigital(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		} else {
			return false;
		}
	}

}
