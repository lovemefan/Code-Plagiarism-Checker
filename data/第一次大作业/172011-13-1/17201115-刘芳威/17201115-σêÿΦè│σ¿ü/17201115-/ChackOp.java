
public class ChackOp {

	public ChackOp(){
		
	}
    public String ChackOp(String op){
    	String result = "right";
    	int n = op.length();
    	int i= 0;
    	int N = 0;
    	
    	for(i=0;i<n;i++){
    		if(op.charAt(i)=='('||op.charAt(i)==')'){
    			N++;
    		}
    		
    	}
    	if(N%2!=0){
    		            return result = "���ʽ�У����źͣ����Ų����";
    	}
    	if(op.matches("[\\S]*[+-/*/][+-/*/][\\S]*")){//���������������
    		
    		return result = "���ʽ���������������";
    		
    	}
    	if(op.matches("[\\S]*[(][+-/*/][\\S]*")){//( ���ŵ��Ҳ��������
    		
    		return result = "�����ŵ��Ҳ��������";
    	}
    	if(op.matches("[\\S]*[0-9][(][\\S]*")){// ( ���ŵ����������
    		
    		return result = "�����ŵ����������";
    	}
    	if(op.matches("[\\S]*[+-/*/][)][\\S]*")){// ) ���ŵ�����������
    		
    		return result = "�����ŵ�����������";
    	}
    	if(op.matches("[\\S]*[)][0-9][\\S]*")){// ) ���ŵ��Ҳ�������
    		
    		return result = "�����ŵ��Ҳ�������";
    	}
    	if(op.matches("[\\S]*[[a-z][A-Z]][\\S]*")){//����ĸ
    		
    		return result = "���ʽ������ĸ";
    	}
    	if(op.matches("[\\S]*[,.?<;:>'{}&^%$#@!~`\"][\\S]*=")){//�зǷ�����
    		 
    		return result = "���ʽ���зǷ�����";
    	}
    	if(op.matches("[\\S]*[ ][\\S]*")){
    		return result = "���ʽ���пո�";
    	}
    	else {
    		return result;
    	}
    	//public String[] ChackSimilar(){
    	//	return op1;
    	//}
    }
}
