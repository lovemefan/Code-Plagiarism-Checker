import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 表示链表的表头同时也表示栈顶
    private int N; // 链表的长度

    //栈的节点类
    private class Node {
        Item data;
        Node next;

        public Node(Item data) {
            this.data = data;
        }
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return first == null;
    }

    //返回栈的大小
    public int size() {
        return N;
    }

    //入栈
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
    }

    //出栈
    public Item pop() {
        Item temp = first.data;
        first = first.next;
        N--;
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.data;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}