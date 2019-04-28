package jsq;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
	private static Scanner file;

	public static void main(String args[]) {
		InputStream inputfile = System.in;
		PrintStream outputfile = System.out;
		try {
			inputfile = new FileInputStream("input.txt");
			outputfile = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File not found!");
			System.exit(1);
		}
		file = new Scanner(inputfile);
		Map<String, Double> map = new HashMap<String, Double>();// ��map��ƥ������ʽ�Ƿ�����˶��
		Calculate operate = new Calculate();
		while (file.hasNextLine())// �ļ��Ƿ������ĩβ
		{
			String str = file.nextLine();
			 Verdict jud = new  Verdict(str);
			if (jud.check(str) != "") {// ���ʽ���Ϸ� ������һ�����ʽ����
				outputfile.println(jud.check(str));
				continue;
			}
			if (map.get(str) == null) {
				double result = operate.caculate(jud.s);
				if (result == 999999999) {
					outputfile.println("error: ��ĸ����Ϊ��");
				} else {
					//map.put(str,result);
					outputfile.println(str + "" + result);
				}
			} else
				outputfile.println("error: ���ʽ�ظ�");
		}
		
	}
}



