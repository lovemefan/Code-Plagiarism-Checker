
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
    		            return result = "表达式中（括号和）括号不相等";
    	}
    	if(op.matches("[\\S]*[+-/*/][+-/*/][\\S]*")){//有运算符连续出现
    		
    		return result = "表达式有连续运算符出现";
    		
    	}
    	if(op.matches("[\\S]*[(][+-/*/][\\S]*")){//( 括号的右侧有运算符
    		
    		return result = "左括号的右侧有运算符";
    	}
    	if(op.matches("[\\S]*[0-9][(][\\S]*")){// ( 括号的左侧有数字
    		
    		return result = "左括号的左侧有数字";
    	}
    	if(op.matches("[\\S]*[+-/*/][)][\\S]*")){// ) 括号的左侧有运算符
    		
    		return result = "右括号的左侧有运算符";
    	}
    	if(op.matches("[\\S]*[)][0-9][\\S]*")){// ) 括号的右侧有数字
    		
    		return result = "右括号的右侧有数字";
    	}
    	if(op.matches("[\\S]*[[a-z][A-Z]][\\S]*")){//有字母
    		
    		return result = "表达式中有字母";
    	}
    	if(op.matches("[\\S]*[,.?<;:>'{}&^%$#@!~`\"][\\S]*=")){//有非法符号
    		 
    		return result = "表达式中有非法符号";
    	}
    	if(op.matches("[\\S]*[ ][\\S]*")){
    		return result = "表达式中有空格";
    	}
    	else {
    		return result;
    	}
    	//public String[] ChackSimilar(){
    	//	return op1;
    	//}
    }
}
