
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileRead{
	File file;
	public FileRead(){
		
	}
	// 传入文件名字创建一个对象
	public FileRead(String newFile){
		file = new File(newFile);
	}
	//从文本读取内容 
	public String[] readFile() throws FileNotFoundException{
		Scanner input = new Scanner(file);
		int num = 0;
		String[] s = new String[1000];
		while (input.hasNext()){
			s[num] = input.nextLine();
			num ++;	
		}
		input.close();
		return s;
	}

}

