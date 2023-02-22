package sdbms;

public class Employee {
	int id;
	String name;
	static int count=101 ;
	public Employee(String name) {
		this.id=count;
		count++;
		this.name=name;
	
	}

	public static void main(String[] args) {
		Employee e1=new Employee("tom");
		System.out.println("Id:"+e1.id+" Name:"+e1.name);
		Employee e2=new Employee("tom");
		System.out.println("Id:"+e2.id+" Name:"+e2.name);
		
	
	}

}
