
public class Main {
	public static void main(String[] args){
		 String expression = "(3+5*6)/11";
		 boolean x = expression.matches("\\d");
		 System.out.println(x);
	}
}
