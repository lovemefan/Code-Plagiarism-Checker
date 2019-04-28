
public class DelSameExpression {

	private String[] expressions; // 记住所有表达式的字符串数组
	private boolean isSame; // 是否相同标志
	private int index; // 字符串数组下标

	// 构造方法
	public DelSameExpression() {
		isSame = false;
		expressions = new String[9999];
		index = 0;
	}

	// 将表达式赋给数组
	public void delSE(String expression) {
		expressions[index] = expression;
		index++;
	}

	// 判断是否重复
	public boolean deleteSame() {
		for (int i = 0; i < index - 1; i++) {
			isSame = expressions[i].equals(expressions[index - 1]);
			if (isSame == true) {
				break;
			}
		}
		return isSame;
	}
}
