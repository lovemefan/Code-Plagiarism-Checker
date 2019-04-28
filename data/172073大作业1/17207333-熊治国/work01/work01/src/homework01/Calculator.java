package homework01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("temp");
		
		readFile(file);	

	}
	
	public static void readFile(File file) throws IOException{
		int n = 0;
		String s = "";
		clearFile();					//清除文件中已有的内容
		Scanner input = new Scanner(new File("temp"));
		String temp = "";
		while (input.hasNext()){
			n++;
			s = input.nextLine();
			if (n == 1 && s.equals(temp)){//必须用equal，这个条件防止第一行表达式为空
				temp = s;
				writeFile(s);
			}else{
				if (s.equals(temp)){//必须用equal
					continue;//进行下一次循环
				}	
				temp = s;
				writeFile(s);
	
			}
			
		}
		input.close();
	}
	
	public static void clearFile() {		//清除文件中已有的内容
        File file =new File("result");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter output =new FileWriter(file);
            output.write("");
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}   
	
	public static void writeFile(String s) throws IOException{
		
		File file = new File("result");
				
		int a = Expression.judgeExpression(s);	//直接调用类中的静态方法
				
		try (FileWriter output = new FileWriter(file,true);){//追加文本信息

			switch(a){
				case 1:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#表达式为空");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 2:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#表达式中有空括号");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 3:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#表达式包含非法字符");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 4:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#运算符连续");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 5:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#运算符前无运算数");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 6:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#运算符后无运算数");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 7:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#小括号前无运算符，括号非第一个字符");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 8:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#小括号后无运算符，括号非最后一个字符");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;
				case 9:
					output.write(s);
					output.write("\r"+"\n");
					output.write("ERROR");
					output.write("\r"+"\n");
					output.write("#括号不匹配");
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
					break;	
				case 0:
					output.write(s + "=" + Expression.result(s));
					output.write("\r"+"\n");
					output.write("----------------");
					output.write("\r"+"\n");
				default:
					;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
}
