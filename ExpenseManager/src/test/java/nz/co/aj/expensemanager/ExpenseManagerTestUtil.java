package nz.co.aj.expensemanager;

import nz.co.aj.expensemanager.user.UserDTO;
import nz.co.aj.expensemanager.type.TypeDTO;
import nz.co.aj.expensemanager.user.User;
import nz.co.aj.expensemanager.type.Type;

import java.util.Calendar;

public class ExpenseManagerTestUtil {

    public TypeDTO createTypeDTO(Long id, String typeName  )
    {
        return new TypeDTO( id, typeName, typeName );
    }

    public UserDTO createUserDTO(Long id, String userName )
    {
        return new UserDTO( id, userName );
    }

    public Type createType(Long id, String typeName  )
    {
        return new Type( id, typeName, null, Calendar.getInstance().getTime());
    }

    public User createUser(Long id, String userName )
    {
        return new User( id, userName );
    }
}
