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
            // ����һ���ɱ䳤��stringBuffer����
            StringBuffer sb = new StringBuffer("");
            
            /*
             * ��ȡ�����ļ�
             */
            Reader reader = new FileReader("d:" + File.separator + "����.txt");
          
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = null;
            // ���ж�ȡ���������ж����Ƿ�Ϊnull�����ֽڻ����ַ���ȡʱ�����ı�־��-1
            while ((string = bufferedReader.readLine()) != null) {
               
                sb.append(string + "/n");
                System.out.println(string);
                String str1 = string;
            	boolean m = cal.check(str1);
            	System.out.println("\n");
            	if (m == true) {
            		Float result = cal.transfer(str1);
					String str2 = String.valueOf(result);
					File file = new File("D:" + File.separator + "���.txt");
			        Writer writer = new FileWriter(file, true);
			        writer.write("\r\n");
			        writer.write(str2);
			        writer.write("\r\n");
			        writer.close();
            	} else{
            		File file = new File("D:" + File.separator + "���.txt");
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