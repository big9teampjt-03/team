package petcare.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import petcare.model.Member;
import petcare.model.Role;

@Getter
public class PrincipalMember implements UserDetails {

	private Member mb;

	public PrincipalMember(Member mb) {
		this.mb = mb;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(()->{
			return mb.getRole().toString();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return mb.getPassword();
	}

	@Override
	public String getUsername() {
		return mb.getUsername();
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
