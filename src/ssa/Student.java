package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

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
		database.put(this.id, this);
	}

	public Student() {
		setup();
	}
	
	//Print single student info
	private void printStudent(Student student) {
		
		System.out.println(String.format("%-6s", student.id) + "    " + String.format("%-16s", student.firstName) + "   "
				+ String.format("%-16s", student.lastName) + "   " + String.format("%-9s", student.eyeColor) + "   "
				+ String.format("%8s", student.monthsEmployed));
	}
	
	private void setup() {
		
		//Create student roster
		classRoster.add(new Student("001122", "Michael", "Clair", "Other", 12));
		classRoster.add(new Student("001112", "Stephen", "Rook", "Brown", 11));
		classRoster.add(new Student("005295", "Kyle", "Deen", "Blue", 2));
		classRoster.add(new Student("004400", "Kevin", "Tran", "Other", 12));
		classRoster.add(new Student("474143", "Jonathan", "Stafford", "Brown", 13));
		
		classRoster.add(new Student("132617", "Reuben", "Turner", "Blue", 12));
		classRoster.add(new Student("306700", "Li", "Lui", "Brown", 12));
		classRoster.add(new Student("215296", "Joshua", "Franey", "Other", 27));
		classRoster.add(new Student("523420", "Gabriel", "Hamilton", "Other", 10));
		classRoster.add(new Student("001014", "Aisha", "Covington", "Brown", 10));
		
		classRoster.add(new Student("006789", "Arun", "Soma", "Brown", 2));
		classRoster.add(new Student("009999", "Steve", "Ellwood", "Other", 2));
		classRoster.add(new Student("343769", "Shaquil", "Timmons", "Brown", 11));
		classRoster.add(new Student("001449", "Karen", "Reiter", "Blue", 10));
		classRoster.add(new Student("267252", "Dax", "Richards", "Brown", 12));
		
		classRoster.add(new Student("229949", "Mike", "Sykes", "Brown", 13));
		classRoster.add(new Student("772223", "Daniel", "Kiros", "Brown", 3));
		classRoster.add(new Student("004444", "Peter", "Choi", "Brown", 2));
		classRoster.add(new Student("005255", "Joe", "Hill", "Brown", 13));
		classRoster.add(new Student ("008888", "Evan", "Tizard", "Brown", 12));

	}

	public void printClassRoster() {
		
		//Print roster sorted alphabetically by first name
		System.out.println("----------PART 2----------");
		System.out.println("Student class roster");
		System.out.println();
		System.out.println("Empl Id   First name         Last name          Eye color   Months at SSA");
		System.out.println("=======   ================   ================   =========   =============");
		
		//Sort by first name with custom comparator
		Collections.sort(classRoster, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				return student1.firstName.compareTo(student2.firstName);
			}
		});

		//Print all student info in the roster
		for (Student student : classRoster) {

			System.out.println(String.format("%-6s", student.id) + "    " + String.format("%-16s", student.firstName) + "   "
					+ String.format("%-16s", student.lastName) + "   " + String.format("%-9s", student.eyeColor) + "   "
					+ String.format("%8s", student.monthsEmployed));
		}
		System.out.println();
		
		//Set up for part three
		System.out.println("----------PART 3----------");
		System.out.println("Empl Id   First name         Last name          Eye color   Months at SSA");
		System.out.println("=======   ================   ================   =========   =============");
		
		//Create Set of all student keys from database HashMap
		Set<String> idSet = database.keySet();
		//Create new list to hold all keys (ids)
		ArrayList<String> idList = new ArrayList<>();
		
		//Pass all keys into list for sorting
		for (String id : idSet) {
			idList.add(id);
		}
		
		//Sorry list
		Collections.sort(idList);
		
		//Iterate through list and print student before and after my id
		for (int id = 0; id < idList.size(); id++) {

			//When it finds my id...
			if ( idList.get(id).equals("005295") ) {
				
				//Save student before, myself and student after 
				Student studentBefore = database.get(idList.get(id - 1));
				Student me = database.get("005295");
				Student studentAfter = database.get(idList.get(id + 1));
				
				//Print all three students
				printStudent(studentBefore);
				printStudent(me);
				printStudent(studentAfter);

			}
			
		}
		
	}
	

}
