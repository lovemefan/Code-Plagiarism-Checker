package counter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//������ʽ�������������У��
public class Checkout {
	//��¼������ʽ
	private String[] errorKind = new String[11];
	//������¼�������Ϣ
	private String[] errorHint = new String[11];
	//firstCounter'�����нӴ��������ַ���
	String firstCounter ;
	//flag������¼�ַ������Ƿ���ȷ
	boolean flag  ; 
	
	//���췽��
	public Checkout(){
		
	}
	
	//��ʼ���Ĺ��췽��
	public Checkout(String firstCounter){
		this.flag = true;
		this.firstCounter = firstCounter;
		errorInputOrHint();
	}
	
	//��ʼ������
	private void errorInputOrHint(){
		errorKind[0] = "[^\\d\\+\\-\\*\\/\\(\\)]";//���ʽ���Ƿ��ַ�
		errorKind[1] = "[\\+|\\-|\\*|\\/]{2,}";//���������
		errorKind[2] = "\\(\\)";//������ 
		errorKind[3] = "\\([\\+\\*\\/]";//'('���������
		errorKind[4] = "[\\+|\\-|\\*|\\/]\\)";//')'ǰ�������
		errorKind[5] = "[\\d|\\)]\\(";//'('ǰ�������ֻ�����')'
		errorKind[6] = "\\)[\\d|\\(]";//')'���������ֻ���������'('
		errorKind[7] = "^[^\\d|\\(\\-]";//���ʽ���˱���������,,'('�е�һ��;
		errorKind[8] = "[^\\d|\\)]$";//���ʽ��β����������,')'��һ��;
		errorHint[0] = "#���ʽ���Ƿ��ַ�";
		errorHint[1] = "#���������";
		errorHint[2] = "#������";
		errorHint[3] = "#'('���������";
		errorHint[4] = "#')'ǰ�������";
		errorHint[5] = "#'('ǰ�������ֻ�����')'";
		errorHint[6] = "#')'���������ֻ���������'('";
		errorHint[7] = "#���ʽ���˱�������,'('�е�һ��";
		errorHint[8] = "#���ʽ��β����������,')'��һ��";
		errorHint[9] = "#���Ų�ƥ��";
		errorHint[10] = "#���ַ���";
	}
	
	//�жϱȽ������ִ���
	public String compare(){
		//temp������ס�����ִ���
		int temp = errorCount();
		if(temp > -1){
			return errorHint[temp];
		}
		//�ж��ǲ������Ų�ƥ��
		else if(bracket() == 9){
			return errorHint[9];
		}
		//�ж��ǲ��ǿ��ַ���
		else if(banking() == 10){
			return errorHint[10];
		}
		//���û�д��󷵻���ȷ�ı��ʽ
		else {
			return firstCounter;
		}
	}
	
	//�ж������ǲ���ƥ��
	private int bracket(){
		int n = 0;
		int temp = -1;
		//���������ַ�������(��)������
		for(int i = 0; i < firstCounter.length(); i++){
			//�����������n��һ
			if(firstCounter.charAt(i) == '('){
					n++;
			}
			//�����������n��һ
			else if(firstCounter.charAt(i) == ')'){
					n--;
			}
			//��Ϊ�����ܳ���nС��һ������������������һ����������
			if(n < 0){
				flag = false;
				temp = 9;
				break;
			}
		}
		//�������û�д�������������Ҳ��
		if(n != 0){
			flag = false;
			temp = 9;
		}
		return temp;
	}
	
	//������ƥ�䣬���д������������
	private int errorCount(){
		//temp������¼��������ʽ�Ĵ�������
		int temp = -1;
		for(int i = 0; i < 9;i++ ){
			//������ʽ����ƥ��
			Pattern pattern = Pattern.compile(errorKind[i]);
			Matcher matcher = pattern.matcher(firstCounter);
			while(matcher.find()){
				flag = false;
				temp = i;
				break;
			}
			//�õ����ʽ�ĵ�һ������
			if(!flag){
				break;
			}
		}
		return temp;
	}
	
	//���д���
	private int banking(){
		int j = 0;//������¼�ո������
		int temp = -1;
		//��������������ҿո�
		for(int i = 0 ; i < firstCounter.length();i++){
			if(firstCounter.charAt(i) == ' '){
				j++;
			}
		}
		//�жϿո�������Ƿ�����е�����һ�����������ʽ�ǿյ�
		if(j == firstCounter.length()){
			flag = false;
			temp = 10;
		}
	return temp;
		
	}
	
	//��ñ��ʽ�Ƿ���ȷ
	public boolean getFlag(){
		return flag;
	}
}
