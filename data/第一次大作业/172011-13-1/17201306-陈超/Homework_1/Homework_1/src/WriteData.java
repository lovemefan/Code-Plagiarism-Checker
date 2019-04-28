import java.io.File;
import java.io.PrintWriter;

//向文件写数据类
public class WriteData {

	// 空构造方法
	public WriteData() {

	}

	// 带参构造方法,参数是最终结果
	public void writeData(String allResult) throws Exception {
		File file = new File("result.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		// 自动关闭资源
		try (PrintWriter output = new PrintWriter(file);) {
			output.println(allResult);
			output.close();
		}
	}
}
