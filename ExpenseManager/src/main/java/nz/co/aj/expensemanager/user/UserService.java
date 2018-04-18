package nz.co.aj.expensemanager.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService 
//implements UserDetailsService 

{
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers()
	{
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach( users::add );
		return users;
	}
	
	public void createUser( User user )
	{
		userRepository.save(user);
	}

	public User findById( Long userId )
	{
		User user = null;
		Optional<User> userOptional = userRepository.findById(userId);
		if( userOptional.isPresent() )
		{
			user = userOptional.get();
		}
		return user;
	}

//	@Override
//	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
