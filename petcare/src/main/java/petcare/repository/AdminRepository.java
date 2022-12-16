package petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import petcare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByUsername(String username);
}

