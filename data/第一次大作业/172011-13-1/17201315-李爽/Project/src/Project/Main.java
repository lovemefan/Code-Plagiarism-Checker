package Project;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] arge) throws Exception {
		File file = new File();
		String[] expression = file.outputFile();// ����ļ�����ı��ʽ
		//�ļ���Ϣ����
		expression = file.outputFile();
		int s = file.index(expression);
		String[] postExpression = new String[s];// ��ź�׺���ʽ
		String[] tureExpr = new String[s];// ��Ŵ�������ı��ʽ
		String[] dealBlankExc = new String[s];// ��Ŵ���ո�ı��ʽ
		toPost to = new toPost();
		for (int i = 0; i < s; i++) {
			dealBlankExc[i] = dealBlank(expression[i]);
			String culExp [] = dealBlankExc[i].split("");
			//�����һ�����Ǹ���
			if(culExp [0].equals("-")){
				dealBlankExc[i] = "0" +dealBlankExc[i]	;
			}
			//�����м���ڵĸ���
			tureExpr[i] = dealBlankExc[i].replace("(-", "(0-");
			postExpression[i] = to.toPost(tureExpr[i]);
		}
		file.inputFile(expression, s, dealBlankExc, postExpression);
	}

	//����ļ�������ʽ�Ŀո�
	public static String dealBlank(String exc) {
		String s = "";
		for (int i = 0;i < exc.length();i++) {
			s = exc.replace(" ", "");
		}
		return s;
	}
}
