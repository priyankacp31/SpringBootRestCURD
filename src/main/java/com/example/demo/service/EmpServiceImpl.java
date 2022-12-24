package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	@Override
	public Emp saveEmployee(Emp emp) {

		return empRepository.save(emp);


	}

	@Override
	public List<Emp> getAllEmployees() {

		return empRepository.findAll();
	}

	@Override
	public Emp getEmpById(long id) {
		Optional<Emp> emp=empRepository.findById(id);

		if(emp.isPresent())
		{
			return emp.get();
		}
		else
		{
			throw new ResourceNotFoundException("Emp", "Id", emp);
		}

	}

	@Override
	public Emp updateEmp(Emp emp, long id) {
		Emp existingEmp= empRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Emp", "Id", id));

		existingEmp.setFname(emp.getFname());
		existingEmp.setLname(emp.getLname());
		existingEmp.setEmail(emp.getEmail());

		empRepository.save(existingEmp);

		return existingEmp;
	}

	
	public void deleteEmp(long id) {
	
		empRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Emp", "Id", id));
		empRepository.deleteById(id);
	}


}
