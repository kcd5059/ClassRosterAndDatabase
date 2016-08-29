package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Student {

	public String id;
	public String firstName;
	public String lastName;
	public String eyeColor;
	public int monthsEmployed;
	public static ArrayList<Student> classRoster = new ArrayList<>();
	public static HashMap<String, Student> database = new HashMap<>();

	public Student(String id, String firstName, String lastName, String eyeColor, int monthsEmployed) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eyeColor = eyeColor;
		this.monthsEmployed = monthsEmployed;
		classRoster.add(this);
		database.put(this.id, this);
	}

	public Student() {

	}

	public void addToRoster(Student student) {
		classRoster.add(student);
	}
	
	private void printStudent(Student student) {
		
		System.out.println(String.format("%-6s", student.id) + "    " + String.format("%-16s", student.firstName) + "   "
				+ String.format("%-16s", student.lastName) + "   " + String.format("%-9s", student.eyeColor) + "   "
				+ String.format("%8s", student.monthsEmployed));
	}

	public void printClassRoster() {
		
		Student s1 = new Student("001122", "Michael", "Clair", "Other", 12);
		Student s2 = new Student("001112", "Stephen", "Rook", "Brown", 11);
		Student s3 = new Student("005295", "Kyle", "Deen", "Blue", 2);
		Student s4 = new Student("004400", "Kevin", "Tran", "Other", 12);
		Student s5 = new Student("474143", "Jonathan", "Stafford", "Brown", 13);
		
		Student s6 = new Student("132617", "Reuben", "Turner", "Blue", 12);
		Student s7 = new Student("306700", "Li", "Lui", "Brown", 12);
		Student s8 = new Student("215296", "Joshua", "Franey", "Other", 27);
		Student s9 = new Student("523420", "Gabriel", "Hamilton", "Other", 10);
		Student s10 = new Student("001014", "Aisha", "Covington", "Brown", 10);
		
		Student s11 = new Student("006789", "Arun", "Soma", "Brown", 2);
		Student s12 = new Student("009999", "Steve", "Ellwood", "Other", 2);
		Student s13 = new Student("343769", "Shaquil", "Timmons", "Brown", 11);
		Student s14 = new Student("001449", "Karen", "Reiter", "Blue", 10);
		Student s15 = new Student("267252", "Dax", "Richards", "Brown", 12);
		
		Student s16 = new Student("229949", "Mike", "Sykes", "Brown", 13);
		Student s17 = new Student("772223", "Daniel", "Kiros", "Brown", 3);
		Student s18 = new Student("004444", "Peter", "Choi", "Brown", 2);
		Student s19 = new Student("005255", "Joe", "Hill", "Brown", 13);
		Student s20 = new Student ("008888", "Evan", "Tizard", "Brown", 12);

		System.out.println("----------PART 2----------");
		System.out.println("Student class roster");
		System.out.println();
		System.out.println("Empl Id   First name         Last name          Eye color   Months at SSA");
		System.out.println("=======   ================   ================   =========   =============");
		
		Collections.sort(classRoster, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				return student1.firstName.compareTo(student2.firstName);
			}
		});

		for (Student student : classRoster) {

			System.out.println(String.format("%-6s", student.id) + "    " + String.format("%-16s", student.firstName) + "   "
					+ String.format("%-16s", student.lastName) + "   " + String.format("%-9s", student.eyeColor) + "   "
					+ String.format("%8s", student.monthsEmployed));
		}
		System.out.println();
		
		System.out.println("----------PART 3----------");
		System.out.println("Empl Id   First name         Last name          Eye color   Months at SSA");
		System.out.println("=======   ================   ================   =========   =============");
		
		Collections.sort(classRoster, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				return student1.id.compareTo(student2.id);
			}
		});
		
		for (int student = 0; student < classRoster.size(); student++) {

			if ( classRoster.get(student).firstName.equals("Kyle") ) {
				
				Student studentBefore = database.get(classRoster.get(student - 1).id);
				Student me = database.get(classRoster.get(student).id);
				Student studentAfter = database.get(classRoster.get(student + 1).id);
				
				printStudent(studentBefore);
				printStudent(me);
				printStudent(studentAfter);

			}
			
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eyeColor == null) ? 0 : eyeColor.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + monthsEmployed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (eyeColor == null) {
			if (other.eyeColor != null)
				return false;
		} else if (!eyeColor.equals(other.eyeColor))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (monthsEmployed != other.monthsEmployed)
			return false;
		return true;
	}
	
	

}
