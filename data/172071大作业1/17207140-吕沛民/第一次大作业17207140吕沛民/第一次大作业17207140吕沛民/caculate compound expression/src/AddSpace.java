
public class AddSpace {
	private String fixedExpression = "";
	public AddSpace() {
		
	}
	
	public AddSpace(String expression) {
		dealExpression(expression);
		
	}
	public String getFixedExpression() {
		//System.out.println(fixedExpression);
		return fixedExpression;
	}
	private boolean isNumber(char tip){			//�鿴�ַ��Ƿ�Ϊ����
		if(tip>='0'&& tip <='9')
			return true;
		else
			return false;
		
	}
	public void dealExpression(String expression) {		//�����ʽÿ�����ֺͷ����Ա߼��Ͽո�
		for(int i= 0;i<expression.length()-1;i++)
		{
			char tip1 = expression.charAt(i);
			char tip2 = expression.charAt(i+1);
			if(isNumber(tip1)&&isNumber(tip2)) {
				fixedExpression += tip1;
			}
			else
			{
				fixedExpression += tip1 + " ";
			}
		}
		fixedExpression += expression.charAt(expression.length()-1);
	}

}
