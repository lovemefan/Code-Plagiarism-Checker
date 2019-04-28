import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputJudge {
	
	public InputJudge(){
		
	}
	
	//文件输入的判断
	public String InputJudge(String input){
		String[] strArr = new String[9];
		strArr[0] = isIllegal(input);//是否有非法字符
		strArr[1] = equalRight(input);//右括号后面是否正确
		strArr[2] = equalLeft(input);//左括号后面是否正确
		strArr[3] = equalRighti(input);//右括号前面是否正确
		strArr[4] = equalLeftb(input);//左括号前面是否正确
		strArr[5] = leftRight(input);//左右括号数量是否匹配
		strArr[6] = count(input);//运算符是否连在一起
		strArr[7] = countFront(input);//运算符前面是否正确
		strArr[8] = countBehind(input);//运算符后面是否正确
		int i = 0;
		for(i = 0;i < 9;i ++){
			if(hasError(strArr[i])){
				break;
			}
		}
		return strArr[i];
	}
	
	public boolean isOk(String input){//判断表达式是否正确
		String[] strArr = new String[9];
		strArr[0] = isIllegal(input);
		strArr[1] = equalRight(input);
		strArr[2] = equalLeft(input);
		strArr[3] = equalRighti(input);
		strArr[4] = equalLeftb(input);
		strArr[5] = leftRight(input);
		strArr[6] = count(input);
		strArr[7] = countFront(input);
		strArr[8] = countBehind(input);
		int i = 0;
		int tag = 0;
		for(i = 0;i < 9;i ++){
			if(hasError(strArr[i])){
				tag = 1;
			}
		}
		if(tag == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean  hasError(String input){//表达式中有ERROR
		Pattern p = Pattern.compile("ERROR");
		Matcher m = p.matcher(input);
		return m.find();
	}
	
	public String[] Repetition(String[] input,int s){//表达式重复
		for(int i = 0; i < s - 1;i ++){
			for(int j = i + 1;j < s;j ++){
				if(input[i] != null){
					if(input[i].equals(input[j])){
						input[i] = input[i] + "\r\nERROR!\r\n#该表达式与其他表达式重复\r\n";
						break;
					}
				}
			}
		}
		return input;
	}
	
	public boolean isEmpty(String input){//表达式为空
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(input);
		return m.find();
	}
	
	public String isIllegal(String input){//存在非法字符
		if(input.matches(".*[[^\\d]&&[^\\+]&&[^\\-]&&[^\\*]&&[^/]&&[^(]&&[^)]]+.*")){
			input += "\r\nERROR\r\n#该表达式含非法字符\r\n";
		}
		return input;
	}
	
	public String equalRighti(String input){//右括号前面不匹配
		if(input.matches(".*[\\(|\\+\\-\\*/]\\).*")){
			input += "\r\nERROR\r\n#该表达式右括号前面不匹配\r\n";
		}
		return input;
	}
	
	public String equalRight(String input){//右括号后面不匹配
		if(input.matches(".*\\)[\\(|\\d].*")){
			input += "\r\nERROR\r\n#该表达式右括号后不匹配\r\n";
		}
		return input;
	}
	
	public String equalLeft(String input){//左括号前面不匹配
		if(input.matches(".*[\\)|\\d]\\(.*")){
			input += "\r\nERROR\r\n#该表达式左括号前面不匹配\r\n";
		}
		return input;
	}
	
	public String equalLeftb(String input){//左括号后面不匹配
		if(input.matches(".*\\([\\+|\\*|/|\\)].*")){
			input += "\r\nERROR\r\n#该表达式左括号后面不匹配\r\n";
		}
		return input;
	}
	
	public String leftRight(String input){//左右括号不匹配
		char[] cha = input.toCharArray();
		int left = 0;
		int right = 0;
		for(int i = 0;i < cha.length;i ++){
			if(cha[i] == '('){
				left ++;
			}
			else if(cha[i] == ')'){
				right ++;
			}
		}
		if(left != right){
			input += "\r\nERROR\r\n#该表达式左右括号不匹配\r\n";
		}
		return input;
	}
	
	public String count(String input){//运算符连接在一起
		if(input.matches(".*[\\+|\\-|\\*|/][\\+|\\-|\\*|/].*")){
			input += "\r\nERROR\r\n#该表达式计算符号连接在一起\r\n";
		}
		return input;
	}
	
	public String countFront(String input){//运算符开头
		if(input.matches("[\\+|\\*|/].*")){
			input += "\r\nERROR\r\n#该表达式以运算符开头";
		}
		return input;
	}
	
	public String countBehind(String input){//以运算符结尾
		if(input.matches(".*[\\+|\\-|\\*|/]")){
			input += "\r\nERROR\r\n#该表达式以运算符结尾\r\n";
		}
		return input;
	}
}
