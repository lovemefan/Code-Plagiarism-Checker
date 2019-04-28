
public class Main {
	public static void main(String [] args){
		MyDate date = new MyDate(2018,11,3);
		Person person = new Person("java","nc","10086","qq.com");
		Student student = new Student(2);
		Employee employee = new Employee("D312",5000,date);
		Faculty faculty = new Faculty(date,3);
		Staff staff = new Staff("teacher");
		System.out.println("Person:" + person.toString());
		System.out.println("Student:" + student.toString());
		System.out.println("Employee:" + employee.toString());
		System.out.println("Faculty:" + faculty.toString());
		System.out.println("Staff:" + staff.toString());
	}
}
