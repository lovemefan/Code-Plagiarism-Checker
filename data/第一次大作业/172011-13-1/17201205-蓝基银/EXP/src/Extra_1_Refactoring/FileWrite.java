package Extra_1_Refactoring;

import java.io.*;

public class FileWrite {
	
	FileWrite (){
		
	}
	void fullyWrite (File myFile,String []fullyProcessed) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(myFile,true));   
		for (int i = 0;fullyProcessed[i]!=null;i++){
		pw.println(fullyProcessed[i]);      // ����
		}
		//pw.print(content);        // ������
		pw.close();
	}
	void Write (File myFile,String fullyProcessed) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(myFile,true));   
		pw.println(fullyProcessed);      // ����
		//pw.print(content);        // ������
		
		pw.close();
		}
}
