package calculate2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class test2 {
	private static String filePath = "src\\test3.txt";
	private static String filePath2 = "src\\test4.txt";
    public static void main(String[] args) throws IOException {
    	ArrayList<String> list = FileRead(filePath);  //调用读取文件操作
    	ArrayList<String> list2 = new ArrayList<String>();
        Calculater2 ca = new Calculater2();
        for(String str:list)
        	list2.add(ca.getEventuate(str));
        
        FileWrite(filePath2,list2);  //把运算后的表达式加上运算结果，写入另一个文件
    }
    
    //把东西写入文件
    public static void FileWrite(String filepath,ArrayList<String> li) throws IOException {
		File file = new File(filePath);
		if(!file.exists()) {
			file.createNewFile();
		}
    	
    	try {
			FileOutputStream fos=new FileOutputStream(filepath,true);
			//保留原文件中内容则为true，否则flase
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			for(String str: li)
				bw.write(str+"\r\n");
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//读取文件中内容
	public static ArrayList<String> FileRead(String filepath) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis=new FileInputStream(filepath);
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader bw=new BufferedReader(isr);
		
		String line;          
		while((line=bw.readLine())!=null) {
			list.add(line);
		}
		bw.close();
		return list;
	}
}