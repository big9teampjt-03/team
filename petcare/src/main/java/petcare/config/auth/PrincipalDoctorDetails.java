package petcare.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import petcare.model.Doctor;
import petcare.repository.DoctorRepository;

@Service
public class PrincipalDoctorDetails implements UserDetailsService {
	@Autowired
	private DoctorRepository dRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loaduserByUsername");
		Doctor doc = dRepository.findByUsername(username);
		if(doc==null) return null;
		PrincipalDoctor pDoctor = new PrincipalDoctor(doc);
		System.out.println("pDoctor:"+pDoctor);
		return pDoctor;
	}

}
