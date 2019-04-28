package bigwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class readAndWriteFromFile {

    public static void main(String[] args) throws IOException {
        try {
            // 声明一个可变长的stringBuffer对象
            StringBuffer sb = new StringBuffer("");
            
            /*
             * 读取完整文件
             */
            Reader reader = new FileReader("d:" + File.separator + "计算.txt");
          
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = null;
            // 按行读取，结束的判断是是否为null，按字节或者字符读取时结束的标志是-1
            while ((string = bufferedReader.readLine()) != null) {
               
                sb.append(string + "/n");
                System.out.println(string);
                String str1 = string;
            	boolean m = cal.check(str1);
            	System.out.println("\n");
            	if (m == true) {
            		Float result = cal.transfer(str1);
					String str2 = String.valueOf(result);
					File file = new File("D:" + File.separator + "结果.txt");
			        Writer writer = new FileWriter(file, true);
			        writer.write("\r\n");
			        writer.write(str2);
			        writer.write("\r\n");
			        writer.close();
            	} else{
            		File file = new File("D:" + File.separator + "结果.txt");
			        Writer writer = new FileWriter(file, true);
			        String str3 = "ERROR";
			        writer.write("\r\n");
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
}