package nz.co.aj.expensemanager.expense;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	public List<Expense> findByUserIduser( Long id );
	
	public List<Expense> findByTypeIdtype( Long id );

}
