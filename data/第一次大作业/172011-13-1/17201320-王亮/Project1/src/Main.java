import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//主类
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 方法调用
		String[] s = readFile();
		String[] str = testToString(s);
		double[] values = testToValue(str);
		outputFile(s, values);
	}

	private static String[] readFile() throws IOException {// 读取文件
		ReadFile file = new ReadFile();// 构造文件读取的对象
		String[] s = file.read();
		Check check1 = new Check(s);// 构造输入校验类的对象
		s = check1.test00();// 去重
		for (int i = 0; i < s.length; i++) {// 过滤空格
			s[i] = s[i].replaceAll(" ", "");
		}
		return s;

	}

	private static boolean checkString(String s) {// 输入校验
		Check checks = new Check(s);// 构造输入校验类的对象
		if (!checks.test()) {// 如果表达式合法
			return false;
		}
		return true;
	}

	private static String checkPrint(String s) {// 得到表达式不合法的部分
		String s1;
		Check checks = new Check(s);// 构造Check类的对象
		checks.test();
		s1 = checks.get();//
		return s1;
	}

	private static String toStrings(String expstr) {// 中缀转后缀，参数为中缀表达式
		SeqStack<String> stack = new SeqStack<String>(expstr.length());// 构造顺序栈对象
		ToString change = new ToString(stack, expstr);// 构造ToString类对象
		String postfix = change.process();
		return postfix;
	}

	private static String[] testToString(String[] s) {// 将输入表达式转化为后缀表达式，参数为输入数组
		String[] str = new String[100];// 合法表达式数组
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (checkString(s[i])) {
				str[j] = toStrings(s[i]);// 合法则转化为后缀表达式
				j++;
			}
		}
		return str;
	}

	private static double toValues(String postfix) {// 由后缀表达式求值，参数为后缀表达式
		LinkedStack<Double> stack = new LinkedStack<Double>();// 构造链式栈对象
		ToValue change = new ToValue(postfix, stack);// 构造ToValue类对象
		double result = change.process();
		return result;
	}

	private static double[] testToValue(String[] str) {// 将表达式数组求值，参数为合法字符转化得到的后缀表达式
		int i = 0;
		for (; i < str.length; i++)// 得到表达式数组的实际长度
		{
			if (str[i] == null)
				break;
		}
		double[] values = new double[i];// 结果数组
		for (int j = 0; j < values.length; j++) {
			values[j] = toValues(str[j]);// 求值
		}
		return values;
	}

	private static void outputFile(String[] s, double[] values) throws IOException {// 文件输出，参数为输入数组和结果数组
		File file1 = new File("C:\\Users\\王小亮\\Desktop\\results.txt");
		if (file1.exists()) {// 判断文件是否存在或重名
			System.out.println("File aleaday exists!");
			System.exit(0);
		}
		PrintWriter outfile = new PrintWriter(file1);// 构造对象
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (checkString(s[i]) && ((values[j] - (int)values[j]) == 0)) {// 如果表达式合法并且小数点后面为零
				outfile.println(s[i] + "=" + (int)values[j]);// 将小数点后为零的小数转为整形数
				j++;
			} 
			else if(checkString(s[i]) && ((values[j] - (int)values[j]) != 0)){// 如果表达式合法并且小数点后面不为零
				outfile.println(s[i] + "=" + values[j]);
				j++;
			}
			else {// 不合法则输出错误内容
				outfile.println("ERROR");
				outfile.println("#" + checkPrint(s[i]));
			}
		}
		outfile.close();// 关闭文件
	}

}
