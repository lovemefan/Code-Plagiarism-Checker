package mathCalculator;

import java.io.File;  
import java.util.ArrayList;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  

public class file {  //��д�ļ��Ĳ�����
	
	public ArrayList<String> getRead() {        //��ȡ�ļ�
		ArrayList<String> line = new ArrayList<String>();  //���ֶ�ȡ���ݵ��ַ�������
		try { 
			String str = "";
			File file = new File("input.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�  
            while ((str = br.readLine()) != null) {   //��ȡ�ļ������洢��line����
            	line.add(str);
            }  
       } 
       catch (Exception e) {  
           e.printStackTrace();  
       }
	   return line;
	}  
	
	public void Write(ArrayList<String> w) {   //д���ļ�
		try {
			FileWriter writer = new FileWriter("output.txt"); //��һ��д�ļ��� 
			for (int i = 0;i < w.size();i ++){
				writer.write(w.get(i)+"\r\n");             //д������
			}
	        writer.close();
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}  
	
}  