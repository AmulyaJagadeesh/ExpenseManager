package nz.co.aj.expensemanager.subType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtypes")
public class SubTypeController {
	
	@Autowired
	SubTypeService subTypeService;
	
	
	@RequestMapping("/allsubtypes")
	public List<SubType> getAllSubTypes()
	{
		return subTypeService.getAllSubTypes();
	}
	
	@RequestMapping( method=RequestMethod.POST, value="/addsubtype")
	public void addSubType( @RequestBody SubType subType )
	{
		subTypeService.addSubType(subType);
	}
	
	@RequestMapping( "/{subTypeId}" )
	public SubType getSubTypeById( @PathVariable Long subTypeId )
	{
		return subTypeService.getSubTypeById(subTypeId);
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteSubType( @PathVariable Long id ) {
		subTypeService.deleteById(id);
	}

}
