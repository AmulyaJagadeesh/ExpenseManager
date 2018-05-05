package nz.co.aj.expensemanager.expense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	ModelMapper mapper;
	
	public List<ExpenseDTO> getAllExpenses()
	{
		List<ExpenseDTO> expenses = new ArrayList<>();
		Iterator<Expense> iterator = expenseRepository.findAll().iterator();
		while( iterator.hasNext() )
		{
			expenses.add(convertToDto(iterator.next()));
		}
		return expenses;
	}
	
	public ExpenseDTO getById( Long id )
	{
		Optional<Expense> expenseOptional = expenseRepository.findById(id);
		if( expenseOptional.isPresent() )
		{
			return convertToDto(expenseOptional.get());
		}
		return null;
	}
	
	public List<ExpenseDTO> getExpensesByUserId(Long userId)
	{
		List<ExpenseDTO> expenses = new ArrayList<>();
		Iterator<Expense> iterator = expenseRepository.findByUserIduser(userId).iterator();
		while( iterator.hasNext() )
		{
			expenses.add(convertToDto(iterator.next()));
		}
		return expenses;
	}

	
	public List<ExpenseDTO> getExpensesByTypeId(Long typeId)
	{
		List<ExpenseDTO> expenses = new ArrayList<>();
		Iterator<Expense> iterator = expenseRepository.findByTypeIdtype(typeId).iterator();
		while( iterator.hasNext() )
		{
			expenses.add(convertToDto(iterator.next()));
		}
		return expenses;
	}
	
	public void deleteExpense( Long id )
	{
		expenseRepository.deleteById(id);
	}
	
	public void addExpense( ExpenseDTO expense )
	{
		expenseRepository.save(convertToEntity(expense));
	}

	private ExpenseDTO convertToDto( Expense expense )
	{
		ExpenseDTO expenseDTO = mapper.map(expense, ExpenseDTO.class );
		return expenseDTO;
	}

	private Expense convertToEntity( ExpenseDTO expenseDTO )
	{
		Expense expense = mapper.map(expenseDTO, Expense.class );
		return expense;
	}

}
