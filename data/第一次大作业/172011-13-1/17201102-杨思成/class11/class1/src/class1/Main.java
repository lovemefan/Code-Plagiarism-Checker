package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	private static String[] ins = new String[2000];//������������ַ�������
	private static boolean defRep (int len,String str){//�ж��Ƿ��ظ�����
		for (int i = 0;i < len ; i++){
			if (str.equals(ins[i])){
				 return true;
			}
		}
		return false;
		
	}
	public static void putFile(String filePath){//����ļ�����
		
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				System.out.println(tempString);
			
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {

				}

			}
		}
	}
	public static void readFile(String filePath) {//��ȡ�ļ�����������
		int point = 0;
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (defRep(point,tempString) == true){
					
				}
				else{
					ins[point++] = tempString ;
					count(tempString);
					
				}
			
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {

				}

			}
		}
	}

	public static void newFile(String filePath){//�½��ļ�
       File file = new File (filePath);
       if (file.exists()){
    	
    	   System.out.println("The file has already exists.Please delete it and create a new file!");
       }
       else{
    	   try{
    		   File fileParent = file.getParentFile();
    		   if (fileParent != null){
    			   if (!fileParent.exists()){
    				    fileParent.mkdirs();
    			   }
    		   }
    		   file.createNewFile();
    	   }
    	   catch (IOException e){
    		   e.printStackTrace();
    	   }
       }
	}
	
	public static void writeFile(String filePath,String conent){//���ļ���д����
	    BufferedWriter out = null;
	    try{
	    	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,true)));
	        out.write(conent+"\r\n");
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	try{
	    		if (out != null){
	    			out.close();
	    		}
	    	}
	    	catch(IOException e){
	    		e.printStackTrace();
	    	}
	    }		
	}
	
	
	public static void count(String temp) {//�����׺���ʽ������д���ļ���
		String post = "";
		int result = 0;
		
		Infix myInfix = new Infix(temp);

		String a= myInfix.getInfix().replaceAll(" ", "");//����ո�
		myInfix.setInfix(a);
		
	    if (myInfix.defInfix(myInfix.getInfix()) == true){
	    	
	      myInfix.toTheSuffix(myInfix.getInfix());
		  post = myInfix.getPost();
		
		DealPost dealpost = new DealPost(post);
		result = (int)dealpost.getResult();
		
		writeFile("Output",myInfix.getInfix() + "=" + result);
	    }
	    else{
	    	writeFile("Output",myInfix.getPro());
	    }
	}
	 public static boolean deleteFile(String filepath) {
	        File file = new File(filepath);
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	               // System.out.println("Misson over, already delete File :" + filepath );
	                return true;
	            } else {
	                //System.out.println("Misson over,can not delete File :" + filepath );
	                return false;
	            }
	        } else {
	           // System.out.println("Misson over,File ��" + filepath + "do not exist!");
	            return false;
	        }
	    }
	public static void main(String[] args) {//������
		deleteFile("Output");//�������ɾ���������ļ���
		newFile("Output");//���������ļ�
		readFile("Input");//����д��
		putFile("Output");//������
		
	}

}
