package Extra_1_Refactoring;

import java.io.*;
import java.util.*;

public class Main1 {

	public static void main(String[] args) throws IOException {
		OperationArray C96 =new OperationArray();
		InputProcessing C97 = new InputProcessing(); 
		/*                                     //下注释为测试四则运算使用
		String input = "1+1";
		//String input = "(30    -  15)  *  (4/2)+((3-1)*3)";
		String input2 = input;
		String result = "";
		input = C97.removeSpaces(input);
		result =C96.goIntoStack(input);
		System.out.println(input2 + " = "+C97.calculation(C96.list));*/
		File tempF = new File("input.txt");
		
		if (!tempF.exists()){
			PrintWriter tempF1 = new PrintWriter(new FileWriter(tempF,true));  
			PrintWriter tempF2 = new PrintWriter(new FileWriter("output.txt",true));  
			System.exit(0);
		}
		FileRead C99 = new FileRead();
		String []fileread = C99.readFromFile();
		
		
		
		File myfile = new File("output.txt");
		FileWrite C100 = new FileWrite();
		FormatCheck C101= new FormatCheck();
		String resulted = "";
		String origin = "";
		for (int i=0 ;fileread[i]!=null;resulted = ""){
			origin = origin+fileread[i];
			fileread[i] = C97.removeSpaces(fileread[i]);
			resulted=C101.check(fileread[i]);
			if(!resulted.equals("")){
				C100.Write(myfile,resulted);
				i++;
				continue;
			};
			resulted = C96.goIntoStack(fileread[i]);
			resulted = C97.calculation(C96.list);
			C100.Write(myfile,origin+"="+resulted);
			i++;
		}
		
		
		
		
		
		
		
	}
}
