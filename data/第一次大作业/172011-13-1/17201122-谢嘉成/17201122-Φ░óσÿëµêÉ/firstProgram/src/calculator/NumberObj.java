package calculator;

/*
 * 数字对象
 */
public class NumberObj {

	private Integer numberValue;

	public Integer getNumberValue() {
		return numberValue;
	}

	public NumberObj(String input) {
		this.numberValue = Integer.valueOf(input);
	}

	/*
	 * 判断是否是数字
	 */
	public static boolean isNumber(String input) {
		return "0123456789".indexOf(input) >= 0;
	}

}
