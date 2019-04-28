package task;

public class Task9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock a=new Stock();
		System.out.println("%"+a.getChangePercent());

	}

}
class Stock{
	private String symbol;
	private String name;
	double previousClosingPrice;
	double currentPrice;
	public Stock() {
		symbol="ORCL";
		name="Oracle Corporation";
		previousClosingPrice=34.5;
		currentPrice=34.35;
	}
	public double getChangePercent() {
		return (34.35-34.5)/34.5;
	}
}