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
		Stack stack = new Stack(); // ��ź�׺���ʽ
		StackInt stackInt = new StackInt(); // �����õ�ջ
		String readFileContent = ""; // ��Ŷ�ȡ�ļ����ݵ��ַ���
		String[] readFileStrs; // �ļ����ݷָ��õ����ַ�������
		
		readFileContent = FileIO.fileInput("./calculateTest.txt");
		readFileStrs = readFileContent.split("\r\n"); // ���ջ��з����зָ� !!!!!ע�⣬windows�ı��ļ��Ļ��з���\r\n
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
					expression = readFileStrs[i].replaceAll("\\s+", ""); //������ʽ���ı�
					FileIO.fileOutput("./calculateResult.txt", expression + "=" + String.valueOf(resultStr.getResult()));					
				} catch (ArithmeticException e){
					FileIO.fileOutput("./calculateResult.txt", e.getMessage());
				}
			}
		}

	}
}
