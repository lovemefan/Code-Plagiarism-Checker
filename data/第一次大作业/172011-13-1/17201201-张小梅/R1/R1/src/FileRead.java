import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
	
	ArrayList<String> str = new ArrayList<String>();//声明一个可变长的数组
	
	//从文件input.txt读取所有的请求
	public FileRead() {  //无参构造函数
		File file = new File("input.txt");
		Scanner input = null ;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNext()){
		    str.add(input.nextLine());
		}		
		System.out.println("文件input.txt中所有的请求为:" + str); //在控制台输出包含所有请求的数组str[]
	}
	
	public ArrayList<String> getStr() {	
		return str;		
	}

}
