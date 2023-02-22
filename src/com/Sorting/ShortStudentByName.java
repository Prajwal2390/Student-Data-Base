package com.Sorting;

import java.util.Comparator;

import sdbms.Student;

public class ShortStudentByName implements Comparator<Student> {
	@Override
	public int compare(Student x, Student y) {
		return x.getName().compareTo(y.getName());
	}


}
