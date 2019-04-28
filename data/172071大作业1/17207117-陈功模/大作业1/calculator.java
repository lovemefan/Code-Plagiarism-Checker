package Calculator;
import Calculator.check;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import Calculator.calculat;
public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = null;
		File f = new File("src\\Calculator\\panel");
		//获取文件内容
		s=read(f,s);
		//检查输入是否规范
		if(f.length()==0) {	//检查表达式是否为空
			System.out.println("ERROR");
			System.out.println("#表达式为空");
		}
		else {
			boolean ch=true;
			check x=new check(s,ch);
			//运算
			if(x.c) {
				calculat result=new calculat(s);
				System.out.println(result.result);
				//输出运算结果
				writeFile(f,result.result);
			}
		}
		
		
		
		
	}
	
	//读取文件内容
	static String read(File f,String s) {
		try (Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				 s = input.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void writeFile(File f,String result) {
		try (PrintWriter output = new PrintWriter(new FileOutputStream(f,true));){
			output.println("运算结果为："+result);
			output.println("请在下一行输入下一个数学表达式");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
