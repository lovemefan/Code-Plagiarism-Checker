import java.util.*;
import java.util.regex.Pattern;

public class Calculation {

	public static ArrayList<String> Calculate(ArrayList<String> ex, ArrayList<String> legality) {
		ArrayList<String> result = new ArrayList<String>();
		// ������ֵջ
		Stack<Integer> stackint = new Stack<Integer>();
		// ��������ջ
		Stack<Character> stackchar = new Stack<Character>();

		int index = legality.size();
		for (int i = 0; i < index; i++) {
			if (legality.get(i).equals("legal")) {
				String l = (String) ex.get(i);
				// ���ַ���ת����char��������
				char[] c = new char[l.length()];
				for (int j = 0; j < l.length(); j++) {
					c[j] = l.charAt(j);

				}

				String num = "";
				for (int k = 0; k < l.length(); k++) {
					char ch = c[k];
					if (ch >= '0' && ch <= '9') {

						num = num + ch;
					}
					if (ch >= '(' && ch <= '/') {
						// String s = num;

						stackint.push(Integer.parseInt(num));
						num = "";
						// ��charת��string��Ȼ���ٽ�stringת��int<���ú���>
						stackchar.push(ch);
					}
				}
				stackint.push(Integer.parseInt(num));

				char sign;
				int a, b, data = 0;
				String temp;
				while (!stackchar.isEmpty()) {
					sign = stackchar.pop();
					if (sign == '+') {
						b = stackint.pop();
						a = stackint.pop();
						data = a + b;
						stackint.push(data);
					} else if (sign == '-') {
						b = stackint.pop();
						a = stackint.pop();
						data = a - b;
						stackint.push(data);
					} else if (sign == '*') {
						b = stackint.pop();
						a = stackint.pop();
						data = a * b;
						stackint.push(data);
					} else if (sign == '/') {
						b = stackint.pop();
						a = stackint.pop();
						data = a / b;
						stackint.push(data);
					}
					data = stackint.pop();
				}
				temp = data + "";
				result.add(temp);
			} else {
				result.add(legality.get(i));
			}
		}
		return result;
	}
}
