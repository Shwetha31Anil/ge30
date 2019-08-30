

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository {
	static List<Employee> employees = new ArrayList<>();
	
	static {
		try {
			setEmployeeDetails();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setEmployeeDetails() throws ParseException {
		Department d=new Department(201,"development",101);
		Department d1=new Department(202,"tseting",102);
		
			employees.add(new Employee(101, "Harsha","Savanth", "harsha.savanth@gmail.com", "25463215", LocalDate.of(2018, 04, 01), "developer",23000,
					101,d ));
			employees.add(new Employee(102, "Shreyamsh","Gowda", "shreyamsh.gowda@gmail.com", "41263215", LocalDate.of(2018, 11, 21), "developer",23000,
					101, d));
			employees.add(new Employee(103, "Sameer","Simha", "sameersimha@gmail.com", "25466615", LocalDate.of(2018, 10, 18), "developer",23000,
					101, d));
			employees.add(new Employee(104, "Deemanth","Ayyappa", "deemanthayyapa@gmail.com", "2163215", LocalDate.of(2018, 1, 21), "tester",25000,
					102, d1));
			employees.add(new Employee(105, "Chetan","Gowda", "chetangowwda@gmail.com", "29661215", LocalDate.of(2018, 11, 21), "tester",25000,
					102, d1));
			employees.add(new Employee(106, "Arun","Kumar", "arunkumar@gmail.com", "2326615", LocalDate.of(2018, 11, 21), "tester",25000,
					0, d1));
			
		
	}
	
	public static List<Employee> getEmployees() {
		return employees;
	}

				
	

	
}
