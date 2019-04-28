
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

	// 查看当前数所在位置
	public int getN() {
		return n;
	}

	// 查看顶端的运算符
	public char searchMachine() {
		return machine[n];
	}
	//切掉一位的字符，用于切掉（和）
    public void cutN(){
    	n--;
    }
	
}
