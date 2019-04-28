
public class Student extends Person{
	protected int grade;
	
	public Student(){
		
	}
	
	public Student(int grade){
		this.grade = grade;
	}
	
	@Override
	public String toString(){
		System.out.println("Student:" + name);
		return this.name;
	}
}
