
public class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	public Stock(String Symbol,String Name){
		symbol=Symbol;
		name=Name;
	}
	public double getChangePercent(){
		return ((currentPrice-previousClosingPrice)*100/previousClosingPrice);
	}

}
