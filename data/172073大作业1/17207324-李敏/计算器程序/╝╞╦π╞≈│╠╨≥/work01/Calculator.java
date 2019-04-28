package work01;
import java.util.Stack;

/**元素类
 * 
 *
 */
class Elem
{
	String e;     //单个元素(可以是符号,也可以是数字)
	boolean isOP; //是否是操作符
	int count;   //元素数量,在数组的零单元才使用,用作数组元素计数
	public Elem()
	{
		e="";
		isOP=false;
		count=0;
	}
}

/**计算类,将正确的算式计算出结果
 * 
 *
 */
public class Calculator 
{	
	//符号优先级表
	private int[][] compare=
		{
		          // +  -   *   /   (  )  #	
		/*  +   */ { 1, 1, -1, -1, -1, 1, 1},
		/*  -   */ { 1, 1, -1, -1, -1, 1, 1},
		/*  *   */ { 1, 1,  1,  1, -1, 1, 1},
		/*  /   */ { 1, 1,  1,  1, -1, 1, 1},
		/*  (   */ {-1,-1, -1, -1, -1, 0,-2},
		/*  )   */ { 1, 1,  1,  1, -2, 1, 1},
		/*  #   */ {-1,-1, -1, -1, -1,-2, 0}	
		};				
	
	
	/**计算方法,传入计算式,返回结果
	 * 
	 * @param 正确的算式字符串
	 * @return 计算结果
	 */
	public Double compute(String expression)
	{
		Elem[] exp0=charToElem(expression);           //字符封装成元素
		Elem[] exp=InversePolandExpression(exp0);    //中缀式转后缀式
		double result=CalculatePolandExpression(exp); //利用后缀式求值
		return result;
	}	
	
	
	/**判断是不是运算符
	 *  
	 * @param 字符
	 * @return 是运算符返回true,否则返回false
	 */
	private boolean IsOP(char ch)	
	{
		switch(ch)
		{
		case '+':   return true;
		case '-':   return true;
		case '*':   return true;
		case '/':   return true;
		case '(':   return true;
		case ')':   return true;
		case '#':   return true;
		default :   return false;
		}			
	}		
	
	
	/**比较运算符优先级
	 * 
	 * @param 运算符1
	 * @param 运算符2
	 * @return 运算符1大于运算符2返回1,等于返回0,小于返回-1
	 */
	private int Precede(char c1,char c2)
	{
		//根据符号分配一下数组下标 
		int pos1=0,pos2=0;
		switch(c1)
		{
			case '+': pos1=0;  break;
			case '-': pos1=1;  break;
			case '*': pos1=2;  break;
		    case '/': pos1=3;  break;
			case '(': pos1=4;  break;
			case ')': pos1=5;  break;
			case '#': pos1=6;  break;		
		}
			switch(c2)
		{
			case '+': pos2=0;  break;
			case '-': pos2=1;  break;
			case '*': pos2=2;  break;
		    case '/': pos2=3;  break;
			case '(': pos2=4;  break;
			case ')': pos2=5;  break;
			case '#': pos2=6;  break;		
		}
		return compare[pos1][pos2];
	}
	
	
	/**将char封装为Elem类型,避免不能计算超过10以上数字的问题
	 * 
	 * @param 正确的算式字符串
	 * @return Elems数组,内含元素对象
	 */
	private Elem[] charToElem(String exp_a)
	{
		exp_a="#"+exp_a+"#";
		Elem[] exp=new Elem[1000];							//一个算式最多可存1000个元素
		int pos=0;
		exp[pos]=new Elem();                                //存入首'#'
		exp[pos].e+=exp_a.charAt(0);
		exp[pos++].isOP=true;
		for(int i=1;i<exp_a.length()-1;i++)
		{		
			exp[pos]=new Elem();
			if(IsOP(exp_a.charAt(i)))    //如果是运算符
			{
				//遍历到是-,且后面是(或者数字,前面是操作符说明是负号
				if(exp_a.charAt(i)=='-'&&IsOP(exp_a.charAt(i-1))&&exp_a.charAt(i-1)!=')'&&(exp_a.charAt(i+1)=='('||!IsOP(exp_a.charAt(i+1))))  
				{
					exp[pos].e+="-1";      //-(x-y)转化为(-1)*(x-y);     y*-x转化为y*(-1)*x;
					exp[pos++].isOP=false;
					exp[pos]=new Elem();
					exp[pos].e+="*";
					exp[pos++].isOP=true;
				}
				else
				{
					exp[pos].e+=exp_a.charAt(i);
					exp[pos++].isOP=true;
				}
				
			}
			else						                //否则是正负号或者数字
			{
				int j=0;			
				for(j=0;!IsOP(exp_a.charAt(i+j));j++)   //把多个单数字(0~9)封装
				{
					exp[pos].e+=exp_a.charAt(i+j);	
				}
				exp[pos++].isOP=false;
				i+=j-1;               //字符串遍历位置往后移
			}
		}
		exp[pos]=new Elem();                                //存入尾'#'
		exp[pos].e+=exp_a.charAt(exp_a.length()-1);
		exp[pos++].isOP=true;
		exp[0].count=pos;            //零单元count记录整个数组元素数量
		return exp;                    //首尾带'#'元素
	}
	
	
	/**中缀式转化为后缀式 
	 * 
	 * @param 中缀式(元素数组)
	 * @return 后缀式(元素数组)
	 */
	private Elem[] InversePolandExpression(Elem[] exp_a)
	{
		//Exp_a是原来存储中缀式的顺序表,Exp_b是用来存储后缀式的顺序表
		Elem[] Exp_b=new Elem[200];	
		Stack<Elem> OPTR=new Stack<Elem>();             //存储运算符的栈		
		int pos1=0,pos2=0;                              //Exp_a顺序表的位置下标 
		
		OPTR.push(exp_a[pos1++]);			 //符号'#'入栈  	    
		Elem e,x;
		e=OPTR.peek();
		while(exp_a[pos1].e.charAt(0)!='#'||e.e.charAt(0)!='#')           //当中缀式顺序表中还有元素或者运算符栈中还有元素时循环进行 
		{
			//原理: 只有操作符栈中栈顶元素遇到优先级小于它的元素,才会把该运算符插入顺序表,
			//这样就有了两个运算符,而上一个运算符优先级是更高的,肯定要先进行运算 
			if(!exp_a[pos1].isOP)                      //如果不是运算符,即是运算数 
			{
				Exp_b[pos2++]=exp_a[pos1++];    	   //则直接存入后缀式顺序表中 
			} 
			
			else                                    	//如果是运算符 
			{
				switch(Precede(e.e.charAt(0),exp_a[pos1].e.charAt(0)))
				{
					case -1:                            //如果栈顶运算符元素优先级小于遍历到的运算符元素 
					{
						OPTR.push(exp_a[pos1++]);      //将中缀式运算符元素存入运算符栈,中缀式顺序表遍历位置下移 				   
					} break;		
				
					case  0:                            //如果栈顶运算符元素优先级等于遍历到的运算符元素 
					{
						OPTR.pop();                    //优先级相等,说明是(),进行配对消除处理 
						pos1++;                          //中缀式顺序表遍历位置下移 
					} break;
					
					case  1:                            //如果栈顶运算符元素优先级大于遍历到的运算符元素 
					{
						x=OPTR.pop();                    //将栈顶运算符元素存入后缀式顺序表,但中缀式顺序表遍历位置不移动,还要再次用来比较 
						Exp_b[pos2++]=x;       
					} break;					 
				}//switch
				e=OPTR.peek();		        //栈顶元素发生了改变,所以要重新获取一下	
			}//else	
		}//while 	
		Exp_b[0].count=pos2;				//零单元count记录整个数组元素数量
		return Exp_b;						//不含'#'元素
	}
	
	
	/**计算逆波兰式 
	 * 
	 * @param 后缀式(元素数组)
	 * @return 计算结果
	 */
	private double CalculatePolandExpression(Elem[] exp)
	{
		//原理:遇到运算符就从栈中弹出两个数进行运算,结果在压入栈中 
		Stack<Double> OPND=new Stack<Double>();            //存放运算数的栈             
		int pos=0;
		double num1,num2,sum=0;
	    while(pos<exp[0].count)
		{	   
	    	if(!exp[pos].isOP)                         //如果遍历到后缀式的元素是操作数 
		    {
	    		OPND.push(Double.valueOf(exp[pos++].e));       //字符类型减去'0'转化为数字类型,将操作数得到的结果压入栈中
		    }
		    else                                               //如果遍历到后缀式的元素是操作符 
		    { 
		    	num2=OPND.pop();                              //出栈两个数进行运算 
		   	    num1=OPND.pop();
		   	    switch(exp[pos++].e.charAt(0))
		   	    {
		   	     	case '+': sum=num1+num2; break;
		   	     	case '-': sum=num1-num2; break;
		   	    	case '*': sum=num1*num2; break;
		   	     	case '/': sum=num1/num2; break;
			    }
		   	 OPND.push(sum);             //将计数得到的结果压入栈中
		    }//else
		}//while
		   
	    double x=OPND.pop();                  //最后栈顶元素就是结果 
		return x;
	}
}
