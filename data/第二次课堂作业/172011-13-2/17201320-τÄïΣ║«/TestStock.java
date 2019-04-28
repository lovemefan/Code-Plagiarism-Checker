
public class TestStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock(34.5,34.35);
		System.out.println("Name: " + stock.getName("Oracle Corporation") + " symble: " + stock.getSymble("ORCL") + " precent is: " + stock.getChangePercent());
		
	}

}
class Stock{
	String symble;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	String getName (String newname) {
	    name = newname;
	    return name;
	}
	String getSymble(String newSymble) {
		symble = newSymble;
		return symble;
	}
	
	Stock(double newpreviousClosingPrice,double newcurrentPrice){
		previousClosingPrice = newpreviousClosingPrice;
		currentPrice = newcurrentPrice;
	}
	double getChangePercent() {
		return Math.pow(Math.pow(previousClosingPrice - currentPrice, 2), 0.5) / currentPrice;
		
	}
}
