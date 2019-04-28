



import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		File file1 = new File("output.txt");
		File file2 = new File("input.txt");

		String pexp = "";
		String oexp = "";
		double iexp = 0;

		IStack b = new IStack();
		Compute c = new Compute();
		Regex d = new Regex();
		IFile file = new IFile();

		String[] check = new String[200];
		check = file.read(file2);

		int i = 0;
		while (!check[i].equals("")) {
			if (!d.iCheck(check[i]).equals("")) {
				file.write(file1, d.iCheck(check[i]));
			} else {
				String exp = check[i];
				Main p = new Main();
				pexp = p.exception(exp); // ����ո�֮�����׺���ʽ
				oexp = b.inFix(pexp); // �õ��ĺ�׺���ʽ
				iexp = c.compute(oexp); // �����׺���ʽ�õ��Ľ��
				file.write(file1, Double.toString(iexp));
			}
			i++;
		}
		
	}
//����׺���ʽ�в���ո�
	public String exception(String exp) {
		String rexp = "";
		String oexp = "";
		rexp = exp.replaceAll(" ", "");
		for (int i = 0; i < rexp.length(); i++) {
			char ch = rexp.charAt(i);
			if (ch >= '0' && ch <= '9') {
				oexp += ch;
			} else
				oexp += " " + ch + " ";
		}
		return oexp;
	}
}