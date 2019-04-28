package allpackage;

public class Compute {
	//  ���㴦��--�沨��ʽ
	double[] OPNUM = new double[20]; //����ջ
	String[] OPCHAR = new String[30]; //�ַ�ջ
	int numtop = 0,chartop = 0; //�ַ�������ջջ��
	String found;
	Compute(String foundation){
		StringBuffer s = new StringBuffer(foundation);
		s.append('#');
		found = s.toString();//�����ַ���
	}
						   //'+', '-', '*', '/', '(', ')', '#'
	char[][] opcharlist = { {'>', '>', '<', '<', '<', '>', '>'}, //'+'
            				{'>', '>', '<', '<', '<', '>', '>'}, //'-'
            				{'>', '>', '>', '>', '<', '>', '>'}, //'*'
            				{'>', '>', '>', '>', '<', '>', '>'}, //'/'
            				{'<', '<', '<', '<', '<', '=', ' '}, //'('
            				{'>', '>', '>', '>', ' ', '>', '>'}, //')'
            				{'<', '<', '<', '<', '<', ' ', '='}};//'#'
	
	char precede(char opr1, char opr2){ //����������ȼ�
		int index1 = toIndex(opr1);
		int index2 = toIndex(opr2);
		
		return opcharlist[index1][index2];
	}
	int toIndex(char ch){//�����±�
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

	double operate(double a, char op, double b) {//����
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

	boolean isOperate(char ch) { //�Ƿ��ǲ�����
		if (ch == '+' || ch == '-' || 
			ch == '*' || ch == '/' || 
			ch == '(' || ch == ')' ||
			ch == '#')
			return true;
		else
			return false;
	}
	String getSign(String found) {//��ȡ���ʽֵ
		 StringBuffer sf = new StringBuffer(found);
		 StringBuffer s = new StringBuffer();
		 
		 if(sf.charAt(0) >= '0' && sf.charAt(0) <= '9') {//�����һ����������ӽ�s
			 while(sf.charAt(0) >= '0' && sf.charAt(0) <= '9') {
				 s.append(sf.charAt(0));
				 sf.deleteCharAt(0);//ɾ����һ��ֵ  ʹ֮���ѭ��
			 }
			 this.found = sf.toString();//�ı�ԭ�ַ���
			 return s.toString();
		 }else {//���ַ�
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
				case '<'://����Ȩ�� ���ô��� ֱ����ջ
					pushChar(sign.charAt(0));
					sign = getSign(found);
					break;
				case '='://ȥ���Ų�������һ�����
					popChar();
					sign = getSign(found);
					break;
				case '>'://��ջ���������ջ
					double a,b;
					b = popNum(); 
					a = popNum();
					pushNum(operate(a,popChar(),b));
					break;
					
				}
			}
		}
		return OPNUM[numtop];//����ջ��ֵ
	}
	

	void pushNum(double num) {//������ջ
		numtop++;
		this.OPNUM[numtop] = num;
	}
	
	void pushChar(char ch) {//�����ջ
		chartop++;
		OPCHAR[chartop] = "";
		this.OPCHAR[chartop] += ch;
	}
	
	double popNum() {//������ջ	
		return this.OPNUM[numtop--];
	}
	
	char popChar() {//������ջ		
		return this.OPCHAR[chartop--].charAt(0);
	}
}
