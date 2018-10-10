package com.StudentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentRoster.models.Dorm;
import com.StudentRoster.models.Student;
import com.StudentRoster.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepo;
	
	public DormService(DormRepository dormRepo) { this.dormRepo = dormRepo; }
	
	// create a new dorm
	public Dorm createDorm(Dorm dorm) { return this.dormRepo.save(dorm); }
	
	// retrieves all the dorms
	public List<Dorm> findAllDorms(){ return this.dormRepo.findAll(); }
	
	// retrieves a dorm by id
	public Dorm findDormById(Long id) {
		Optional<Dorm> response = this.dormRepo.findById(id);
		if(response.isPresent()) {
			return response.get();
		}else {
			return null;
		}
	}
	
	// add student to dorm
	public Dorm addStudentToDorm(Dorm dorm, Student student) {
		student.setDorm(dorm);
		return this.dormRepo.save(dorm);
	}
}
