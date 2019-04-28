package BigWork;

import java.util.Iterator;

public class Stacks<Item> implements Iterable<Item> {
    private Node first; // ��ʾ����ı�ͷͬʱҲ��ʾջ��
    private int N; // ����ĳ���
    //����ڵ�Ĺ���
    private class Node {
        Item data;//����
        Node next;//ָ����һ���ڵ�
        //�ڵ�Ĺ��캯��
        public Node(Item data) {
            this.data = data;
        }
    }
    //ջ�Ĺ��캯��
    Stacks(){
    }
    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty() {
        return first == null;
    }
    //����ջ�ĳ���
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
    //��Ҳ������
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
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