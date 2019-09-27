package com.mphasis.training.daos;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;

import com.mphasis.training.beans.Employee;
import com.mphasis.training.conf.HibernateUtil;


public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory sessionFactory;
	public EmployeeDaoImpl() {
		//Configuration con=new Configuration().configure().addAnnotatedClasses(Account)
																.addAnnotatedClasses(Employee.class);
																
		//sessionFactory=con.buildSessionFactory();
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	@Override
	public void addEmployee(Employee e) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.save(e);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.update(e);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int eid) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Employee e=(Employee) session.get(Employee.class, eid);
			session.delete(e);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public Employee getEMployeeById(int eid) {
		Employee e=null;
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			e=(Employee) session.get(Employee.class,eid);
			tr.commit();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}

	public int callProcedure(int emp_id,int salary_inc) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();

		ProcedureCall query =  
session.createStoredProcedureCall("emp_salary_increase",Employee.class);
        query.registerParameter(
            "emp_id", Integer.class, ParameterMode.IN)
        .bindValue(emp_id);
     query.registerParameter(
            "salary_inc", Integer.class, ParameterMode.INOUT)
     .bindValue(salary_inc);

ProcedureOutputs procedureResult=query.getOutputs();
int salary_inc1= (int) 
procedureResult.getOutputParameterValue("salary_inc");
tr.commit();
return salary_inc1;	
	}
	
	
	@Override
	public List<Employee> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Employee>	employees=
		session.createCriteria(Employee.class).list();
		tr.commit();
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Employee>	employees=
		session.createCriteria(Employee.class)
		.add(Restrictions.eq("empName", name)).list();
		tr.commit();
		return employees;
	}

	@Override
	public List<Employee> getEMployeeBySal(int sal) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Employee>	employees=
		session.createCriteria(Employee.class)
		.add(Restrictions.eq("salary", sal
				)).list();
		tr.commit();
		return employees;
	}

}
