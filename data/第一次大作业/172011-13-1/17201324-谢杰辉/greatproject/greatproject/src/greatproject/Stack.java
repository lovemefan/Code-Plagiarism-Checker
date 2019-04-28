package greatproject;

public class Stack<E> {
	private cha<E> top;

	class cha<E> {
		E e;
		private cha<E> next;

		public cha(E e) {
			this.e = e;
		}

		public cha() {

		}
	}

	public Stack() {
		top = new cha<E>();
		top.next = null;
	}

	public cha<E> getTop() {
		return top;
	}

	public void push(E e) {
		cha<E> ch = new cha<E>(e);
		ch.next = top;
		top = ch;
	}

	public E pop() {
		cha<E> ch = top;
		top = top.next;
		return ch.e;
	}

	public boolean isEmpty() {
		if (top.next == null) {
			return true;
		}
		return false;
	}

}
