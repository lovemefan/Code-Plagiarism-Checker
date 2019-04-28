package 正则表达式test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//文件操作
public class FileOperation{
	FileOperation(){}
	String temp[]=new String[100];
	/*//写文件表达式
	public void writerFile1(File expression) {
		Scanner a=new Scanner(System.in);
	     String y=a.nextLine();	 
	     while(!"A".equals(a.nextLine())){
		try (FileWriter fileWriter=new FileWriter(expression,true);){
			
			fileWriter.write(y+"\n");				
			fileWriter.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	  }
	}*/
	//读取文件expression
	int readFile1(File expression){
		int i=0;
		try (Scanner input = new Scanner(expression);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				temp[i]=s;
				i++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	//写文件result
	public void writerFile(File result,String str,int t) {
		try (FileWriter fileWriter=new FileWriter(result,true);){
			fileWriter.write(str+t+"\n");	
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	//读取文件result
	void readFile2(File result){
		String line=null;
		try(Scanner input = new Scanner(result);){
			while(input.hasNextLine() && (line=input.nextLine())!=null){
				if(!input.hasNextLine()){
					System.out.println(line);
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}