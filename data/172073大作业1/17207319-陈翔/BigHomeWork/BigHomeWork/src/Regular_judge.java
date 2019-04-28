import java.util.*;
import java.io.*;
public class Regular_judge {
	
	Regular_judge(){
		
	}
	
	public int judge(String exp) {
		int index;//用已返回是哪种错误
		int gap1, gap2;//用以检测两个括号是否匹配
		gap1 = gapJudgeLeft(exp);
		gap2 = gapJudgeRight(exp);
		//System.out.println(exp);
		if("" == exp)
			return 1;
		else if(exp.contains("()"))
			return 2;
		else if(exp.matches("[\\^\\+\\-\\*\\/][\\d]]{1,}"))
			return 3;
		else if(gap1 != gap2)
			return 4;
		else if(exp.matches("[\\+\\-\\/\\*][\\+\\-\\*\\/]{1,}"))
			return 5;
		else if(exp.matches("[\\^[\\d]][\\+\\-\\*\\/]{1,}"))
			return 6;
		else if(exp.matches("[\\+\\-\\/\\*][\\^[\\d]]{1,}"))
			return 7;
		else if(exp.matches("[\\^[\\d]][\\+\\-\\*\\/][\\(]{1,}"))
			return 8;
		else if(exp.matches("[\\)][\\+\\-\\*\\/][\\^[\\d]]{1,}"))
			return 9;
		 return 0;
	}

	public int gapJudgeLeft(String exp) { 
		String a = new String();
		a = "";
		a.concat(exp);
		return (exp.length() - exp.replaceAll("\\(", "").length());
	}
	public int gapJudgeRight(String exp) {
		String a = new String();
		a = "";
		a.concat(exp);
		return (exp.length() - exp.replaceAll("\\)", "").length());
	}

}
