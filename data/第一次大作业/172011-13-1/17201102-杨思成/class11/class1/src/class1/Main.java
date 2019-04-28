package class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	private static String[] ins = new String[2000];//保存已输入的字符的数组
	private static boolean defRep (int len,String str){//判断是否重复输入
		for (int i = 0;i < len ; i++){
			if (str.equals(ins[i])){
				 return true;
			}
		}
		return false;
		
	}
	public static void putFile(String filePath){//输出文件内容
		
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
	public static void readFile(String filePath) {//读取文件并进行运算
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

	public static void newFile(String filePath){//新建文件
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
	
	public static void writeFile(String filePath,String conent){//在文件上写内容
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
	
	
	public static void count(String temp) {//计算后缀表达式并将其写入文件中
		String post = "";
		int result = 0;
		
		Infix myInfix = new Infix(temp);

		String a= myInfix.getInfix().replaceAll(" ", "");//处理空格
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
	           // System.out.println("Misson over,File ：" + filepath + "do not exist!");
	            return false;
	        }
	    }
	public static void main(String[] args) {//主方法
		deleteFile("Output");//程序完成删除创建的文件夹
		newFile("Output");//创建的新文件
		readFile("Input");//读并写入
		putFile("Output");//输出结果
		
	}

}
