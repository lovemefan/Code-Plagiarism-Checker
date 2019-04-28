import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Writer {
	Calculate[] cal = new Calculate[10000];// 表达式序列
	int size = 0;// 大小

	public Writer() throws FileNotFoundException {// 将表达式存进表达式对象中
		File file = new File("Informations.txt");// Create a File instance
		if (file.exists() == false) {// 如果文件不存在则停止运行
			System.out.println("文件不存在");
			System.exit(0);
		}
		Scanner input = new Scanner(file);// Creat a Scanner for the file
		while (input.hasNextLine()) {// 记录表达式,并计算
			cal[size++] = new Calculate(input.nextLine());
		}
		input.close();
	}

	public void writeToFile() throws IOException {// 从文件中读取表达式
		File outputFile = new File("expression.txt");// 创建文件对象
		PrintWriter output = new PrintWriter(outputFile);// 创建一个输出对象
		for (int i = 0; i < size; ++i) {
			if (!isExist(cal, i)) {// 如果请求相同则忽略该请求，不相同则输出
				printTofile(cal[i], output);
			}
		}
		output.close();
		System.out.println("写入完成");
	}

	private boolean isExist(Calculate[] s, int pos) {// 是否存在该序列
		for (int i = 0; i < pos; ++i) {
			if (s[pos].filter.getFinalString().equals(s[i].filter.getFinalString())) {
				return true;
			}
		}
		return false;
	}

	private void printTofile(Calculate cal, PrintWriter output) throws IOException {// 将结果写进文件
		if (cal.filter.getIsLegal() == true) {// 如果表达式合法
			output.println(cal.printExp());// 写入表达式结果到文件中
		} else {// 表达式错误
			output.println(cal.filter.getErrorString());// 写入错误信息
		}
	}
}
