package 大作业;
import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Test {
	public static String getResult(String s)  {
        String sufExpr = toSufExpr(s);// 转为后缀表达式
      Stack<Double> num = new Stack<Double>();
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?|[+\\-*/]");
        Matcher m = p.matcher(sufExpr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/]")) {// 遇到运算符，将最后两个数字取出，进行该运算，将结果再放入容器
                double a1 = num.pop();
                double a2 = num.pop();
                double res = doubleCal(a2, a1, temp.charAt(0));
                num.push(res);
            } else {// 遇到数字直接放入容器
                num.push(Double.valueOf(temp));
            }
        }
        return num.pop() + "";
    }

 public static String toSufExpr(String expr) {
        StringBuffer s = new StringBuffer();
        Stack<String> oper = new Stack<String>();
        oper.push(null);//在栈顶压人一个null，配合它的优先级，目的是减少下面程序的判断

        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");//这个正则为匹配表达式中的数字或运算符
        Matcher m = p.matcher(expr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) { //是运算符
                if (temp.equals("(")) { //遇到左括号，直接压栈
                    oper.push(temp);
                } else if (temp.equals(")")) { //遇到右括号，弹栈输出直到弹出左括号（左括号不输出）
                    String top = null;
                    while (!(top = oper.pop()).equals("(")) {
                        s.append(top+" ");
                    }
                } else {//遇到运算符，比较栈顶符号，若该运算符优先级大于栈顶，直接压栈；若小于栈顶，弹栈输出直到大于栈顶，然后将改运算符压栈。
                    try {
						while(getPriority(temp)<=getPriority(oper.peek()) ) {
						    s.append(oper.pop()+" ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
                    oper.push(temp);
                }
            }else {//遇到数字直接输出
                s.append(temp+" ");
            }
        }
        String top = null;//最后将符合栈弹栈并输出
        while(null != (top = oper.pop())) {
            s.append(top+" ");
        }
        return s.toString();
    }
 static double doubleCal(double a1, double a2, char operator)  {
	double sum = 0 ;
    switch (operator) {
    case '+':
        sum = a1 + a2;
        break;
    case '-':
    	sum = a1 - a2;
    	break;
    case '*':
    	sum = a1 * a2;
    	break;
    case '/':
    	sum = a1 / a2;
    	break;
    default:
        break;
    }
   return sum;
}
 static int getPriority(String s) {
        if(s==null) return 0;
        switch(s) {
    	case "(":  return 1;
    	case "+": return 2;
    	case "-": return 2;
    	case "*": return 3;
    	case "/": return 3;
    	default:break;
        }
       return 0;
    }
public static void read(File f,File H) throws Exception{
	String s3 = null;
	String s2 =  null;
	
	int d = 0;
	boolean isnum=true;
	try (Scanner input = new Scanner(f);){
		while(input.hasNext()) {
			int b = 0;
			s3 = input.nextLine();
			s2 = s3.replace(" ", "");
			if(s2.equals("")==true) {
				System.out.println("ERROR");
				System.out.println("#表达式为空");
				//System.exit(0);
				b = 1;
			}else {
				isnum = s2.matches("[0-9+\\-*/()\\s]+");
			}
			if(isnum == false) {
				System.out.println("ERROR");
				System.out.println("#表达式含有非法字符");
				b = 1;
				//System.exit(0);
			}
			pand(H,s2,b);			
		}
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
}
public static void writeFile1(File F,String s,String s1) {
	try (FileWriter out = new FileWriter(F, true);){
		out.write(s+"="+s1+"\n");
		out.close();					
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException ioe){

		System.out.println(ioe);

	}
}
public static void pand(File H,String s6,int d) {
	int b = d;
	int a = 0;
	int c = 0 ;
	String s4 = null;
	String s2 = s6;
	for(int i=0;i<s2.length();i++){
		String s1 = s2.substring(i, i+1);
		if((s1.equals(")"))==true) {
			String s = s2.substring(i-1,i);
			if((s.equals("("))==true) {
				System.out.println("ERROR");
				System.out.println("#表达式含有空括号");
				b= 1;
			//	System.exit(0);
			}
		}
		if((s1.equals(")"))==true) {
			a++;
		}
		if((s1.equals("("))==true) {
			c++;
		}
		if((s1.equals("("))==true) {
			if(i==s2.length()-1){
				System.out.println("ERROR");
				System.out.println("#运算符无效");
				b= 1;
			}
		}
		
	}
	if (a!=c) {
		System.out.println("ERROR");
		System.out.println("#表达式括号不匹配");
		b = 1;
	//	System.exit(0);
	}
	for(int i=0;i<s2.length();i++){
		String s1 = s2.substring(i, i+1);
		if((s1.equals("+"))==true||(s1.equals("-"))==true||(s1.equals("*"))==true||(s1.equals("/"))==true) {
			String s = s2.substring(i-1,i);
			if((s.equals("+"))==true||(s.equals("-"))==true||(s.equals("*"))==true||(s.equals("/"))==true) {
				System.out.println("ERROR");
				System.out.println("#表达式运算符连续");
				b = 1;
			//	System.exit(0);
			}
		}
		if(i!=s2.length()-1||i!=0) {
			if((s1.equals(")"))==true) {
				String s = s2.substring(i,i+1);
				boolean sum = s.matches("^[0-9]+");
				if(sum==true) {
					System.out.println("ERROR");
					System.out.println("#表达式括号后无运算符");
					b=1;
				}
			}
		}
	}
	Pattern six = Pattern.compile("\\)\\d");//小括号后无运算符，括号非最后一个字符
	Matcher sixt = six.matcher(s2);
	if(sixt.find()==true) {
		System.out.println("ERROR");
		System.out.println("#运算符无效");
		b=1;
	}
	Pattern two = Pattern.compile("\\([\\+\\-\\*\\/]");//(左括号后面是运算符,运算符连续
	Matcher twot = two.matcher(s2);
	if(twot.find()==true) {
		System.out.println("ERROR");
		System.out.println("#运算符连续");
		b=1;
	}
	Pattern three = Pattern.compile("[\\+\\-\\*\\/]\\)");//)右括号前面是运算符,运算符连续
	Matcher threet = three.matcher(s2);
	if(threet.find()==true) {
		System.out.println("ERROR");
		System.out.println("#运算符连续");
		b=1;
	}
	if(b==0) {
		System.out.print(s2+"=");
		System.out.println(getResult(s2));
		 s4 = getResult(s2);
		 writeFile1(H,s2,s4);
	}
}
public static void main(String[] args) throws Exception {
      //  String str = "3+4-5*(2/3)";
		File f = new File("大作业\\input");
		File H = new File("大作业\\output");
		read(f,H);
        
    }

}

