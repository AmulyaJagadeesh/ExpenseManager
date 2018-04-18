package nz.co.aj.expensemanager.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	public List<Expense> getAllExpenses()
	{
		List<Expense> expenses = new ArrayList<>();
		expenseRepository.findAll().forEach(expenses::add);
		return expenses;
	}
	
	public Expense getById( Long id )
	{
		Optional<Expense> expenseOptional = expenseRepository.findById(id);
		if( expenseOptional.isPresent() )
		{
			return expenseOptional.get();
		}
		return null;
	}
	
	public List<Expense> getExpensesByUserId(Long userId)
	{
		List<Expense> expenses = new ArrayList<>();
		expenseRepository.findByUserIduser(userId).forEach(expenses::add);
		return expenses;
	}

	
	public List<Expense> getExpensesByTypeId(Long typeId)
	{
		List<Expense> expenses = new ArrayList<>();
		expenseRepository.findByTypeIdtype(typeId).forEach(expenses::add);
		return expenses;
	}
	
	public void deleteExpense( Long id )
	{
		expenseRepository.deleteById(id);
	}
	
	public void addExpense( Expense expense )
	{
		expenseRepository.save(expense);
	}

}
