//建栈
public class Stack {
	// 顶端和底部指向
	public Node stackTop;
	public Node stackBottom;

	public Stack(Node stackTop, Node stackBottom) {
		this.stackTop = stackTop;
		this.stackBottom = stackBottom;
	}

	public Stack() {
	}

	// 进栈 stack 栈 value 要进栈的元素
	public static void pushStack(Stack stack, String value) {

		// 封装数据成节点
		Node newNode = new Node(value);

		// 栈顶本来指向的节点交由新节点来指向
		newNode.next = stack.stackTop;

		// 栈顶指针指向新节点
		stack.stackTop = newNode;

	}

	// 遍历栈(只要栈顶指针不指向栈底指针，就一直输出)

	public static void traverse(Stack stack) {
		Node stackTop = stack.stackTop;

		while (stackTop != stack.stackBottom) {

			System.out.println("该栈不为空" + stackTop.data);

			stackTop = stackTop.next; // 可以使栈顶降一位
		}

	}

	// 很简单，只要栈顶和栈底是同一指向，那么该栈就为空

	// 判断该栈是否为空

	public static boolean isEmpty(Stack stack) {
		if (stack.stackTop == stack.stackBottom) {

			// System.out.println("该栈为空");
			return true;
		} else {

			// System.out.println("该栈不为空");
			return false;
		}

	}

	// 在出栈之前看看该栈是否为空，不为空才出栈...
	// 将栈顶的元素的指针(指向下一个节点)赋值给栈顶指针(完成出栈)

	// 出栈(将栈顶的指针指向下一个节点)

	public static String popStack(Stack stack) {

		// 栈不为空才能出栈
		if (!isEmpty(stack)) {

			// 栈顶元素
			Node top = stack.stackTop;

			// 栈顶指针指向下一个节点
			stack.stackTop = top.next;

			// System.out.println("出栈的元素是：" + top.data);
			return top.data;

		} else {
			// System.out.println("返回error");
			return "error";
		}
	}
	// 当时学C的时候需要释放内存资源，可是Java不用呀，所以栈顶指向栈底，就清空栈了

	// 清空栈

	public static void clearStack(Stack stack) {

		stack.stackTop = null;
		stack.stackBottom = stack.stackTop;
	}
}
