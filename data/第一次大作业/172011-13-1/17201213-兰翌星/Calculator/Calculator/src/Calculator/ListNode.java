package Calculator;

public class ListNode {
		public String exception = null;
		public ListNode next = null;
		
		public ListNode() {
			// TODO Auto-generated constructor stub
		}
		
		public ListNode(String exception) {
			this.exception = exception.replaceAll("\\s", "");
		}
}
