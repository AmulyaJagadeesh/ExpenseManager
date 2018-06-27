package nz.co.aj.expensemanager.type;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import nz.co.aj.expensemanager.subType.SubTypeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TypeTest {
	
	@Mock
	TypeService typeService;
	
	@InjectMocks
	TypeController controller;
	
	@Test
	public void testAllTypes()
	{
		
		when(typeService.getAllTypes()).thenReturn(Arrays.asList(
				new TypeDTO(1L, "Grocery", "bdsh" ),
				new TypeDTO(2L, "ads", "bddffds fsh")
				) );
		Assert.assertTrue(controller.getAllTypes().size() == 2);
		
	}
	
	

}
