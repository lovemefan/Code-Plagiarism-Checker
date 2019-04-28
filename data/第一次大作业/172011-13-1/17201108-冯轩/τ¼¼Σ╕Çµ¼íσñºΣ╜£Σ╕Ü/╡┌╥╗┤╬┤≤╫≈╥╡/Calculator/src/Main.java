import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String status = "";
		String expression;
		Stack stack = new Stack(); // 存放后缀表达式
		StackInt stackInt = new StackInt(); // 计算用的栈
		String readFileContent = ""; // 存放读取文件内容的字符串
		String[] readFileStrs; // 文件内容分割后得到的字符串数组
		
		readFileContent = FileIO.fileInput("./calculateTest.txt");
		readFileStrs = readFileContent.split("\r\n"); // 按照换行符进行分割 !!!!!注意，windows文本文件的换行符是\r\n
		readFileStrs = VakidateExpression.removeRepetition(readFileStrs);
		for (int i = 0; i < readFileStrs.length; i++) {
			if ((status = VakidateExpression.isLegalExpression(readFileStrs[i])) != "legal") {
				FileIO.fileOutput("./calculateResult.txt", status);

			} else {				
				InfixToPost infixToPost = new InfixToPost(stack, readFileStrs[i]);
				infixToPost.process();
				Calculate resultStr = new Calculate(infixToPost.getPost(), stackInt);
				try{
					resultStr.operate();
					expression = readFileStrs[i].replaceAll("\\s+", ""); //输出表达式到文本
					FileIO.fileOutput("./calculateResult.txt", expression + "=" + String.valueOf(resultStr.getResult()));					
				} catch (ArithmeticException e){
					FileIO.fileOutput("./calculateResult.txt", e.getMessage());
				}
			}
		}

	}
}
