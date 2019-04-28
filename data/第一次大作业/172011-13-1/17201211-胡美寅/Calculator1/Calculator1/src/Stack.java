//��ջ
public class Stack {
	// ���˺͵ײ�ָ��
	public Node stackTop;
	public Node stackBottom;

	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.stackBottom = stackBottom;
	}

	public Stack() {
	}

	// ��ջ stack ջ value Ҫ��ջ��Ԫ��
	public static void pushStack(Stack stack, String value) {

		// ��װ���ݳɽڵ�
		Node newNode = new Node(value);

		// ջ������ָ��Ľڵ㽻���½ڵ���ָ��
		newNode.next = stack.stackTop;

		// ջ��ָ��ָ���½ڵ�
		stack.stackTop = newNode;

	}

	// ����ջ(ֻҪջ��ָ�벻ָ��ջ��ָ�룬��һֱ���)

	public static void traverse(Stack stack) {
		Node stackTop = stack.stackTop;

		while (stackTop != stack.stackBottom) {

			System.out.println("��ջ��Ϊ��" + stackTop.data);

			stackTop = stackTop.next; // ����ʹջ����һλ
		}

	}

	// �ܼ򵥣�ֻҪջ����ջ����ͬһָ����ô��ջ��Ϊ��

	// �жϸ�ջ�Ƿ�Ϊ��

	public static boolean isEmpty(Stack stack) {
		if (stack.stackTop == stack.stackBottom) {

			// System.out.println("��ջΪ��");
			return true;
		} else {

			// System.out.println("��ջ��Ϊ��");
			return false;
		}

	}

	// �ڳ�ջ֮ǰ������ջ�Ƿ�Ϊ�գ���Ϊ�ղų�ջ...
	// ��ջ����Ԫ�ص�ָ��(ָ����һ���ڵ�)��ֵ��ջ��ָ��(��ɳ�ջ)

	// ��ջ(��ջ����ָ��ָ����һ���ڵ�)

	public static String popStack(Stack stack) {

		// ջ��Ϊ�ղ��ܳ�ջ
		if (!isEmpty(stack)) {

			// ջ��Ԫ��
			Node top = stack.stackTop;

			// ջ��ָ��ָ����һ���ڵ�
			stack.stackTop = top.next;

			// System.out.println("��ջ��Ԫ���ǣ�" + top.data);
			return top.data;

		} else {
			// System.out.println("����error");
			return "error";
		}
	}
	// ��ʱѧC��ʱ����Ҫ�ͷ��ڴ���Դ������Java����ѽ������ջ��ָ��ջ�ף������ջ��

	// ���ջ

	public static void clearStack(Stack stack) {

		stack.stackTop = null;
		stack.stackBottom = stack.stackTop;
	}
}
