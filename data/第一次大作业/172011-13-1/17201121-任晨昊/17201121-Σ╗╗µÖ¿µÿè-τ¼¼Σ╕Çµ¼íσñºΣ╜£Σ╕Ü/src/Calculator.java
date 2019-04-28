import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static void main(String[] args) throws FileNotFoundException {//文件操作方法

		Exp e = new Exp();
		String fPath = "src/test.txt";//读取字符的文件路径
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fPath));
		} catch (FileNotFoundException e1) {//若文件不存在
			System.out.println("File doesn't exist!Program will shut down!");
			return;
			// e1.printStackTrace();
			// return ;
		}
		System.out.println("Load file success!");
		String str;
		File file = new File("src/ans.txt");//输出结果的文件路径
		PrintStream ps = new PrintStream(new FileOutputStream(file));

		while (true) {
			try {
				str = br.readLine();
				str = str.replaceAll(" ", ""); //去空格
				if (str == null)
					break;
			} catch (Exception e1) {
				ps.close();
				break;
			}

			ps.append(str);// 在已有的基础上添加字符串
			// System.out.print(str);
			if (Check.check(str)) {
				e.setExp(str);
				Queue<Node> suffix = e.getSuffix();
				int t;
				t = Compute.calculate(suffix);
				// System.out.println("="+t);
				ps.append("=" + t);// 在已有的基础上添加字符串
				ps.println("");
			} else
				ps.println("\nERROR:\n#" + str);
		}
		return;
	}
}