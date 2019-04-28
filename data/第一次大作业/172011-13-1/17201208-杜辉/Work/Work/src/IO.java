
//文件输入输出
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class IO {
	InputStream inputStream = System.in;
	PrintStream outputStream = System.out;
	Scanner input;

	IO() {
		try {
			inputStream = new FileInputStream("input.txt");
			outputStream = new PrintStream("output.txt");
		} catch (Exception e) {
			System.err.println("File Not Found.");
			System.exit(1);
		}
		input = new Scanner(inputStream);
	}

	public Boolean getHasNextLine() {
		return input.hasNextLine();// 判断文件是否有下一句
	}

	public String getNextLine() {
		return input.nextLine(); // 返回文件所读的信息
	}

	public void getAns(String ans) {
		outputStream.println(ans); // 将得到的信息输出到文件中
	}
}
