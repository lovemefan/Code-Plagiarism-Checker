package Calculator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Readfile {
	
	 String filename;
	 int i=0;
	 
	 String[] p=new String[50];
	 public Readfile(){
		 
	 }
	 public Readfile(String filename){
		 this.filename=filename;
	 }
	 public void readWay()
	          {
		              String fileName="D:/Data.txt";
	                  String line;
	                  try
	                 {
	                         BufferedReader in=new BufferedReader(new FileReader(fileName));
	                         line=in.readLine();//���ж�ȡ
	                          while (line!=null)
	                         {
	                                
	                                  p[i]=line;
	                                  line=in.readLine();
	                                  i++;
	                          }
	                         in.close();
	                  } catch (IOException e)
	                 {
	                         e.printStackTrace();
	                  }
	          }
	public int Geti(){
		return i;//�õ����ʽ�ĸ���
	}
	public String[] getXep(){
	
		 return p;
	 }
}



