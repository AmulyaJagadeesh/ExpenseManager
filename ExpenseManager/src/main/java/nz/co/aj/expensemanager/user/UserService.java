package nz.co.aj.expensemanager.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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
	ModelMapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDTO> findAllUsers()
	{
		List<UserDTO> users = new ArrayList<>();
		Iterator<User> iterator = userRepository.findAll().iterator();
		while( iterator.hasNext() )
		{
			users.add(convertToDto(iterator.next()));
		}
		return users;
	}
	
	public void createUser( UserDTO user )
	{
		userRepository.save(convertToEntity(user));
	}

	public UserDTO findById( Long userId )
	{
		Optional<User> userOptional = userRepository.findById(userId);
		if( userOptional.isPresent() )
		{
			return convertToDto(userOptional.get());
		}
		return null;
	}

//	@Override
//	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private UserDTO convertToDto( User user )
	{
		UserDTO userDTO = mapper.map(user, UserDTO.class );
		return userDTO;
	}

	private User convertToEntity( UserDTO userDTO )
	{
		User user = mapper.map(userDTO, User.class );
		return user;
	}

}
