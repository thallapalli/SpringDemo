package com.kt.spring.demo.springdemo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.kt.spring.demo.springdemo.entity.Account;
import com.kt.spring.demo.springdemo.entity.Department;
import com.kt.spring.demo.springdemo.entity.Hero;
import com.kt.spring.demo.springdemo.repository.AccountRepository;
import com.kt.spring.demo.springdemo.repository.DepartmentRepository;
import com.kt.spring.demo.springdemo.repository.HeroRepository;



@RestController
public class SpringDemoController {
	Logger logger = LoggerFactory.getLogger(SpringDemoController.class);
	
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	HeroRepository heroRepository;
	@PutMapping("/springdemo/hr/department/save")
	public Department saveDepartment(@RequestBody Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#saveAll(java.lang.Iterable)
	 */
	@PutMapping("/springdemo/hr/department/saveall")
	public Iterable<Department> saveAll(@RequestBody List<Department> departments) {
		// TODO Auto-generated method stub
		return departmentRepository.saveAll(departments);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	
	@GetMapping("/springdemo/hr/department/{id}/detail")
	public Optional<Department> findById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}
	@GetMapping("/springdemo/hr/account/{username}/detail")
	public Account findByUsername(@PathVariable String  username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}
	//@GetMapping("/springdemo/hr/account/findByusernameandpassword")
	@GetMapping("/springdemo/hr/account/{username}/{password}/findByusernameandpassword")
	//public Account findByUsernameAndPassword(@RequestParam Map<String,String> mapOfRequest) {
	public Account findByUsernameAndPassword(@PathVariable String username,@PathVariable  String password) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsernameAndPassword(username,password);
		//return accountRepository.findByUsernameAndPassword(mapOfRequest.get("username"),mapOfRequest.get("password"));
	}
	
	@PutMapping("/springdemo/hr/account/save")
	public Account saveAll(@RequestBody Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@PostMapping("/springdemo/hr/account/update")
	public Account updateAccount(@RequestBody Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#existsById(java.lang.Object)
	 */
	@GetMapping("/springdemo/hr/department/{id}/isexists")
	public boolean existsById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.existsById(id);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@GetMapping("/springdemo/hr/department/findall")
	public Iterable<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}
	@GetMapping("/springdemo/hr/heros/all")
	public Iterable<Hero> findAllHeros() {
		// TODO Auto-generated method stub
		return heroRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAllById(java.lang.Iterable)
	 */
	
	@GetMapping("/springdemo/hr/department/findallbyids")
	
	public  Iterable<Department> findAllById(@RequestPart Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return departmentRepository.findAllById(ids);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@GetMapping("/springdemo/hr/department/count")
	public  long count() {
		// TODO Auto-generated method stub
		return departmentRepository.count();
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	
	@DeleteMapping("/springdemo/hr/department/{id}/delete")
	public  void deleteById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@DeleteMapping("/springdemo/hr/department/delete")
	public  void delete(@RequestBody Department department) {
		// TODO Auto-generated method stub
		departmentRepository.delete(department);
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)
	 */
	
	public  void deleteAll(Iterable<? extends Department> departments) {
		// TODO Auto-generated method stub
		departmentRepository.deleteAll(departments);
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@DeleteMapping("/springdemo/hr/department/deleteall")
	public  void deleteAll() {
		// TODO Auto-generated method stub
		departmentRepository.deleteAll();
		
		
	}


}
