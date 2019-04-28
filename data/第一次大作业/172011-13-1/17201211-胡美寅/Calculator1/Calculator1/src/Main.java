import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	// 正则表达式用于检验表达式的合法性 （能够判断单括号）
	private static final String REGEX = "((^\\d+\\s*)|(^\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))(([\\+\\-\\*/]\\s*\\d+)\\s*|([\\+\\-\\*/]\\s*\\(\\s*\\d+\\s*([\\+\\-\\*/]\\s*\\d+\\s*)+\\)\\s*))+$";
	// 正则表达式中的两个类
	private static Pattern pattern;
	private static Matcher matcher;

	// 主函数加上 throws Exception 因为可能会投出错误
	public static void main(String[] args) throws Exception {
		// 初始化栈(无元素) 匿名对象引用
		Stack stack = new Stack(new Node(), new Node());
		// 栈顶和栈尾是同一指向
		stack.stackBottom = stack.stackTop;
		// 指向null
		stack.stackTop.next = null;
		Scanner input1 = new Scanner(System.in);
		System.out.println("输入你的运算表达式所在的文件位置(绝对路径!)");
		String address1 = input1.nextLine();
		java.io.File file1 = new java.io.File(address1);
		// 检验输入的运算表达式所在位置文件是否存在
		while (!file1.exists()) {
			System.out.println("Source file " + address1 + " " + "does not exist");
			System.out.println("请重新输入你的运算表达式所在的文件位置(绝对路径!)");
			address1 = input1.nextLine();
			file1 = new java.io.File(address1);
		}
		// 保存结果的文件假如不存在会自动新建一个 假如存在则结果会附加上去 所以不需要检验文件是否存在
		System.out.println("输入你的运算表达式结果想要储存的文件位置(绝对路径!)");
		Scanner input3 = new Scanner(System.in);
		String address2 = input3.nextLine();
		java.io.File file2 = new java.io.File(address2);
		// 注意此处input命名和前面易混淆
		Scanner input2 = new Scanner(file1);
		while (input2.hasNext()) {
			// 从文件中读取表达式
			String expression = input2.nextLine();
			// 利用正则表达式进行检验表达式的合法性
			pattern = Pattern.compile(REGEX);
			matcher = pattern.matcher(expression);
			// 表达式若符合模式 则matches方法返回true 否则返回false 并且输出错误
			if (matcher.matches()) {
				// 将符合模式的表达式转化成后缀表达式
				InfixToPost infix = new InfixToPost(stack, expression);
				infix.process();
				// 将后缀表达式存在String类型的 post中
				String post = infix.getPost();
				// 新建一个存放结果的栈 并且计算出结果
				Stack stack_result = new Stack();
				PostToResult ptr = new PostToResult(post, stack_result);
				ptr.operate();
				// 检验目标文件是否存在 不存在则新建一个 存在则直接以附加方式写入
				if (!file2.exists()) {
					// 新建文件写入
					java.io.PrintWriter output = new java.io.PrintWriter(file2);
					output.println(expression + "=" + ptr.getResult());

					output.close();
				} else {
					// 以追加方式写入
					BufferedWriter out = null;
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
					out.write(expression + "=" + ptr.getResult() + "\r\n");
					out.close();
				}

			}else{
				// 检验目标文件是否存在 不存在则新建一个 存在则直接以附加方式写入
				if (!file2.exists()) {
					// 新建文件写入
					java.io.PrintWriter output = new java.io.PrintWriter(file2);
					output.println("ERROR" + "\r\n"  + "#" + " " + expression);

					output.close();
				} else {
					// 以追加方式写入
					BufferedWriter out = null;
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
					out.write("ERROR" + "\r\n" +  "#" + " " + expression + "\r\n");
					out.close();
				}
			}

		}
		input2.close();
	}
}
