
public class Machine {
	private char[] machine = new char[500];
	private int n = -1;

	public Machine() {
		
	}

	public void pushMachine(char x) {
		machine[++n] = x;
	}

	public char popMachine() {
		
			return machine[n--];
		
	}

	public boolean Decide() {
		return n == -1 ? true : false;
	}

	// �鿴��ǰ������λ��
	public int getN() {
		return n;
	}

	// �鿴���˵������
	public char searchMachine() {
		return machine[n];
	}
	//�е�һλ���ַ��������е����ͣ�
    public void cutN(){
    	n--;
    }
	
}
