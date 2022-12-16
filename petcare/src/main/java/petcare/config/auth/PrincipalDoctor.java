package petcare.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import petcare.model.Doctor;

@Getter
public class PrincipalDoctor implements UserDetails {
	
	private Doctor doc;

	public PrincipalDoctor(Doctor doc) {
		this.doc = doc;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(()->{
			return doc.getRole().toString();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return doc.getPassword();
	}

	@Override
	public String getUsername() {
		return doc.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
