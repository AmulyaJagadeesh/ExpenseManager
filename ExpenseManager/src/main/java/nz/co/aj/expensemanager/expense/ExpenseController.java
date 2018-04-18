package nz.co.aj.expensemanager.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping(value="/allexpenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
	
	@RequestMapping(value="/user/{userId}")
	public List<Expense> getExpensesByUserId( @PathVariable Long userId ) {
		return expenseService.getExpensesByUserId(userId);
	}
	
	@RequestMapping(value="/type/{typeId}")
	public List<Expense> getExpensesByTypeId( @PathVariable Long typeId ) {
		return expenseService.getExpensesByTypeId(typeId);
	}
	
	@RequestMapping( method = RequestMethod.POST, value="/addExpense")
	public void addExpense( @RequestBody Expense expense ) {
		expenseService.addExpense(expense);
	}
	
	@RequestMapping( value="/deleteExpense/{id}" )
	public void deleteExpense( @PathVariable Long id )
	{
		expenseService.deleteExpense(id);
	}

}
