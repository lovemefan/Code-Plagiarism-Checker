
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

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
    }

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
