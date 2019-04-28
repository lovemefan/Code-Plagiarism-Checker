import java.io.IOException;
import java.util.Scanner;

public class InputFile {
	public String Error = "";//输入的错误信息
	
	public InputFile(){
		
	}
	
	//文件的读取
	public String[] inputFile()throws IOException{
		java.io.File file1 = new java.io.File("input.txt");//读取"input.txt"文件
		Scanner input = new Scanner(file1);
		String[] part = new String[50]; 
		String[] count = new String[50];
		InputJudge j ;
		j = new InputJudge();
		int i = 0;
		while(input.hasNextLine()){//将文件内的字符串读取进字符串数组
			String str = input.nextLine();
			if(j.isEmpty(str)){//表达式是否为空
				Error += "\r\nERROR\r\n#该表达式为空\r\n";
			}
			else if(j.isOk(str.replace(" ", ""))){//去掉表达式中的空格
				Error += j.InputJudge(str.replace(" ", "")) + "\n";
			}
			else{
				part[i] = str;//将正确的表达式进入操作
				i ++;
			}
		}
		part = j.Repetition(part,i);//判断是否有重复的表达式
		int h = 0;
		for(int k = 0;k < i; k ++){//将错误信息存入
			if(j.hasError(part[k])){
				Error += part[k];
			}
			else {
				count[h] = part[k];
				h ++;
			}
		}
		return count;
	}
}
