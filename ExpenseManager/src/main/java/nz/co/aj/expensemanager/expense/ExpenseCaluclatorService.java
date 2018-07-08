package nz.co.aj.expensemanager.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ExpenseCaluclatorService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Double calculateExpenseByUserId( Long userId )
    {
        Double expense = 0D;
        Iterator<Expense> iterator = expenseRepository.findByUserIduser(userId).iterator();
        while( iterator.hasNext() )
        {
            expense = expense + iterator.next().getAmount();
        }
        return expense;
    }
}
