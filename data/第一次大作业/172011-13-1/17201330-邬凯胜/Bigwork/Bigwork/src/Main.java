
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		File myfile = new File();// 调用CreateFile()类，实现文件的读写操作
		myfile.WriteFile();// 建立文件
		Scanner scanner = new Scanner(myfile.file);
		int i = 0;
		String[] dej = new String[myfile.readFile(myfile.file)];// 存放临时数据
		if (scanner.hasNext()) {// 判断是否文件可读
			do {
				dej[i] = "" + scanner.nextLine();
				InputCheck check = new InputCheck(dej[i]);// 正则表达式
				// 验证输入数据的正确性1
				dej[i] = dej[i].replaceAll(" ", "");// replacAll语句去除字符串里的空格
				if (check.judgeAll()) {// 判断表达式输入没有问题
					char[] s = dej[i].toCharArray();
					String expression = Expression.getExpression(s);
					s = expression.toCharArray();
					ArrStack as = Calculate.rpn(s);
					dej[i] = dej[i] + "=" + as.getTop();// 加入等号和结果
					System.out.println("*第" + (i + 1) + "行计算结果" + dej[i]);// 输出
				}else { 
					dej[i] = check.getErrorMessage();
					System.out.println("*第" + (i + 1) + dej[i]);
				}
				i++;
			} while (scanner.hasNextLine());
			scanner.close();// 关闭文件
			if (myfile.file.delete())// 删除原文件
				// 判断数组是否有重复文件，若有，则删除那行
				dej = myfile.equal(dej);
			myfile.WriteFile(dej);// 新建文件，并且将临时数据导入保存到文件
		} else
			System.out.println("#文件中没有可读数据！");
	}
}

