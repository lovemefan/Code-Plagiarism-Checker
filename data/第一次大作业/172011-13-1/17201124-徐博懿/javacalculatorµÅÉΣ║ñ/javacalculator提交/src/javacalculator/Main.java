package javacalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Calculate calculate = new Calculate();

		// System.out.println("请输入表达式");
		// Scanner scan = new Scanner(System.in);
		// String s=scan.next();

		FileWriter fw = null;
		File f = new File("输出.txt");

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 提高性能
		try {
			String str = "";
			fis = new FileInputStream("输入.txt");// FileInputStream
			// 从文件读取字节
			isr = new InputStreamReader(fis);// InputStreamReader 字节流通向字符流,
			br = new BufferedReader(isr);//
											// InputStreamReader
			while ((str = br.readLine()) != null) {
				// System.out.println(str);
				// 验证表达式是否正确
				str = str.replaceAll(" ", ""); //去除空格

				Boolean isTrue = Zhengze.validateValue(str);
				if (true == isTrue) {
					ArrayList result = calculate.getStringList(str); // String转到List
					result = calculate.getPostOrder(result); // 中缀表达式转成后缀表达式
					int i = calculate.calculate(result); // 计算
					String s = String.valueOf(i);
					String sum = str + "=" + s + System.getProperty("line.separator");
					// System.out.println(sum);

					// 写文档
					fw = new FileWriter(f, true);
					BufferedWriter out = new BufferedWriter(fw);
					out.write(sum);
					out.close();
				}
				if (false == isTrue) {
					// 写文档
					fw = new FileWriter(f, true);
					BufferedWriter out = new BufferedWriter(fw);
					String str1 = "ERROR\n" + "#" + str + System.getProperty("line.separator");
					out.write(str1);
					out.close();
				}
			}
			System.out.println("计算完毕");
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				// 关闭文件按照先后顺序先关闭s后n最后m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
