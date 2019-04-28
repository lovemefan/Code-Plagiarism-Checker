import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//����
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ��������
		String[] s = readFile();
		String[] str = testToString(s);
		double[] values = testToValue(str);
		outputFile(s, values);
	}

	private static String[] readFile() throws IOException {// ��ȡ�ļ�
		ReadFile file = new ReadFile();// �����ļ���ȡ�Ķ���
		String[] s = file.read();
		Check check1 = new Check(s);// ��������У����Ķ���
		s = check1.test00();// ȥ��
		for (int i = 0; i < s.length; i++) {// ���˿ո�
			s[i] = s[i].replaceAll(" ", "");
		}
		return s;

	}

	private static boolean checkString(String s) {// ����У��
		Check checks = new Check(s);// ��������У����Ķ���
		if (!checks.test()) {// ������ʽ�Ϸ�
			return false;
		}
		return true;
	}

	private static String checkPrint(String s) {// �õ����ʽ���Ϸ��Ĳ���
		String s1;
		Check checks = new Check(s);// ����Check��Ķ���
		checks.test();
		s1 = checks.get();//
		return s1;
	}

	private static String toStrings(String expstr) {// ��׺ת��׺������Ϊ��׺���ʽ
		SeqStack<String> stack = new SeqStack<String>(expstr.length());// ����˳��ջ����
		ToString change = new ToString(stack, expstr);// ����ToString�����
		String postfix = change.process();
		return postfix;
	}

	private static String[] testToString(String[] s) {// ��������ʽת��Ϊ��׺���ʽ������Ϊ��������
		String[] str = new String[100];// �Ϸ����ʽ����
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (checkString(s[i])) {
				str[j] = toStrings(s[i]);// �Ϸ���ת��Ϊ��׺���ʽ
				j++;
			}
		}
		return str;
	}

	private static double toValues(String postfix) {// �ɺ�׺���ʽ��ֵ������Ϊ��׺���ʽ
		LinkedStack<Double> stack = new LinkedStack<Double>();// ������ʽջ����
		ToValue change = new ToValue(postfix, stack);// ����ToValue�����
		double result = change.process();
		return result;
	}

	private static double[] testToValue(String[] str) {// �����ʽ������ֵ������Ϊ�Ϸ��ַ�ת���õ��ĺ�׺���ʽ
		int i = 0;
		for (; i < str.length; i++)// �õ����ʽ�����ʵ�ʳ���
		{
			if (str[i] == null)
				break;
		}
		double[] values = new double[i];// �������
		for (int j = 0; j < values.length; j++) {
			values[j] = toValues(str[j]);// ��ֵ
		}
		return values;
	}

	private static void outputFile(String[] s, double[] values) throws IOException {// �ļ����������Ϊ��������ͽ������
		File file1 = new File("C:\\Users\\��С��\\Desktop\\results.txt");
		if (file1.exists()) {// �ж��ļ��Ƿ���ڻ�����
			System.out.println("File aleaday exists!");
			System.exit(0);
		}
		PrintWriter outfile = new PrintWriter(file1);// �������
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (checkString(s[i]) && ((values[j] - (int)values[j]) == 0)) {// ������ʽ�Ϸ�����С�������Ϊ��
				outfile.println(s[i] + "=" + (int)values[j]);// ��С�����Ϊ���С��תΪ������
				j++;
			} 
			else if(checkString(s[i]) && ((values[j] - (int)values[j]) != 0)){// ������ʽ�Ϸ�����С������治Ϊ��
				outfile.println(s[i] + "=" + values[j]);
				j++;
			}
			else {// ���Ϸ��������������
				outfile.println("ERROR");
				outfile.println("#" + checkPrint(s[i]));
			}
		}
		outfile.close();// �ر��ļ�
	}

}
