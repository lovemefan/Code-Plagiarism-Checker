import java.util.ArrayList;

public class DeleteSpaces {
	//保存的是原始数据删除空格后的表达式
	private static ArrayList<String> str = new ArrayList<>();

	public DeleteSpaces() {
		
	}
	
	public static ArrayList<String> getStr() {
		return str;
	}

	public static void delSpaces(ReadFromFile p) {
		String s = null;
		for (int i = 0; i < p.getStrings().size(); i++) {
			s = p.getStrings().get(i).replaceAll(" ", "");
			str.add(s);
		}
	}
	
	public static void addSpace(ArrayList<String> st) {
		for (int i = 0; i < str.size(); i++) {
			String string = "";

			String l = "" + str.get(i).charAt(str.get(i).length() - 1);
			if (l.matches("[\\+\\-\\*\\/\\(\\)]")) {
				l = " " + l;
			}

			for (int j = 0; j < str.get(i).length() - 1; j = j + 1) {
				char a = str.get(i).charAt(j);
				char b = str.get(i).charAt(j + 1);

				String c = "" + a + b;
				String temp;
				if (c.matches("[\\+\\-\\*\\/\\(\\)]{2}")) {
					temp = " " + a;
					string = string + temp;
					continue;
				}
				if (c.matches("[^\\+\\-\\*\\/\\(\\)]{2}")) {
					temp = "" + a;
					string = string + temp;
					continue;
				}
				if (c.matches("[^\\+\\-\\*\\/\\(\\)][\\+\\-\\*\\/\\(\\)]")) {
					temp = "" + a;
					string = string + temp;
					continue;
				}
				if (c.matches("[\\+\\-\\*\\/\\(\\)][^\\+\\-\\*\\/\\(\\)]")) {
					temp = " " + a + " ";
					string = string + temp;
					continue;
				}
			}
			string = string + l;
			st.add(string);
		}
	}
}