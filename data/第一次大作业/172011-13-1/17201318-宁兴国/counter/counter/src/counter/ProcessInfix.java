package counter;

/*�Ա��ʽ����Ԥ����
���� infix��(5+6)*78
�õ� result ��( 5 + 6 ) * 78
*/
public class ProcessInfix {
	String result = "";
	public ProcessInfix(){
		
	}
	
	//���췽��
	public ProcessInfix(String infix){
		processInfix(infix);
	}
	
	//������ʽ�ӿո�
	private void processInfix(String infix){
		String temp = "";
		for(int i = 0; i < infix.length()-1; i++){
			char temp1 = infix.charAt(i);
			char temp2 = infix.charAt(i + 1);
						//�ж��ǲ��Ǵ���9������
			if(isNumber(temp1) && isNumber(temp2)){
				result += temp1;
			}
			//�ж��ǲ��Ǹ���
			else if(temp1 == '(' && temp2 == '-' && isNumber(infix.charAt(i + 2))){
				result += temp1 + " " + '0' + " ";
			}
			else{
				result += temp1 + " ";
			}
		}
		if (infix.charAt(0) == '-'){
			 temp = '0' + " ";
			 result = temp + result;
		 }
		result += infix.charAt(infix.length() - 1);
	}
	
	//�ж���
	private boolean isNumber(char ch) {
		if(ch >= '0' && ch <= '9'){
			return true;
		}
		else
			return false;
	}
	
	//��ô�����˵ı��ʽ
	public String getProcessInfix(){	
		System.out.println(result);
		return result;
	}
}
