package jisuanji;

public class Check {
	String expression;
	
	public Check(){
		
	}
	
	public Check(String expression){
		this.expression = expression;
	}
	
	public String checkex(String expression){
		String e;
		if(expression.matches(".*([\\!-\\&]|\\,|\\=|[\\:-\\~]).*")){
			e = "Error# ���зǷ��ַ�";
		}
		else if(expression.matches(".*\\([\\+\\-\\*\\/].*")){
			e = "Error# (�����������";
		}
		else if(expression.matches(".*[\\+\\-\\*\\/]\\)")){
			e = "Error# )ǰ���������";
		}
		else if(expression.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")){
			e = "Error# ���������������һ��";
		}
		else if(expression.matches(".*\\)\\(.*")){
			e = "Error# )(�м�û�������";
		}
		else if(expression.matches(".*[\\d]\\(.*")){
			e = "Error# (ǰ�治�������";
		}
		else if(expression.matches(".*\\)[\\d].*")){
			e = "Error# )���治�������";
		}
		else if(expression.matches(".*\\(\\).*")){
			e = "Error# ������";
		}
		else if(expression.length() == 0){
			e = "Error# ���ַ���";
		}
		else{
			e = expression;
		}
		return e;
	}

}
