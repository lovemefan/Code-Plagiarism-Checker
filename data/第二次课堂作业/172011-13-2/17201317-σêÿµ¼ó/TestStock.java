package work;

public class TestStock {
    public static void main(String[] args){
    	Stock stock1=new Stock("ORCL","Oracle Corporation",34.5,34.35);
    	//stock1.symbol="ORCL";
    	//stock1.name="Oracle Corporation";
    	//stock1.previousClosingPrice=34.5;
    	//stock1.currentPrice=34.35;
    	System.out.println("Symbol: "+stock1.getSymbol());
    	System.out.println("Name: "+stock1.getName());
    	System.out.println("Previousclosingprice: "+stock1.getPreviousClosingPrice());
    	System.out.println("Currentprice: "+stock1.getCurrentPrice());
    	System.out.println("Changeprecent: "+stock1.getChangePercent()*100+"%");
    	
    }
}
