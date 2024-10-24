package com.tka.OrganizationalWorkFlow.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationalWorkFlow.entity.Country;
import com.tka.OrganizationalWorkFlow.entity.Employee1;
import com.tka.OrganizationalWorkFlow.service.Employee;
@Repository
public class MainDAO {

		@Autowired
		SessionFactory factory;//org.hibernate

		public String addCountry(Country c) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				s.persist(c);
				tx.commit();
				msg="Country added";
				
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
			}

		public String updateCountry(Country c,int id) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				
				Country c1=s.get(Country.class,id);
				c1.setCname(c.getCname());
				s.merge(c1);

				tx.commit();
				msg="Country Updated";
				
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
			}

		public String deleteCountry(int id) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				
				Country country=s.get(Country.class,id);
				s.remove(country);
				tx.commit();

				msg="Country Deleted";
				
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
			}

		public List<Country> getAllCountry() {
			String msg=null;
			List<Country> list=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				String hql="from Country";
				Query<Country> query=s.createQuery(hql,Country.class);
				list=query.list();
				tx.commit();	
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return list;
		}
		
		public Country getparticularCountryById(int cid) {
			Session session=null;
			Transaction tx=null;
			Country country=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				country=session.get(Country.class, cid);
				tx.commit();			
				
			}catch (Exception e) {
				// TODO: handle exception
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return country;
		}

		public String addEmployee(Employee1 e) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				s.persist(e);
				tx.commit();
				msg="Employee added";
				
			}
			catch(Exception ex)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
		}

		//PUT...localhost:8081/api/UpdateEmployee/2
		public String updateEmployee(Employee1 emp, int id) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				
				Employee1 e1=s.get(Employee1.class,id);
				e1.setName(emp.getName());
				e1.setMobileno(emp.getMobileno());
				e1.setEmailid(emp.getEmailid());
				s.merge(e1);

				tx.commit();
				msg="Employee Updated";
				
			}
			catch(Exception ex)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
		}

		public String deleteEmployee(int id) {
			String msg=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				
				Employee1 e1=s.get(Employee1.class,id);
				s.remove(e1);
				tx.commit();

				msg="Employee Deleted";
				
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return msg;
		}

		public Employee1 getparticularEmployeeById(int id) {
			Session session=null;
			Transaction tx=null;
			Employee1 emp=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				emp=session.get(Employee1.class, id);
				tx.commit();			
				
			}catch (Exception e) {
				// TODO: handle exception
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return emp;
		}

		public List<Employee1> getAllEmployee() {
			String msg=null;
			List<Employee1> list=null;
			Session s=null;//org.hibernate
			Transaction tx=null;//org.hibernate
			try
			{
				s=factory.openSession();
				tx=s.beginTransaction();
				String hql="from Employee1";
				Query<Employee1> query=s.createQuery(hql,Employee1.class);
				list=query.list();
				tx.commit();	
			}
			catch(Exception e)
			{
				if(tx!=null)
				{
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}		
			return list;
		}

		public Employee1 login(Employee1 e) {
			
				Session session=null;
				Transaction tx=null;
				Employee1 emp=null;
				try {
					
					session=factory.openSession();
					tx=session.beginTransaction();
					String hqlQuery="from Employee1 where emailid=:emailid and mobileno=:mobileno";
					
					Query<Employee1> query= session.createQuery(hqlQuery,Employee1.class);
					query.setParameter("emailid", e.getEmailid());
					query.setParameter("mobileno", e.getMobileno());
					
					emp= query.uniqueResult();
					tx.commit();
					
				}
					catch (Exception e1) {
						if(tx!=null) {
							tx.rollback();
						}
						e1.printStackTrace();
						
					}finally {
						
						if(session!=null) {
							session.close();
						}
						
					}
				return emp;
				
			}


		public List<Employee1> getEmployeesBySalaryRange(Double min, Double max) {
			Session session=null;
			Transaction tx=null;
			List<Employee1> list=null;
			try {
				
				session=factory.openSession();
				tx=session.beginTransaction();
		        String hql = "from Employee1 where salary between :min and :max";
		        Query<Employee1> query = session.createQuery(hql, Employee1.class);
		        query.setParameter("min", min);
		        query.setParameter("max", max);
		        list=query.list();
			}
			catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
				
			}finally {
				
				if(session!=null) {
					session.close();
				}
				
			}
		return list;
		
	}

		public List<Employee1> getEmployeesByStatus(String status) {
			
			Session session=null;
			Transaction tx=null;
			List<Employee1> list=null;
			try {
				
				session=factory.openSession();
				tx=session.beginTransaction();
	        String hql = "from Employee1 where status = :mystatus";
	        Query<Employee1> query = session.createQuery(hql, Employee1.class);
	        query.setParameter("mystatus", status);
	        list=query.list();
			}
			catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
				
			}finally {
				
				if(session!=null) {
					session.close();
				}
				
			}
		return list;
		      

		}
		
		public String updateEmployeeStatus(Long empId) {
			String msg=null;
			Session s=null;
			Transaction tx=null;
			 Employee1 employee ;
			 
			 String newStatus=null;
			try
			{
				// TODO Auto-generated method stub
				s=factory.openSession();
				tx=s.beginTransaction();
			

		      employee= s.get(Employee1.class, empId);
	        
	        if (employee == null) {
	            msg= "Employee not found";
	        }
	        else
	        {
	        	
        if ("Suspended".equals(employee.getStatus())) {
	            msg= "Cannot be updated";
	        }
	        newStatus = "Active".equalsIgnoreCase(employee.getStatus()) ? "Inactive" : "Active";
	        employee.setStatus(newStatus);
	        }
	        s.merge(employee);
			tx.commit();
	        msg="Status updated to " + newStatus;
			}
			
			catch(Exception e)
			{
				if(tx!=null)
				{
					e.printStackTrace();
					tx.rollback();
				}
			}
			finally {
				if(s!=null)
				{
					s.close();
				}
			}
			return msg;
	    
	}
}







