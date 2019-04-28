import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("express.txt");// 从文件中读取数据
		File file1 = new File("result.txt");//将结果保存到文件
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(file1);
		while (input.hasNext()) {
			String str1 = input.nextLine();
			String str = str1.replace(" ", "");// 将字符串中的空格去掉
			Check c = new Check();
			String result = c.check(str);// 判断表达式是否合法
			System.out.println(result);
			output.println(result);// 将数据写入文件
		}
		output.close();// 关闭文件
		input.close();// 关闭文件
	}

}
		
	

