package nz.co.aj.expensemanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		super();
//		this.userService = userService;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}

	@RequestMapping( method=RequestMethod.POST, value="/add" )
	public void createUser( @RequestBody UserDTO user )
	{
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.createUser(user);
	}
	
	@RequestMapping( value="/" )
	public List<UserDTO> findAllUsers( )
	{

		return userService.findAllUsers();
	}
	
	@RequestMapping( value="/{userId}" )
	public UserDTO findUser( @PathVariable Long userId )
	{

		return userService.findById(userId);
	}
	
	
}
