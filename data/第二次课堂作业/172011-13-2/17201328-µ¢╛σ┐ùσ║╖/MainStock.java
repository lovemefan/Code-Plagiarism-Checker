
public class MainStock {
	public static void main(String[] args){
		Stock s1;
		s1 = new Stock();
		s1.setPrice(34.5, 34.35);
		System.out.println("The " + s1.setSymbol() + " "+ s1.setName() +" change percent is " + s1.getChangePercent());
	}
}
