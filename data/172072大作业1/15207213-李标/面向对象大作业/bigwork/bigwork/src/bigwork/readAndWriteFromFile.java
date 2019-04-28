package bigwork;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class readAndWriteFromFile {

    public static void main(String[] args) throws IOException {
        try {
            // 声明一个可变长的stringBuffer对象
            StringBuffer sb = new StringBuffer("");
            
            //*读取完整文件 (work)            
            Reader reader = new FileReader("work\\计算.txt");          
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = null;
            Input(string);//输入表达式
                   
            // 按行读取，结束的判断是是否为null，按字节或者字符读取时结束的标志是-1
            while ((string = bufferedReader.readLine()) != null) {
                                     	
                sb.append(string + "/n");
                /*System.out.print(string);
                System.out.println("="+"\n")*/;
                
                String str1 = string;
            	boolean m = cal.check(str1);  //调用cal中的check 将cal 返回的值赋给m  true or false 
            	/*System.out.println("\n");*/
            	
            	// true
            	if (m == true) {
            		Float result = cal.transfer(str1);           		
					String str2 = String.valueOf(result);
					System.out.println("等于："+str2);
					
					File file = new File("work\\结果.txt");
			        Writer writer = new FileWriter(file, true);//追加文件使用：FileWriter() 打开一个写文件器，构造函数中的第二个参数true表示以追加的形式写文件
			        writer.write(str2);  //str2中的数据写进文件结果.txt中
			        writer.write("\r\n");
			        writer.close();//关闭writer文件器
            	} else{  //判错
            		File file = new File("work\\结果.txt");			        
			        String str3 = "ERROR";
			        
			        Writer writer = new FileWriter(file, true);
			        /*writer.write("\r\n");*/
                    writer.write(str3);
			        writer.write("\r\n");
                    writer.close();
            	}
            }
            bufferedReader.close();
            reader.close();
            } catch (FileNotFoundException e){
            	e.printStackTrace();
            } catch (IOException e) {
            	e.printStackTrace();
            	}
        }
        
       //输入表达式
        static  String Input(String s) {    	     
               Scanner input = new Scanner(System.in);
               System.out.println("输入一个表达式写入到“计算.txt”文件中：");
               s = input.nextLine();         
               File f=new File("work\\计算.txt");
               try (PrintWriter output = new PrintWriter(f);){
               output.print(s);  		
		       } catch (FileNotFoundException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
		        }
               return s;
         }
}