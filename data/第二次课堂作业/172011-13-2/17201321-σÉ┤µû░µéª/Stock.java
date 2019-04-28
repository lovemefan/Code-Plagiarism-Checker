
public class Stock {
	public static void main(String[] args) {
		Stock s = new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("previousClosingPrice is "+s.previousClosingPrice+"\n"+" currentPrice is "+s.currentPrice+"\n"+" it's the market value chnage percent is "+s.getChangePercent(34.5,34.35)*100+"%");
	}
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol,String newName,double newPreviousClosingPrice,double newCurrentPrice){
		symbol = newSymbol;
		name = newName;
		previousClosingPrice = newPreviousClosingPrice;
		currentPrice = newCurrentPrice;
	}
	double getChangePercent(double previousClosingPrice,double currentPrice){
		return (currentPrice-previousClosingPrice)/previousClosingPrice;
	}
}
