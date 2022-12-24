package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Emp;

//JpaRepository<Emp, Long> ==>1st para is type of entity, 2nd para is type of primary key
// for this interface no need to add @Repository & @Transcational annotation bcoz 
//JpaRepository internally provides @Repository
public interface EmpRepository extends JpaRepository<Emp, Long>{

}
