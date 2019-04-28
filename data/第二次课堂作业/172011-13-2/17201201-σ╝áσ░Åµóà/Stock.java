
public class Stock {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		private String symbol;
		private String name;
		private double previousClosingPrice;
		private double currentPrice;
		
		public String getSymbol(){
			return symbol;
		}
		
		public  String getName(){
			return name;
		}
		
		public double getPreviousClosingPrice(){
			return previousClosingPrice;
		}
		
		public double getCurrentPrice(){
			return currentPrice;
		}
	
        public Stock(String symbol,String name,double previousClosingPrice,double currentPrice){
        	this.symbol = symbol;
        	this.name = name;
        	this.previousClosingPrice = previousClosingPrice;
        	this.currentPrice = currentPrice;
        }
    	
		public double getChangePercent(){
			return (currentPrice-previousClosingPrice)/previousClosingPrice;
		} 
}
