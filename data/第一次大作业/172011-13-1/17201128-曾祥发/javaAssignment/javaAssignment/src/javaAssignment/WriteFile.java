package javaAssignment;
import java.io.*;

public class WriteFile {
	WriteFile(){
		
	}
	
	public  void write(String [] expression,String [] result){

		try{
			File writeName = new File("output.txt");//写入文件到out.txt，若文件夹已存在，则覆盖，不存在新建
			writeName.createNewFile();
			try(FileWriter writer = new FileWriter(writeName);
				BufferedWriter file = new BufferedWriter(writer)){
				int i = 0;
				while(expression[i] != null){
					if(result[i].equals("ERROR\r\n"))//表达式错误的话输出格式不一样
						file.write(result[i]+"#"+expression[i]+"\r\n");
					else
						file.write(expression[i]+result[i]+"\r\n");//正常的保存格式
					i++;
				}
				file.flush();
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

}
