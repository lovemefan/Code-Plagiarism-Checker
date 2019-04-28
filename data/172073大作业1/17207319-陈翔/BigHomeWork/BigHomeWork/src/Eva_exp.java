import java.util.*;
import java.io.*;
public class Eva_exp {
	
	File_operate fo = new File_operate();
	File f = new File("D:\\Eclipse_Workspace\\BigHomeWork\\src\\exp.txt");
	Regular_judge  jud = new Regular_judge();
	
	Eva_exp(){
	}
	
	public boolean priJudge(char a, char b) {
		switch (a) {
			case '+':a += 1;
						break;
			case '-':a -= 1;
						break;
			case '*':a += 4;
						break;
			case '/':a -= 1;
						break;
			default:;
		}
		switch (b) {
		case '+':b += 1;
					break;
		case '-':b -= 1;
					break;
		case '*':b += 4;
					break;
		case '/':b -= 1;
					break;
		default:return false;
		}		
		if(b >= a)
			return true;
		else
			return false;
	}
	public String infixToSuffix(String str) {//中缀表达式转后缀表达式
		int num;
		Stack stack = new Stack();
		String tar_str = "";
		for(int i = 0;i < str.length(); i++) {
			num = 0;
			System.out.println(stack.size());
			if( str.charAt(i) >= 48 && str.charAt(i) <= 57 ) {
				num = str.charAt(i) - 48;
				while(str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57 ) {
					if(i == str.length() - 1)
						break;
					++i;
					num *= 10;
					num +=str.charAt(i) - 48;
				}
				tar_str  = tar_str .concat( String.valueOf(num) );
				continue;
			}
			else if ( ')' == str.charAt(i)) {
				while( '(' != (char)stack.elementAt(stack.size() - 1)) {
					tar_str  = tar_str .concat(String.valueOf(stack.pop()));
				}
				stack.pop();
			}
			else if('(' == str.charAt(i) || ')'== str.charAt(i)) {
				stack.push(str.charAt(i));
				continue;
			}
			else if(priJudge(str.charAt(i), (char)stack.elementAt(stack.size() - 1)) &&
					1 >= stack.size()) {
				
				tar_str .concat(String.valueOf(stack.pop()));
				while(priJudge(str.charAt(i), (char)stack.elementAt(stack.size() -1 ))	&&
						1 >= stack.size())
					tar_str .concat(String.valueOf(stack.pop()));
			}
			stack.push(str.charAt(i));
			
		}
		return tar_str;
	}
	
	
	public String calExp(String str) {//后缀表达式求值
		Stack stack = new Stack();
		String tar_str = "";
		int result = 0;
		for(int i = 0;i < str.length(); i++) {
			int temp = 0;
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57 )
				stack.push(str.charAt(i));
			else {
				switch (str.charAt(i)) {
					case '+':temp = (int) stack.elementAt(stack.size() - 1 ) +	
							(int) stack.elementAt(stack.size());
								break;
					case '-':temp = (int) stack.elementAt(stack.size() - 1 ) -	
							(int) stack.elementAt(stack.size());
								break;
					case '*':temp = (int) stack.elementAt(stack.size() - 1 ) *	
							(int) stack.elementAt(stack.size());
								break;
					case '/':temp =(int) stack.elementAt(stack.size() - 1 ) /	
							(int) stack.elementAt(stack.size());
								break;	
					default:;
				}
				stack.pop();
				stack.pop();
				stack.push(temp);
			}
			result = (int)stack.pop();
		}
		tar_str.concat(str);
		tar_str.concat(String.valueOf(result));
		
		return tar_str;
	}
	
	public void expEva() {
		String[] exp;
		 //fo.writeFile(f);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		exp = fo.readFile(f);
		//System.out.println(exp[0]);//测试
		for(int i = 0;i <= fo.conlumn - 1; i++) {
			String str ;
			boolean flag;
			str = new String();
			//exp[i] = new String();
			str = str.concat(exp[i]);
			
			
			flag = showWrongResult(this.jud.judge(exp[i]));
			if (!flag)
				continue;
			System.out.print(str);
			if (str == null)
				System.out.println("表达式为空");
		//	exp[i] = infixToSuffix(exp[i]);
		//	exp[i] = calExp(exp[i]);
			InfixToSuffix its = new InfixToSuffix ();
			showRightResult(str, its.suffixCalc(exp[i]));
			
		}
	}
	
	
	public boolean showWrongResult(int index) {
		if(0 == index)
			return true;
		System.out.printf("ERROR\n#");
		switch(index) {
			case 1:System.out.println("表达式为空");
				break;
			case 2:System.out.println("表达式中有空括号");
				break;			 
			case 3:System.out.println("表达式包含非法字符");
				break;
			case 4:System.out.println("括号不匹配");
				break;	
			case 5:System.out.println("运算符连续");
				break;
			case 6:System.out.println("运算符前无运算数");
				break;	
			case 7:System.out.println("运算符后无运算数");
				break;
			case 8:System.out.println("括号非第一个字符且之前无运算数 ");
				break;
			case 9:System.out.println("小括号后无运算数，括号非最后一个字符");
				break;
			default:return true;
		}
		return false;
	}
	
	
	public void showRightResult(String exp, String result) {
		System.out.println( "=" + result);
	}

}
