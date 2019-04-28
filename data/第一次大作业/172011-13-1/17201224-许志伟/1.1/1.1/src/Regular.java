
public class Regular {
	private String ex;

	
	public Regular(){
		
	}
	
	public Regular(String ex){
		this.ex = ex;
		
	}
	
	
	/*空字符串、运算符连续、空括号、括号不配对、
	(后是运算符、)前面是运算符、2*(3-2)+1
	(前面不是运算符、)后面不是运算符、表达式内含非法字符等*/
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
