package com.tka.OrganizationalWorkFlow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationalWorkFlow.entity.Country;
import com.tka.OrganizationalWorkFlow.entity.Employee1;
import com.tka.OrganizationalWorkFlow.service.MainService;


@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;
	
	
	//POST...localhost:8081/api/AddCountry...BODY...RAW...JSON...{"cname":"INDIA"}
//	@PostMapping("AddCountry")
//	public String addCountry(@RequestBody Country c)
//	{
//		String str=service.addCountry(c);
//		return str;
//	}
	//POST..localhost:8081/api/AddCountry..body..raw..json..{"cname":"Japan"}
	@PostMapping("AddCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c)
	{
		String str=service.addCountry(c);
		return ResponseEntity.ok(str);//to send status code along with msg
	}

	
	//PUT..localhost:8081/api/UpdateCountry/5..body..raw..{"cname":"Russia"}
	@PutMapping("UpdateCountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c,@PathVariable int id)
	{
		String str=service.updateCountry(c,id);
		return ResponseEntity.ok(str);//to send status code along with msg
	}
	
	//DELETE ..localhost:8081/api/DeleteCountry/2
	@DeleteMapping("DeleteCountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable int id)
	{
		String str=service.deleteCountry(id);
		return ResponseEntity.ok(str);//to send status code along with msg
	}

	//GET..localhost:8081/api/GetAllCountry
	@GetMapping("GetAllCountry")
	public ResponseEntity<List> getAllCountry()
	{
		List<Country> list=service.getAllCountry();
		return ResponseEntity.ok(list);//to send status code along with msg
	}
	
	//GET..localhost:8081/api/GetCountryById/1
	@GetMapping("GetCountryById/{cid}")
	public ResponseEntity<Country> getparticularCountryById(@PathVariable int cid)
	{
		Country c=service.getparticularCountryById(cid);
		return ResponseEntity.ok(c);//to send status code along with msg
	}
	
	
	//POST..localhost:8081/api/AddEmployee
	@PostMapping("AddEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee1 e)
	{
	
		String str=service.addEmployee(e);
		return ResponseEntity.ok(str);//to send status code along with msg
	}
	
	//PUT...localhost:8081/api/UpdateEmployee/1
	@PutMapping("UpdateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee1 e,@PathVariable int id)
	{
		String str=service.updateEmployee(e,id);
		return ResponseEntity.ok(str);//to send status code along with msg
	}
	//DELETE ..localhost:8081/api/DeleteEmployee/4..none
	@DeleteMapping("DeleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		String str=service.deleteEmployee(id);
		return ResponseEntity.ok(str);//to send status code along with msg
	}
	
	//GET...localhost:8081/api/GetEmployeeById/1
	@GetMapping("GetEmployeeById/{cid}")
	public ResponseEntity<Employee1> getparticularEmployeeById(@PathVariable int cid)
	{
	Employee1 e1=service.getparticularEmployeeById(cid);
		return ResponseEntity.ok(e1);//to send status code along with msg
	}
	
	//GET..localhost:8081/api/GetAllEmployee
	@GetMapping("GetAllEmployee")
	public ResponseEntity<List> getAllEmployee()
	{
		List<Employee1> list=service.getAllEmployee();
		return ResponseEntity.ok(list);//to send status code along with msg
	}
	
	
	//localhost:8081/api/login
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee1 e)
	{
		Map map= service.login(e);
		return ResponseEntity.ok(map);
	}

	
	//GET..localhost:8081/api/getEmployeeBySalary/ 50000/ 80000
	@GetMapping("getEmployeeBySalary/{min}/{max}")
    public ResponseEntity<List> getEmployeesBySalaryRange(
            @PathVariable Double min, 
            @PathVariable Double max) {
        List<Employee1> list= service.getEmployeesBySalaryRange(min, max);
        return ResponseEntity.ok(list);
    }
	
	//GET...localhost:8081/api/GetEmployeeByStatus/active
	
		@GetMapping("GetEmployeeByStatus/{status}")
	    public ResponseEntity<List> getEmployeesByStatus(@PathVariable String status) {
			 return ResponseEntity.ok(service.getEmployeesByStatus(status));
	    }
		
}

//JSON FIle for AddEmployee and UpdateEmployee
//{
//
//    "name":"Sumit Sir",
//    "mobileno":"9960556000",
//    "emailid":"kiran@thekiranacademy.com",
//    "salary":"80000",
//    "department":"DevOps",
//    "status":"Active",
//    "createdBy":"admin",
//    "createdDate":"2024-10-20T18:30:00.000+00:00",
//    "updatedBy":"admin",
//    "updatedDate":"2024-10-20T18:30:00.000+00:00",
//    "country":{
//        "cid":"6",
//        "cname":"Japan"
//    }
//}


//To Update..JSON
//{
//
//    "name":"Sumit Sir",
//    "mobileno":"9800556397",
//    "emailid":"sumit@thekiranacademy.com"
//   
//}

//JSON for login
//{
//    "emailid":"modi@thekiranacademy.com",
//    "mobileno":"9860556000"
//}

