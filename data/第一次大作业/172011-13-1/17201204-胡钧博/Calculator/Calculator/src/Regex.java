import java.util.regex.*;
public class Regex {
	String out = "";
    String[] e = new String[]{"[\\S]*[\\(][\\+|\\-|\\*|\\/][\\S]*"
    		,"[\\S]*[\\+|\\-|\\*|\\/][\\)][\\S]*"
    		,""
    		,"[\\S]*[\\+|\\-|\\*|\\/]{2}[\\S]*"
    		};
	public Regex(){
		
	}

    public String iCheck(String post){
	    if(post.matches(e[0])){
	    	out = "ERROR  #'('����������� ";
	    }
	    if(post.matches(e[1])){
		    out = "ERROR  #')'ǰ��������� ";
	    }
		if(post.matches(e[2])){
			out = "ERROR  #���ַ��� ";
		}
		if(post.matches(e[3])){
		    out = "ERROR  #��������� ";
		}

		if(bracket(post).equals("false")){
		    out = "ERROR  #���Ų�ƥ��";
		}
		
	return out;
    	
}
 
public String bracket(String e) {
	int k = 0;
	for (int i = 0; i < e.length(); i ++) {
		if (e.charAt(i) == '(') {
			k = k + 1;
		} else if (e.charAt(i) == ')') {
			k = k - 1;
		}
			if(k<0){
				return "false";
		}
	}
    if(k > 0){
    	return "false"; 
    }
    return "true";
}
}
