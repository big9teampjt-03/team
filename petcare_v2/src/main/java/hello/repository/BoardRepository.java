package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.model.Doctor;

public interface BoardRepository
	extends JpaRepository<Doctor, Long>{


}
