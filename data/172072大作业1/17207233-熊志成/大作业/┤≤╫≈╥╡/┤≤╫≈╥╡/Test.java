package ����ҵ;
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
        String sufExpr = toSufExpr(s);// תΪ��׺���ʽ
      Stack<Double> num = new Stack<Double>();
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?|[+\\-*/]");
        Matcher m = p.matcher(sufExpr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/]")) {// ������������������������ȡ�������и����㣬������ٷ�������
                double a1 = num.pop();
                double a2 = num.pop();
                double res = doubleCal(a2, a1, temp.charAt(0));
                num.push(res);
            } else {// ��������ֱ�ӷ�������
                num.push(Double.valueOf(temp));
            }
        }
        return num.pop() + "";
    }

 public static String toSufExpr(String expr) {
        StringBuffer s = new StringBuffer();
        Stack<String> oper = new Stack<String>();
        oper.push(null);//��ջ��ѹ��һ��null������������ȼ���Ŀ���Ǽ������������ж�

        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");//�������Ϊƥ����ʽ�е����ֻ������
        Matcher m = p.matcher(expr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) { //�������
                if (temp.equals("(")) { //���������ţ�ֱ��ѹջ
                    oper.push(temp);
                } else if (temp.equals(")")) { //���������ţ���ջ���ֱ�����������ţ������Ų������
                    String top = null;
                    while (!(top = oper.pop()).equals("(")) {
                        s.append(top+" ");
                    }
                } else {//������������Ƚ�ջ�����ţ�������������ȼ�����ջ����ֱ��ѹջ����С��ջ������ջ���ֱ������ջ����Ȼ�󽫸������ѹջ��
                    try {
						while(getPriority(temp)<=getPriority(oper.peek()) ) {
						    s.append(oper.pop()+" ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
                    oper.push(temp);
                }
            }else {//��������ֱ�����
                s.append(temp+" ");
            }
        }
        String top = null;//��󽫷���ջ��ջ�����
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
				System.out.println("#���ʽΪ��");
				//System.exit(0);
				b = 1;
			}else {
				isnum = s2.matches("[0-9+\\-*/()\\s]+");
			}
			if(isnum == false) {
				System.out.println("ERROR");
				System.out.println("#���ʽ���зǷ��ַ�");
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
				System.out.println("#���ʽ���п�����");
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
				System.out.println("#�������Ч");
				b= 1;
			}
		}
		
	}
	if (a!=c) {
		System.out.println("ERROR");
		System.out.println("#���ʽ���Ų�ƥ��");
		b = 1;
	//	System.exit(0);
	}
	for(int i=0;i<s2.length();i++){
		String s1 = s2.substring(i, i+1);
		if((s1.equals("+"))==true||(s1.equals("-"))==true||(s1.equals("*"))==true||(s1.equals("/"))==true) {
			String s = s2.substring(i-1,i);
			if((s.equals("+"))==true||(s.equals("-"))==true||(s.equals("*"))==true||(s.equals("/"))==true) {
				System.out.println("ERROR");
				System.out.println("#���ʽ���������");
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
					System.out.println("#���ʽ���ź��������");
					b=1;
				}
			}
		}
	}
	Pattern six = Pattern.compile("\\)\\d");//С���ź�������������ŷ����һ���ַ�
	Matcher sixt = six.matcher(s2);
	if(sixt.find()==true) {
		System.out.println("ERROR");
		System.out.println("#�������Ч");
		b=1;
	}
	Pattern two = Pattern.compile("\\([\\+\\-\\*\\/]");//(�����ź����������,���������
	Matcher twot = two.matcher(s2);
	if(twot.find()==true) {
		System.out.println("ERROR");
		System.out.println("#���������");
		b=1;
	}
	Pattern three = Pattern.compile("[\\+\\-\\*\\/]\\)");//)������ǰ���������,���������
	Matcher threet = three.matcher(s2);
	if(threet.find()==true) {
		System.out.println("ERROR");
		System.out.println("#���������");
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
		File f = new File("����ҵ\\input");
		File H = new File("����ҵ\\output");
		read(f,H);
        
    }

}

