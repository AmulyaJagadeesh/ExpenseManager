package nz.co.aj.expensemanager.type;

import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class TypeEntityToDTOTest {

    private ModelMapper mapper = new ModelMapper();

    @Test
    public void typeToDTO()
    {
        Type type = new Type();
        type.setIdtype(1L);
        type.setName("Grocery");
        type.setDescription("House hold items");

        TypeDTO dto = mapper.map( type, TypeDTO.class );
        Assert.assertEquals( type.getIdtype(), dto.getIdtype() );
        Assert.assertEquals(type.getName(), dto.getName() );
        Assert.assertEquals(type.getDescription(), dto.getDescription() );
    }
}
