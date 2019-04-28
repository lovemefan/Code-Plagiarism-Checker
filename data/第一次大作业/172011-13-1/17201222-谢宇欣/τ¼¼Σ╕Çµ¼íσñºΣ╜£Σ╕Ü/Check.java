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
			e = "Error# 含有非法字符";
		}
		else if(expression.matches(".*\\([\\+\\-\\*\\/].*")){
			e = "Error# (后面是运算符";
		}
		else if(expression.matches(".*[\\+\\-\\*\\/]\\)")){
			e = "Error# )前面是运算符";
		}
		else if(expression.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")){
			e = "Error# 两个运算符连接在一起";
		}
		else if(expression.matches(".*\\)\\(.*")){
			e = "Error# )(中间没有运算符";
		}
		else if(expression.matches(".*[\\d]\\(.*")){
			e = "Error# (前面不是运算符";
		}
		else if(expression.matches(".*\\)[\\d].*")){
			e = "Error# )后面不是运算符";
		}
		else if(expression.matches(".*\\(\\).*")){
			e = "Error# 空括号";
		}
		else if(expression.length() == 0){
			e = "Error# 空字符串";
		}
		else{
			e = expression;
		}
		return e;
	}

}
