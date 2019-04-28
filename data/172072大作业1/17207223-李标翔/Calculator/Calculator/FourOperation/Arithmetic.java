package FourOperation;
/**
 * 该类实现 + - * / 四则运算
 * 
 */
public class Arithmetic {
	/**
	 * 加法运算
	 * @param number1
	 * @param number2
	 * @return double
	 */
	public static double addition(double number1,double number2) {
		return number1+number2;
	}
	/**
	 * 减法运算
	 * @param number1
	 * @param number2
	 * @return double
	 */
	public static double subtraction(double number1,double number2) {
		return (number1-number2);
	}
	/**
	 * 乘法运算
	 * @param number1
	 * @param number2
	 * @return double
	 */
	public static double multiplication(double number1,double number2) {
		return number1*number2;
	}
	/**
	 * 除法运算
	 * @param number1
	 * @param number2
	 * @return double
	 */
	public static double division(double number1,double number2) {
		//特别注意number2是0的情况
		return (number1/number2);
	}
}
