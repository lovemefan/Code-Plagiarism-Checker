package calcultor;

import java.util.Scanner;
import java.io.*;

public class File {
	private static String file[] = new String[100];
	
	public File() throws Exception{
		getStr();
	}
	
	public void getStr() throws Exception{
		int i = 0;
		java.io.File file = new java.io.File("data.txt");
		
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()){
			File.file[i] = input.nextLine();
			i ++;
		}
		input.close();
		file.delete();
	}

	
	public void setStr(String[] str) throws IOException{
		java.io.File file = new java.io.File("data.txt");
		if(file.exists()){
			System.out.println("File already exists");
			System.exit(1);
		}
		int i = 0;
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		while(str[i] != null){
			output.print(str[i]);
			output.println("");;
			i ++;
		}
		output.close();
	}
	
	public static String[] getArray(){
			return file;
	}
	
	public int getLength(){
		return file.length;
	}
}
