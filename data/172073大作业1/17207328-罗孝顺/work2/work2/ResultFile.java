package work2;
//import java.util.regex.*;
//import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class ResultFile {
	String s = null;//��Ҫд������ݣ�
	
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
	            String s2 = s1.replaceAll(" ","");//ȥ�����ʽ�еĿո��м估��β��	        	
	        	Judge p = new Judge(s2);
	        	if(p.error0()==false) {
		        	out.write("ERROR\r\n");
		        	out.write("#�����ǰ��������\r\n");
		        	continue;
		        }	
	        	if(p.error1()==false) {
		        	out.write("ERROR\r\n");
		        	out.write("#���ʽ���������ַ�\r\n");
		        	continue;
		        }	
	        	if(p.error2()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ�к��п�����\r\n");
	        		continue;
	        	}
	        	if(p.error3()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ��������һ������������\r\n");
	        		continue;
	        	}
	        	if(p.error4()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ���������ͷ\r\n");
	        		continue;	        		
	        	}
	        	if(p.error5()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ�������ź��������\r\n");
	        		continue;
	        	}
	        	if(p.error6()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ�������ź��������\r\n");
	        		continue;
	        	}
	        	if(p.error7()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ��������ǰ���������\r\n");
	        		continue;
	        	}
	        	if(p.error8()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ�������ź��������\r\n");
	        		continue;
	        	}
	        	if(p.error9()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ�����������\r\n");
	        		continue;
	        	}
	        	if(p.error10()==false) {
	        		out.write("ERROR\r\n");
	        		out.write("#���ʽ���ŶԲ�ƥ��\r\n");
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
