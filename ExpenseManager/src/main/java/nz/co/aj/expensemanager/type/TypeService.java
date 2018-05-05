package nz.co.aj.expensemanager.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService
{
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	TypeRepository typeRepository;
	
	public TypeDTO getType( Long id )
	{
		Optional<Type> type = typeRepository.findById(id);
		if( type.isPresent() )
		{
			return convertToDto( type.get() );
		}
		return null;
	}
	
	public void addType( TypeDTO type )
	{
		typeRepository.save( convertToEntity(type) );
	}

	public List<TypeDTO> getAllTypes()
	{
		List<TypeDTO> types = new ArrayList<>();
		Iterator<Type> iterator = typeRepository.findAll().iterator();
		while( iterator.hasNext() )
			types.add(convertToDto(iterator.next()));
		return types;
	}
	
	public void deleteTypeById( Long id )
	{
		typeRepository.deleteById(id);
	}

	private TypeDTO convertToDto(Type type)
	{
		TypeDTO postDto = modelMapper.map(type, TypeDTO.class);
		return postDto;
	}

	private Type convertToEntity(TypeDTO typeDto )
	{
		Type type = modelMapper.map(typeDto, Type.class);
		return type;
	}

}
