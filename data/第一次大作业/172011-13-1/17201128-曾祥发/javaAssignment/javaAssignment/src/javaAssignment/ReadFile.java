package javaAssignment;
import java.io.*;

public class ReadFile {
	
	ReadFile(){
		
	}
	
	public  void Read( String [] expression){//读取文件
		try(FileReader reader = new FileReader("input.txt");
			BufferedReader file = new BufferedReader(reader)){
			String line;
			int i = 0;
			while((line = file.readLine()) != null){//按行读取文件
				if(line.equals("")){//空行不读
					continue;
				}
				expression[i] = line.replaceAll(" ", "");//将读取出来的字符串将空格去掉存入表达式数组
				i++;
			}
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
