package calculator1;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	 public List<String> results(String n) {

		List<String> result = new ArrayList<String>();
		//标记字符位置
		if (n.length() == 0) {
			return result;
		}
		int begin = 0;
		char[] con = new char[100];
		int a = -1;
		while (begin < n.length()) {
			String now = "";
			//判断首位数字
			if (n.charAt(begin) <= '9' && n.charAt(begin) >= '0') {
				while (true) {
					//判断是否为数字
					if (begin < n.length() && n.charAt(begin) <= '9' && n.charAt(begin) >= '0') {
						//去两个运算符中间的数值
						now = now + n.charAt(begin++);
					} else {
						break;
					}
				}
				result.add(now);
			} else {
				char o = n.charAt(begin++);
				//判断运算是否结束
				if (a == -1) {
					con[++a] = o;
				} else 
					//遇到）
					if (o == ')') {
					while (true) {
						//判断判断新的运算是否开始
						if (con[a] == '(') {
							a--;
							break;
						} else {
							result.add("" + con[a--]);
						}
					}
				} else
					//求值
					if (orderOperations(con[a], o)) {
					result.add("" + con[a--]);
					con[++a] = o;
				} else {
					con[++a] = o;
				}
			}
		}
		while (a > -1) {
			result.add("" + con[a--]);
		}
		return result;
	}

	private boolean orderOperations(char c, char o) {

		Check orderOperations=new Check();
		return false;
	}

     

}
