
import java.io.File;
import java.util.Scanner;

//从文件读数据类
public class ReadData {

	private String expression; // 表达式
	private String allResult; // 最终结果

	// 构造方法
	public ReadData() {
		expression = ""; // 最初表达式为空
		allResult = ""; // 最终结果未成
	}

	// 表达式访问器
	public String getExpression() {
		return this.expression;
	}

	// 最终结果访问器
	public String getAllResult() {
		return this.allResult;
	}

	// 读文件并调用操作方法
	public void readData() throws Exception {
		File file = new File("test.txt");
		Scanner input = new Scanner(file);
		// 产生一个处理数据类的对象
		Deal deal = new Deal();
		// 产生一个向文件写数据类的对象
		WriteData wD = new WriteData();
		// 如果还有下一行，则继续读数据
		while (input.hasNext()) {
			this.expression = input.nextLine();
			// 处理读入的表达式
			// System.out.println(expression);
			this.allResult = deal.dealExpression(expression, allResult);
		}
		wD.writeData(allResult);
		input.close();
	}
}
