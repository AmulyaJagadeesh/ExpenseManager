package nz.co.aj.expensemanager.expense;

import java.util.List;

import nz.co.aj.expensemanager.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/expenses")
@Api(value="expense", description="Operations pertaining to expenses in Expense Manager")
public class ExpenseController extends Controller {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping( method=RequestMethod.GET, value="/")
	public List<ExpenseDTO> getAllExpenses()
	{
		return expenseService.getAllExpenses();
	}

	@ApiOperation(value = "Returns the expense for a particular expense ID")
	@RequestMapping( method=RequestMethod.GET,value="/{expenseId}")
	public ExpenseDTO getExpense( @PathVariable Long expenseId )
	{
		return expenseService.getById(expenseId);
	}
	
	@ApiOperation(value = "Returns the expenses for a particular user ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK") 
			})
	@RequestMapping( method=RequestMethod.GET,value="/user/{userId}")
	public List<ExpenseDTO> getExpensesByUserId( @PathVariable Long userId )
	{
		return expenseService.getExpensesByUserId(userId);
	}
	
	@RequestMapping( method=RequestMethod.GET, value="/type/{typeId}")
	public List<ExpenseDTO> getExpensesByTypeId( @PathVariable Long typeId )
	{
		return expenseService.getExpensesByTypeId(typeId);
	}
	
	@RequestMapping( method = RequestMethod.POST, value="/add")
	public void addExpense( @RequestBody ExpenseDTO expense )
	{

		expenseService.addExpense(expense);
	}
	
	@RequestMapping(  method=RequestMethod.DELETE, value="/delete/{id}" )
	public void deleteExpense( @PathVariable Long id )
	{

		expenseService.deleteExpense(id);
	}

}
