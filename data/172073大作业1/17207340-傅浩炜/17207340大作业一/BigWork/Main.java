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
			File f = new File("src\\BigWork\\test");//������ʽ���ļ�
			File f2 = new File("src\\BigWork\\answer");//����𰸺ͱ�����ļ�
			String Array[]=new String[25];
			
			Scanner input =  new Scanner(f);
			for(int i=0;input.hasNextLine();i++) {//���������洢���ʽ
				Array[i]=input.nextLine();
				
				fo.writeFile(f2, Array[i]);//д��f2�ļ�
				
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
