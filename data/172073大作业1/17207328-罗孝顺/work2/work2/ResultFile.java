package work2;
//import java.util.regex.*;
//import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class ResultFile {
	String s = null;//需要写入的内容；
	
	ResultFile(String s){
		this.s=s;
	}
	void writerfile(String s) {
		File file = new File("infile.txt");
//		calculate equation = new calculate();
		Calculate a = new Calculate();
		File file1 = new File("resultfile.txt");
	    try{
	    	FileReader fr = new FileReader(file);
	        BufferedReader bf=new BufferedReader(fr);
	        String s1 = null;
	        int result = 0;
	        FileWriter out = new FileWriter(file1);
	        while((s1 = bf.readLine())!=null){	        			        	
	            String s2 = s1.replaceAll(" ","");//去除表达式中的空格（中间及首尾）	        	
	        	Judge p = new Judge(s2);
	        	if(p.error0()==false) {
		        	out.write("ERROR\r\n");
		        	out.write("#运算符前无运算数\r\n");
		        	continue;
		        }	
	        	if(p.error1()==false) {
		        	out.write("ERROR\r\n");
		        	out.write("#表达式中有其他字符\r\n");
		        	continue;
		        }	
	        	if(p.error2()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中含有空括号\r\n");
	        		continue;
	        	}
	        	if(p.error3()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中有连在一起的两个运算符\r\n");
	        		continue;
	        	}
	        	if(p.error4()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式以运算符开头\r\n");
	        		continue;	        		
	        	}
	        	if(p.error5()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号后有运算符\r\n");
	        		continue;
	        	}
	        	if(p.error6()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号后有运算符\r\n");
	        		continue;
	        	}
	        	if(p.error7()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中左括号前不是运算符\r\n");
	        		continue;
	        	}
	        	if(p.error8()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式中右括号后不是运算符\r\n");
	        		continue;
	        	}
	        	if(p.error9()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式以运算符结束\r\n");
	        		continue;
	        	}
	        	if(p.error10()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#表达式括号对不匹配\r\n");
	        		continue;
	        	}	
	        	result = a.calculate(s2);
	        	//result = equation.Change(s2);
	        	out.write(s2+"="+result+"\r\n");
	        }
	        out.close();
	        bf.close();
	        fr.close();
	    }catch(Exception e){
	        e.printStackTrace(); 
	    }
	}
}
