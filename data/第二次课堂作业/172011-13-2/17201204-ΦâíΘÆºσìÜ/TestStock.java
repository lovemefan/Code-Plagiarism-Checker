
public class TestStock {
	public static void main(String[] args){
		Stock a1 = new Stock("ORCL","Oracle Corporation");
		a1.setCurrentPrice(34.35);
		a1.setPreviousClosingPrice(34.5);
		System.out.println("The ChangePercent is :" + a1.getChangePercent()*100 + "%");
		
	}

}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	Stock(String newSymbol , String newName){
		symbol = newSymbol;
		name = newName;
	}
	double getChangePercent(){
		return (Math.abs(currentPrice - previousClosingPrice)) / previousClosingPrice;
	}
	public void setCurrentPrice(double newCurrentPrice){
		currentPrice = newCurrentPrice;
	}
	public void setPreviousClosingPrice(double newPreviousClosingPrice){
	    previousClosingPrice = newPreviousClosingPrice;
	}
}