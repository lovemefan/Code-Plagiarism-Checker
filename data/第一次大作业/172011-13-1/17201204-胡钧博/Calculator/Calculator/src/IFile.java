
//文件输入输出
import java.io.*;
import java.util.Scanner;

public class IFile {
	IFile(){
		
	}
	public String[] read(File file)throws IOException{
		String strings[] = new String[200];
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;  
		int s = 1;  //行号
		while ((temp = br.readLine()) != null) {  
		   strings[s-1] = temp;
		    s++;  
		}
		strings[s-1]="";
		br.close();  
		return strings;
	}
	public void write(File file , String processedResult)throws IOException{
		FileWriter p = new FileWriter(file,true);
		PrintWriter w = new PrintWriter(new FileWriter(file,true));
		w.println(processedResult);
		w.close();
	}
}




