package bigwork;

public class Queue {
	private String[] line;//�ַ���������Ϊ����
	private int frist;//ָ����е�ͷ
	private int last;//ָ����е�β

	public Queue(){
		
	}
	
	//�������г���
	public Queue(int i) {
		frist = 0;
		last = 0;
		line = new String[i];
	}

	// ���ַ��������
	public static boolean inLine(Queue q, String ch) {
		if (isFull(q))//�ж϶����Ƿ�����
			return false;
		else {
			q.line[q.last] = ch;//û�������β������ַ���
			q.last++;
			return true;
		}
	}

	// �ж϶����Ƿ�����
	public static boolean isFull(Queue q) {
		boolean pan = false;
		if ((q.last + 1) == q.line.length)
			pan = true;
		return pan;
	}

	// ������ȫ�����ת��Ϊ�ַ���
	public static String queueToStr(Queue q) {
		int i = q.frist;
		String exp = "";
		while (i != q.last) {
			exp = exp + q.line[i];
			i++;
		}
		return exp;
	}
}
