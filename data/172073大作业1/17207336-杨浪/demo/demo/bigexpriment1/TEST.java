package bigexpriment1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TEST {
	public static void main(String[] args) {
	File f = new File("src\\test");
	File f1 = new File("src\\test3");
	Calculate cal =new Calculate();
	FIleoperation fo=new FIleoperation();
	String s;
	try (Scanner input = new Scanner(f);){
		while(input.hasNextLine()) {//判断下一行字符是否为空
			s = input.nextLine();//读一行字符
			Standard std=new Standard();		
			int k=std.pd(s);
		    while(k!=1) {
		    	if(input.hasNextLine()) {
				s = input.nextLine();
				k=std.pd(s);}
		    	else
		    		k=1;
			}
			double result=cal.qiuzhi(s);
			fo.writeFile1(f1,s,result);		
			k=std.pd(s);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	  }
		fo.readLine1(f1);
	}
}
