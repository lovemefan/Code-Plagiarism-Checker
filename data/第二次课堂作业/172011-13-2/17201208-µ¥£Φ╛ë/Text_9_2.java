
public class Text_9_2 {
	public static void main(String[] args){
		Stock s = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
		System.out.printf("%.2f%%",s.getChangePercent());
	}
}
class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPercent;

    Stock(String symbol, String name, double previousClosingPrice, double currentPercent){
    	 this.symbol = symbol;
    	 this.name = name;
    	 this.previousClosingPrice = previousClosingPrice;
    	 this.currentPercent = currentPercent;
    }
    
    void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice = previousClosingPrice;
    }
    
    void setCurrentPercent(double currentPercent){
        this.currentPercent = currentPercent;
    }
    
    double getChangePercent(){
        return  ((currentPercent - previousClosingPrice) / previousClosingPrice) * 100;

    }
}