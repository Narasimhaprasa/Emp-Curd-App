package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOpertionsController {
	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeOpertionsController.showHome()");
		// return Logical View Name
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeOpertionsController.showEmployeeReport()");
		// use service
		List<Employee> list = service.getAllEmployees();
		//put the results in model attributes
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.showAddEmployeeForm()");
		 emp.setJob("CLERK");
		 return "employee_register";
	}
	@PostMapping("/add")
	public String addEmployee(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.addEmployee()");
		//use service
		String result = service.registerEmployee(emp);
		System.out.println(result);
		List<Employee> list = service.getAllEmployees();
		System.out.println(list);
		//keep results in model attributes
		map.put("resultMsg", result);
		map.put("empsData", list);
		 
		//return LVN
		return "employee_report";
	}
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.showEditEmployeeForm()");
		System.out.println("Number::"+no);
	 //get Employee details dynamically based on the given emp no
		Employee emp1 = service.getEmployeeByNo(no);
		System.out.println("Emp1="+emp1);
		System.out.println("EMP="+emp);
		//emp=emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		System.out.println("EmployeeOpertionsController.editEmployee()");
		System.out.println("emp="+emp);
		//use service
		String msg=service.editEmployee(emp);
		List<Employee> list = service.getAllEmployees();
		//keep results in model attributes
		map.put("resultMsg",msg);
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,Map<String,Object> map) {
		System.out.println("EmployeeOpertionsController.deleteEmployee()");
		//use service
		System.out.println("Number::"+no);
		String msg = service.deleteEmployee(no);
		List<Employee> list = service.getAllEmployees();
		//keep results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return lVN
		return "employee_report";
	}
}//class
