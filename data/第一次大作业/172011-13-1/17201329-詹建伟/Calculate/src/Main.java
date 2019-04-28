import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		java.io.File a = new java.io.File("a.txt");
		java.io.File b = new java.io.File("b.txt");
		File file = new File();

		Stack stack = new Stack(new Node(), new Node());
		stack.stackTop = stack.stackBottom;
		stack.stackTop.next = null;

		Scanner input = new Scanner(a);

		java.io.PrintWriter output = new java.io.PrintWriter(b);

		Judgeexpression Je = new Judgeexpression();

		String expression = new String();
		int flag = 0;//判断相同的标记
		while (input.hasNextLine()) {
			flag++;
			expression = file.readFile(input);
			if (expression.equals("")){
				continue;
			}
			if (!Je.Judge(expression, output)) {
				continue;
			}
			expression = expression.replace(" ", "");
			if (Je.isSame(a, expression, flag)) {
				continue;
			}
			//对表达式进行处理并计算
			StackProcced stackProcced = new StackProcced();
			String s = stackProcced.isNegative(expression);
			stackProcced.laterExp(stack, stackProcced.Procced(stack, s), output, expression);
		}
		input.close();
		output.close();
	}
}
