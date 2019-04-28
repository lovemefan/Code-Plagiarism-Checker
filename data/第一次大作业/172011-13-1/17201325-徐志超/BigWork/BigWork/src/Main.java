import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		File file = new File("xzc.txt");
		Scanner input = new Scanner(file);
		// 创建对象
		InfixToSuffix in = new InfixToSuffix();
		SufToResult s = new SufToResult();
		Check c;

		String[] result = new String[100];// 储存结果的数组
		int i = 0;
		while (input.hasNext()) {// 从文件读数据

			String exp = input.nextLine();// 读
			c = new Check(exp);
			if (!exp.equals("")){
				// 如果开头有负数
				if (exp.charAt(0) == '-' && Character.isDigit(exp.charAt(1))) {
					exp = '0' + exp;
				}
			}
			// 判断是否通过校验
			if (c.cheakAll()) {
				exp = exp.replace("(-", "(0-");// 给负号前面加0
				double a = 0;
				a = s.getResult(in.InfToSuf(exp));
				if(String.valueOf(a) != "Infinity"){
					result[i] = exp + "=" + String.valueOf(a);
				}
				else{
					result[i] = "ERROR\r\n#除数不能为零";
				}
			} 
			else {
				result[i] = c.errorAll();
			}
			i++;
		}
		input.close();// 关闭文件
		FileWrite f = new FileWrite();
		// 将结果写入文件
		f.fileWrite(result);
	}
}