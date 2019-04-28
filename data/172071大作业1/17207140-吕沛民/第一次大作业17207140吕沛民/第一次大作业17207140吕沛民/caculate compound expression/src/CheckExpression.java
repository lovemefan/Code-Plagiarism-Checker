import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpression {
	private String[] errorKind = new String[11];
	private String[] errorMark = new String[11];
	public String expression;
	boolean determine;
	public CheckExpression() {
		
	}
	public CheckExpression(String expression) {
		this.expression = expression;
		this.determine = true;
		errorMarkAndInput();
	}
	public boolean getdetermine() {
		return determine;
	}
	private void errorMarkAndInput() {
		errorKind[0] = "[^\\d\\+\\-\\*\\/\\(\\)]"; 		//���ʽ���Ƿ��ַ�
		errorKind[1] = "[\\+|\\-|\\*|\\/]{2,}"; 		//���������
		errorKind[2] = "\\(\\)";		//������
		errorKind[3] = "\\([\\+\\*\\-\\/]";		 //'('���������
		errorKind[4] = "[\\+|\\-|\\*|\\/]\\)";		//')'ǰ�������
		errorKind[5] = "[\\d|\\)]\\("; 		//'('ǰ�������ֻ���')'
		errorKind[6] = "\\)[\\d|\\(]";		//')'�����������ֻ�����'('
		errorKind[7] = "^[^\\d|\\(\\-]";		 //���ʽ ��ͷ���������֣�'('
		errorKind[8] = "[^\\d|\\)]$";		//���ʽ��β����������,')'��һ��;
		errorMark[0] = "#���ʽ���Ƿ��ַ�";
		errorMark[1] = "#���������";
		errorMark[2] = "#������";
		errorMark[3] = "#'('���������";
		errorMark[4] = "#')'ǰ�������";
		errorMark[5] = "#'('ǰ�������ֻ�����')'";
		errorMark[6] = "#')'���������ֻ���������'('";
		errorMark[7] = "#���ʽ���˱�������,'('�е�һ��";
		errorMark[8] = "#���ʽ��β����������,')'��һ��";
		errorMark[9] = "#���Ų�ƥ��";
		errorMark[10] = "#���ַ���";
		
	}
	private int markError() {	//ʵ��ƥ�����ͽ���ƥ��
		int flag = -1;
		for(int i =0 ;i<9; i++)
		{	
			Pattern pattern = Pattern.compile(errorKind[i]);
			Matcher matcher = pattern.matcher(expression);
			while(matcher.find())
			{	
				determine = false;
				flag = i;
				break;
			}
			//���ǵ����ʽ��һ���������˳�ѭ��
			if(!determine)  
			{
				break;
			}
		}
		return flag;
	}
	
	private int brackets() {	//�鿴���ʽ�ո��Ƿ�ƥ��
		int flag = -1;
		int k= 0;
		for(int i=0; i<expression.length();i++) 
		{	
			
			if(expression.charAt(i)=='(') {
				k++;
			}
			else if (expression.charAt(i)==')') {
				k--;
			}
		}
			if(k<0) 
			{
				determine = false;
				flag = 9;
				
			}
			if (k!=0) {
				determine = false;
				flag = 9;
				
			}
		
		return flag;
	}
	private int space() { 	//�鿴���ʽ�Ƿ�Ϊ��
		int l =0;
		int flag = -1;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)==' ') {
				l++;
			}
		}
		if(l==expression.length()) {
			determine =false;
			flag = 10;
		}
		return flag;
	}
	public String errorFind() {			//�ҵ����ʽ���������
		int flag = markError();
		if(flag > -1) {
			
			return errorMark[flag];
		}
		else if(brackets()== 9) {
			return errorMark[9];
		}
		else if(space() == 10) {
			return errorMark[10];
		}
		else
		{
			return expression;
		}
		
	}
}
