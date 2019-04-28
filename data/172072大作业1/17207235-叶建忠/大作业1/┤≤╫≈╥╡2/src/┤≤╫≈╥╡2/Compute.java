package 大作业2;

import java.io.*;
import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compute {

    public static void main(String[] args) throws IOException {
        //打开文件进行读取
        File fp = new File("src\\compute");
        File fp1 = new File("src\\result");

        //文件的读写
        FileReader fileReader = new FileReader(fp);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileOutputStream fileOutputStream = new FileOutputStream(fp1);
        //格式化输入
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);

        //把文件里的数据一行一行的读取到result里面
        int i = 0,k;
        String[] result = new String[100];
        String[] Stemp = new String[100];
        RePolish compute = new RePolish();

        while ((Stemp[i] = bufferedReader.readLine()) != null) {
            //从文件中读取表达式并进行计算
            result[i]= "";
            if (isRealExpression(Stemp[i])) {
                result[i] += (Stemp[i].replaceAll("\\s+", "") + "=" + compute.computeResult(compute.transformToRePolish(Stemp[i])));
            }
            else {
                result[i] += (Stemp[i] + " ERROR");
            }
            //判断是否有重复的
            k = i-1;
            while (k > 0) {
                if (result[i].equals(result[k]))
                    break;
                k--;
            }
            //把结果输入到文件中
            if(k == 0)
                printWriter.println(result[i]);
            i++;
        }
        fileReader.close();
        bufferedReader.close();
        fileOutputStream.close();
    }  	
    
    //判断表达式是否合法
    public static boolean isRealExpression(String expression) {
    //判断表达式的语法是否发生错误
    	Pattern regularString = Pattern.compile("\\s");//匹配空表达式
		Matcher m = regularString.matcher(expression);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#表达式为空");
			return false;
		}
		Pattern regularString1 = Pattern.compile("\\(\\)");//匹配空括号
		Matcher m1 = regularString1.matcher(expression);
		if(m1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式中有空括号");
			return false;
		}
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//匹配非法字符
		Matcher m2 = regularString2.matcher(expression);
		if(m2.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式包含非法字符");
			return false;
		}
		Stack var=new Stack();//括号不匹配情况
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
					System.out.println("#括号不匹配");
					return false;
				}
			}
			
		}
		 if(var.isEmpty() == false) {
			System.out.println("ERROR");
			System.out.println("#括号不匹配");
			return false;
		}
		
		Pattern regularString4 = Pattern.compile("[\\+\\-\\*\\/]{2,}");//运算符连续
		Matcher m4 = regularString4.matcher(expression);
		if(m4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符连续");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//运算符前无运算数
		Matcher m5 = regularString5.matcher(expression);
		if(m5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符前无运算数");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//运算符后无运算数
		Matcher m6 = regularString6.matcher(expression);
		if(m6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符后无运算数");
			return false;
		}
		
		else
			return true;
    	
    	}
    }
