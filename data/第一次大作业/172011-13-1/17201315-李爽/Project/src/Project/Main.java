package Project;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] arge) throws Exception {
		File file = new File();
		String[] expression = file.outputFile();// 存放文件导入的表达式
		//文件信息导入
		expression = file.outputFile();
		int s = file.index(expression);
		String[] postExpression = new String[s];// 存放后缀表达式
		String[] tureExpr = new String[s];// 存放处理负数后的表达式
		String[] dealBlankExc = new String[s];// 存放处理空格的表达式
		toPost to = new toPost();
		for (int i = 0; i < s; i++) {
			dealBlankExc[i] = dealBlank(expression[i]);
			String culExp [] = dealBlankExc[i].split("");
			//处理第一个数是负数
			if(culExp [0].equals("-")){
				dealBlankExc[i] = "0" +dealBlankExc[i]	;
			}
			//处理中间存在的负数
			tureExpr[i] = dealBlankExc[i].replace("(-", "(0-");
			postExpression[i] = to.toPost(tureExpr[i]);
		}
		file.inputFile(expression, s, dealBlankExc, postExpression);
	}

	//清除文件导入表达式的空格
	public static String dealBlank(String exc) {
		String s = "";
		for (int i = 0;i < exc.length();i++) {
			s = exc.replace(" ", "");
		}
		return s;
	}
}
