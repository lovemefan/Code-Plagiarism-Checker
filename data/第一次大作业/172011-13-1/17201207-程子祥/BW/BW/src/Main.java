import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] array = new String[1000];
		String str;
		int i = 0;
		InputStream inputStream = System.in;
		PrintStream outputStream = System.out;
		try {
			inputStream = new FileInputStream("input.txt");
			outputStream = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
		Scanner input = new Scanner(inputStream);
		while ((input.hasNextLine())) {
			str = input.nextLine();
			array[i] = str;
			str = str.replaceAll(" ","");//删除空格					
			if (!str.matches("[\\+\\-\\*\\/\\(\\)\\d\\s]*")) {// 非法字符
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\+\\+|\\+-|\\+/|\\+\\*|--|-\\+|-\\*|-/|\\*\\+|\\*-|\\*/|\\*\\*|/-|//|/\\+|/\\*).*")) { //连续符号
				outputStream.println("ERROR\r\n"+"#" +str); // ---.
				continue;
			}

			if (str.matches(".*(\\)\\d|\\d\\().*")) { // ）右边是数字的情况 或 (左边是数字的情况
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\(\\)).*")) { // 匹配空括号
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")) { // 右括号左边含有运算符
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches(".*(\\(\\+|\\(/|\\(\\*).*")) { // 左括号右边有运算符
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}

			if (str.matches("[\\+\\*\\/].*")) {// 判断以符号开头
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}
			if (str.matches(".*\\/0.")) { // /0
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			}
			if (str.matches(".*[\\+\\-\\*\\/]")) {// 最后一个字符为运算符
				outputStream.println("ERROR\r\n"+"#" +str);
				continue;
			} 
	else {
				outputStream.println(str+"="+StringToArithmetic.stringToArithmetic(str));
			
			i++;
			}
		}

	}
}