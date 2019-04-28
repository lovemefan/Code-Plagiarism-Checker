package calculator;
//判断运算符
public class MyUtils {
	/**
	 * 是否是加減乘除
	 */
	static boolean isJJCC(Character  ch) {
		return "+-*/".indexOf(ch)>-1;
	}
	
	/**
	 * 是否是加減乘除括号
	 */
	static boolean isJJCCKK(Character  ch) {
		return "+-*/()".indexOf(ch)>-1;
	}

	/**
	 * 是否是括号
	 */
	public static boolean isKHFF(Character ch) {
		return "()".indexOf(ch)>-1;
	}
	
	/**
	 * 是否是运算符号
	 */
	public static boolean isYSFF(Character ch) {
		return "0123456789+-*/()".indexOf(ch)>-1;
	}
	
}
