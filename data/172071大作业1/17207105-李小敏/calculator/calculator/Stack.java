package bigAssignments.calculator;

/**计算合法表达式*/
public class Stack {
	int TRsize=0;// 运算符栈长度
	int NDsize=0; // 运算数栈长度
	char[] OPTR; // 运算符入栈
	double[] OPND; // 运算数入栈
	public Stack(String exp) {
		OPTR = new char[exp.length()];
		OPND = new double[exp.length()];
	}
	//将运算符存入栈顶
	public void pushOPTR(char value) {
		if(TRsize >= OPTR.length) {
			char[] tempTR = new char[OPTR.length * 2];
			System.arraycopy(OPTR, 0, tempTR, 0, OPTR.length);
			OPTR = tempTR;
		}
		OPTR[TRsize++] = value;
	}
	// 将运算数存入栈顶
	public void pushOPND(double value) {
		if(NDsize >= OPND.length) {
			double[] tempND = new double[OPND.length * 2];
			System.arraycopy(OPND, 0, tempND, 0, OPND.length);
			OPND = tempND;
		}
		OPND[NDsize++] = value;
	}
	//返回并取出运算符栈的栈顶元素
	public char PopOPTR() {
		return OPTR[--TRsize];
	}
	//返回并取出运算数栈的栈顶元素
	public double PopOPND() {
		return OPND[--NDsize];
	}
	//返回栈顶元素
	public char peakOPTR() {
		return OPTR[TRsize-1];
	}
	
	//返回栈顶元素
	public double peakOPND() {
		return OPND[NDsize-1];
	}
}
