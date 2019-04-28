package FourOperation;

import java.util.ArrayList;
/**
 * 该类进行逆波兰算法求表达式的值
 */
public class ReversePolishType {
	private char[] ch = {'(',')','+','-','*','/'};//字符串数组
	private Stack OPTR = new Stack();//运算符栈
	private Stack OPND = new Stack();//操作数栈
	
	private ArrayList<String> LA = new ArrayList<>();//存放表达式的字符串列表
	//无参构造方法
	ReversePolishType(){}
	/**
	 * 该类传入一个已经分好类的存放在列表里的表达式，返回表达式的值
	 * @param exp
	 * @return double
	 */
	public double calculate(ArrayList<String> exp) {//计算方法
		int i = 0;//标记变量
		LA = exp;//为了防止表达式被破坏，复制一下内容
		while(i < LA.size()) {//遍历LA列表
			//进行LA列表的逐个数字和操作符对应的操作
			i = dealWithSum(i,LA.get(i));
		}
		while(!OPTR.isEmpty()) {//当操作符栈不为空，求值直到栈空
			getsum();
		}
		
		return Double.valueOf((String) OPND.peek());//此时数值栈顶元素即为表达式的值
	}
	/**
	 * 进行操作符对应的操作
	 * @param i
	 * @param str
	 * @return i
	 */
	private int dealWithSum(int i,String str){
		if(isOpnd(str)) {//数值直接压入堆栈
			OPND.push(str);
			i++;
		}
		else {
			if(OPTR.isEmpty()) {//若操作符栈为空，直接压入操作符
				OPTR.push(str);
				i++;
			}
			else {
				if(str.charAt(0) == ')') {//右括号寻找与之匹配的左括号
					while(((String) OPTR.peek()).charAt(0) != '(') {
						//不是左括号则一直往下运算知道寻找到左括号
						getsum();
					}
					OPTR.pop();
					i++;
				}
				else {
					//进行运算符对应的操作
					i = compareAndOperate(i,str);
				}
			}
		}
		return i;
	}
	/**
	 * 传入当前操作符及其所在列表的下标，返回列表下一个元素下标
	 * @param i
	 * @param str
	 * @return i
	 */
	private int compareAndOperate(int i,String str){
		//操作符栈顶的操作符与当前要存入的操作符进行优先级比较
		switch(Precede(OPTR.peek(),str)){	
			/*
			优先级低取值取符号求值，取完之后若操作符栈中无操作符，退出操作
			若不为空，若操作符堆栈顶部元素依然比当前操作符优先级低，继续求值，直到栈空或者优先级改变*/
			case '<':
				getsum();
				if(OPTR.isEmpty()) {
					break;
				}
				while(Precede(OPTR.peek(),LA.get(i)) == '<') {
					getsum();
					if(OPTR.isEmpty()) {
						break;
					}
				}
				OPTR.push(LA.get(i));
				i++;
				break;
			//优先级相同求一次值
			case '=':
				getsum();
				OPTR.push(LA.get(i));
				i++;
				break;
			//优先级高直接把当前操作符压入堆栈
			case '>':
				OPTR.push(LA.get(i));
				i++;
				break;  
		}
		return i;
	}
	
	/**
	 * 栈顶两数求值操作
	 */
	private void getsum(){		
		String a,b;//临时变量
		char theat;//临时运算符
		String sum;//获值变量
		b = ((String) OPND.pop()).trim();
		a = ((String) OPND.pop()).trim();
		theat = ((String) OPTR.pop()).charAt(0);
		sum = Operate(a,theat,b);
		OPND.push(sum);//计算结果压入数值栈
	}
	
	/**
	 * 判断是否是操作数
	 * @param str
	 * @return boolean
	 */
	private boolean isOpnd(String str)
	{
		boolean mark = true;//默认为数值
		for(int i = 0;i < 6; i++)
		{
			if(str.equals(String.valueOf(ch[i])))
			{
				mark = false;
				break;
			}
		}
		return mark;
	}
	/**
	 * 给传入的运算符赋优先级值，并返回
	 * @param s
	 * @return i 
	 */
	private int priority(char s){
		if(s == '+'||s == '-')
			return 2;
		if(s == '*'||s == '/')
			return 3;
		else
			return 4;
	}
	
	/**
	 * 优先级函数，返回栈顶的运算符和当前运算符的比较值
	 * @param object
	 * @param str2
	 * @return >|=|<
	 */
	private char Precede(Object object,String str2){
		char f = 0;//初始化装取比较值的变量
		char e = ((String) object).charAt(0);//进行栈顶操作符的格式转换
		int i = 0, j = 0;//临时变量
		//给操作符赋优先度
		if(e == '(')
			i = 0;
		else
			i = priority(e);
		
		if(str2.charAt(0) == '(')
			j = 5;
		else
			j = priority(str2.charAt(0));
		//优先度比较
		if(j < i) {
			f = '<';
		}
		else if(j == i){
			f = '=';
		}
		else{
			f = '>';
		}
		
	    return f;	
	}
	/**
	 * 计算两个数的值,结果字符串化
	 * @param a 位于前面的数值
	 * @param theat 操作符
	 * @param b 位于后面的数值
	 * @return String
	 */
	private String Operate(String a,char theat,String b)//计算函数 
	{
		double f1 = Double.valueOf(a.trim());
		double f2 = Double.valueOf(b.trim());
		double total = 0;
		switch (theat)
			{
				case '+':
					total = Arithmetic.addition(f1, f2);
				break;
				case '-':
					total = Arithmetic.subtraction(f1, f2);
				break;
				case '*':
					total = Arithmetic.multiplication(f1, f2);
				break;
				case '/':
					total = Arithmetic.division(f1, f2);
				break;
			}

			return String.valueOf(total);
	}
}
