
public class Change {
	public static void main(String[] args) {
		Stock s = new Stock("ORCl","Oracle Corperation");
		s.previousClosingPrice = 34.5;
		s.currentPrice = 34.35;
		String str = String.format("%.2f",s.getChangepercent() * 100);
		System.out.print("The stock code " + s.symbol + ",name "  + s.name +" value change percentage is " + str +"%");
	}

}
class Stock{
	String symbol,name;
	double previousClosingPrice,currentPrice;
	Stock(String newsymbol,String newname){
		symbol = newsymbol;
		name = newname;
	}
	double getChangepercent() {
		return currentPrice/previousClosingPrice;
	}
}
