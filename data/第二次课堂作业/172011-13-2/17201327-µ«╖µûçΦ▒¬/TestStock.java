
public class TestStock {
	
	public static void main(String[] args) {
		Stock a;
		String symbol = "ORCL";
		String name = "Oracle Corporation";
		a = new Stock(symbol,name);
		
		double previousClosingPrice = 34.5;
		double currentPrice = 34.35;
		double percent = a.getChangePercent(previousClosingPrice, currentPrice);
		System.out.printf("%.2f",percent);
		System.out.print("%");
	}
	
}
