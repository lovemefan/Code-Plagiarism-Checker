package bigAssignments.calculator;

/**����Ϸ����ʽ*/
public class Stack {
	int TRsize=0;// �����ջ����
	int NDsize=0; // ������ջ����
	char[] OPTR; // �������ջ
	double[] OPND; // ��������ջ
	public Stack(String exp) {
		OPTR = new char[exp.length()];
		OPND = new double[exp.length()];
	}
	//�����������ջ��
	public void pushOPTR(char value) {
		if(TRsize >= OPTR.length) {
			char[] tempTR = new char[OPTR.length * 2];
			System.arraycopy(OPTR, 0, tempTR, 0, OPTR.length);
			OPTR = tempTR;
		}
		OPTR[TRsize++] = value;
	}
	// ������������ջ��
	public void pushOPND(double value) {
		if(NDsize >= OPND.length) {
			double[] tempND = new double[OPND.length * 2];
			System.arraycopy(OPND, 0, tempND, 0, OPND.length);
			OPND = tempND;
		}
		OPND[NDsize++] = value;
	}
	//���ز�ȡ�������ջ��ջ��Ԫ��
	public char PopOPTR() {
		return OPTR[--TRsize];
	}
	//���ز�ȡ��������ջ��ջ��Ԫ��
	public double PopOPND() {
		return OPND[--NDsize];
	}
	//����ջ��Ԫ��
	public char peakOPTR() {
		return OPTR[TRsize-1];
	}
	
	//����ջ��Ԫ��
	public double peakOPND() {
		return OPND[NDsize-1];
	}
}
