

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService2 {

	public static void main(String[] args) {
		 List<Employee> list=EmployeeRepository.getEmployees();
		double salarySum=list.stream().mapToDouble(employee->employee.getSalary()).sum();
		System.out.println(salarySum);
		
		Map<Object, List<Employee>> deptCount=list.stream()
				.collect(Collectors.groupingBy(employee->employee.getDepartment()));
        System.out.println(deptCount);
        
        Comparator<Employee> comparator = 
        		Comparator.comparing( Employee::getHireDate );

    
        java.util.Optional<Employee> employee = list
                .stream()
                .sorted((e1, e2) -> e1.getHireDate()
                        .compareTo(e2.getHireDate())).findFirst();

        System.out.println("senior most employee of an organization"+employee.get());

	System.out.println("dispalying the list according to date");
	list.stream()
            .sorted((e1, e2) -> e1.getHireDate()
                    .compareTo(e2.getHireDate()))
            .forEach(e -> System.out.println(e));
	 
	 System.out.println("employees without department");
	 
	 List<Employee> filtered = list
			 	.stream().filter(empd-> empd.getDepartment().equals(null))
			 	.collect(Collectors.toList());
	
	
	if(filtered.isEmpty()) {
		System.out.println("employee belongs to department");
	}else {
	
		for(Employee e:filtered) {
			System.out.println(e);
		}
	}
	
	 System.out.println("department without employees");
	 System.out.println("invalid case");
	
	 
	 System.out.printf("Count of Employees by department:");  
      Map<Department, Long> counted = list.stream()
              .collect(Collectors.groupingBy(Employee::getDepartment, 
            		  Collectors.counting()));
      System.out.println(counted);
      
      System.out.println("Sort employees by FirstName");

      list.sort((Employee s1, Employee s2)->s1.getFirstname().compareTo(s2.getFirstname()));
      list.forEach((s)->System.out.println(s));  
      
      System.out.println("Sort employees by Id");

      list.sort((Employee s1, Employee s2)->s1.getEmployeeId()-s2.getEmployeeId()); 
      list.forEach((s)->System.out.println(s)); 
      
   
      System.out.println("dispalying the list according to day");
  	list.stream()
              .sorted((e1, e2) -> e1.getHireDate().getDayOfWeek()
                      .compareTo(e2.getHireDate().getDayOfWeek()))
              .forEach(e -> System.out.println(e));

  	System.out.println("comparing first name and last name both");
  	Comparator<Employee> byFirstName = (e1, e2) -> e1
            .getFirstname().compareTo(e2.getFirstname());

    Comparator<Employee> byLastName = (e1, e2) -> e1.getLastname()
            .compareTo(e2.getLastname());

    list.stream().sorted(byFirstName.thenComparing(byLastName))
            .forEach(e -> System.out.println(e));

    System.out.println("list of employees without manager");
    
    List<Employee> filtered1 = list
		 	.stream().filter(empd-> empd.getManagerId()==0)
		 	.collect(Collectors.toList());


if(filtered1.isEmpty()) {
	System.out.println("employee reports to Manager");
}else {

	for(Employee e:filtered1) {
		System.out.println(e);
	}
}

System.out.println("employees who are managers");
List<Employee> filtered2 = list
	.stream().filter(empd-> empd.getEmployeeId()==empd.getManagerId())
	.collect(Collectors.toList()); 
for(Employee e:filtered2) {
	System.out.println(e);
}

System.out.println("list of names and salary and with salary increment");
list.forEach(item->System.out.println(item.getFirstname()+" "+item.getSalary()+" increment"+item.getSalary()*1.2));


System.out.println("list of names and hiredate and day of joined");
list.forEach(item->System.out.println(item.getFirstname()+" "+item.getHireDate()+"day of joined "+item.getHireDate().getDayOfWeek()));

System.out.println("list of names and duration in company");
list.forEach(item->System.out.println(item.getFirstname()+" "
+Period.between(item.getHireDate(), LocalDate.now())));



	}
}
