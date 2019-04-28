
public class Faculty extends Employee{
	protected MyDate workDate;
	protected int level;
	
	public Faculty(){
		
	}
	
	public Faculty(MyDate workDate,int level){
		this.workDate = workDate;
		this.level = level;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
