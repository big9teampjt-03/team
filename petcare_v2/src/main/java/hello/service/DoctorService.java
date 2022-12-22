package hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Doctor;
import hello.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository dRepository;
	
	@Transactional
	public void insert(Doctor doctor) {
		dRepository.insert(
				doctor.getDochospital(),
				doctor.getDochospitaladdr(),
				doctor.getDochospitalpostal(),
				doctor.getDochospitaltel(),
				doctor.getDoclicensenum(),
				doctor.getDocname(),
				doctor.getUser().getUserid(),
				doctor.getRole().DOCTOR.toString(),
				doctor.getRegdate());
	}

	public List<Doctor> list() {
		return dRepository.findAll();
	}
	
	public Doctor detail(Long doctorid) {
		return dRepository.findById(doctorid).get();
	}
	
	@Transactional
	public void successappr(Doctor doctor) {
		Doctor d = dRepository.findById(doctor.getDoctorid()).get();
		d.setApproval(1);
	}

	@Transactional
	public void failappr(Doctor doctor) {
		Doctor d = dRepository.findById(doctor.getDoctorid()).get();
		d.setApproval(2);
	}
	
	@Transactional
	public void drop(Doctor doctor) {
		Doctor d = dRepository.findById(doctor.getDoctorid()).get();
		d.setApproval(3);
	}
	
}
