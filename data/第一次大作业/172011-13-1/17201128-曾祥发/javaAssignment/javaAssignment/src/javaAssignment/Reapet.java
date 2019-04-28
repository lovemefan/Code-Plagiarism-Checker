package javaAssignment;

public class Reapet {//

	Reapet() {

	}

	public void stringReapet(String[] expression, boolean[] tf, String[] result) {//规范表达式
		Regex reg = new Regex();
		reg.regex(expression, result, tf);//正则表达式判断
		int j = 0;
		while (expression[j] != null) {//找到相同的表达式
			if (tf[j]) {
				int k = j + 1;
				while (expression[k] != null) {
					if (expression[j].equals(expression[k])) {
						tf[k] = false;
						result[k] = "has been calculated!";//将相同的表达式标记且将结果改了
					}
					k++;
				}
			}
			j++;
		}

		cl(expression, tf, result);
	}

	public void cl(String[] expression, boolean[] tf, String[] result) {
		int i = 0;
		while (expression[i] != null) {
			if (tf[i]) {
				Negative n = new Negative();//处理负数的运算
				expression[i] = n.cNegative(expression[i]);
				Split split = new Split();//处理后拿去拆分
				result[i] = "=" + split.split(expression[i]);//收回结果
			}
			i++;
		}
	}

}