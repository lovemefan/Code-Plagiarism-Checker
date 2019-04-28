package Calculator;

import java.util.Stack;

public class isError {
	private String Exception = null;
	StringBuffer ERRORBuffer = new StringBuffer();
	Stack<Character> stack = new Stack<Character>();
	
	/**
	 * �޲ι��췽��
	 */
	public isError() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �вι��췽������ʼ�����ʽ
	 * @param Exception
	 */
	public isError(String Exception) {
		this.Exception = Exception;
	}
	
	/**
	 * ���ر��ʽ�Ĵ�����Ϣ
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ERRORBuffer.toString();
	}
	
	/**
	 * �жϱ��ʽ�����Ƿ���ڴ���ƥ�䷵��true,��ƥ�䷵��false����¼������Ϣ
	 * @return
	 */
	public boolean BracketsError(){
		boolean error = true;
		error = getEr();
		if(this.Exception.matches("(.*)[0-9]\\((.*)")){
			ERRORBuffer.append("ȱ�ٲ�����:���������ȱ�ٲ�����;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\)[0-9](.*)")){
			ERRORBuffer.append("ȱ�ٲ�����:�������ұ�ȱ�ٲ�����;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\([\\*+-/](.*)")){
			ERRORBuffer.append("ȱ�ٲ�����:�������ұ�ȱ�ٲ�����;");
			error = false;
		}
		if(this.Exception.matches("(.*)[\\*+-/]\\)(.*)")){
			ERRORBuffer.append("ȱ�ٲ�����:���������ȱ�ٲ�����;");
			error = false;
		}
		if(this.Exception.matches("(.*)\\(\\)(.*)")){
			ERRORBuffer.append("������:�������ޱ��ʽ;");
			error = false;
		}
		return error;
	}
	
	private boolean getEr(){
		boolean error = true;
		for(int i = 0 ; i < Exception.length() ; i ++){
			if(Exception.charAt(i) == '('){
				stack.push(Exception.charAt(i));
			}
			if(Exception.charAt(i) == ')'){
				if(stack.isEmpty()){
					ERRORBuffer.append("���Ų�ƥ��:ȱ��������;");
					error = false;
				}else{
					stack.pop();
				}
			}
		}
		if( ! stack.isEmpty()){
			ERRORBuffer.append("���Ų�ƥ��:ȱ��������;");
			error = false;
		}
		return error;
	}
	
	/**
	 * �жϲ������������򷵻�false����¼������Ϣ
	 */
	public boolean OperatorError(){
		boolean error = true;
		if(this.Exception.matches("(.*)[\\*+-/][\\*+-/](.*)")){
			ERRORBuffer.append("�����ȱ�ٲ�����;");
			error = false;
		}
//		if( ! this.Exception.matches("(.*)[\\*+-/](.?)")){
//			ERRORBuffer.append("ȱ���������:ȱ��+ - * /;");
//			error = false;
//		}
		return error;
	}

	/**
	 * �жϷǷ��ַ�
	 * @return
	 */
	public boolean ErrorChar(){
		if(this.Exception.matches("(.*)[^\\*+-/0123456789\\(\\)](.*)")){
			ERRORBuffer.append("���зǷ��ַ�;");
			return false;
		}
		return true;
	}
}
