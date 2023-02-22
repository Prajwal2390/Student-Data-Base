package sdbms;


import java.security.cert.X509CRLEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.Sorting.ShortStudentByName;
import com.Sorting.SortStudentByAge;
import com.Sorting.SortStudentById;
import com.Sorting.SortStudentByMarks;

import customexecption.InvalidChoiceExecption;
import customexecption.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem{
	
	Scanner ip=new Scanner(System.in);
	Map<String, Student> db=new LinkedHashMap<String, Student>();
	
	@Override
	public void addStudent() {
		System.out.println("Enter the Student age:");
		int age=ip.nextInt();
		System.out.println("Enter the Student name:");
		String name=ip.next();
		System.out.println("Enter the student marks:");
		int marks=ip.nextInt();
		Student s=new Student(age,name,marks);
		db.put(s.getId(), s);
		System.out.println("Student data added succesfully");
		System.out.println("Student Id is "+s.getId());		
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter the student Id");
		String Id=ip.next().toUpperCase();
		 //Id=Id.toUpperCase();
		if(db.containsKey(Id)) {
			Student std= db.get(Id);
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			//System.out.println(std);->printing ref var as toString() is overridden 				
		}else {
			try {
				throw new StudentNotFoundException("Student Not Found");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
		Set<String> keys=db.keySet();//genarics is string bcz id is string
		for(String key:keys) {
			Student value=db.get(key);
			System.out.println(value);
			//System.out.println(db.get(key));
		}
		}
		else {
			try {
				throw new StudentNotFoundException("Student records are not Available to Display" );
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent() {
		System.out.println("Enter the Student ID");
		String Id=ip.next().toUpperCase();
		if(db.containsKey(Id)) {
			System.out.println("Student record Found");
			System.out.println(db.get(Id));
			db.remove(Id);
			System.out.println("Student record deleted Succesfully");			
		}
		else {
			try {
				throw new StudentNotFoundException("Student Id not found");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}
		}				
	}
	@Override
	public void removeAllStudents() {
		if(db.size()!=0) {
		System.out.println("Student record Available"+db.size());
               db.clear();
               System.out.println("All Student recorded are succesfully");
               System.out.println("Student record Available"+db.size());
		}
		else {
			try {
				throw new StudentNotFoundException("Student Database is Empty");				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent() {
		System.out.println("Enter the Id :");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1.update age\n2.name\n3.Marks");
			System.out.println("Enter your choice");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter age to be updated");
			//int age=ip.nextInt();
			std.setAge(ip.nextInt());
			break;
			
			case 2: System.out.println("Eneter name to be updated");
			//String name=ip.next();
			std.setName(ip.next());
			break;
			
			case 3:System.out.println("Enter marks to be updated");
			//int marks=ip.next();
			std.setMarks(ip.nextInt());
			break;
			default:
				try {
					throw new InvalidChoiceExecption("Invalid choice");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}			
		}else {
			try {
				throw new StudentNotFoundException("Student Record Not found");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void countStudent() {
		System.out.println("No of Student Recorded "+db.size());
	}

	@Override
	public void sortStudent() {
		
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<>();
		for(String key:keys) {
			list.add(db.get(key));
			
		}
		
		System.out.println("1.Sort by Id\n2.Sort by Name\n3.Sort by age\n4.Sort by Marks");
		System.out.println("Enter your Choice");
		int choice=ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById() );
			display(list);
			break;
		case 2:
			Collections.sort(list,new ShortStudentByName() );
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByAge() );
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks() );
			display(list);
			break;
			
			default:
				try {
					throw new InvalidChoiceExecption("Invalid choice");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		
		}
		

	
	}
		else {
			   try {
				   throw new StudentNotFoundException("No Sufficient Student Object to Compare ");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
	}		
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));			
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
	}
		else {try {
			String message ="No Sufficient Student Object to Compare";
			throw new StudentNotFoundException(message);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		}
	}
	
	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));		
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
	}
		else {
			   try {
				   throw new StudentNotFoundException("No Sufficient Student Object to Compare ");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
	}
}
