
public class Person {
	protected String name;
	protected String address;
	protected String tel;
	protected String mail;
	
	public Person(){
		
	}
	
	public Person(String name,String address,String tel,String mail){
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}
	
	public String toString(){
		return this.name;
	}
}
