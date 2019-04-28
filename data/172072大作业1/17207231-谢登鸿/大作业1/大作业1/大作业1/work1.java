package ����ҵ1;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io. *;
import java.util.Scanner;
import java.lang.String;

class StackNumber{
	int [] elements=new int[99];
	int size=0;
	
	StackNumber(){
	this.size=0;
	}
	StackNumber(int size){
		this.size=size;
	}
	public boolean empty() {
		if (size ==0)
		return true;
		else
		return false;
		
	}
	public void push(int a) {
		size++;
		this.elements[size-1]=a;
	}
	public int pop() {		//����������ջ��Ԫ��
		size--;
		return this.elements[size];
	}
	public int gettop() {		//��ȡջ��Ԫ�أ�������
		return this.elements[size-1];
	}
	public int getsize() {
		return this.size;
	}
	public void setsize(int size) {
		this.size=size;
	}
}


class StackOption{
	char [] option = new char[99];
	int size=0;
	StackOption(){
		this.size=0;
	}
	StackOption(int size){
		this.size=size;
	}
	public boolean empty() {
		if (size ==0)
		return true;
		else
		return false;
	}
	public void push(char a) {
		size++;
		this.option[size-1]=a;
	}
	public char pop() {		//����������ջ��Ԫ��
		size--;
		return this.option[size];
	}
	public char gettop() {		//��ȡջ��Ԫ�أ�������
		return this.option[size-1];
	}
	public int getsize() {
		return this.size;
	}
	public void setsize(int size) {
		this.size=size;
	}	
}
public class work1 {

