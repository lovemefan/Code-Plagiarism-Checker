import java.util.Iterator;


public class Stack<Item> implements Iterable<Item> {
    private Node first; // ��ʾ����ı�ͷͬʱҲ��ʾջ��
    private int N; // ����ĳ���

    private class Node {
        Item data;
        Node next;

        public Node(Item data) {
            this.data = data;
        }
    }

    //�ж�Ϊ��
    public boolean isEmpty() {
        return first == null;
    }

    //������
    public int size() {
        return N;
    }

    //��ջ
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
    }

    //��ջ
    public Item pop() {
        Item temp = first.data;
        first = first.next;
        N--;
        return temp;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }
}
