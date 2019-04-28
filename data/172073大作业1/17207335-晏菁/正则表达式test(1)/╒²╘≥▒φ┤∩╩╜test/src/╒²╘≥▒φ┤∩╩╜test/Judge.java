package 正则表达式test;

public class Judge {
	//判断str是否符合正确表达式
		public boolean judge(String str){
			String temp1="";
			String temp2="";
			String temp="Null";
			int k=0;
			int m=0;
				
			temp1=str.substring(0,1);
			if((temp1.matches("[\\+\\-\\*\\/]"))){
				System.out.println("ERROR #运算符前无运算数");
				return false;
			}
			//判断整个字符串是否含非法字符	
			for(int i=0;i<str.length()-1;i++){
				temp1=str.substring(i, i+1);
				if(!temp1.matches("[[0-9]\\+\\-\\*\\/\\(\\)]")){
					System.out.println("ERROR #表达式中含非法字符");
					return false;
				}
			}
			//判断表达式的其它错误
			for(int i=0;i<str.length()-1;i++){
				temp1=str.substring(i,i+1);
				temp2=str.substring(i+1,i+2);
				if(temp1.matches("\\(")&&temp2.matches("\\)")){
					System.out.println("ERROR #表达式中有空括号");
					return false;
				}
				else if( (temp1.matches("[\\+\\-\\*\\/]")) &&temp2.matches("[\\+\\-\\*\\/]") ){
					System.out.println("ERROR #运算符继续");
					return false;
				}
				else if((!temp1.matches("[[0-9]\\)]")) && (temp2.matches("[\\+\\-\\*\\/]"))){
					if(!temp1.matches("[0-9]")){
					System.out.println("ERROR #运算符前无运算数");
					return false;
					}
				}
				else if((temp2.matches("\\(")) && (!temp1.matches("[\\+\\-\\*\\/]")) && (i!=0)){
					System.out.println("ERROR #括号非第一个字符且之前无运算符");
					return false;
				}
				else if((temp1.matches("[\\+\\-\\*\\/]")) && (!temp2.matches("[[0-9]\\(]"))){
					if(!temp2.matches("[0-9]")){
					System.out.println("ERROR #运算符后无运算数");
					return false;
					}
				}
				else if((temp1.matches("\\)")) && (!temp2.matches("[\\+\\-\\*\\/]")) && (i!=(str.length()-1))){
					System.out.println("ERROR #小括号后无运算符，括号非最后一个字符");
					return false;
				}
			}
			
			//判断括号是否匹配
			for(int i=0;i<str.length();i++){
				temp1=str.substring(i,i+1);
				if( (temp.matches("\\(")) ){
					k++;
				}
				else if(temp.matches("\\)")){
					m++;
				}
			}
			if(k!=m){
				System.out.println("ERROR	#括号不匹配");
				return false;
			}
			
			return true;
		}

}
