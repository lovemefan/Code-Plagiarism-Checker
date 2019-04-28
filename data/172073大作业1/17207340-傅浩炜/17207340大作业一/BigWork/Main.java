package BigWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws IOException {
		 	
		 	Main fo = new Main();
			File f = new File("src\\BigWork\\test");//输入表达式的文件
			File f2 = new File("src\\BigWork\\answer");//输出答案和报错的文件
			String Array[]=new String[25];
			
			Scanner input =  new Scanner(f);
			for(int i=0;input.hasNextLine();i++) {//用数组来存储表达式
				Array[i]=input.nextLine();
				
				fo.writeFile(f2, Array[i]);//写入f2文件
				
			}
			input.close();
			
	}
	private void writeFile(File f2 ,String str) throws IOException {
		try (PrintWriter output = new PrintWriter(new FileWriter(f2,true));){
			 Counter s = new Counter();	
			 Regex Regex=new Regex(); 
				 Boolean J=true;
				 Regex.Initialization();
				 if(str!=null)
				 J=Regex.Judge(str);
				 if(J==false) {
					 output.println("ERROR");
					 output.println(Regex.ErrorMessage(str));
				 }
				 else {
					 output.println(""+str+"="+""+s.solv(str));
					 output.println("");
				 }
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
}
