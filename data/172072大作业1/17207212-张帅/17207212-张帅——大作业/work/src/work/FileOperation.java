package work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {//文件操作类
	public String[] readLine(File f) {

		ArrayList<String> arrString=new ArrayList<String>();
		
		try (Scanner input = new Scanner(f);){

			while(input.hasNextLine()) {

				arrString.add(input.nextLine());
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String[] str = arrString.toArray(new String[arrString.size()]);
		
		return str;
	}
	
	public void writeFile(File F) {//将结果写入文件

		try (PrintWriter output = new PrintWriter(F);){
			
			File f = new File("src\\输入");
			String[] s =readLine(f);
			double result=0;
			
			for(int i=0;i<s.length;i++) {
				
				s[i]=s[i].replace(" ", ""); 
				
				if(Calculatortest.test(s, i) == 0) {
				
					if(Calculatortest.test1(s[i]) == 1)
						output.println("ERROR\n#表达式为空");
					else if(Calculatortest.test1(s[i]) == 2)
						output.println("ERROR\n#表达式中有空括号");
					else if(Calculatortest.test3(s[i]) == 1)
						output.println("ERROR\n#表达式包含非法字符");
					
					else if(Calculatortest.test1(s[i]) == 4)
						output.println("ERROR\n#运算符连续");
					else if(Calculatortest.test1(s[i]) == 5)
						output.println("ERROR\n#运算符前无运算数");
					else if(Calculatortest.test1(s[i]) == 6)
						output.println("ERROR\n#运算符后无运算数");
					else if(Calculatortest.test1(s[i]) == 7)
						output.println("ERROR\n#括号非第一个字符且之前无运算符");
					else if(Calculatortest.test1(s[i]) == 8)
						output.println("ERROR\n#小括号后无运算符，括号非最后一个字符");
					else if(Calculatortest.test2(s[i]) == 1)
						output.println("ERROR\n#括号不匹配");
					//else if(s[i] != "+" || s[i] != "+")
					else {
						
						ArrayList<String> InOrderList = Calculator.getStringList(s[i]);  //String转换为List
						ArrayList<String> PostOrderList = Calculator.getPostOrder(InOrderList);   //中缀变后缀
						result = Calculator.calculate(PostOrderList);   //计算
						
						output.println(s[i]+"="+result);
					}
				}
				else {					
				}
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} 

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
