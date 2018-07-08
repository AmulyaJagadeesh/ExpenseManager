package nz.aj.expensemanager.expense;


import nz.co.aj.expensemanager.ExpenseManagerTestUtil;
import nz.co.aj.expensemanager.expense.ExpenseController;
import nz.co.aj.expensemanager.expense.ExpenseDTO;
import nz.co.aj.expensemanager.expense.ExpenseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith( MockitoJUnitRunner.class )
public class ExpenseControllerTest
{
    @Mock
    ExpenseService expenseService;

    @InjectMocks
    ExpenseController controller;

    ExpenseManagerTestUtil testUtil = new ExpenseManagerTestUtil();

    @Test
    public void getAllExpenses()
    {
        Mockito.when( expenseService.getAllExpenses()).thenReturn(
                Arrays.asList(
                        new ExpenseDTO( 1L, "Grocery", "House hold", 100D,
                                testUtil.createTypeDTO(1L, "Grocery"), testUtil.createUserDTO(1L, "Amulya" ) ),
                        new ExpenseDTO( 2L, "Shopping", "House hold", 100D,
                                testUtil.createTypeDTO(2L, "Shopping"), testUtil.createUserDTO(1L, "Amulya" ) )
                )
        );
        Assert.assertEquals( 2, controller.getAllExpenses().size() );
    }

    @Test
    public void getExpensesByUser()
    {
        Mockito.when( expenseService.getExpensesByUserId(1L)).thenReturn(
                Arrays.asList(
                        new ExpenseDTO( 1L, "Grocery", "House hold", 100D,
                                testUtil.createTypeDTO(1L, "Grocery"), testUtil.createUserDTO(1L, "Amulya" ) ),
                        new ExpenseDTO( 2L, "Shopping", "House hold", 100D,
                                testUtil.createTypeDTO(2L, "Shopping"), testUtil.createUserDTO(1L, "Amulya" ) )
                )
        );
        Assert.assertEquals( 2, controller.getExpensesByUserId(1L).size() );
    }
}
