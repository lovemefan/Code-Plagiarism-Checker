import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileOperation {//文本处理类
	String[] ss = new String[20];
	int i =0;
	public String[] readLine(File f) {//以行为单位读取内容并输出    文件名
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//scanner下一行有没有内容
				String s = input.nextLine();//从scanner中读取一行内容，以换行结束
				ss[i] = s;
				i++;
			}
		} catch (FileNotFoundException e) {//异常处理
			e.printStackTrace();
		}
		return ss;
	}
	
	public void writeFile(File f,String expression, int T) {//写入设置好的内容  文件名
		try (PrintWriter output = new PrintWriter(f);){
			output.println(expression+"="+T);					
		} catch (FileNotFoundException e) {//异常处理
			e.printStackTrace();
		} 
	}
//	
//	public static void main(String[] args) {
//		FileOperation fo = new FileOperation();//构造FileOperation类
//		File f = new File("src\\Expression");//构造File类，查找符合相对文件名的地方
//		File f2 = new File("src\\Result");//作为储存结果的文件
//		fo.readLine(f);	
//		fo.writeFile(f2);
//	}
}
