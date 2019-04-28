import java.io.IOException;
import java.util.ArrayList;

public class HandleAll {
	public static void handleAll(ArrayList<String> st,ReadFromFile p1,DeleteSpaces p2) throws IOException {
		// 表达式校验，转转后缀表达式，计算等相关操作
		for (int i = 0; i < st.size(); i++) {
			// 去掉之前算过的表达式
			if (Neglect.neglectExpression(p2, i)) {
				continue;
			}

			// 正则表达式判断是否符合表达式规则
			if (Check.CheckingRegularExpression(p1.getStrings().get(i),i)) {
				continue;
			}

			// 计算及显示
			double result = Calculate.calculate((Solution.transformToSuffixExpression(st.get(i)).toString()));
			WriteToFile.writeToFile((i + 1) + ": " + p1.getStrings().get(i) + " = " + result);
		}
	}
}
