package com.mphasis.training.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mphdepartment")
public class Department {
	
	@Id
	private int deptid;
	@Column(name="dname", length=45, unique=true)
	private String dname;
	@Transient
	private String loc;
	@OneToMany()
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", dname=" + dname + ", employees=" + employees + "]";
	}
	

}
