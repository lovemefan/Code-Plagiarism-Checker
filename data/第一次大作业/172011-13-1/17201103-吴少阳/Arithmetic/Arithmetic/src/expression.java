import java.io.IOException;
import java.util.*; 
public class expression {
	public static void main(String[] args) throws IOException {
		operation lt = new operation();
		fileIO a = new fileIO();
		checkexpression t = new checkexpression();
		StringBuilder str = new StringBuilder();
		a.fileInput();
		for (int i = 0; a.setexpression(i) != null; i++) {
			if (t.check(a.setexpression(i))=="1") {//判断表达式是否正确
				List<String> list = lt.work(a.setexpression(i));//将中缀表达式传入函数变为后缀表达式
				List<String> list2 = lt.InfixToPostfix(list);//将后缀表达式传入函数计算表达式的值
				str.append(a.setexpression(i)+"="+((double)Math.round(lt.doCal(list2)*10)/10)+"\r\n");//输出正确表达式及它的值 并保留一位小数
			} else
				str.append("ERROR\r\n#" + t.check(a.setexpression(i))+"\r\n");//输出错误表达式及它的错误信息
           }
		a.fileOutput(str.toString());//调用函数，将所有信息写入文件中
	}
}
