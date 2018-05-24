package nz.co.aj.expensemanager.subType;

import java.util.List;

import nz.co.aj.expensemanager.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subtypes")
public class SubTypeController extends Controller {
	
	@Autowired
	SubTypeService subTypeService;
	
	
	@GetMapping("/")
	public List<SubTypeDTO> getAllSubTypes()
	{
		return subTypeService.getAllSubTypes();
	}
	
	@PostMapping( value="/add")
	public void addSubType( @RequestBody SubTypeDTO subType )
	{
		subTypeService.addSubType(subType);
	}
	
	@GetMapping( "/{subTypeId}" )
	public SubTypeDTO getSubTypeById( @PathVariable Long subTypeId )
	{
		return subTypeService.getSubTypeById(subTypeId);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSubType( @PathVariable Long id )
	{
		subTypeService.deleteById(id);
	}

}
