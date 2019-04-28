import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Check {

	ArrayList<String> s1;
	FileRead f = new FileRead(); // 构造FileRead的对象f

	public Check() { // s1得到所有请求
		s1 = f.getStr();
	}

	// 判断所有请求是否符合规范
	public void pan() {
		int i = 0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;
		for (i = 0; i < s1.size(); i++) {
			for (j = i + 1; j < s1.size(); j++) {
				if (s1.get(i).compareTo(s1.get(j)) == 0) {
					System.out.println(s1.get(j) + "\nERROR\n" + "#输入请求重复，舍弃");
					s1.remove(j);
				}
			}
		}
		System.out.println("舍弃重复请求后s1的大小为:" + s1.size());
		System.out.println("输出舍弃重复请求后s1的内容为：" + s1);
		for (i = 0; i < s1.size(); i++) {
			// 判断输入请求是否为空字符串
			if (s1.get(i).compareTo("") == 0) {
				System.out.println(s1.get(i) + "\nERROR\n" + "#输入为空字符串，为无效输入内容");
				s1.remove(i);
			}

			// 以数字分隔s1的所有符号
			String[] t = s1.get(i).split("\\d");
			for (j = 0; j < t.length; j++) {
				// 判断输入的请求中是否含有非法字符
				if (t[j].matches("[^\\+\\-\\*\\/\\(\\)]")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#输入非法字符");
					s1.remove(s1.get(i));
					break;
				}
				// 判断输入请求中是否含有连续的运算符
				if (t[j].matches("[\\+\\-\\*\\/]{2,}")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#运算符连续输入");
					s1.remove(s1.get(i));
					break;
				}
				// 判断输入请求中是否含有空括号
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					System.out.println(s1.get(i) + "\nERROR\n" + "#输入空括号");
					s1.remove(s1.get(i));
					break;
				}
				// 判断输入的请求括号是否匹配
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\([\\+\\-\\*\\/]{0,}")
						|| t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					sum1 = sum1 + 1;
				}
				if (t[j].matches("\\(\\(")) {
					sum1 = sum1 + 2;
				}
				if (t[j].matches("[\\+\\-\\*\\/]{0,}\\)[\\+\\-\\*\\/]{0,}")
						|| t[j].matches("[\\+\\-\\*\\/]{0,}\\(\\)[\\+\\-\\*\\/]{0,}")) {
					sum2 = sum2 + 1;
				}
				if (t[j].matches("\\)\\)")) {
					sum2 = sum2 + 2;
				}
			} // forj
			if (sum1 != sum2) {
				System.out.println(s1.get(i) + "\nERROR\n" + "#输入括号不匹配");
				s1.remove(s1.get(i));
			}
			sum1 = 0;
			sum2 = 0;
		} // fori
		System.out.println("输出所有有效请求为:" + s1);

	}// pan

	// 将符合规范的请求保存到output.txt文件
	public void WriterData() {
		File file = new File("output.txt");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		for (i = 0; i < s1.size(); i++) {
			output.println(s1.get(i));
		}
		output.close();
	}// writer

}
