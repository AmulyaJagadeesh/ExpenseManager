package nz.co.aj.expensemanager.type;

import java.util.List;

import nz.co.aj.expensemanager.controller.Controller;
import nz.co.aj.expensemanager.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/types")
@RestController
public class TypeController extends Controller {
	
	@Autowired
	TypeService typeService;

	@GetMapping(value="/{id}")
	public TypeDTO getType( @PathVariable("id") Long id ) throws ResourceNotFoundException
	{

		return typeService.getType(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addType(@RequestBody TypeDTO type )
	{
		typeService.addType(type);
	}
	
	@GetMapping(value="/")
	public List<TypeDTO> getAllTypes()
	{
		List<TypeDTO> types = typeService.getAllTypes();
		return types;
		
	}
	
	@RequestMapping(value="/delete/{id}")
	public void deleteType( @PathVariable Long id )
	{

	    typeService.deleteTypeById(id);
	}


}
