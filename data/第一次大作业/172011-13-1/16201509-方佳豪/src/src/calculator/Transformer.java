package calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transformer {
	Stack<Character> op=new Stack<>();
	//正则表达式来处理带小数点的数字
	Pattern pattern=Pattern.compile("[0-9]+(\\.[0-9]+)?");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List transform(String s){
		
		int i=0;
		List list=new ArrayList<>();
		
		while(i<s.length()){
			char c=s.charAt(i);
			if (c>='0'&&c<='9') {
				String s1=s.substring(i);
				Matcher m =pattern.matcher(s1);
				if (m.find()) {    //取匹配到的第一个数字
					s1=m.group();

					list.add(s1);
				}
				i=i+s1.length();
				continue;
			}else if (c=='(') {
				op.push(c);
			}else if (c==')') {
				char p=op.pop();
				while(p!='('){
					list.add(p);
					p=op.pop();
				}
			}else if (c=='+'||c=='-') {
				while(!op.isEmpty()&&(op.peek()=='+'||op.peek()=='-'||
						op.peek()=='*'||op.peek()=='/')){
					list.add(op.pop());
				}
				op.push(c);
			}else if (c=='*'||c=='/') {
				while(!op.isEmpty()&&(op.peek()=='*'||op.peek()=='/')){
					list.add(op.pop());
				}
				op.push(c);
			}
			i++;
		}
		while(!op.isEmpty()){
			list.add(op.pop());
		}
		return list;
	}
}
