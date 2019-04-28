package bigAssignments.calculator;
import java.io.*;
import java.util.*;

/**判断不合法表达式*/
public class JudgeLegal {
	int flag = 1;// 判断表达式是否存在异常情况，0为表达式存在任意一种异常情况，1为表达式合法
	int IsNull = 1; // 判断表达式是否为空，1为空，0为非空
	Calculate file = new Calculate();
	File fileOut = new File("E:\\Eclipse\\src\\bigAssignments\\calculator\\Output");
	/**empty expression 
	  *  检验表达式为空*/
	void EmptyExp(String OneExp, File f){
		try {
			FileWriter fw = new FileWriter(f,true);
			if(OneExp.length() == 0) {
				fw.write("\nERROR\n#表达式为空\n");
				flag = 0;
				fw.close();
			}else
				IsNull = 0;
		}catch(IOException  e) {
			e.printStackTrace();
		} 
	}
	/**empty parentheses
	  *  检验是否包含空括号*/
	void EmptyPare(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length(); i++) {
				if(OneExp.charAt(i) == '(' ) 
					if(OneExp.charAt(i+1) == ')' ) {
						fw.write("\nERROR\n#表达式中有空括号\n");
						fw.close();
						flag = 0;
						break;
					}	
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}		
	}
	/**illegal charachters 
	  * 检验包含非法字符*/
	void IllegalChar(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length(); i++) {
				char ch = OneExp.charAt(i);
				if(ch > 57 || ch < 40 || ch == 44 || ch == 46) {
					fw.write("\nERROR\n#表达式包含非法字符\n");
					fw.close();
					flag = 0;
					break;
				}
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** missmatching parentheses 
	  * 检验括号不匹配*/
	void MissmatchPare(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			String[] LeftPar = ("," + OneExp + ",").split("\\(");
			String[] RightPar = ("," + OneExp + ",").split("\\)");
			if(LeftPar.length != RightPar.length) {
				fw.write("\nERROR\n#表达式括号不匹配\n");
				fw.close();
				flag = 0;
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** Consecutive Operator 
	  * 检验连续运算符*/
	void  ConOper(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length()-1; i++) {
				String extract1 = "" + OneExp.charAt(i); // 提取表达式中的一个字符进行判断
				String extract2 = "" + OneExp.charAt(i+1);
				if(extract1.matches("[\\+\\-\\*\\/]") && extract2.matches("[\\+\\-\\*\\/]")) {
					fw.write("\nERROR\n#运算符连续\n");
					fw.close();
					flag = 0;
				}
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** invalid operator
	  * 无效运算符*/
	void InvalOper(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			OneExp = "#" + OneExp + "#";
			for(int i=1; i<OneExp.length()-1; i++) {
				String current = "" + OneExp.charAt(i);
				String front = "" + OneExp.charAt(i-1);
				String back = "" + OneExp.charAt(i+1);
				if(current.matches("[\\+\\-\\*\\/]")) {
					if(front.matches("[^0-9\\)]")) {
						fw.write("\nERROR\n#运算符前无运算数\n");
						flag = 0; // 运算符前无运算数
					}	// 运算符后无运算数
					if(back.matches("[^0-9\\(]")) {
						fw.write("\nERROR\n#运算符后无运算数\n");
						flag = 0;
					}
				}	//小括号前无运算数，括号非第一个字符
				else if(current.matches("\\(")) {
					if(front.matches("[^\\+\\-\\*\\/\\#\\(]")) {
						fw.write("\nERROR\n#括号非第一个字符且之前无运算符\n");
						flag = 0;
					}
				}	//小括号后无运算数，括号非最后一个字符
				else if(current.matches("\\)")) {
					if(back.matches("[^\\+\\-\\*\\/\\#\\)]")) {
						fw.write("\nERROR\n#小括号后无运算符，括号非最后一个字符\n");
						flag = 0;
					}
				}
			}
			fw.close();
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	// 表达式异常处理
	void Judge(File f) throws IOException{
		Calculate result;
		file.InitFile(fileOut);
		try(Scanner output = new Scanner(f)){
			while(output.hasNextLine()) {
				FileWriter fw = new FileWriter(fileOut,true);
				String S = output.nextLine();
				fw.write("表达式：" + S);
				fw.close();
				S = S.replaceAll(" ", "");
				EmptyExp(S,fileOut);
				if(IsNull == 0) {
					EmptyPare(S,fileOut);
					IllegalChar(S,fileOut);
					MissmatchPare(S,fileOut);
					ConOper(S,fileOut);
					InvalOper(S,fileOut);
				}
				if(flag == 1) {
					result = new Calculate();
					result.GetResult(fileOut,S);
				}
				flag = 1;
			}
		}
	}
}
