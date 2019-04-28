package ����ҵ1;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.*;
public class ExpressionEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infile F1 =new infile();//�ѱ��ʽ���뵽�ļ�test1
		resultfile F2 = new resultfile();//�ѽ�����뵽�ļ�test2
		F1.creatfile();
		F2.writerfile();
	}

}
class Calculater{
	  Stack<Integer> OPTR = new Stack<>();
	  Stack<Character> OPND = new Stack<>();
	  String str;

	  public int calculate(String str) {
	        String[] str1 = strToExpressionArr(str);
	        return calculate(str1);
	    }
//�ѱ��ʽת��Ϊ����
private static String[] strToExpressionArr(String str) {
	  ArrayList<String> list = new ArrayList<>();
	  for(int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                 str = str.substring(0, i) +
                  " " + str.charAt(i) + " " +
                 str.substring(i + 1, str.length());
                 i += 2;
        }
	}
     Scanner scan = new Scanner(str);
     while (scan.hasNext()) {
        list.add(scan.next());
    }
     scan.close();
     return list.toArray(new String[list.size()]);
}

//�����������ʽ
private  int calculate(String[] expression) {
    for (int i = 0; i < expression.length; i++) {
    	 String ele = expression[i];//��������֣����������ջ
         if (isOPTR(ele)) {
             OPTR.push(new Integer(ele));
        }
        //�����Ƿ���
        //�����Ӽ��ţ���ջ���ķ��Ŷ������ֱ꣬�������������ź�ջ�������������ȡ���ķ���ѹ��ջ
         else if (ele.charAt(0) == '+' || ele.charAt(0) == '-') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //�����˳��ţ���ǰ��ĳ˳��Ŵ����꣬������ȡ���ķ���ѹ��ջ
        else if (ele.charAt(0) == '*' || ele.charAt(0) == '/') {
            while (!OPND.isEmpty() && OPND.peek() != '(' &&
                    OPND.peek() != '+' && OPND.peek() != '-') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();

            OPND.push(ele.charAt(0));
        }
        //���������ţ�ֻ��ջ
        else if (ele.charAt(0) == '(') {
            OPND.push(ele.charAt(0));
        }
        //���������ţ�ֻ����ջ��ȫ������
        else if (ele.charAt(0) == ')') {
            while (!OPND.isEmpty() && OPND.peek() != '(') {
                int b = OPTR.pop();
                int a = OPTR.pop();
                OPTR.push(getAnswer(a, OPND.pop(), b));
            }

            if (!OPND.isEmpty() && OPND.peek() == '(')
                OPND.pop();
        }
    }
    //���û���������Ž�β�ı��ʽ���������ʣ�µķ��Ŵ�����
    if (!OPND.isEmpty()) {
        int b = OPTR.pop();
        int a = OPTR.pop();
        OPTR.push(getAnswer(a, OPND.pop(), b));
    }
    return OPTR.peek();
}
//�ж��Ƿ�����
private static boolean isOPTR(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) < '0' || s.charAt(i) > '9')
            return false;
    }
    return true;
}
//��������
private static int getAnswer(int a, char operator, int b) {
    switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
    }
    return 0;
}
}
class infile {
	void creatfile() {
		String s;
		Scanner input=new Scanner(System.in);
		System.out.println("��������ʽ����#����");
		File file = new File("src\\test1");
		if(file.exists()) {
				file.deleteOnExit();
			}else {
				try {
						file.createNewFile();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		s=input.next();  
		try{
		
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			while(!s.equals("#")){
        	
				bw.write(s+"\r\n");
				bw.flush();
				s=input.next();
				
			}
			System.out.println("�������");
			System.out.println("ע���������src�µ�test2�鿴�����ʽ����src�µ�test1�鿴");
			input.close();
			bw.close();
			fw.close();
			}catch(Exception e){
				e.printStackTrace(); 
			}
}
}
	
class resultfile {
	void writerfile() {
		Calculater a = new Calculater();
		File file = new File("src\\test1");
		File file1 = new File("src\\test2");
	    try{
	    	FileReader fr = new FileReader(file);
	        BufferedReader bf=new BufferedReader(fr);
	        String s1 = null;
	        int result = 0;
	        FileWriter out = new FileWriter(file1);
	        while((s1 = bf.readLine())!=null){	        			        	
	            String s2 = s1.replaceAll(" ","");//ȥ�����ʽ�еĿո��м估��β��	        	
	        	judge p = new judge(s2);
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
//�жϲ����������ʽ��ʽ������������򷵻�true����֮����false
class judge {

	private String str; // ��Ҫ��֤�ı��ʽ
	private boolean b; // ���ʽ�Ƿ����
	
	public judge(String str) {
		this.str = str;
		this.b = true;
	}
	public String getExpression() {
		return str;
	}
	public boolean getb() {
		return b;
	}
	// ƥ���Ƿ��������ַ�
	public boolean error1() {
		String string = "[^0-9\\+\\-\\*\\/\\(\\)]";	
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ���Ƿ��п�����
	public boolean error2() {
		String string = ".*\\(\\).*";		
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {		
			b = false;
		}
		return b;
	}

	// ƥ���Ƿ�����������һ��������
	public boolean error3() {
		String string = ".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�Ƿ����������ͷ
	public boolean error4() {
		String string = "^[\\+\\-\\*\\/\\)]";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�������ź��������
	public boolean error5() {
		String string = ".*\\([\\+\\*\\/].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ��������ǰ�������
	public boolean error6() {
		String string = ".*[\\+\\-\\*\\/]\\).*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ��������ǰ���������
	public boolean error7() {
		String string = ".*[^\\+\\-\\*\\/\\(]\\(.*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�������ź��������
	public boolean error8() {
		String string = ".*\\)[^\\+\\-\\*\\/\\)].*";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ����ʽ�����������
	public boolean error9() {
		String string = "[\\+\\-\\*\\/]$";
		Pattern pattern = Pattern.compile(string);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			b = false;
		}
		return b;
	}

	// ƥ�����Ÿ�����������򷵻�false����֮����true
	public boolean error10() {
		int num1 = 0; // ��¼(�ĸ���
		int num2 = 0; // ��¼)�ĸ���
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				num1++;
			}
			if (c == ')') {
				num2++;
			}
		}
		if (num1 != num2) {
			b = false;
		}
		return b;
	}		
	
}





