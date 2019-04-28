package work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {//�ļ�������
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
	
	public void writeFile(File F) {//�����д���ļ�

		try (PrintWriter output = new PrintWriter(F);){
			
			File f = new File("src\\����");
			String[] s =readLine(f);
			double result=0;
			
			for(int i=0;i<s.length;i++) {
				
				s[i]=s[i].replace(" ", ""); 
				
				if(Calculatortest.test(s, i) == 0) {
				
					if(Calculatortest.test1(s[i]) == 1)
						output.println("ERROR\n#���ʽΪ��");
					else if(Calculatortest.test1(s[i]) == 2)
						output.println("ERROR\n#���ʽ���п�����");
					else if(Calculatortest.test3(s[i]) == 1)
						output.println("ERROR\n#���ʽ�����Ƿ��ַ�");
					
					else if(Calculatortest.test1(s[i]) == 4)
						output.println("ERROR\n#���������");
					else if(Calculatortest.test1(s[i]) == 5)
						output.println("ERROR\n#�����ǰ��������");
					else if(Calculatortest.test1(s[i]) == 6)
						output.println("ERROR\n#���������������");
					else if(Calculatortest.test1(s[i]) == 7)
						output.println("ERROR\n#���ŷǵ�һ���ַ���֮ǰ�������");
					else if(Calculatortest.test1(s[i]) == 8)
						output.println("ERROR\n#С���ź�������������ŷ����һ���ַ�");
					else if(Calculatortest.test2(s[i]) == 1)
						output.println("ERROR\n#���Ų�ƥ��");
					//else if(s[i] != "+" || s[i] != "+")
					else {
						
						ArrayList<String> InOrderList = Calculator.getStringList(s[i]);  //Stringת��ΪList
						ArrayList<String> PostOrderList = Calculator.getPostOrder(InOrderList);   //��׺���׺
						result = Calculator.calculate(PostOrderList);   //����
						
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
