package allpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
/*
 * 读取文件所有指令
 * 筛选指令
 * 执行指令
 * 输出结果
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i = 0,k = 0;
		double answer;
		int[] num = new int[25];
		String[] filelist = new String[30]; //存储文件原指令

		Resolve resolve = new Resolve();
		Output output = new Output();
		
		File f = new File("work1");
		Scanner input = new Scanner(f);
		
		for(i = 0;input.hasNextLine();i++) {//提取文件内容并去空格
			filelist[i] = input.nextLine();
			filelist[i] = resolveEx(filelist[i]);
			if(isTong(filelist,i)) { //如果文件内容出现相同，删去它
				i--;
			}
		}
		input.close();
		for(int j= 0;j<i;j++) {
			if(filelist[j].length() == 0)
				num[j] = 9;
		}
		for(k = 0;k < i;k++) {
			if(num[k] != 9)//处理表达式为空
				num[k] = resolve.isLegal(filelist[k]);
			answer = 0;
			if(num[k] == 0){
				Compute compute = new Compute(filelist[k]);
				answer = compute.dataCompute();
				
			}
			output.outputAnswer(num[k],filelist[k],answer);
		}
	}
	//处理空格
	static String resolveEx(String filelist) {
		filelist = filelist.replaceAll(" ","");
		return filelist;
	}
	//处理相同字符串
	static boolean isTong(String[] filelist,int i) {
		for(int j = 0;j < i;j++) {
			if(filelist[i].compareTo(filelist[j]) == 0) {
				return true;
			}
		}
		return false;
	}

}
