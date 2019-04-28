package call;

import java.util.Scanner;

public class First {
	public static void main(String[] args) throws Exception {
		CreatFile myfile = new CreatFile();// 调用CreateFile()类，实现文件的读写操作
		myfile.WriteFile();// 建立文件
		Scanner scanner = new Scanner(myfile.file);
		Regular equation = new Regular();// 正则表达式类Regular（）调用
		int i = 0;
		String[] dej = new String[myfile.readFile(myfile.file)];// 存放临时数据
		String dejReg = null;
		if (scanner.hasNext()) {// 判断是否文件可读
			do {
				dej[i] = "" + scanner.nextLine();
				// 验证输入数据的正确性1
				System.out.println("第" + (i + 1) + "个该表达式为：" + dej[i]);
				dej[i] = dej[i].replaceAll(" ", "");// replacAll语句去除字符串里的空格
				dejReg = equation.RegularJudge(dej[i]);
				dejReg = dejReg.replaceAll("null", "");// replacAll语句去除字符串里的空格
				// System.out.println(dejReg);
				if (dejReg.equals("")) {// 判断表达式输入没有问题
					// 计算表达式并输出结果
					double result = ExperssionEvaluator.evaluate(dej[i]);// 计算结果
					dej[i] = dej[i] + "=" + result;// 加入等号和结果
					System.out.println("*第" + (i + 1) + "行计算结果" + dej[i]);// 输出
				} else {
					dej[i] = dej[i] + "\r\nError!" + dejReg;
				}
				i++;
			} while (scanner.hasNextLine());
			scanner.close();// 关闭文件
			// 判断数组是否有重复文件，若有，则删除那行
			dej = myfile.equal(dej);
			myfile.WriteFile(dej);// 新建文件，并且将临时数据导入保存到文件
		} else
			System.out.println("#文件中没有可读数据！");
	}
}