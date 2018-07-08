package nz.co.aj.expensemanager;

import nz.co.aj.expensemanager.expense.Expense;
import nz.co.aj.expensemanager.expense.ExpenseCaluclatorService;
import nz.co.aj.expensemanager.expense.ExpenseRepository;
import nz.co.aj.expensemanager.type.Type;
import nz.co.aj.expensemanager.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = ExpenseCaluclatorService.class )
public class ExpenseCalculatorServiceTest
{
    ExpenseManagerTestUtil testUtil = new ExpenseManagerTestUtil();

    @MockBean
    ExpenseRepository expenseRepository;

    @Autowired
    ExpenseCaluclatorService expenseCaluclatorService;

    @Test
    public void calculateExpenseByUser()
    {
        Type groceryType = testUtil.createType(1L, "Grocery " );
        User testUser = testUtil.createUser( 1L, "Test123" );

        Mockito.when( expenseRepository.findByUserIduser( 1L ) ).thenReturn(
                Arrays.asList(
                        new Expense( 1L, "Grocery", 100D, groceryType, testUser ),
                        new Expense( 2L, "Grocery", 100D, groceryType, testUser )
                )
        );
        Assert.assertEquals(java.util.Optional.ofNullable(expenseCaluclatorService.calculateExpenseByUserId(1L)),
                java.util.Optional.ofNullable(200D) );
    }


}
