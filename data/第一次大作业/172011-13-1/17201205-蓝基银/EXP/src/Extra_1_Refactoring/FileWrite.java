package Extra_1_Refactoring;

import java.io.*;

public class FileWrite {
	
	FileWrite (){
		
	}
	void fullyWrite (File myFile,String []fullyProcessed) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(myFile,true));   
		for (int i = 0;fullyProcessed[i]!=null;i++){
		pw.println(fullyProcessed[i]);      // 换行
		}
		//pw.print(content);        // 不换行
		pw.close();
	}
	void Write (File myFile,String fullyProcessed) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(myFile,true));   
		pw.println(fullyProcessed);      // 换行
		//pw.print(content);        // 不换行
		
		pw.close();
		}
}
