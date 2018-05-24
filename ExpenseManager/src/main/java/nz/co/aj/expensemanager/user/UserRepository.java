package nz.co.aj.expensemanager.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
	
	public User findByEmailAndPassword( String email, String password);

	public Optional<User> findByName(String name);

}
