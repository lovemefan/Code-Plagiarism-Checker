
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileRead{
	File file;
	public FileRead(){
		
	}
	// �����ļ����ִ���һ������
	public FileRead(String newFile){
		file = new File(newFile);
	}
	//���ı���ȡ���� 
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

