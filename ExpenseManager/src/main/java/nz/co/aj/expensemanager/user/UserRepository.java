package nz.co.aj.expensemanager.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
	
	public User findByEmail( String email);

}
