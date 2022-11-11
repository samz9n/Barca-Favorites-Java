package fi.haagahelia.barcafavoritesbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.barcafavoritesbackend.domain.User;
import fi.haagahelia.barcafavoritesbackend.domain.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private final UserRepository repository;

	@Autowired
	public UserDetailService(UserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username);
		if (curruser == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}