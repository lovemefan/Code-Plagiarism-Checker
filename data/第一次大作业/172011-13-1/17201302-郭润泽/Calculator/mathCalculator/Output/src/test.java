import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  

public class test {
	
	public static void main(String[] args) {
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw 

            /* ����TXT�ļ� */  
			String pathname = "D:/information.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(pathname);     // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader);  // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
            }  

            /* д��Txt�ļ� */  
            File writename = new File("D:/output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�  
            writename.createNewFile(); // �������ļ�  
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
            out.write("�һ�д���ļ���\r\n"); // \r\n��Ϊ����  
            out.flush(); // �ѻ���������ѹ���ļ�  
            out.close(); // ���ǵùر��ļ�  
       } 
       catch (Exception e) {  
           e.printStackTrace();  
       }
	}  
	
}  