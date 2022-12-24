package hello.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import hello.model.Doctor;
import hello.model.User;
import hello.repository.DoctorRepository;

@Service
@Transactional(readOnly = true)
public class DoctorService {
	
	@Autowired
	private DoctorRepository dRepository;
	
	@Transactional
	public void insert(Doctor doctor) {
		dRepository.insert(
				doctor.getDocname(),
				doctor.getDoclicensenum(),
				doctor.getDochospital(),
				doctor.getDochospitaltel(),
				doctor.getDochospitaladdr(),
				doctor.getDochospitalpostal(),
				doctor.getUser().getUserid(),
				doctor.getRole().DOCTOR.toString(),
				doctor.getRegdate());
	}

	public List<Doctor> list() {
		return dRepository.findAll();
	}
	
	public Doctor docdetail(Long doctorid) {
		return dRepository.findById(doctorid).get();
	}
	
	@Transactional
	public void docupdate(Doctor doctor) {
		Doctor d = dRepository.findById(doctor.getDoctorid()).get();
		d.setDocname(doctor.getDocname());
		d.setDoclicensenum(doctor.getDoclicensenum());
		d.setDochospital(doctor.getDochospital());
		d.setDochospitaltel(doctor.getDochospitaltel());
		d.setDochospitaladdr(doctor.getDochospitaladdr());
		d.setDochospitalpostal(doctor.getDochospitalpostal());
		d.setApproval(0);
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
