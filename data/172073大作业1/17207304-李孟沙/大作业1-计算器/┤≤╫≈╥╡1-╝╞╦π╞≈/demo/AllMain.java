package demo;

import java.util.Scanner;
import java.io.File;

public class AllMain {
	
	public static void main(String[] args) throws Exception {
		
		ExpressionFile f = new ExpressionFile();
		String[] exps = new String[1000];//给所有表达式分配一个数组的空间
		File f1 = new File("expression.txt");//创建一个表达式的文件
		Scanner input = new Scanner(f1);
		int i = 0;
		while (input.hasNextLine()) {
			exps[i] = input.nextLine();//文件里的表达式全部一个一个给数组
			if(exps[i].isEmpty()) {
				exps[i] = "ERROR\r\n#表达式为空";
			}
			else
				exps[i] = f.ToAllexps(exps[i]);//把表达式算出来后和表达式一起一个一个给原数组
			System.out.println(exps[i]);//在显示台上输出所有表达式和结果	
			i++;
		}
		f.write(exps);//把测试后的表达式都写到结果文件里
	}
}
