package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("api/employees")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@PostMapping
	public ResponseEntity<Emp> saveEmp(@RequestBody Emp emp)
	{
		return new ResponseEntity<Emp>(empService.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Emp> getAllEmployees()
	{
		return empService.getAllEmployees();
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable long id)
	{
		return new ResponseEntity<Emp>(empService.getEmpById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable long id, @RequestBody Emp emp)
	{
		return new ResponseEntity<Emp>(empService.updateEmp(emp, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable long id, @RequestBody Emp emp)
	{
		return new ResponseEntity<String>("Employee recored deleted..!!!!", HttpStatus.OK);
		
	}
}
