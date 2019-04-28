package workTwo;

public class Stock {

	 String  symbol;
	 String  name;
	 double previousClosingPrice;
	 double currentPrice;
	
   	Stock( String  symbol,
	       String  name,
	       double previousClosingPrice,
	       double currentPrice){
			
   		this.symbol=symbol;
		   this.name=name;
		   this.previousClosingPrice=previousClosingPrice;
		   this.currentPrice=currentPrice;
	}
	double getChangePercent(){
		return Math.abs((currentPrice-previousClosingPrice)/previousClosingPrice)*100;
		
	}
		
		    public static void main(String[] args){
			Stock one = new Stock("ORCL","Orcle Corporation", 34.5,34.35);
			System.out.println("the change is"+one.getChangePercent());
	}
}
