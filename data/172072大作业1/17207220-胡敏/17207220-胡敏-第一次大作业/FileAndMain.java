package 大作业;//多个式子一起输入再逐个进行计算

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileAndMain {	
	static int num=1;
	public void writeFile(File f) {//写文件，在这里是覆盖了之前文件的文本，再一次输出时，打印的时新写的内容
		try (PrintWriter output = new PrintWriter(f);){//文本输出打印对象格式化形式
			System.out.println("Please enter a expression,enter '#' to end:");
			Scanner input=new Scanner(System.in);
			String a=input.nextLine();
			while(!a.equals("#")) {
				output.println(a);
				System.out.println("Please enter a expression,enter '#' to end:");
				a=input.nextLine();
			}
			input.close();
								
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public void readLine(File f,File fw) throws IOException {
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//回车（一句）为分隔
				String s = input.nextLine();//读取文件中的字符串作为代替键盘输入
			//	System.out.print(s);
				Suffix.filetoexp(s,fw);
				continue;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {//main函数在这里
		
		FileAndMain fo = new FileAndMain();//fo文件管理者,自己创建
		File f = new File("src\\Waitforcalculate");	//f代表文件,java提供，\\转译,提取文件,f作为管理
		File fw = new File("src\\output");
		//静态文件类
		fo.writeFile(f);//将内容写入文件，并覆盖原有内容
		fo.readLine(f,fw);	//展示文件内所有内容
	}


}