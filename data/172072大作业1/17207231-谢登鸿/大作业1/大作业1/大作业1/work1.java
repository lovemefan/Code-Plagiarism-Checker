package 大作业1;
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
	public int pop() {		//弹出并返回栈顶元素
		size--;
		return this.elements[size];
	}
	public int gettop() {		//获取栈顶元素，不弹出
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
	public char pop() {		//弹出并返回栈顶元素
		size--;
		return this.option[size];
	}
	public char gettop() {		//获取栈顶元素，不弹出
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
	            if (isOPN(c)) { //判断是否是操作数
	                //是 则入操作数栈 ，读入下一个
	            	char [] cn= new char[9];
	            	char cp =  bd[p].charAt(u+1);
	            	int v= 1;
	            	cn[0]=c;
	            	while(isOPN(cp)) {
	            		cn[v]=cp;
	            		v++;
	            		cp= bd[p].charAt(u+v);
	            	}
	            	 //多位数判断
	            	 if(v>1) {
		            		int the=cn[0]-48;//asc码 '0'转为int是48  A是65 a是97
		            		for(int i=0;i<v-1;i++)
		            		{
		            	   		 the =(int) the*10+cn[i+1]-48; 
		            		}
		            //		 System.out.println("the为:"+the);
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
	                    case '>':  //优先级比栈顶元素大 ，则入栈,并接收下一个字符
	                        b.push(c);
	                      u++;  c = (char) bd[p].charAt(u);
	                        break;
	                    case '='://优先级和栈顶元素相同
	                        b.pop(); //脱去括号
	                        u++;  c = (char) bd[p].charAt(u);
	                        break;
	                    case '<': //优先级比栈顶元素小，则操作数出栈，操作符出栈，运算之后入栈。即意思是优先级高的先运算
	                        int y = a.pop();//顺序靠后的操作数
	                        int x = a.pop();//顺序靠前的操作数
	                        a.push(Option(x, y, b.pop()));
	                        break;
	                }
	            }
	        }
	       int  result = a.pop();
	      //  System.out.println("计算结果为:"+result);
	       System.out.println(bd[p].substring(0,bd[p].length()-1)+"="+result);
	       
	       try (FileWriter out = new FileWriter(f3, true);){
				out.write(bd[p].substring(0,bd[p].length()-1)+"="+result+"\r\n");//每个字符和数据前有空格，方便后续读入
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
			 System.out.println("ERROR	#表达式为空！");
				return false;
		}
		for(int i=0;i<bd.length()-1;i++) {
			int a=(int) bd.charAt(i);
			char b= bd.charAt(i);
			char c= bd.charAt(i+1);
		
		if(a<40||(a>43&&a<45)||(a>45&&a<47)||a>57){			
			 System.out.println("ERROR	#表达式包含非法字符！");
			return false;
		}
		
		if( bd.charAt(i)=='('&&bd.charAt(i+1)==')') {
			 System.out.println("ERROR	#有空括号！");
				return false;
		}
		if( (b=='+'||b=='-'||b=='*'||b=='/')&&(c=='+'||c=='-'||c=='*'||c=='/')) {
			 System.out.println("ERROR	#连续运算符！");
				return false;
		}

		if(a=='(')
			left++;
		if(a==')')
			right++;
		if(right>left) {
			System.out.println("ERROR	#括号不匹配！");
			return false;
		}
		if(i==bd.length()-2) {
			if(left!=right) {
				System.out.println("ERROR	#括号不匹配！");
				return false;
			}
		}
		if(i==0) {
			if(b=='+'||b=='-'||b=='*'||b=='/') {
				System.out.println("ERROR	#运算符前无运算数！");
				return false;
			}
		}
		if(i==bd.length()-2) {
			if(b=='+'||b=='-'||b=='*'||b=='/') {
					System.out.println("ERROR	#运算符后无运算数！");
					return false;
				}
		}
				
		
		

	}
		return true;
}
    static char isPrior(Character c,StackOption b) {
        char c2 = b.gettop();
        if (c == '+' || c == '-') { //c为后进入的操作符，c2为之前进入的操作符
            //如果同为+ - 则c2的优先级大于c  同理 * /就更不用说了
            if (c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/') {  //所以和栈顶元素相比 优先级要小
                return '<';
            }
            if (c2 == '(') {
                return '>';
            }
            if (c2 == ')') {
                return '<';
            }
            if (c2 == '#') {
                return '>'; //#是定义为预算结束的标志符 比所有的操作符优先级都小
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
