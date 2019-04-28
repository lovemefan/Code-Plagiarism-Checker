
public class Employee extends Person{
	protected String office;
	protected int salary;
	protected MyDate date;
	
	public Employee(){
		
	}
	
	public Employee(String office,int salary,MyDate date){
		this.office = office;
		this.salary = salary;
		this.date = date;
	}
	
	@Override
	public String toString(){
		System.out.println("Employee:" + name);
		return this.name;
	}
}
