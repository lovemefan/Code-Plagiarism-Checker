package BigWork;

import java.util.Iterator;

public class Stacks<Item> implements Iterable<Item> {
    private Node first; // 表示链表的表头同时也表示栈顶
    private int N; // 链表的长度
    //链表节点的构造
    private class Node {
        Item data;//数据
        Node next;//指向下一个节点
        //节点的构造函数
        public Node(Item data) {
            this.data = data;
        }
    }
    //栈的构造函数
    Stacks(){
    }
    //判断栈是否为空
    public boolean isEmpty() {
        return first == null;
    }
    //计算栈的长度
    public int size() {
        return N;
    }
    //出栈
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
    }
    //进栈
    public Item pop() {
        Item temp = first.data;
        first = first.next;
        N--;
        return temp;
    }
    //我也看不懂
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