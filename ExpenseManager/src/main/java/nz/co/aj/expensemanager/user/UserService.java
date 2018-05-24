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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService 
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

	public UserDTO login( UserDTO user )
	{
		User userLoggedIn = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if( userLoggedIn != null )
		{
			return convertToDto(userLoggedIn);
		}
		return null;
	}

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
