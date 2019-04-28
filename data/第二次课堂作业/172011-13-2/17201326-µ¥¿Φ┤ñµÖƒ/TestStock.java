package test2;

public class TestStock {
	public static void main(String[] args){
		Stock S1 = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
		System.out.println("The change of price is " + S1.getChangePercent() + "%");
	}
}
