import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	private static	List<String> listExpression=new ArrayList<String>();
	
	 //读取文件 .txt 转 list
    
   public static List<String> setUpArrayLists()throws IOException{
   
    File fileExp = new File("expression.txt");
  	 FileReader redExp=new FileReader(fileExp);
  	 BufferedReader bufExp=new BufferedReader(redExp);
  	 
  	
        
  	   String str="";
      while((str=bufExp.readLine())!=null){
      	listExpression.add(str.trim());
      }
      
      
      bufExp.close();
      redExp.close();
      
      return listExpression;

   }
}
