package homeWork;
import java.util.Scanner;

public class CreatFile {

	// 构造函数

	public CreatFile() {

	}

	// 读取文件内容

	// 字符串变量 用于存储文件内容

	public int Read(String[] src) throws Exception {

		java.io.File file = new java.io.File("多项式.txt");

		Scanner input = new Scanner(file);

		int j = 0;

		while (input.hasNext()) {

			src[j] = input.nextLine();

			src[j] = src[j].replaceAll(" ", "");

			for (int k = 0; k < j; k++) {

				if (src[j].equals(src[k])) {

					j--;

					break;

				}

			}

			j++;

		}

		input.close();

		return j;

	}

	// 写入文件

	// 字符串数组 用以存放算式 字符串数组 用以存放相应算式结果 int数组 用以存放算式是否合法 int型 算式个数

	public void writeResult(String[] src, String[] result, int[] flag, int i) throws Exception {

		java.io.File file = new java.io.File("运算结果.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		for (int j = 0; j < i; j++) {

			if (flag[j] == 0) {

				output.println(src[j] + "=" + result[j]);

			}

			else {

				output.println("ERROR");

				output.println(src[j]);

			}

		}

		output.close();

	}

}
