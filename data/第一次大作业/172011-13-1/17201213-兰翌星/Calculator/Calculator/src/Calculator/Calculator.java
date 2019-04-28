package Calculator;

public class Calculator {
	static isError iserror;
	static Calculate calculate;
	static DocProcessing doc;
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		head = getExp();
		head = rmRepeated(head);
		head = reverseIteratively(head);
		Calulate(head);
	}
	
	/**
	 * 计算方法
	 */
	public static void Calulate(ListNode head){
		ListNode p = head;
		double result;
		while(p != null){
			iserror = new isError(p.exception);
			if(!iserror.ErrorChar() || !iserror.OperatorError() || !iserror.BracketsError()){
				doc.saveEceptionToFile("ERROR");
				doc.saveEceptionToFile("#"+ p.exception + ":" + iserror.toString());
			}else{
				calculate = new Calculate(p.exception);
				calculate.getPostFix();
				result = calculate.getExpResult();
				if(!calculate.isError()){
					doc.saveEceptionToFile("ERROR");
					doc.saveEceptionToFile("#" + p.exception + ":" + calculate.getErrorBuffer());
				}else{
					doc.saveEceptionToFile(p.exception + "=" + (int)result);
				}
			}
			
			p = p.next;
			if(p.exception == null){
				break;
			}
		}
		doc.closeFile();
	}
	
	/**
	 * 将数据读入链表
	 * @return
	 */
	public static ListNode getExp(){
		String line = null;
		doc = new DocProcessing();
		doc = new DocProcessing("data\\Input.txt","data\\output.txt");
		ListNode head = new ListNode();
		while((line = doc.getException()) != null){
			if(line.replaceAll("\\s", "") == null){
				continue;
			}
			ListNode node = new ListNode(line);
			node.next = head;
			head = node;
		}
		return head.next;
	}
	
	/**
	 * 去重方法
	 * @param head
	 * @return
	 */
	public static ListNode  rmRepeated(ListNode head){
		ListNode p = new ListNode();
		p = head;
		while(p != null ){
			ListNode q = p;
			while(q.next != null){
				if(p.exception.equals(q.next.exception)){
					q.next = q.next.next;
				}else
				{
					q = q.next;
				}
			}
			p = p.next;
		}
		return head;
	}
	
	/**
	 * 链表反转
	 */
	public static ListNode reverseIteratively(ListNode head){
		ListNode pReverseHead = head;
		ListNode pNode = head;
		ListNode pPrev = new ListNode();
		while(pNode != null){
			ListNode pNext = pNode.next;
			if(pNext == null){
				pReverseHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		return pReverseHead.next;
	}
}
