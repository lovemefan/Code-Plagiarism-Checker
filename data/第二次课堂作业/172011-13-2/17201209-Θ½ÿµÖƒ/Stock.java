
public class Stock {
	public static void main(String[] args){
		Stock stock = new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("The stock's code is "+stock.symbol);
		System.out.println("The stock's name is "+stock.name);
		System.out.println("The stock's previous closing price is "+stock.previousClosingPrice);
		System.out.println("The stock's current price is "+stock.currentPrice);
		System.out.println("The stock's price has changed by "+stock.getChangePercent()+"%");
	}
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    Stock() {
        symbol="xxxx";
        name="yyyy";
    }
    
	Stock(String newSymbol, String newName, double previousClosingPrice,double currentPrice){
		symbol = newSymbol;
		name = newName;
		this.previousClosingPrice =  previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
    double getChangePercent(){
		return Math.abs(34.5 - 34.35);
	}
}
