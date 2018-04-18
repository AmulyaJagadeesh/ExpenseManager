package nz.co.aj.expensemanager.subType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTypeService {
	
	@Autowired
	SubTypeRepository subTypeRepository;
	
	public List<SubType> getAllSubTypes() {
		List<SubType> subTypes = new ArrayList<>();
		subTypeRepository.findAll().forEach(subTypes::add);
		return subTypes;
		
	}
	
	public void addSubType( SubType subType ) {
		subTypeRepository.save(subType);
	}
	
	public SubType getSubTypeById( Long id )
	{
		Optional<SubType> subType = subTypeRepository.findById(id);
		if( subType.isPresent() )
		{
			return subType.get();
		}
		return null;
	}
	
	public void deleteById( Long id )
	{
		subTypeRepository.deleteById(id);
	}

}
