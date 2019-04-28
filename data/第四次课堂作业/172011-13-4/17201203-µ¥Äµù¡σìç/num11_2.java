package num11;

import java.util.Scanner;

public class num11_2 {
	public static void main(String agrs[]) {
		Staff staff = new Staff();
		System.out.println(staff.toString());
	}
}

class Person {
	protected String name;
	private String sex;

	public Person() {
		name = "marry";

		sex = "female";
	}

	public Person(String name,   String sex) {
		this.name = name;

		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString() {
		return "Name: " + name + "\nSex: " + sex;
	}
}

class Student extends Person {
	public static int ONE = 1;
	public static int TWO = 2;
	public static int THREE = 3;
	public static int FOUR = 4;

	private int grade = 0;

	public Student() {
		super();
		grade = 0;
	}

	public Student(String name, double height, double weight, String sex, int grade) {
		super(name, sex);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString() + "\nGrade: " + grade;
	}
}

class Employee extends Person {
	private String address;
	private int tel;
	private String email;

	public Employee() {
		super();
		address = "nanchang";
		tel = 0;
		email = "075328";
	}

	public Employee(String name,  String sex, String address, int tel, String email) {
		super(name,  sex);
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + "\nAddreaa: " + address + "\nTel: " + tel + "\nEmail: " + email;
	}
}

class Faculty extends Employee {
	private double salary;
	private String office;
	private String startTime;
	private String endTime;
	private int grade;
	private int workTime;

	public Faculty() {
		super();
		salary = 0;
		office = "default";
		startTime = "timeless";
		endTime = "timeless";
		grade = 0;
		workTime = 0;
	}

	public Faculty(String name,  String sex, String address, int tel, String email,
			double salary, String office, String startTime, String endTime, int grade, int workTime) {
		super(name,sex, address, tel, email);
		this.salary = salary;
		this.office = office;
		this.startTime = startTime;
		this.endTime = endTime;
		this.grade = grade;
		this.workTime = workTime;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getTime() {
		return startTime + "-" + endTime;
	}

	public void setTime(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + salary + "\nOffice: " + office + "\nTime: " + startTime + "-" + endTime
				+ "\nGrade: " + grade + "\nWorkTime: " + workTime;
	}

}

class Staff extends Employee {
	private double salary;
	private String office;
	private String startTime;
	private String endTime;
	private String duty;

	public Staff() {
		super();
		salary = 0;
		office = "default";
		startTime = "timeless";
		endTime = "timeless";
		duty = "default";
	}

	public Staff(String name, String sex, String address, int tel, String email,
			double salary, String office, String startTime, String endTime, String duty) {
		super(name, sex, address, tel, email);
		this.salary = salary;
		this.office = office;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duty = duty;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getTime() {
		return startTime + "-" + endTime;
	}

	public void setTime(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + salary + "\nOffice: " + office + "\nTime: " + startTime + "-" + endTime
				+ "\nDuty: " + duty;
	}
}
