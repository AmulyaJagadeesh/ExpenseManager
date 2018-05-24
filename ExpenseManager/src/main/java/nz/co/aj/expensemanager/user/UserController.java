package nz.co.aj.expensemanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping( method=RequestMethod.POST, value="/registration" )
	public void createUser( @RequestBody UserDTO user )
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.createUser(user);
	}
	
	@GetMapping( value="/users" )
	public List<UserDTO> findAllUsers( )
	{
		return userService.findAllUsers();
	}
	
	@GetMapping( value="/users/{userId}" )
	public UserDTO findUser( @PathVariable Long userId )
	{
		return userService.findById(userId);
	}
	
	
}
