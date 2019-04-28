package work;

public class TestStock {
	public static void main(String[] args){
		Stock stock1 = new Stock("ORCL","Oracle Corporation");
		stock1.setPreviousClosingPrice(34.5);
		stock1.setCurrentPrice(34.35);
		System.out.printf("The change percent is %5.2",stock1.getChangePercent()*100);
	}

}
