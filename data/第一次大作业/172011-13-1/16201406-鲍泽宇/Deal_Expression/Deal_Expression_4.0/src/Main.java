import java.util.Scanner;
import java.io.*;

//import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建对象
		Write w = new Write();
		Evaluate e = new Evaluate();
		Regex r = new Regex();
		Io i = new Io(e,w,r);
		
		//用户输入
		System.out.println("请输入TXT文件文件名并按下Enter，以进行测试");
		System.out.println("输入格式：X:\\filename.txt 或 X:/filename.txt或filename.txt(仅当文件在工程文件夹根目录下时)");	
		
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();	
		File file = new File(str);
		
		//输入校验
		while(!file.exists()) {
			System.out.println("文件没有找到，请重新输入标准文件名");
			String str2="";
			str2 = input.nextLine();
			//System.out.println(str2);
			File file2 = new File(str2);
			file = file2;
			str = str2;
			//System.out.println(str);
		}
		
		
		
		System.out.println(str);
		i.reader(str);
		
		

		System.out.println("Over");
		System.out.println("输出文件将保存在工程文件夹根目录的 YourResults.txt");
		input.close();

		
		
		

	}

}
