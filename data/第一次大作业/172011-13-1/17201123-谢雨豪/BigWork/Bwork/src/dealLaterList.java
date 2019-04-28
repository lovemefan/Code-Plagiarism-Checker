import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dealLaterList {
	public dealLaterList() {

	}

	public double dealLaterList(List<String> laterList) {

		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < laterList.size(); i++) {
			String temp = laterList.get(i);
			
			String regEx1 = "[^\\+\\-\\*\\/]";
			Pattern pattern1 = Pattern.compile(regEx1);
			Matcher matcher1 = pattern1.matcher(temp);
			boolean b1 = matcher1.find();
			if (/*!temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/")*/ b1) {//为了降低圈复杂度 改成正则表达式
				stack.push(Double.parseDouble(temp));
				// System.out.print("\n"+Double.parseDouble(temp));
			} else if(!stack.empty()){
				if (temp.equals("+")/*&&!stack.empty()*/) {
						double a = stack.pop();
						double b = stack.pop();
						double ans = a + b;
						stack.push(ans);
				} else if (temp.equals("-")/*&&!stack.empty()*/) {
					double a = stack.pop();
					double b = stack.pop();
					double ans = b - a;
					stack.push(ans);
				} else if (temp.equals("*")/*&&!stack.empty()*/) {
					double a = stack.pop();
					double b = stack.pop();
					double ans = b * a;
					stack.push(ans);
				} else if (temp.equals("/")/*&&!stack.empty()*/) {
					double a = stack.pop();
					double b = stack.pop();
					double ans = b / a;
					stack.push(ans);
				}
			}
		}
		
		if(!stack.empty())
		{
			return stack.pop();
		}
		return 0;
	}
}
