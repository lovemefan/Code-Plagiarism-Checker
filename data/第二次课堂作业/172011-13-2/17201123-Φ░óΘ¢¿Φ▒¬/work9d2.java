package work1015;

public class work9d2 {
	public static void main(String args[]){
		Stock sto=new Stock();
		sto.setStock("ORCL", "Oracle Corporation", 34.5, 34.35);
		System.out.println(sto.getChangePercent()+"%");
	}
}
