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
            // ����һ���ɱ䳤��stringBuffer����
            StringBuffer sb = new StringBuffer("");
            
            //*��ȡ�����ļ� (work)            
            Reader reader = new FileReader("work\\����.txt");          
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string = null;
            Input(string);//������ʽ
                   
            // ���ж�ȡ���������ж����Ƿ�Ϊnull�����ֽڻ����ַ���ȡʱ�����ı�־��-1
            while ((string = bufferedReader.readLine()) != null) {
                                     	
                sb.append(string + "/n");
                /*System.out.print(string);
                System.out.println("="+"\n")*/;
                
                String str1 = string;
            	boolean m = cal.check(str1);  //����cal�е�check ��cal ���ص�ֵ����m  true or false 
            	/*System.out.println("\n");*/
            	
            	// true
            	if (m == true) {
            		Float result = cal.transfer(str1);           		
					String str2 = String.valueOf(result);
					System.out.println("���ڣ�"+str2);
					
					File file = new File("work\\���.txt");
			        Writer writer = new FileWriter(file, true);//׷���ļ�ʹ�ã�FileWriter() ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷�ӵ���ʽд�ļ�
			        writer.write(str2);  //str2�е�����д���ļ����.txt��
			        writer.write("\r\n");
			        writer.close();//�ر�writer�ļ���
            	} else{  //�д�
            		File file = new File("work\\���.txt");			        
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
        
       //������ʽ
        static  String Input(String s) {    	     
               Scanner input = new Scanner(System.in);
               System.out.println("����һ�����ʽд�뵽������.txt���ļ��У�");
               s = input.nextLine();         
               File f=new File("work\\����.txt");
               try (PrintWriter output = new PrintWriter(f);){
               output.print(s);  		
		       } catch (FileNotFoundException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
		        }
               return s;
         }
}