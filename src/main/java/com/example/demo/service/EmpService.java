package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Emp;

public interface EmpService {

	Emp	saveEmployee(Emp emp);

	List<Emp> getAllEmployees();
	
	Emp getEmpById(long id);
	
	Emp updateEmp(Emp emp,long id);
	
	void deleteEmp(long id);
}
