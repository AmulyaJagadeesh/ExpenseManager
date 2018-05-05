package nz.co.aj.expensemanager.expense;

import nz.co.aj.expensemanager.subType.SubTypeDTO;
import nz.co.aj.expensemanager.type.TypeDTO;
import nz.co.aj.expensemanager.user.UserDTO;

import java.util.Date;

public class ExpenseDTO
{
    private Long idexpense;
    private String name;
    private String description;
    private Double amount;
    private Date spentDate;
    private TypeDTO type;
    private SubTypeDTO subType;
    private UserDTO user;

    public Long getIdexpense() {
        return idexpense;
    }

    public void setIdexpense(Long idexpense) {
        this.idexpense = idexpense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSpentDate() {
        return spentDate;
    }

    public void setSpentDate(Date spentDate) {
        this.spentDate = spentDate;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public SubTypeDTO getSubType() {
        return subType;
    }

    public void setSubType(SubTypeDTO subType) {
        this.subType = subType;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
