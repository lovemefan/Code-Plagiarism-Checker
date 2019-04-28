package mathCalculator;

import java.io.File;  
import java.util.ArrayList;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  

public class file {  //读写文件的操作类
	
	public ArrayList<String> getRead() {        //读取文件
		ArrayList<String> line = new ArrayList<String>();  //保持读取内容的字符串数组
		try { 
			String str = "";
			File file = new File("input.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件  
            while ((str = br.readLine()) != null) {   //读取文件，并存储在line里面
            	line.add(str);
            }  
       } 
       catch (Exception e) {  
           e.printStackTrace();  
       }
	   return line;
	}  
	
	public void Write(ArrayList<String> w) {   //写入文件
		try {
			FileWriter writer = new FileWriter("output.txt"); //打开一个写文件器 
			for (int i = 0;i < w.size();i ++){
				writer.write(w.get(i)+"\r\n");             //写入内容
			}
	        writer.close();
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}  
	
}  