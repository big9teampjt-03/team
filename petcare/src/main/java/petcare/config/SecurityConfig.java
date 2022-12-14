package petcare.config;

public class SecurityConfig {
	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Bean
		public BCryptPasswordEncoder encodePwd() {
			return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable();
			http.authorizeRequests()
				.antMatchers("/admin/*").authenticated()
				.antMatchers("/doctor/*").authenticated()
				.antMatchers("/member/*").permitAll()
				.anyRequest()
				.permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/loginPro")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
		}
	}
}
