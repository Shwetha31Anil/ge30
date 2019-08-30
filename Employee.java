

import java.time.LocalDate;
import java.util.Date;

public class Employee {
	private int employeeId;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenummber;
	private LocalDate hireDate;
	private String designation;
	static double salary;
	private int managerId;
	Department department;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String firstname, String lastname, String email, String phonenummber,
			LocalDate hireDate, String designation, double salary, int managerId, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenummber = phonenummber;
		this.hireDate = hireDate;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPhonenummber() {
		return phonenummber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhonenummber(String phonenummber) {
		this.phonenummber = phonenummber;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public int getManagerId() {
		return managerId;
	}
	public Department getDepartment() {
		return department;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phonenummber=" + phonenummber + ", hireDate=" + hireDate + ", designation=" + designation
				+ ", salary=" + salary + ", managerId=" + managerId + ", department=" + department + "]";
	}
	
	
	
}