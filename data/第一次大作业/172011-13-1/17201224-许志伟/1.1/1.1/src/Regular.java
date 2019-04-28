
public class Regular {
	private String ex;

	
	public Regular(){
		
	}
	
	public Regular(String ex){
		this.ex = ex;
		
	}
	
	
	/*���ַ���������������������š����Ų���ԡ�
	(�����������)ǰ�����������2*(3-2)+1
	(ǰ�治���������)���治������������ʽ�ں��Ƿ��ַ���*/
	public boolean deal(){
	      
		boolean k = true;
		if(ex.isEmpty()){
			k = false;
		}else if(ex.matches(".*[\\+\\-\\*\\/]{2}.*")){
			k = false;
		}else if(ex.matches(".*\\(\\).*")){	
			k = false;
		}else if(ex.matches(".*\\([\\+\\-\\*\\/].*")){
			k = false;
		}else if(ex.matches(".*[\\+\\-\\*\\/]\\).*")){
			k = false;
		}else if(ex.matches(".*[^\\+\\-\\*\\/]\\(")){
			k = false;
		}else if(ex.matches(".*\\)[^\\+\\-\\*\\/]")){
			k = false;
		}else if(ex.matches(".*[^\\d\\+\\-\\*\\/\\(\\)].*")){
			k = false;
		}
		return k;
	}
	
	public boolean IsEmpty(){
		return ex.isEmpty();
	}
	
	public boolean OperateContinue(){
		return ex.matches(".*[\\+\\-\\*\\/]{2}.*");
	}
	
	public boolean EmptyParentheses(){
		return ex.matches(".*\\(\\).*");
	}
	
	public boolean BehindIsOperate(){
		return ex.matches(".*\\([\\+\\-\\*\\/].*");
	}

	public boolean FrongIsOperate(){
		return ex.matches(".*[\\+\\-\\*\\/]\\).*");
	}

	public boolean BehingIsnotOperate(){
		return ex.matches(".*\\)[^\\+\\-\\*\\/]");
	}
	
	public boolean FrontIsnotOperate(){
		return ex.matches(".*[^\\+\\-\\*\\/]\\(");
	}
	
	public boolean IllegalityOperate(){
		return ex.matches(".*[^\\d\\+\\-\\*\\/\\(\\)].*"); 
	}
	
	public void deleteSpace(){
		ex = ex.replaceAll("\\s","");
	}
	
	public String getExpression(){
		return ex;
	}
	
}
