package Call;

import java.io.File;
import java.util.Scanner;

public class CreatFile {
	java.io.File file = new java.io.File("calculate.txt");

	// 从文件中传输数据输入到电脑
	String LookFile() throws Exception {
		Scanner input = new Scanner(this.file);
		String de = null;
		while (input.hasNext()) {
			de = "" + input.nextLine();
		}
		input.close();
		return de;
	}

	// 写入数据到文件
	void WriteFile() throws Exception {
		if (!file.exists()) {
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			output.close();
		}
	}

	void WriteFile(String[] result) throws Exception {
		if (file.exists()) {
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			for (int i = 0; i < result.length; i++) {
				output.println(result[i]);
			}
			output.close();
		}
	}

	// 判断文件有多少行
	public int readFile(File fis) throws Exception {
		int count = 0;
		Scanner scanner = new Scanner(fis);
		while (scanner.hasNextLine()) {
			scanner.nextLine();
			count++;
		}
		scanner.close();
		System.out.println("*这时文件有:" + count + "行");
		return count;
	}

	// 删除相同的值
	public String[] equal(String[] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i].equals(result[j])) {
					result = delete(j, result);
				}
			}
		}
		System.out.println("#若有相同行，系统则为您自动删除相同行！");
		return result;
	}

	// 删除数组中某个节点的详细过程
	public String[] delete(int index, String array[]) {
		// 数组的删除其实就是覆盖前一位
		String[] arrNew = new String[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			if (i < index) {
				arrNew[i] = array[i];
			} else {
				arrNew[i] = array[i + 1];
			}
		}
		return arrNew;
	}
}