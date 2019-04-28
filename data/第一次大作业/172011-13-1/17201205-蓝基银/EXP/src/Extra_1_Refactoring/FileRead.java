package Extra_1_Refactoring;

import java.io.*;

public class FileRead {
	String path = "input.txt";
	File myFile = new File(path);
	
	FileRead (){
		
	}
	FileRead (String path){
		this.path = path;
	}
	
	String[] readFromFile () throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(myFile));
		String tempString = null;  
		int line = 1;  
		String fileString[] = new String[1001];
		// 一次读入一行，直到读入null为文件结束  
		while ((tempString = reader.readLine()) != null) {  
		    // 显示行号  
		    //System.out.println("line " + line + ": " + tempString); 
		    fileString[line-1] = tempString;
		    line++;  
		}  
		reader.close();  
		return fileString;
	}
}
