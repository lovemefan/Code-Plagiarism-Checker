package jisuanqi;
import jisuanqi.calcheck;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import jisuanqi.cal;
public class cal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = null;
		File f = new File("src\\jisuanqi\\mianban");
		//获取文件内容
		s=read(f,s);
		//检查输入是否规范
		if(f.length()==0) {	//检查表达式是否为空
			System.out.println("ERROR");
			System.out.println("#表达式为空");
		}
		else {
			calcheck x=new calcheck(s);
			//运算
			cal result=new cal(s);
			
			//输出运算结果
			writeFile(f,result.result);
		}
		
		
		
		
	}
	
	public static void writeFile(File f,String result) {
		try (PrintWriter output = new PrintWriter(new FileOutputStream(f,true));){
			output.println("您的计算结果为："+result);					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	static String calculat(String s) {
		String result = null;
		return result;
		
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
	

}
