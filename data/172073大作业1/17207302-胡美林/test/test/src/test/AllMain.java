import java.io.File;
import java.util.Scanner;
public class AllMain {

	public static void main(String[] args) throws Exception {
		ExpressionFile f = new ExpressionFile();
		String[] exps = new String[1000];//给测试的文件里所有表达式分配一个数组的空间
		File file = new File("experission.txt");//创建一个表达式的文件
		Scanner input = new Scanner(file);
		int i = 0;
		while (input.hasNextLine()) {
			exps[i] = input.nextLine();//文件里的表达式全部一个一个给数组
			exps[i] = f.expsToAllexps(exps[i]);//把表达式算出来后和表达式一起一个一个给原数组
			System.out.println(exps[i]);//在显示台上输出所有表达式和结果
			i++;
		}
		f.write(exps);//把测试后的表达式一个一个都写到另一个文件里去
	}
}
