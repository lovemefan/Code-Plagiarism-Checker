import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要读取的.txt文件的路径和名字(例如input.txt):");
		String inputName = input.nextLine();
		System.out.println("请输入要读取的表达式个数(大于0的整数):");
		int n = input.nextInt();
		//检验输入
		while (n < 0) {
			System.out.println("输入错误,请输入要读取的表达式个数(大于0的整数):");
			n = input.nextInt();
		}
		//消除输入整型变量\n残留
		input.nextLine();
		System.out.println("请输入要输出的.txt文件的路径和名字(例如output.txt):");
		String outputName = input.nextLine();
		MyFile myFile = new MyFile(inputName,outputName,n);
		//从文件读取
		myFile.input();
		//输出到文件
		myFile.output();
		System.out.println("已输出");
	}
	
}
