package homework;
//import java.util.*;
import java.util.Scanner;
import java.io.IOException;
public class ReadDate {
	private String bdString = " ";
	public ReadDate(){
		
	}
  //private static Scanner input;
	
public String getData() throws IOException { 
	  java.io.File file=new java.io.File("homework.txt");
	 Scanner input = new Scanner(file);
	  java.io.File file1=new java.io.File("result.txt");
	   java.io.PrintWriter output = new java.io.PrintWriter(file1);
	   
	  while(input.hasNext()){
	    bdString = input.nextLine();
	   
	    operate nbl=new operate(bdString); 
	   System.out.println(bdString);
	    boolean a=nbl.isNum(bdString);
	    boolean b=nbl.isCzf(bdString);
	  
	    if(a==false&&b==false){
	    	
	    	
	    	 nbl.zz_hz();
			  if(nbl.js_nbl()!=99999){
				  int result=0;
				  result= nbl.js_nbl();
				  output.println(bdString+"="+result);
			  }
			  
			
			 // nbl.
			
			 //System.out.println(result);n
	    
	    }
	    else{
		//  operate operate = new operate(bdString);
		//return bdString;
	    	nbl.stack_ysbds1();
	    output.println(nbl.stack_ysbds1());
	   
	 		   
	    }
     }
      
	  input.close();
	  output.close();
    return bdString;
 }
}
