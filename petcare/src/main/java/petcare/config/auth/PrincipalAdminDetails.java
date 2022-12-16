package petcare.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import petcare.model.Admin;
import petcare.repository.AdminRepository;

@Service
public class PrincipalAdminDetails implements UserDetailsService {
	@Autowired
	private AdminRepository aRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loaduserByUsername");
		Admin ad = aRepository.findByUsername(username);
		if(ad==null) return null;
		PrincipalAdmin pAdmin = new PrincipalAdmin(ad);
		System.out.println("pAdmin:"+pAdmin);
		return pAdmin;
	}

}
