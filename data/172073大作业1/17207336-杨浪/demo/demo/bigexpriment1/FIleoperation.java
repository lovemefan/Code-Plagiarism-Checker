package bigexpriment1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FIleoperation {
	FIleoperation(){		
	}
	public void writeFile1(File f,String s,double num) {//写入计算结果
		try (FileWriter output = new FileWriter(f,true);){
			output.write(s+"="+num+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void readLine1(File f) {
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {//判断下一行字符是否为空
				String s = input.nextLine();//读一行字符
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
