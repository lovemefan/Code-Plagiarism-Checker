package bigwork;

public class Queue {
	private String[] line;//字符串数组作为队列
	private int frist;//指向队列的头
	private int last;//指向队列的尾

	public Queue(){
		
	}
	
	//设立队列长度
	public Queue(int i) {
		frist = 0;
		last = 0;
		line = new String[i];
	}

	// 将字符输入队列
	public static boolean inLine(Queue q, String ch) {
		if (isFull(q))//判断队列是否满了
			return false;
		else {
			q.line[q.last] = ch;//没满向队列尾部添加字符串
			q.last++;
			return true;
		}
	}

	// 判断队列是否满了
	public static boolean isFull(Queue q) {
		boolean pan = false;
		if ((q.last + 1) == q.line.length)
			pan = true;
		return pan;
	}

	// 将队列全部输出转换为字符串
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
