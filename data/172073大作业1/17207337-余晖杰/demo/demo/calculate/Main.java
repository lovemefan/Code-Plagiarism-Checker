package calculate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

import experiment_3.Goods;
public class Main {
    public static void main(String[] args) throws IOException, FormatException {
       // System.out.println("输入算式：");
       // Scanner scanner = new Scanner(System.in);
        String express =  printFile();
        Calculator calculator = new Calculator(express);
        writeFile(express);
        printFile2();
       //System.out.println(express+"="+calculator.calculate());
       // printFile();
       //try {
           // System.out.println("="+calculator.calculate());
       // } catch (FormatException e) {
           // e.printStackTrace();
       // }
  }
 /*   public  static void  writeboxFile(String expression) throws IOException, FormatException{//表达式输入到文件
 		File file=new File("src\\test");
 		PrintWriter pw=new PrintWriter(file);
 		Calculator calculator1 = new Calculator(expression);
 		pw.println(expression+"="+calculator1.calculate());
 		pw.close();
 		} */
    public  static String  printFile() throws IOException, FormatException{//从文件读取运算式
    	File file=new File("src\\test");
    	FileReader fileReader = null;
    	try {
    		fileReader = new FileReader(file);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	Scanner sc=new Scanner(fileReader);
    	String line = null;
    	while((sc.hasNextLine()&&(line=sc.nextLine())!=null)){
    		if(!sc.hasNextLine()){
    			//System.out.println(line);
    		}
    	}
    	sc.close();
    	return line.replace(" ", "");
    }
    public  static void  writeFile(String expression) throws IOException, FormatException{//将表达式结果写入到文件
		File file=new File("src\\test");
		BufferedWriter bw=null;
		try {
		bw=new BufferedWriter(new FileWriter(file,true));
		Calculator calculator1 = new Calculator(expression);
		bw.write("="+calculator1.calculate()+"\n");
		bw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
    public  static String  printFile2() throws IOException, FormatException{//将运算之后的表达式从文件输出
    	File file=new File("src\\test");
    	FileReader fileReader = null;
    	try {
    		fileReader = new FileReader(file);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	Scanner sc=new Scanner(fileReader);
    	String line = null;
    	while((sc.hasNextLine()&&(line=sc.nextLine())!=null)){
    		if(!sc.hasNextLine()){
    			System.out.println(line.replace(" ", ""));
    		}
    	}
    	sc.close();
    	return line;
    }
 		}

/*FileReader fileReader = null;
try {
	fileReader = new FileReader(file);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
Scanner sc = new Scanner(fileReader);
String line = null;
while((sc.hasNextLine()&&(line=sc.nextLine())!=null)){
	if(!sc.hasNextLine()){
		System.out.println(line);
	}
}
sc.close();*/
