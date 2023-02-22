package sdbms;

public class Student {
	private String Id;
	private int age;
	private String name;
	private  int marks;
	static int  count=101;
	Student(int age,String name,int marks){
		this.Id="1KI"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}
	public String getId() {
		return Id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String toString() {
		return "ID:"+Id+" Age:"+age+" Name:"+name+" Marks:"+marks;
	}
	

}
