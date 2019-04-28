
public class Staff extends Employee{
	protected String title;
	
	public Staff(){
		
	}
	
	public Staff(String title){
		this.title = title;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
