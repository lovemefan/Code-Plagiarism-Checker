
public class Stock {

	public static void main(String[] args) {
		Stock stock1 = new Stock("ORCL", "Oracle Corporation");
		stock1.setPrevious(34.5);
		stock1.setPrice(34.35);
		System.out.println("The percent with " + "the symbol of '" + stock1.symbol +
				"' and the name of '" + stock1.name + "' is " + stock1.getChangePersent() + "%");
	}
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currenPrice;
	public Stock(String newSymbol, String newName){
		this.symbol = newSymbol;
		this.name = newName;
	}
	
	public void setPrevious(double newPreviousClosingPrice){
		this.previousClosingPrice = newPreviousClosingPrice;
	}
	public void setPrice(double currenPrice){
		this.currenPrice = currenPrice;
	}
	
	public double getChangePersent(){
		return previousClosingPrice / currenPrice * 100;
	}

}
