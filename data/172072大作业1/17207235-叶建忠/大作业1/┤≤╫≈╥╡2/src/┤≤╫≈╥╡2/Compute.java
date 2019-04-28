package ����ҵ2;

import java.io.*;
import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compute {

    public static void main(String[] args) throws IOException {
        //���ļ����ж�ȡ
        File fp = new File("src\\compute");
        File fp1 = new File("src\\result");

        //�ļ��Ķ�д
        FileReader fileReader = new FileReader(fp);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileOutputStream fileOutputStream = new FileOutputStream(fp1);
        //��ʽ������
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);

        //���ļ��������һ��һ�еĶ�ȡ��result����
        int i = 0,k;
        String[] result = new String[100];
        String[] Stemp = new String[100];
        RePolish compute = new RePolish();

        while ((Stemp[i] = bufferedReader.readLine()) != null) {
            //���ļ��ж�ȡ���ʽ�����м���
            result[i]= "";
            if (isRealExpression(Stemp[i])) {
                result[i] += (Stemp[i].replaceAll("\\s+", "") + "=" + compute.computeResult(compute.transformToRePolish(Stemp[i])));
            }
            else {
                result[i] += (Stemp[i] + " ERROR");
            }
            //�ж��Ƿ����ظ���
            k = i-1;
            while (k > 0) {
                if (result[i].equals(result[k]))
                    break;
                k--;
            }
            //�ѽ�����뵽�ļ���
            if(k == 0)
                printWriter.println(result[i]);
            i++;
        }
        fileReader.close();
        bufferedReader.close();
        fileOutputStream.close();
    }  	
    
    //�жϱ��ʽ�Ƿ�Ϸ�
    public static boolean isRealExpression(String expression) {
    //�жϱ��ʽ���﷨�Ƿ�������
    	Pattern regularString = Pattern.compile("\\s");//ƥ��ձ��ʽ
		Matcher m = regularString.matcher(expression);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#���ʽΪ��");
			return false;
		}
		Pattern regularString1 = Pattern.compile("\\(\\)");//ƥ�������
		Matcher m1 = regularString1.matcher(expression);
		if(m1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ʽ���п�����");
			return false;
		}
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//ƥ��Ƿ��ַ�
		Matcher m2 = regularString2.matcher(expression);
		if(m2.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���ʽ�����Ƿ��ַ�");
			return false;
		}
		Stack var=new Stack();//���Ų�ƥ�����
		char item;
		for(int i = 0;i < expression.length();i++) {
			item = expression.charAt(i);
			if(item == '(') {
				var.push(item);
			}
			else if(item == ')') {
				if(var.isEmpty() == false) {
					var.pop();
				}
				else {
					System.out.println("ERROR");
					System.out.println("#���Ų�ƥ��");
					return false;
				}
			}
			
		}
		 if(var.isEmpty() == false) {
			System.out.println("ERROR");
			System.out.println("#���Ų�ƥ��");
			return false;
		}
		
		Pattern regularString4 = Pattern.compile("[\\+\\-\\*\\/]{2,}");//���������
		Matcher m4 = regularString4.matcher(expression);
		if(m4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//�����ǰ��������
		Matcher m5 = regularString5.matcher(expression);
		if(m5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#�����ǰ��������");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//���������������
		Matcher m6 = regularString6.matcher(expression);
		if(m6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#���������������");
			return false;
		}
		
		else
			return true;
    	
    	}
    }
