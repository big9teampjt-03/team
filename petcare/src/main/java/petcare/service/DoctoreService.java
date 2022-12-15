package petcare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import petcare.model.Doctor;
import petcare.repository.DoctorRepository;


@Service
public class DoctoreService {

	@Autowired
	private DoctorRepository Repository;
	
	
	
	public Doctor detail(Long doctor_id) {
		return Repository.findById(doctor_id).get();
	}
	
	/*
	 * public List<User>list(){ return userRepository.findAll();//findAll은 전체를 보게하는
	 * 함수 이름. 내장되어있음 } }
	 */
	 
	
	  public Page<Doctor> findAll(Pageable pageable) {  
	Page<Doctor> doctor = Repository.findAll(pageable);// 아무 검색 없을때
	  return doctor; 
	  }
	 
}
