import java.io.*;
import java.util.*;
public class File_operate {
	
	int conlumn = 0;
	File_operate(){
	}

	public String[] readFile(File f) {//��ȡ���ʽ
		
		String[] exp;
		exp = new String[100];//���Դ洢��ȡ�ı��ʽ
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
	                f.createNewFile();//����ļ������ڣ��ʹ������ļ�
	                fos = new FileOutputStream(f);//�״�д���ȡ
	            }else{
	                //����ļ��Ѵ��ڣ���ô�����ļ�ĩβ׷��д��
	            			//fos = new FileOutputStream(f,true);//���ﹹ�췽������һ������true,��ʾ���ļ�ĩβ׷��д��
	            			//OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//ָ����UTF-8��ʽд���ļ�

	            		/*	osw.write(str + '\n');
	            			//osw.write("\r");
	            			//ÿд��һ��Map�ͻ�һ��
	            			//д����ɹر���*/
	            			//osw.close(); 
	            			}
		 	}catch (Exception e) {
	            e.printStackTrace();
	        }
	   }

	
	
		
}
