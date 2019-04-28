package bigHomewrk1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		File outFile = new File("src\\outputCalculation");
		File inFile = new File("src\\inputCalculation");

		clearFile();
		try (Scanner input = new Scanner(outFile);){
			while(input.hasNextLine()) {	//判断文件是否可以继续读取
				String s = input.nextLine();//从文件中接收一行作为字符串返回，以换行为结束
				s = deleteSpace(s);
				JudgeLegalInput expression = new JudgeLegalInput(s);	//接收的字符串判断是否合法
				try (FileWriter output = new FileWriter(inFile,true);){
					if(expression.getLegal()) {
						Calculate test = new Calculate(s);
						output.write(s+" = ");
						String temp = "";
						temp = temp +test.getCalculationResults();
						output.write(temp+"\n");
					}else {
						output.write(s+"  ");
						output.write("ERROR"+"\t");
						output.write(expression.getResult()+"\n");
					}
					output.close();
				} catch (IOException e) {
					System.out.println("输出文件不可写");
					e.printStackTrace();
				} 
			}
		} catch (FileNotFoundException e) {
			System.out.println("输入文件不可读");
			e.printStackTrace();
		}
	}
	//删除计算式中空格
	public static String deleteSpace(String a) {
		String b = "";
		int k = -1;
		if(a.equals("")) {
			return a;
		}
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) == ' ') {
				b = b + a.substring(k+1, i);
				k = i;
			}
		}
		if(a.charAt(a.length()-1) != ' ') {
			b = b + a.substring(k+1);
		}
		return b;
		
	}
	//清除文档内容
	public static void clearFile() {
        File file =new File("src\\inputCalculation");
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
}
