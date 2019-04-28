
public class work92 {
	public static void main(String[] args){
		Stock stock = new Stock(34.5,34.35);
		System.out.println("In yesterday,The price is " + stock.previousClosingPrice
				+ "; today,the price is " + stock.currentPrice + " and the change is "
				+ stock.getChangePercent() + "%");
	}

}
