package com.tcampest.curriculum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tcampest.curriculum.domain.User;
import com.tcampest.curriculum.repository.UserRepository;
import com.tcampest.curriculum.security.model.SimplyUserDetails;


@Component
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			UserDetails details = new SimplyUserDetails(user.getLogin(),user.getPassword(), user.getGrantedAuthorities());
			return details;
		}
	}

}
