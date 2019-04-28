package BigHomeWork1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class File_ {
	File file;
	// 无参构造
	public File_(){
		
	}
	// 传入一个文件 构造
	public File_(String newFile){
		file = new File(newFile);
	}
	// 获得file
	public File getFile(){
		return file;
	}
	// 设置file
	public void setFile(File newFile){
		file = newFile;
	}
	// 从文本读取内容， 
	public String[] readFile(File newFile) throws FileNotFoundException{
		Scanner input = new Scanner(newFile);
		int num = 0;
		String[] a = new String[500];
		while (input.hasNext()){
			a[num] = input.nextLine();
			num ++;
		}
		input.close();
		return a;
	}
	// 向文本输人文本内容
	public void writeFile(String[] newStr,String[] newStr2,String newStr1) throws FileNotFoundException{
		File f = new File(newStr1);
		PrintWriter output = new PrintWriter(f);
		for(int i = 0;newStr[i] != null;i ++){
		    output.println(newStr[i] + "\n");
		    InputCheck b = new InputCheck(newStr2[i]);
		    if(b.judgeAll() == false){
		    	switch(b.getError()){
		    	case 0:
		    		break;
		    	case 1:
		    		output.println("ERROR\n#表达式中含有不合法字符\n");
		    		break;
		    	case 2:
		    		output.println("ERROR\n#表达式中运算符或括号使用错误\n");
		    		break;
		    	case 3:
		    		output.println("ERROR\n#表达式中括号匹配错误\n");
		    		break;
		    	case 4:
		    		output.println("ERROR\n#表达式首运算符使用错误\n");
		    		break;
		    	case 5:
		    		output.println("ERROR\n#表达式尾运算符使用错误\n");
		    		break;	
		    	}
		    }
		}
		output.close();
	}

}

