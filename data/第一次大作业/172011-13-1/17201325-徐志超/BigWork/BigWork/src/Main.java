import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		File file = new File("xzc.txt");
		Scanner input = new Scanner(file);
		// ��������
		InfixToSuffix in = new InfixToSuffix();
		SufToResult s = new SufToResult();
		Check c;

		String[] result = new String[100];// ������������
		int i = 0;
		while (input.hasNext()) {// ���ļ�������

			String exp = input.nextLine();// ��
			c = new Check(exp);
			if (!exp.equals("")){
				// �����ͷ�и���
				if (exp.charAt(0) == '-' && Character.isDigit(exp.charAt(1))) {
					exp = '0' + exp;
				}
			}
			// �ж��Ƿ�ͨ��У��
			if (c.cheakAll()) {
				exp = exp.replace("(-", "(0-");// ������ǰ���0
				double a = 0;
				a = s.getResult(in.InfToSuf(exp));
				if(String.valueOf(a) != "Infinity"){
					result[i] = exp + "=" + String.valueOf(a);
				}
				else{
					result[i] = "ERROR\r\n#��������Ϊ��";
				}
			} 
			else {
				result[i] = c.errorAll();
			}
			i++;
		}
		input.close();// �ر��ļ�
		FileWrite f = new FileWrite();
		// �����д���ļ�
		f.fileWrite(result);
	}
}