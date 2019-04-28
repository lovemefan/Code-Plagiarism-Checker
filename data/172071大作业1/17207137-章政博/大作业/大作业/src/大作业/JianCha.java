package 大作业;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JianCha {
	int jc1(String ex,File f1) throws IOException{
		JiSuan c = new JiSuan();
		int i = 0,j = 0, n1 = 0, n = 0,jj = 0;
		try{
			
		while(j<ex.length()-1) {
			FileWriter output = new FileWriter(f1,true);
			
			if(c.isSwitch(ex.charAt(0)) == 5) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#括号不匹配");
				output.write("\r\n");
				output.flush();
				return 1;
			}else if(c.isSwitch(ex.charAt(0))<4 ) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#运算符前无运算数");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			if(c.isSwitch(ex.charAt(j)) >=6&&!Character.isDigit(ex.charAt(j))) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#表达式包含非法字符");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			if(c.isSwitch(ex.charAt(j)) == 4&&c.isSwitch(ex.charAt(j+1)) == 5) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#表达式中有空括号");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			if(c.isSwitch(ex.charAt(j)) == 4) {
				n1++;
				if(j==0) {
					
				}
				else if(c.isSwitch(ex.charAt(j-1))>4) {
					output.write(ex.substring(0, ex.length()-1));
					output.write("\r\n");
					output.write("ERROR\r\n#括号非第一个字符且之前无运算符");
					output.write("\r\n");
					output.flush();
					return 1;
				}
			}
			if(c.isSwitch(ex.charAt(j)) == 5) {
				if((c.isSwitch(ex.charAt(j+1)) > 5 || c.isSwitch(ex.charAt(j+1)) == 4) && c.isSwitch(ex.charAt(j+1))!=6) {
					output.write(ex.substring(0, ex.length()-1));
					output.write("\r\n");
					output.write("ERROR\r\n#小括号后无运算符，括号非最后一个字符");
					output.write("\r\n");
					output.flush();
					return 1;
				}
				n1--;
			}
			if(c.isSwitch(ex.charAt(j)) < 4 && c.isSwitch(ex.charAt(j+1))<4) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#运算符连续");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			if(n1<0) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#括号不匹配");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			if(c.isSwitch(ex.charAt(j)) < 4 &&!Character.isDigit(ex.charAt(j+1))&&c.isSwitch(ex.charAt(j+1)) != 4) {
				output.write(ex.substring(0, ex.length()-1));
				output.write("\r\n");
				output.write("ERROR\r\n#运算符后无运算数");
				output.write("\r\n");
				output.flush();
				return 1;
			}
			
			j++;
		}
		if(ex.length()==1) {
			FileWriter output = new FileWriter(f1,true);
			output.write("ERROR\r\n#表达式为空");
			output.write("\r\n");
			output.flush();
			return 1;
		}
		if(n1!=0) {
			FileWriter output = new FileWriter(f1,true);
			output.write(ex.substring(0, ex.length()-1));
			output.write("\r\n");
			output.write("ERROR\r\n#括号不匹配");
			output.write("\r\n");
			output.flush();
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		return n1;
		
	}
	String jckg(String ex) {
		String exp = new String();
		int i = 0,j = 0;
		while(j<ex.length()-1) {
			if(ex.charAt(j)!=' ') {
				exp = exp + ex.charAt(j);
			}else
				i++;
			
			j++;
		}
		
		return exp;
	}
	void jckh(File f) {
		String[] s = new String[50];
		String[] s1 = new String[100];
		for(int i=0;i<50;i++) {
			s[i] = new String();
		}
		int i = 0,j = 0;
		try (Scanner input = new Scanner(f);){
			
			while(input.hasNextLine()) {
				s1[j] = input.nextLine();
				if(s1[j].length()!=0) {
					s[i]=s1[j];
					i++;
				}else {
					System.out.println("ERROR\r\n#表达式为空");
				}
				j++;//System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try (PrintWriter output = new PrintWriter(f);){
			for(int jj = 0;jj<i;jj++)
				output.println(s[jj]);	
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
