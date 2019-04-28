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
		Map<String, Double> map = new HashMap<String, Double>();// 用map来匹配运算式是否出现了多次
		Calculate operate = new Calculate();
		while (file.hasNextLine())// 文件是否读到了末尾
		{
			String str = file.nextLine();
			 Verdict jud = new  Verdict(str);
			if (jud.check(str) != "") {// 表达式不合法 进行下一个表达式计算
				outputfile.println(jud.check(str));
				continue;
			}
			if (map.get(str) == null) {
				double result = operate.caculate(jud.s);
				if (result == 999999999) {
					outputfile.println("error: 分母不能为零");
				} else {
					//map.put(str,result);
					outputfile.println(str + "" + result);
				}
			} else
				outputfile.println("error: 表达式重复");
		}
		
	}
}



