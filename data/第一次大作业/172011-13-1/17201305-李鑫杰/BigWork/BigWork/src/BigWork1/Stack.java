package BigWork1;

public class Stack{//用于转换为后缀式的字符型栈
	Node first; //链表的表头,也表示栈顶
	int N; //链表的长度

	//节点
	class Node{
		String data;//节点数据
		Node next;//节点的下一指向

		//节点数据赋值
		public Node(String data){
			this.data = data;
		}
	}

	public Stack(){

	}

	//栈顶是否为空
	public boolean isEmpty(){
		return first == null;
	}

	//返回栈的长度
	public int size(){
		return N;
	}

	//进栈
	public void push(String item){
		Node oldfirst = first;//旧栈顶的引用赋给新栈顶

		first = new Node(item);//给新栈顶赋值

		first.next = oldfirst;//旧栈顶与新栈顶连接

		N++;//长度加一
	}

	//出栈
	public String pop(){
		String temp = first.data;
		first = first.next;// 第二节点的引用赋给first，成为新栈顶

		N--;//长度减一
		return temp;
	}

}
