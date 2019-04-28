import java.io.*;
import java.util.*;
public class File_operate {
	
	int conlumn = 0;
	File_operate(){
	}

	public String[] readFile(File f) {//读取表达式
		
		String[] exp;
		exp = new String[100];//用以存储读取的表达式
		try(Scanner input = new Scanner(f);){
			while(input.hasNext()) {
				exp[conlumn] = new String();
				exp[conlumn++] = input.next();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return exp;
		
	}
	public void writeFile(File f) {
		
		 try{
	            FileOutputStream fos = null;
	            if(f.exists()){
	                f.createNewFile();//如果文件不存在，就创建该文件
	                fos = new FileOutputStream(f);//首次写入获取
	            }else{
	                //如果文件已存在，那么就在文件末尾追加写入
	            			//fos = new FileOutputStream(f,true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
	            			//OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件

	            		/*	osw.write(str + '\n');
	            			//osw.write("\r");
	            			//每写入一个Map就换一行
	            			//写入完成关闭流*/
	            			//osw.close(); 
	            			}
		 	}catch (Exception e) {
	            e.printStackTrace();
	        }
	   }

	
	
		
}
