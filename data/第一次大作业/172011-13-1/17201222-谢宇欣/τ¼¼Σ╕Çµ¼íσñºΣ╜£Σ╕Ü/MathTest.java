package jisuanji;
import java.util.*;
import java.io.*;
public class MathTest {
	 public static void main(String[] args) throws Exception{
		 Check c = new Check();
		 double result = 0;
		 System.out.println("请输入文件的地址");
		 Scanner in= new Scanner(System.in);
		 String path = in.next(); 
		 File file = new File(path);
		 Scanner input = new Scanner(file);
		 ArrayList<String> strArray = new ArrayList<>();
		 while(input.hasNext()){
		     String expres = input.nextLine();
		     strArray.add(expres);
		 }
			 input.close();
			 File file1 = new File("D:\\result");
			 PrintWriter output = new PrintWriter(file1);
			for(int i=0;i<strArray.size();i++){
				 String ex = c.checkex(strArray.get(i));
				 if(ex.matches(".*Error.*")==false){
					 result = Calculator.conversion(ex);
					 output.println(ex + " = " + result);
				 }
				 else{
					 output.println(strArray.get(i) + "   " + ex);
				}
			}
				 output.close();
			 }
	 


}
