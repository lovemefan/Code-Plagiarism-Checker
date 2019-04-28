class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol ,String newName){
		symbol = newSymbol;
		name = newName;
	}
	void SetpreviousClosingPrice(double newPreviousClosingPrice) {
		previousClosingPrice = newPreviousClosingPrice;
		
	}
	void SetcurrentPrice(double newCurrentPrice) {
		currentPrice = newCurrentPrice;
	}
	double getChangePercent() {
		return (currentPrice-previousClosingPrice)/previousClosingPrice;	
	}
	public static void main(String[] args) {
		Stock t = new Stock("ORCL" ,"Oracle Corporation");
		t.previousClosingPrice = 34.5;
		t.currentPrice = 34.35;
		System.out.println("Its changepercent is " + t.getChangePercent()*100 + "% ." );
	}
	
	

}
