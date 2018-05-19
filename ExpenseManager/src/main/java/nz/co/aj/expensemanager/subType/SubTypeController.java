package nz.co.aj.expensemanager.subType;

import java.util.List;

import nz.co.aj.expensemanager.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtypes")
public class SubTypeController extends Controller {
	
	@Autowired
	SubTypeService subTypeService;
	
	
	@RequestMapping("/")
	public List<SubTypeDTO> getAllSubTypes()
	{
		return subTypeService.getAllSubTypes();
	}
	
	@RequestMapping( method=RequestMethod.POST, value="/add")
	public void addSubType( @RequestBody SubTypeDTO subType )
	{
		subTypeService.addSubType(subType);
	}
	
	@RequestMapping( "/{subTypeId}" )
	public SubTypeDTO getSubTypeById( @PathVariable Long subTypeId )
	{
		return subTypeService.getSubTypeById(subTypeId);
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteSubType( @PathVariable Long id )
	{
		subTypeService.deleteById(id);
	}

}
