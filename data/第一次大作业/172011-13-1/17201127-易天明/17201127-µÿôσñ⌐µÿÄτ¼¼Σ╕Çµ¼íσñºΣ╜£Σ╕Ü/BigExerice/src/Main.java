import java.io.IOException;
import java.util.ArrayList;

public class Main {
	// 保存用空格分开后的数据
	private static ArrayList<String> st = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		WriteToFile.fileDel(); // 删除已存在的输出文件
		ReadFromFile p1 = new ReadFromFile();

		DeleteSpaces p2 = new DeleteSpaces();

		// 删除原始数据的空格
		p2.delSpaces(p1);

		// 添加空格是的数据格式化以便运算
		p2.addSpace(st);
		
		//操作连接其他类的方法
		HandleAll.handleAll(st, p1, p2);
	}
}
