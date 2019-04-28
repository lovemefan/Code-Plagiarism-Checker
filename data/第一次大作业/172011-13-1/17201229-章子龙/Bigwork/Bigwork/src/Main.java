import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		File file1 = new File("input.txt");
		
		Scanner input = new Scanner(file1);

		File file2 = new File("ouput.txt");
		
		PrintWriter output = new PrintWriter(file2);

		Convert con = new Convert();

				   
		ArrayList<String> s1 = new ArrayList<String>();   //将文件的计算式导入字符串数组
		 
		ArrayList<String> s2 = new ArrayList<String>();    //将s1中的字符串去空格后存入

		// 将文件里的表达式输入字符串数组
		while (input.hasNextLine()) {
			
			s1.add(input.nextLine());
			
		}

		// 处理表达式
		// 去除字符串中的空格
		for (int i = 0; i < s1.size(); i++) {
			s2.add(s1.get(i).replaceAll(" ", ""));   //将s1中的字符串去空格后存入s2

		}


		// 去除相同的字符串
		for (int i = 0; i < s2.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (s2.get(j).equals(s2.get(i))) {
					s2.remove(i);
				}
			}

		}

		Check c = new Check();
		float key;  //记录计算式的结果

		//判断计算式是否合法
		for (int i = 0; i < s2.size() ; i++) {
			if (!s2.get(i).matches(".*[\\(-\\+|\\-|\\/|\\d].*")) {
				output.println(s2.get(i));
				output.println("                   #error,含非法字符");
			}

			else if (s2.get(i).matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")) {
				output.println(s2.get(i));
				output.println("                   #error,运算符连续");
			}

			else if (s2.get(i).matches(".*[\\(][\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,空括号");
			}

			else if (c.check(s2.get(i)) == 0) {
				output.println(s2.get(i));
				output.println("                   #error,括号不匹配");
			}

			else if (c.check2(s2.get(i),1) == 0){
				output.println(s2.get(i));
				output.println("                   #error,开头不能为'('以外的运算符");
			}
			
			else if(c.check2(s2.get(i), s2.get(i).length()) == 0){
				output.println(s2.get(i));
				output.println("                   #error,结尾不能为')'以外的运算符");
			}
			
			else if (s2.get(i).matches(".*[\\(][\\+\\*\\/].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'后是运算符");
			}

			else if (s2.get(i).matches(".*[\\+\\-\\*\\/][\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'前是运算符");
			}

			else if (s2.get(i).matches(".*[\\d|\\(|\\)][\\(].*")) {
				output.println(s2.get(i));
				output.println("                   #error,'('前不是运算符");
			}

			else if (s2.get(i).matches(".*[\\)][\\d|\\(|\\)].*")) {
				output.println(s2.get(i));
				output.println("                   #error,')'后不是运算符");
			}

			else {

				key = con.Convert(s2.get(i));
				output.println(s2.get(i));
				output.println("                                = " + key);
			}
		}
		output.close();
		System.out.println("计算完成");
	}
}
