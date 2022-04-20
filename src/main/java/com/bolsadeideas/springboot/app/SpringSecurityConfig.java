package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Una anotación especialmente para spring security
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired // para poder inyectar
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = passwordEncoder();

		UserBuilder users = User.builder().passwordEncoder(password -> {
			return encoder.encode(password);
		}); // Configuración de la forma en la que se encripta la contraseña

		// Creamos los usuarios en memoria|| se asignan el nombre de usuario, contraseña
		// y roles
		builder.inMemoryAuthentication().withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
				.withUser(users.username("carlos").password("12345").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Asignando permisos de acceso a rutas
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
				.antMatchers("/ver/**").hasAnyRole("USER").antMatchers("/form/**").hasAnyRole("ADMIN")
				.antMatchers("/eliminar/**").hasAnyRole("ADMIN").antMatchers("/factura/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated();

	}

}
