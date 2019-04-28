package BigWork1;

public class StackInt//用于计算后缀式的整型栈
{
	Node first; //链表的表头,也表示栈顶
    int N; //链表的长度

    class Node {//节点
        double data;//节点数据
        Node next;//节点的下一指向

        public Node(double data) {
            this.data = data;//节点数据赋值
        }
    }

    public StackInt() {
    	
    }
    
    public boolean isEmpty() {
        return first == null;//栈顶是否为空
    }

    public int size() {
        return N;//返回栈的长度
    }

    public void push(double item) {//进栈
    	
        Node oldfirst = first;//旧栈顶的引用赋给新栈顶
        
        first = new Node(item);//给新栈顶赋值
        
        first.next = oldfirst;//旧栈顶与新栈顶连接
        
        N++;//长度加一
    }

    public double  pop() {
        double temp=first.data; 
        first = first.next;//第二节点的引用赋给first，成为新栈顶
        
        N--;//长度减一
        return temp;
    }
}
