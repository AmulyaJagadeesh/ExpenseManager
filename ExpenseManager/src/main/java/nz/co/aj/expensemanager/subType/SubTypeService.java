package nz.co.aj.expensemanager.subType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTypeService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	SubTypeRepository subTypeRepository;
	
	public List<SubTypeDTO> getAllSubTypes()
	{
		List<SubTypeDTO> subTypes = new ArrayList<>();
		Iterator<SubType> iterator = subTypeRepository.findAll().iterator();
		while( iterator.hasNext() )
		{
			subTypes.add(convertToDto(iterator.next()));
		}
		return subTypes;
	}
	
	public void addSubType( SubTypeDTO subTypeDTO )
	{
		subTypeRepository.save( convertToEntity(subTypeDTO));
	}
	
	public SubTypeDTO getSubTypeById( Long id )
	{
		Optional<SubType> subType = subTypeRepository.findById(id);
		if( subType.isPresent() )
		{
			return convertToDto(subType.get());
		}
		return null;
	}
	
	public void deleteById( Long id )
	{

		subTypeRepository.deleteById(id);
	}

	private SubTypeDTO convertToDto( SubType subType)
	{
		SubTypeDTO subTypeDTO = mapper.map(subType, SubTypeDTO.class);
		return subTypeDTO;
	}

	private SubType convertToEntity(SubTypeDTO subTypeDTO )
	{
		SubType subType = mapper.map(subTypeDTO, SubType.class);
		return subType;
	}

}
