import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

//import java.util.Map;
//import java.util.HashMap;
public class Dealwith {

	public static void main(String[] args) throws Exception {
		File file = new java.io.File("输入.txt");
		Scanner input = new Scanner(file);
		File file1 = new java.io.File("结果.txt");
		PrintWriter output = new PrintWriter(file1);
		Machine m = new Machine();
		Figure f = new Figure();
		ChackOp c = new ChackOp();
		Computer p = new Computer();
		while (input.hasNextLine()) {
			String op = input.nextLine();
			System.out.println(op);
			String result = c.ChackOp(op);
			System.out.println(result);
			if (result.matches("right")) {// 判断表达式是否正确
				double x = p.Deal(f, m, op);
				// System.out.println(x); // 查看结果
				output.println(op + "=" + x);

			} else {
				output.println("ERROR");
				output.println("#" + result);

			}

		}
		output.close();
	}

}
