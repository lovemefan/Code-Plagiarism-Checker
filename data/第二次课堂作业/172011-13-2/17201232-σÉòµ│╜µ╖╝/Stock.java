
public class Stock {
	public static void main(String[] args){
		Stock s = new Stock ("ORCL" , "Oracle Corporation");
		
	
	System.out.println("  The symbol is :  " + s.symbol+
			"  The name is :  " + s.name +
			"  The change is :  " + s.getChangePercent());

	
	}
	
	
	String symbol;
	String name;
	double currentPrice = 34.35;
	double prevoiusClosingPrice = 34.5;
    public Stock (String symbol,String name){
		this.symbol = symbol;
		this.name = name;
	}
	
	double getChangePercent(){
		
		return (currentPrice - prevoiusClosingPrice)/ currentPrice ;
	}
	
	
	
}
