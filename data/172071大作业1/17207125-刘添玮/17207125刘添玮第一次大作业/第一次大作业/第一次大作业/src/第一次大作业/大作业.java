package 第一次大作业;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.script.ScriptException;
public class 大作业 {

	public static void main(String[] args) throws ScriptException, IOException {
		// TODO 自动生成的方法存根
		File f =new File("src\\expression"); 
		File f1=new File("src\\ans");
		FileOperation f0=new FileOperation();
		FileWriter output = new FileWriter(f1,true);
		String[] s=new String[3];
		s=f0.readLine(f);
		judge J1=new judge(f);
		for(int i=0;i<3;i++) {
			s[i]=s[i].substring(2);
		}
		for(int i=0;i<3;i++) {
			if(!J1.True(s[i])&&J1.Test(s[i])==10) {
				Operation op1=new Operation(s[i]);
				System.out.println(op1.getans());
				output.write(s[i]+"'s ans is:"+op1.getans());
				output.write("\r\n");
				output.flush();
			} 
		}
		output.close();
	}
}