package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Doctor;
import hello.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository bRepository;

	public List<Doctor> list() {
		return bRepository.findAll();
	}
	
	public Doctor docdetail(Long doctorid) {
		return bRepository.findById(doctorid).get();
	}

}
