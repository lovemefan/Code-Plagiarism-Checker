
import java.util.Iterator;

/**
 * 链表表头操作实现下压栈
 * 
 * @author 七分帅气
 * @date 2016.7.20
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 表示链表的表头同时也表示栈顶
    private int N; // 链表的长度

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
