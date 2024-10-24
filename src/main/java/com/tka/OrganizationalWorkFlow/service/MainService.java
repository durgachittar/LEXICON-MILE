package com.tka.OrganizationalWorkFlow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationalWorkFlow.DAO.MainDAO;
import com.tka.OrganizationalWorkFlow.entity.Country;
import com.tka.OrganizationalWorkFlow.entity.Employee1;

@Service
public class MainService {
	
	@Autowired  
	MainDAO dao;
	public  String addCountry(Country c) {
		
			
			String str=dao.addCountry(c);
			if(Objects.isNull(str))
			{
				str="Country not added";
			}
			return str;
	
	}
	
	public String updateCountry(Country c,int id) {
		String str=dao.updateCountry(c,id);
		if(Objects.isNull(str))
		{
			str="Country not updated";
		}
		return str;

	}
	public String deleteCountry(int id) {
		String str=dao.deleteCountry(id);
		if(Objects.isNull(str))
		{
			str="Country not deleted";
		}
		return str;
	}
	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry();
		return list;
	}
	public Country getparticularCountryById(int cid)
	{
		Country c=dao.getparticularCountryById(cid);
		return c;
		
	}
	
	public  String addEmployee(Employee1 e) {
		
		
		String str=dao.addEmployee(e);
		if(Objects.isNull(str))
		{
			str="Employee not added";
		}
		return str;

}

	public String updateEmployee(Employee1 e, int id) {
		String str=dao.updateEmployee(e,id);
		if(Objects.isNull(str))
		{
			str="Employee not updated";
		}
		return str;
	}

	public String deleteEmployee(int id) {
		String str=dao.deleteEmployee(id);
		if(Objects.isNull(str))
		{
			str="Employee not deleted";
		}
		return str;
	}

	public Employee1 getparticularEmployeeById(int cid) {
		Employee1 e=dao.getparticularEmployeeById(cid);
		return e;
	}

	public List<Employee1> getAllEmployee() {
		List<Employee1> list=dao.getAllEmployee();
		return list;
	}

	public Map login(Employee1 e) {
		
			Employee1 emp= dao.login(e);
			
			Map map=new HashMap();
			if(Objects.isNull(emp)) {
				map.put("msg","Invalid User");
				map.put("user", emp);
			}else {
				map.put("msg", "Valid User");
				map.put("user", emp);
			}
		
			return map;
			
		}

public List<Employee1> getEmployeesBySalaryRange(Double min, Double max)
{
	List<Employee1> list=dao.getEmployeesBySalaryRange(min, max);
	return list;
	
}

public List<Employee1> getEmployeesByStatus(String status) {
	List<Employee1> list=dao.getEmployeesByStatus(status);
	return list;
}


}
