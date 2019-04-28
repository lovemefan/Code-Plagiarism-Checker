
public class MyDate {
	private long year;
	private long month;
	private long day;
	
	public MyDate(){
		
	}
	
	public MyDate(int year,int month,int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public MyDate(long time){
		this.year = time / (3600 * 1000 * 24 * 365);
		this.month = (time / (3600 * 1000 * 24) - 365 * this.year) / 30;
		this.day = time / (3600 * 1000 * 24) - 365 * this.year - 30 * this.month;
	}
	
	public long getYear(){
		return this.year;
	}
	
	public long getMonth(){
		return this.month;
	}
	
	public long getDay(){
		return this.day;
	}
	
	public void setDate(long elapsedTime){
		this.year = elapsedTime / (3600 * 1000 * 24 * 365);
		this.month = (elapsedTime / (3600 * 1000 * 24) - 365 * this.year) / 30;
		this.day = elapsedTime / (3600 * 1000 * 24) - 365 * this.year - 30 * this.month;
	}
}