	public static void main(String[] args){
		StackNumber a = new StackNumber();
		StackOption b = new StackOption();
		
		Scanner input = new Scanner(System.in);
		String [] bd = new String[99];
		int r=0;
		File f2 = new File("C:\\Users\\XDH\\Desktop\\testfile.txt");	
		File f3 = new File("C:\\Users\\XDH\\Desktop\\result.txt");	
		try (Scanner input1 =new Scanner(f2);){
			while(input1.hasNextLine()) {
				bd[r]  = input1.nextLine();
			//	System.out.println(bd[r]);
				bd[r] = bd[r].concat("#");
				r++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int p=0;p<r;p++) {
			if(isturebds(bd[p])==true) {
		int u=0;
		 char c = (char) bd[p].charAt(u);
		  b.push('#');
	        while (c != '#' ||  b.gettop() != '#') {
	            if (isOPN(c)) { //�ж��Ƿ��ǲ�����
	                //�� ���������ջ ��������һ��
	            	char [] cn= new char[9];
	            	char cp =  bd[p].charAt(u+1);
	            	int v= 1;
	            	cn[0]=c;
	            	while(isOPN(cp)) {
	            		cn[v]=cp;
	            		v++;
	            		cp= bd[p].charAt(u+v);
	            	}
	            	 //��λ���ж�
	            	 if(v>1) {
		            		int the=cn[0]-48;//asc�� '0'תΪint��48  A��65 a��97
		            		for(int i=0;i<v-1;i++)
		            		{
		            	   		 the =(int) the*10+cn[i+1]-48; 
		            		}
		            //		 System.out.println("theΪ:"+the);
		            		 a.push(the);
		            		 u=u+v;
		            		 c =(char) bd[p].charAt(u);
	            	 }
	            	else {
	                a.push(c-48);
	               u++; c =(char) bd[p].charAt(u);
	            	}
	            } else {
	                switch (isPrior(c,b)) {
	                    case '>':  //���ȼ���ջ��Ԫ�ش� ������ջ,��������һ���ַ�
	                        b.push(c);
	                      u++;  c = (char) bd[p].charAt(u);
	                        break;
	                    case '='://���ȼ���ջ��Ԫ����ͬ
	                        b.pop(); //��ȥ����
	                        u++;  c = (char) bd[p].charAt(u);
	                        break;
	                    case '<': //���ȼ���ջ��Ԫ��С�����������ջ����������ջ������֮����ջ������˼�����ȼ��ߵ�������
	                        int y = a.pop();//˳�򿿺�Ĳ�����
	                        int x = a.pop();//˳��ǰ�Ĳ�����
	                        a.push(Option(x, y, b.pop()));
	                        break;
	                }
	            }
	        }
	       int  result = a.pop();
	      //  System.out.println("������Ϊ:"+result);
	       System.out.println(bd[p].substring(0,bd[p].length()-1)+"="+result);
	       
	       try (FileWriter out = new FileWriter(f3, true);){
				out.write(bd[p].substring(0,bd[p].length()-1)+"="+result+"\r\n");//ÿ���ַ�������ǰ�пո񣬷����������
				out.close();					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException ioe){

				System.out.println(ioe);

			}
	       
		}
	}
		

	}
	
   static boolean isturebds(String bd) {
		int left = 0;
		int right = 0;
		if(bd==null||bd.length()<=0) {
			 System.out.println("ERROR	#���ʽΪ�գ�");
				return false;
		}
		for(int i=0;i<bd.length()-1;i++) {
			int a=(int) bd.charAt(i);
			char b= bd.charAt(i);
			char c= bd.charAt(i+1);
		
		if(a<40||(a>43&&a<45)||(a>45&&a<47)||a>57){			
			 System.out.println("ERROR	#���ʽ�����Ƿ��ַ���");
			return false;
		}
		
		if( bd.charAt(i)=='('&&bd.charAt(i+1)==')') {
			 System.out.println("ERROR	#�п����ţ�");
				return false;
		}
		if( (b=='+'||b=='-'||b=='*'||b=='/')&&(c=='+'||c=='-'||c=='*'||c=='/')) {
			 System.out.println("ERROR	#�����������");
				return false;
		}

		if(a=='(')
			left++;
		if(a==')')
			right++;
		if(right>left) {
			System.out.println("ERROR	#���Ų�ƥ�䣡");
			return false;
		}
		if(i==bd.length()-2) {
			if(left!=right) {
				System.out.println("ERROR	#���Ų�ƥ�䣡");
				return false;
			}
		}
		if(i==0) {
			if(b=='+'||b=='-'||b=='*'||b=='/') {
				System.out.println("ERROR	#�����ǰ����������");
				return false;
			}
		}
		if(i==bd.length()-2) {
			if(b=='+'||b=='-'||b=='*'||b=='/') {
					System.out.println("ERROR	#�����������������");
					return false;
				}
		}
				
		
		

	}
		return true;
}
    static char isPrior(Character c,StackOption b) {
        char c2 = b.gettop();
        if (c == '+' || c == '-') { //cΪ�����Ĳ�������c2Ϊ֮ǰ����Ĳ�����
            //���ͬΪ+ - ��c2�����ȼ�����c  ͬ�� * /�͸�����˵��
            if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/') {  //���Ժ�ջ��Ԫ����� ���ȼ�ҪС
                return '<';
            }
            if (c2 == '(') {
                return '>';
            }
            if (c2 == ')') {
                return '<';
            }
            if (c2 == '#') {
                return '>'; //#�Ƕ���ΪԤ������ı�־�� �����еĲ��������ȼ���С
            }
        }
        if (c == '*' || c == '/') {
            if (c2 == '+' || c2 == '-') {
                return '>';
            }

            if (c2 == '*' || c2 == '/') {
                return '<';
            }
            if (c2 == '(') {
                return '>';
            }
            if (c2 == ')') {
                return '<';
            }
            if (c2 == '#') {
                return '>';
            }
        }


        if (c == '(') {
            return '>';
        }
        if (c == ')') {
            if (c2 != '(') {
                return '<';
            } else {
                return '=';
            }
        }

        if (c == '#') {
            if (c2 != '#') {
                return '<';
            } else {
                return '=';
            }
        }
        return 0;
    }
	
    static int Option(int a, int b, Character c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    static boolean isOPN(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/'||c=='('||c==')'||c=='#') {
            return false;
        } else {
            return true;
        }
    }

}
