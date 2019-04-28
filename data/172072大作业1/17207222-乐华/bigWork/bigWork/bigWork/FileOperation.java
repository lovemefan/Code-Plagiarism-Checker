package bigWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperation {
	String[] s = new String[50];//放入表达式的数组；
	int numberLine=0;//文件的行数
	public String[] readLine(File f) {
	//	String[] s = new String[3];
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				this.s[numberLine] = input.nextLine();
				numberLine++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	public void writeFile(File f) {
		try (PrintWriter output = new PrintWriter(f);){
				output.println("(9+9)*(9+1)");
				output.println("6+6-5*(8+1)");
				output.println("122*(6+1)-22");
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public void writeFile1(File f1,String[] ss,String[] s,int[] flag,String[] error) {	//把表达式和结果写入result文件中；
		int j=0;
		try (PrintWriter output = new PrintWriter(f1);){
			for(int i=0;i<this.numberLine;i++) {
				if(i==flag[j] && j<flag.length-1) {
		
					output.println(s[i]);
					output.println("ERROR");
					output.println(error[j]);
					j++;
				}
				else {
					output.print(s[i]);
					output.println(" = " + ss[i]);
				}
				}
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
}

