
//无法计算负数   

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
		Map<String, Double> map = new HashMap<String, Double>();// 用map来匹配运算式是否出现了多次
		Orerate operate = new Orerate();
		while (file.hasNextLine())// 文件是否读到了末尾
		{
			String str = file.nextLine();
			str = str.replaceAll(" ", "");// 删除空格
			Judge jud = new Judge(str);
			Error err = new Error(str);

			if (jud.check(str) != "") {// 表达式不合法 进行下一个表达式计算
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
					outputfile.println("ERROR\r\n#分母不能为零");
				} else {
					map.put(str, result);
					outputfile.println(str + "=" + result);
				}
			} else
				outputfile.println("ERROR\r\n#表达式重复");
		}

	}
}
