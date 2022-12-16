package petcare.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import petcare.model.Admin;

@Getter
public class PrincipalAdmin implements UserDetails {

	private Admin ad;

	public PrincipalAdmin(Admin ad) {
		this.ad = ad;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(()->{
			return ad.getRole().toString();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return ad.getPassword();
	}

	@Override
	public String getUsername() {
		return ad.getUsername();
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
