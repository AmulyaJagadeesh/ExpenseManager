package nz.co.aj.expensemanager.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository typeRepository;
	
	public Type getType( Long id )
	{
		Optional<Type> type = typeRepository.findById(id);
		if( type.isPresent() )
		{
			return type.get();
		}
		return null;
	}
	
	public void addType( Type type )
	{
		typeRepository.save(type);
	}

	public List<Type> getAllTypes() {
		List<Type> types = new ArrayList<>();
		typeRepository.findAll().forEach(types::add);
		return types;
		
	}
	
	public void deleteTypeById( Long id )
	{
		typeRepository.deleteById(id);
	}

}
