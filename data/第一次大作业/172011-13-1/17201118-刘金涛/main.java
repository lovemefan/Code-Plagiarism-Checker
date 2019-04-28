
//�޷����㸺��   

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
			inputfile = new FileInputStream("expression.txt");
			outputfile = new PrintStream("result.txt");
		} catch (Exception e) {
			System.err.println("File not found!");
			System.exit(1);
		}
		file = new Scanner(inputfile);
		Map<String, Double> map = new HashMap<String, Double>();// ��map��ƥ������ʽ�Ƿ�����˶��
		Orerate operate = new Orerate();
		while (file.hasNextLine())// �ļ��Ƿ������ĩβ
		{
			String str = file.nextLine();
			str = str.replaceAll(" ", "");// ɾ���ո�
			Judge jud = new Judge(str);
			Error err = new Error(str);

			if (jud.check(str) != "") {// ���ʽ���Ϸ� ������һ�����ʽ����
				outputfile.println(jud.check(str));
				continue;
			}
			if (err.check(str) != "") {
				outputfile.println(err.check(str));
				continue;
			}
			if (map.get(str) == null) {
				double result = operate.caculate(str);
				if (result == 999999999) {
					outputfile.println("ERROR\r\n#��ĸ����Ϊ��");
				} else {
					map.put(str, result);
					outputfile.println(str + "=" + result);
				}
			} else
				outputfile.println("ERROR\r\n#���ʽ�ظ�");
		}

	}
}
