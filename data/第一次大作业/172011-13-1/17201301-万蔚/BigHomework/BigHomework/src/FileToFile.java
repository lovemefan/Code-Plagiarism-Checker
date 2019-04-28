import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 数据IO类
public class FileToFile {
	// 数据存储
	ArrayList<String> data = new ArrayList<>();

	public FileToFile() {

	}

	// 读文件写文件
	public void inputFile() throws IOException {
		File file = new File("input.txt");
		File outputFile = new File("output.txt");
		//判断文件是否存在
		if (!file.exists()) {
			System.out.println("文件不存在");
			System.exit(0);
		}
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(outputFile);
		while (input.hasNextLine()) {
			String str = input.nextLine();
			Check check = new Check(str);
			str = check.getExpression();
			// 数据查重
			if (!data.contains(str)) {
				outputFile(check, output);
				data.add(str);
			}
		}
		output.close();
		System.out.println("成功");
		input.close();
	}

	// 输出到文件
	private void outputFile(Check check, PrintWriter output) {
		String str = check.getExpression();
		if (check.getLegal()) {
			Calculate c = new Calculate(check);
			// 在计算之后知道除数为0的情况
			c.compute();
			if (check.getLegal()) {
				output.println(str + "=" + c.getNum());   //将计算结果写入文件
			} else {
				output.println("ERROR\n#" + check.getError());  //将错误信息写入文件
			}
		} else {
			output.println("ERROR\n#" + check.getError());  //将错误信息写入文件
		}
	}
}
