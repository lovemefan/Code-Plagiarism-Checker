import java.util.Scanner;
import java.lang.String;
import java.io. *;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Calculator {

	public static void main(String[] args){
		File fo = new File("src\\test");	
		File f1 = new File("src\\test01");
		Stackzf zf = new Stackzf();//创一个存字符的栈
		Stacknum num = new Stacknum();//创一个存数的栈
		Scanner input = new Scanner(System.in);
		String [] str = new String[20];
		int m=0;
		try (Scanner shuru =new Scanner(fo);){
			while(shuru.hasNextLine()) {
				str[m]  = shuru.nextLine();
				str[m] = str[m].concat("#");
				m++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int n=0;n<m;n++) {
			if(TandF(str[n])==true) {
				int s=0;
				char c = (char) str[n].charAt(s);
				zf.push('#');
	        while (c != '#' ||  zf.peek() != '#') {
	            if (isnum(c)) { //判断是不是为操作数 是的话则入操作数栈 ，继续读入下一个东西
	            	int k= 1;
	            	char [] ch= new char[9];
	            	char ch1=str[n].charAt(s+1);
	            	ch[0]=c;
	            	while(isnum(ch1)) { //多位数判断
	            		ch[k]=ch1;
	            		k++;
	            		ch1= str[n].charAt(s+k);
	            	}
	            	 if(k>1) {
		            		int r=ch[0]-48;
		            		for(int i=0;i<k-1;i++)
		            		{
		            	   		 r =(int) r*10+ch[i+1]-48; 
		            		}
		            		 num.push(r);
		            		 s=s+k;
		            		 c =(char) str[n].charAt(s);
	            	 }
	            	else {
	            		num.push(c-48);
	            		s++; 
	            		c =(char) str[n].charAt(s);
	            	}
	            } 
	            else {
	                switch (bjyxj(c,zf)) {//比较优先级
	                	case '<': //优先级低，则操作数出栈，操作符出栈，运算之后入栈
	                		int x = num.pop();//即意思是优先级高的先运算
	                		int y = num.pop();
	                		num.push(Jisuan(x, y, zf.pop()));
	                		break;
	                    case '>':  //优先级高，则入栈,并接收下一个字符
	                        zf.push(c);
	                      s++; 
	                      	c = (char) str[n].charAt(s);
	                        break;
	                    case '='://优先级相同
	                        zf.pop(); 
	                        s++;
	                        c = (char) str[n].charAt(s);
	                        break;
	                }
	            }
	        }
	       int  result = num.pop();//在文件test01输出结果
	       System.out.println(str[n].substring(0,str[n].length()-1)+"="+result);
	       try (FileWriter out = new FileWriter(f1, true);){
				out.write(str[n].substring(0,str[n].length()-1)+"="+result+"\r\n");
				out.close();					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException i) {
				System.out.println(i);
			}
		}
	}
}
   static boolean TandF(String str) {//正确还是错误
		int l = 0;
		int r = 0;
		if(str==null||str.length()<=0) {
			 System.out.println("ERROR	#表达式为空");
				return false;
		}
		for(int i=0;i<str.length()-1;i++) {
			int q=(int) str.charAt(i);
			char w= str.charAt(i);
			char c= str.charAt(i+1);
		
		if(q<40||(q>43&&q<45)||(q>45&&q<47)||q>57){			
			 System.out.println("ERROR	#表达式包含非法字符");
			return false;
		}
		
		if( str.charAt(i)=='('&&str.charAt(i+1)==')') {
			 System.out.println("ERROR	#有空括号");
				return false;
		}
		if( (w=='+'||w=='-'||w=='*'||w=='/')&&(c=='+'||c=='-'||c=='*'||c=='/')) {
			 System.out.println("ERROR	#连续运算符");
				return false;
		}
		if(q=='(')
			l++;
		if(q==')')
			r++;
		if(i==0) {//运算符前无运算数
			if(w=='+'||w=='-'||w=='*'||w=='/') {
				System.out.println("ERROR	#运算符前无运算数");
				return false;
			}
		}
		if(i==str.length()-2) {
			if(w=='+'||w=='-'||w=='*'||w=='/') {
					System.out.println("ERROR	#运算符后无运算数");
					return false;
				}
		}
		if(r>l) {//括号不匹配
			System.out.println("ERROR	#括号不匹配");
			return false;
		}
		if(i==str.length()-2) {
			if(l!=r) {
				System.out.println("ERROR	#括号不匹配");
				return false;
			}
		}
	}
		return true;
}
    static char bjyxj(Character m,Stackzf n) {//#是定义为预算结束的标志符  比较优先级
        char x = n.peek();
        if (m == '+' || m == '-') { 
            if (x == '(') {
                return '>';
            }
            if (x == ')') {
                return '<';
            }
            if (x == '#') {
                return '>'; 
            }
            if ( x == '-' ||x == '+' || x == '/'|| x == '*' ) { 
                return '<';
            }
        }
        if (m == '(') {
            return '>';
        }
        if (m == ')') {
            if (x != '(') {
                return '<';
            } else {
                return '=';
            }
        }
        if (m == '*' || m == '/') {
            if (x == '+' || x == '-') {
                return '>';
            }

            if (x == '*' || x == '/') {
                return '<';
            }
            if (x == '(') {
                return '>';
            }
            if (x == ')') {
                return '<';
            }
            if (x == '#') {
                return '>';
            }
        }
        if (m == '#') {
            if (x != '#') {
                return '<';
            } else {
                return '=';
            }
        }
        return 0;
    }
	
    static int Jisuan(int a, int b, Character c) {//计算
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

    static boolean isnum(char c) {
        if ( c == '*' || c == '/'||c=='('||c==')'||c == '+' || c == '-' ||c=='#') {
            return false;
        } else {
            return true;
        }
    }

}
class Stackzf{//存字符的栈
	char [] zf = new char[20];
	int size=0;
	Stackzf(){
		this.size=0;
	}
	Stackzf(int size){
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
		this.zf[size-1]=a;
	}
	public char peek() {	
		return this.zf[size-1];
	}
	public char pop() {	
		size--;
		return this.zf[size];
	}
}
class Stacknum{//存数的栈
	int [] num=new int[20];
	int size=0;
	Stacknum(){
	this.size=0;
	}
	Stacknum(int size){
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
		this.num[size-1]=a;
	}
	public int peek() {		
		return this.num[size-1];
	}
	public int pop() {		
		size--;
		return this.num[size];
	}
}

