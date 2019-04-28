import java.io.*;
import java.util.*;

public class FileOperation {
	//从文件中一行一行的读取信息并将信息返回给调用者
	public String[] readLine(File f,String str[]) {
		int i=0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				str[i]=input.nextLine();;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();//异常处理保证程序出现异常时能继续运行而不崩溃
		}
		str[i]=null;
		return str;
	}
	
	//向文件中写入一行一行的销售记录
	public void writeFile(String s) {
		File f=new File("result.txt");
		try (FileWriter output=new FileWriter(f,true);){//在不覆盖原文件内容下继续写入新内容
			output.write(s);
			output.write("\r\n");//换行
			output.flush();//刷新缓冲区将信息写入文件
		} catch (IOException e) {
			e.printStackTrace();//异常处理保证程序出现异常时能继续运行而不崩溃
		} 
	}
		
}
