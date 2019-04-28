package allpackage;

public class Compute {
	//  计算处理--逆波兰式
	double[] OPNUM = new double[20]; //数字栈
	String[] OPCHAR = new String[30]; //字符栈
	int numtop = 0,chartop = 0; //字符与数字栈栈顶
	String found;
	Compute(String foundation){
		StringBuffer s = new StringBuffer(foundation);
		s.append('#');
		found = s.toString();//复制字符串
	}
						   //'+', '-', '*', '/', '(', ')', '#'
	char[][] opcharlist = { {'>', '>', '<', '<', '<', '>', '>'}, //'+'
            				{'>', '>', '<', '<', '<', '>', '>'}, //'-'
            				{'>', '>', '>', '>', '<', '>', '>'}, //'*'
            				{'>', '>', '>', '>', '<', '>', '>'}, //'/'
            				{'<', '<', '<', '<', '<', '=', ' '}, //'('
            				{'>', '>', '>', '>', ' ', '>', '>'}, //')'
            				{'<', '<', '<', '<', '<', ' ', '='}};//'#'
	
	char precede(char opr1, char opr2){ //找运算符优先级
		int index1 = toIndex(opr1);
		int index2 = toIndex(opr2);
		
		return opcharlist[index1][index2];
	}
	int toIndex(char ch){//返回下标
		int index = 0;
		
		switch(ch) {
		case '+': 
				index = 0; //+
			break;
		case '-': 
				index = 1; //-
			break;
		case '*': 
				index = 2; //*
			break;
		case '/': 
				index = 3; ///
			break;
		case '(': 
				index = 4; //(
			break;
		case ')': 
				index = 5; //)
			break;
		case '#': 
				index = 6; //#
			break;		
		}
 
		return index;
	}

	double operate(double a, char op, double b) {//计算
		double ret = 0;
 
		switch(op)
		{
		case '+':
			ret = a + b;
			break;
		case '-':
			ret = a - b;
			break;
		case '*':
			ret = a * (b * 1.0);
			break;
		case '/':
			ret = a / (b * 1.0);
			break;
		}
 
		return ret;
	}

	boolean isOperate(char ch) { //是否是操作符
		if (ch == '+' || ch == '-' || 
			ch == '*' || ch == '/' || 
			ch == '(' || ch == ')' ||
			ch == '#')
			return true;
		else
			return false;
	}
	String getSign(String found) {//获取表达式值
		 StringBuffer sf = new StringBuffer(found);
		 StringBuffer s = new StringBuffer();
		 
		 if(sf.charAt(0) >= '0' && sf.charAt(0) <= '9') {//如果第一个是数字添加进s
			 while(sf.charAt(0) >= '0' && sf.charAt(0) <= '9') {
				 s.append(sf.charAt(0));
				 sf.deleteCharAt(0);//删除第一个值  使之完成循环
			 }
			 this.found = sf.toString();//改变原字符串
			 return s.toString();
		 }else {//是字符
			 String n = "";
			 n += sf.charAt(0);
			 if(sf.charAt(0) != (int)'#')
					 sf.deleteCharAt(0);
			 this.found = sf.toString();
			 return n;
		 }
		
	}
	double dataCompute() {
		String sign;
		pushChar('#');
		sign = getSign(found);
		while(sign.charAt(0) != '#' ||  OPCHAR[chartop].charAt(0) != '#') {
			if(!isOperate(sign.charAt(0))) {
				pushNum(Integer.parseInt(sign));
				sign = getSign(found);
			}else {
				switch(precede(OPCHAR[chartop].charAt(0),sign.charAt(0))) {
				case '<'://优先权低 不用处理 直接入栈
					pushChar(sign.charAt(0));
					sign = getSign(found);
					break;
				case '='://去括号并接收下一个标记
					popChar();
					sign = getSign(found);
					break;
				case '>'://退栈并将结果入栈
					double a,b;
					b = popNum(); 
					a = popNum();
					pushNum(operate(a,popChar(),b));
					break;
					
				}
			}
		}
		return OPNUM[numtop];//返回栈顶值
	}
	

	void pushNum(double num) {//入数字栈
		numtop++;
		this.OPNUM[numtop] = num;
	}
	
	void pushChar(char ch) {//入符号栈
		chartop++;
		OPCHAR[chartop] = "";
		this.OPCHAR[chartop] += ch;
	}
	
	double popNum() {//出数字栈	
		return this.OPNUM[numtop--];
	}
	
	char popChar() {//出符号栈		
		return this.OPCHAR[chartop--].charAt(0);
	}
}
