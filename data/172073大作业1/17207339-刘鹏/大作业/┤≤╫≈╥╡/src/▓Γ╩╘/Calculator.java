package ����;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;



class FileOperation {// ��ȡ�ļ�
	public void readExpression(File f) throws FileNotFoundException {  
		File fw = new File("src//result");
		PrintWriter output = new PrintWriter(fw);
		
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				//RegularExpression expre = new RegularExpression();
				//expre.checkout(s,output);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		output.close();
	}
	
	public void readLine(File f) {  
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class Calculator {  
	
    public static void main(String[] args) { 
    	Scanner input = new Scanner(System.in);
    	//System.out.println("���������ʽ�����س���������");
    	calculator();
    	String src = input.nextLine();
    	System.out.println(cal(src));
    	System.out.println(" ");
    	
    
		}
    
    
    public static String cal(String src) {  
        StringBuilder builder = new StringBuilder();  
        if (src.contains("(")) {  
            Pattern pattern = Pattern.compile("\\(([^()]+)\\)");  
            Matcher matcher = pattern.matcher(src);  
            int lastEnd = 0;  
            while (matcher.find()) {  
                  
                builder.append(src.substring(lastEnd, matcher.start()));  
                //System.out.println(builder.toString());  
                builder.append(cal(matcher.group(1)));  
                lastEnd = matcher.end();  
            }  
            builder.append(src.substring(lastEnd));  
        } else {  			//�ȼ���˳���
            Pattern pattern = Pattern.compile("([\\d.]+)\\s*([*/])\\s*([\\d.]+)");  
            builder.append(src);  
            Matcher matcher = pattern.matcher(builder.toString());  
            while (matcher.find()){  
                float f1 = Float.parseFloat(matcher.group(1));  
                float f2 = Float.parseFloat(matcher.group(3));  
                float result = 0;  
                switch (matcher.group(2)){  
                    case "*":  
                        result = f1 * f2;  
                        break;  
                    case "/":  
                        result = f1 / f2;  
                        break;  
                }  
                builder.replace(matcher.start(), matcher.end(),  
                        String.valueOf(result));  
                matcher.reset(builder.toString());  
            }  							//�ڼ���Ӽ���
            pattern = Pattern.compile("([\\d.]+)\\s*([+-])\\s*([\\d.]+)");  
            matcher = pattern.matcher(builder.toString());  
            while (matcher.find()){  
                float f1 = Float.parseFloat(matcher.group(1));  
                float f2 = Float.parseFloat(matcher.group(3));  
                float result = 0;  
                switch (matcher.group(2)){  
                    case "+":  
                        result = f1 + f2;  
                        break;  
                    case "-":  
                        result = f1 - f2;  
                        break;  
                }  
                builder.replace(matcher.start(), matcher.end(),  
                        String.valueOf(result));  
                matcher.reset(builder.toString());  
            }  
            return builder.toString();  
        }  
        //System.out.println(builder);  
        return cal(builder.toString());  
    } 
    
                                  //�����쳣���ڴ���
    public static String calculator() {     
    	int flag = 0;
    	String src = " ";
    	Scanner input = new Scanner(System.in);
		System.out.print("���������ʽ�����س���������\n");
		System.out.print(" ");
		while(flag == 0) {
			src = input.nextLine();
			if(src.length() == 0) {        //�ж�����ļ���ʽ�Ƿ�Ϊ��
				flag = 1;
				System.out.println("ERROR");
		    	System.out.println("#���ʽΪ��");
		    	System.out.println("�������������ʽ�����س�������:");
		    	System.out.print("");
			}
			else {
		    	System.out.println(cal(src));
		    	System.out.print("���������ʽ�����س���������\n");
		    	System.out.print("");
		    }
		}
		return src;	     //���·��غϷ�����
    }
    
} 