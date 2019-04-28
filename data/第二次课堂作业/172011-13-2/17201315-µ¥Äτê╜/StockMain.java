package Stock;

public class StockMain {
	public static void main(String[] args)  {
		Stock s1;
		s1 = new Stock();
		s1 = new Stock("ORCL","Oracle Corporation");
		s1.setPreviousClosingPrice(34.5);
		s1.setCurrentPrice(34.35);
		System.out.println("The stock stmbol is " + s1.getSymbol());
		System.out.println("The stock name is " + s1.getName());
		System.out.println("The stock previou closing price is " + s1.getPreviousClosingPrice());
		System.out.println("The stock current price is " + s1.getCurrentPrice());
		System.out.println("The stock change percentis " + s1.getChangePercent() + "%");
	}
}
