package nz.co.aj.expensemanager.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	@RequestMapping(value="/{id}")
	public Type getType( @PathVariable("id") Long id )
	{
		return typeService.getType(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addType(@RequestBody Type type ) {
		typeService.addType(type);
	}
	
	@RequestMapping(value="/alltypes")
		public List<Type> getAllTypes() {
		List<Type> types = typeService.getAllTypes();
		return types;
		
	}
	
	@RequestMapping(value="/delete/{id}")
	public void deleteType( @PathVariable Long id ) {
		typeService.deleteTypeById(id);
	}

}
