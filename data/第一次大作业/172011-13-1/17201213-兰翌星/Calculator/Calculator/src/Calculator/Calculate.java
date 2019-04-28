package Calculator;

import java.util.LinkedList;

public class Calculate {
	private String niFixExp;//��׺���ʽ
	private String postFixExp;//��׺���ʽ
	private StringBuffer buffer = new StringBuffer();
	private boolean isError = true;
	OperatorsEnum operatorsEnum = null;
	LinkedList<OperatorsEnum> stack = new LinkedList<OperatorsEnum>();
	
	/**
	 * ���ʽ�����޲ι��췽��
	 */
	public Calculate() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �вι��췽������ʼ����������ʽ
	 * @param inFix
	 */
	public Calculate(String inFix) {
		// TODO Auto-generated constructor stub
		this.niFixExp = inFix.replaceAll("\\s","");
	}
	
	
	/**
	 * ��׺���ʽת���ɺ�׺���ʽ
	 * @param inFix:��׺���ʽ
	 * @return PostFix:��׺���ʽ
	 */
	public String getPostFix(){
		char[] ch = this.niFixExp.trim().toCharArray();
		StringBuffer Buffer = new StringBuffer();
		Buffer = getFix(Buffer , ch);
		if(isOperator(ch[ch.length - 1]) == null){
			Buffer.append(';');
		}
		while(stack.size() > 0){
			Buffer.append(stack.pop()).append(';');
		}
		this.postFixExp = Buffer.toString();
		return Buffer.toString();
	}
	
	private StringBuffer getFix(StringBuffer Buffer,char[] ch){
		for(int i = 0 ; i < ch.length; i ++){
			if((operatorsEnum = isOperator(ch[i])) == null){
					Buffer.append(ch[i]);
			}else{
				if(i > 0){
					if(isOperator(ch[i - 1]) == null){
						Buffer.append(';');
					}
				}
				if(operatorsEnum.equals(OperatorsEnum.RIGHT_BRACKET)){
					while(! stack.peek().equals(OperatorsEnum.LEFT_BRACKET)){
						Buffer.append(stack.pop()).append(';');
					}
					stack.pop();	
				}else{
					while(stack.size() > 0 && stack.peek().prior >= operatorsEnum.prior && ! stack.peek().equals(OperatorsEnum.LEFT_BRACKET)){
						Buffer.append(stack.pop()).append(';');
					}
					stack.push(operatorsEnum);
				}
			}
		}
		return Buffer;
	}
	
	/**
	 * �����׺���ʽ
	 * @param postFix:��׺���ʽ
	 * @return double :��׺���ʽ�ļ�����
	 */
	public double getExpResult(){
		LinkedList<String> List=new LinkedList<>();
		double num = 0;
		OperatorsEnum operatorsEnum;
		String[] postStr=this.postFixExp.toString().split(";");
	      for (String s:postStr) {
	    	  char[] c = s.toCharArray();
	            if ((operatorsEnum = isOperator(c[0])) != null){
	                if (!List.isEmpty()){
	                    double num1=Double.valueOf(List.pop());
	                    double num2=Double.valueOf(List.pop());
	                    if (s.equals("/")&&num1==0){
	                    	buffer.append("��������Ϊ0;");
	                        isError = false;
	                        return 0;
	                    }
	                    num=Cal(num2,num1,operatorsEnum);
	                    List.push(String.valueOf(num));
	                }
	            }
	            else {
	                List.push(s);
	            }
	        }
	        if (!List.isEmpty()){
	            return num = Double.valueOf(List.pop());
	        }
		return num;
	}
	
	public boolean isError(){
		return this.isError;
	}
	
	public String getErrorBuffer(){
		return buffer.toString();
	}
	
	/**
	 * ��ѧ���㷽��
	 * @param Num1 :��һ��������
	 * @param Num2 :�ڶ���������
	 * @param operatorsEnum:������
	 * @return:���
	 */
	private double Cal(double Num1,double Num2,OperatorsEnum operatorsEnum){
		switch(operatorsEnum){
		case PLUS:
			return Num1 + Num2;
		case MINUS:
			return Num1 - Num2;
		case MULTIPLY:
			return Num1 * Num2;
		case DIVIDE:
			return Num1 / Num2;
		case MODULAR:
			return Num1 % Num2;
		default:
			break;
		}
		return 0;
	}
	
	/**
	 * �ж��ַ�ch�Ƿ�Ϊ������
	 * @param ch:���ж��ַ�
	 * @return �ǲ������򷵻�ö���������ǲ������򷵻�NULL
	 */
	private OperatorsEnum isOperator(char s){
		for(OperatorsEnum operatorsEnum : OperatorsEnum.values()){
			if(s == operatorsEnum.operator){
				return operatorsEnum;
			}
		}
		return null;
	}
}
